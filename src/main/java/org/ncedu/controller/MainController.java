package org.ncedu.controller;

import org.ncedu.entity.MessageRoom;
import org.ncedu.entity.Music;
import org.ncedu.entity.Rooms;
import org.ncedu.entity.Users;
import org.ncedu.service.MusicService;
import org.ncedu.service.RoomService;
import org.ncedu.service.UserService;
import org.ncedu.service.VkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Date;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 *
 */
@Controller
public class MainController {

    private static final String OAUTH_URL = "https://oauth.vk.com/authorize";
    private static final String CLIENT_ID = "client_id=5691009";
    private static final String REDIRECT_URI = "redirect_uri=http://localhost:8080/VKMusicListener/oauth2";
    private static final String SCOPE = "scope=65544";
    private static final String RESPONCE_TYPE = "response_type=token&v=5.60";
    private static final String VERSION_API = "v=5.60";

    @Autowired
    private UserService userService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private VkService vkService;

    @Autowired
    private MusicService musicService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index () {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    //Реакция на нажатие кнопки "Create Room"
    //Затем надо инфу с messageRoom перенести в Room, а Room добавить в бд
    @PostMapping(value = "/add_room")
    public ResponseEntity receiveRoom(@RequestBody MessageRoom messageRoom) {

        System.out.println("Received from client: " + messageRoom);
        roomService.addRoom(messageRoom.getName(),messageRoom.getDescription(),messageRoom.getCreator_id());
        return new ResponseEntity("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "auth", method = RequestMethod.GET)
    public String vkoAuth() {
        return "redirect:"+
                OAUTH_URL+
                "?"+
                CLIENT_ID+"&"+
                REDIRECT_URI+"&"+
                SCOPE+"&"+
                RESPONCE_TYPE+"&"+
                VERSION_API;
    }

    @RequestMapping(value = "oauth2")
    public String redirectOverJs() {
        return "redirectOverJs";
    }

    @RequestMapping(value = "useradd")
    public String getUser (@RequestParam(value = "access_token") String token,
                           @RequestParam(value = "user_id") String user_id,
                           HttpServletResponse response) {
        Users user = null;
        if ((user =userService.getUserByVk(user_id)) == null) {
            user = new Users();
            user.setVk_id(user_id);
            user.setAccess_token(token);
            user.setRegistration(new Date(new java.util.Date().getTime()));
            user.setName(user_id);
            userService.addUser(user);
        } else {
            if (!user.getAccess_token().equals(token)) {
                user.setAccess_token(token);
                userService.updateUser(user);
            }
        }
        return "redirect:user?id=" + user.getUser_id();
    }

    @RequestMapping(value = "user")
    public String getUser (@RequestParam(value = "id") String id,
                           ModelMap model) {
        Users user = userService.getUserById(Long.parseLong(id));
        model.addAttribute("username", user.getName());
        model.addAttribute("vk_id", user.getVk_id());
        model.addAttribute("registration", user.getRegistration());
        List rooms;
        if((rooms = roomService.getRoomsByUser(user)) != null && rooms.size() > 0 ) {
            model.addAttribute("room_id", ((Rooms)rooms.get(0)).getRoom_link());
        };
        return "user";
    }

    @RequestMapping (value = "room/{room_link}")
    public String getRoom (@PathVariable ("room_link") String room_link,
                           ModelMap model) {
        Rooms room = roomService.getRoomsByLink(room_link);
        Users creator = userService.getUserById(Long.parseLong(roomService.getCreatorIdRoomsByLink(room_link)));
        model.addAttribute("room_name", room.getName().toUpperCase());
        model.addAttribute("href_creator", creator.getUser_id());
        model.addAttribute("room_creator", creator.getName());
        model.addAttribute("room_created", room.getCreated().toString());
        model.addAttribute("room_description", room.getDescription());
        return "room";
    }

    @RequestMapping(value = "getRoom/{vk_id}")
    public @ResponseBody Rooms[] getRoomsByVk (@PathVariable ("vk_id") String vk_id) {
        Users user = userService.getUserByVk(vk_id);
        List<Rooms> rooms = roomService.getRoomsByUser(user);
        Rooms[] result = new Rooms[rooms.size()];
        //result = rooms.toArray(new Rooms[0]);  -- Not works
        for (int i = 0; i<rooms.size(); i++)
        {
            result[i] = new Rooms();
            result[i].setRoom_link(rooms.get(i).getRoom_link());
            result[i].setRoom_id(rooms.get(i).getRoom_id());
            result[i].setCreated(rooms.get(i).getCreated());
            result[i].setName(rooms.get(i).getName());
            result[i].setDescription(rooms.get(i).getDescription());
        }
        return result;
    }

    //не работает запрос hql
    @RequestMapping(value = "deleteRoom/{room_link}")
    public @ResponseBody void deleteRoom (@PathVariable ("room_link") String room_link) {
        System.out.println("Deleting room " + room_link);
        roomService.deleteRoomByLink(room_link);
    }

    @RequestMapping(value = "mp3/{id}")
    public HttpServletResponse mp3 (@PathVariable ("id") String id,
                                    HttpServletRequest request,
                                    HttpServletResponse response)
            throws IOException {
        Long long_id = Long.parseLong(id);
        Music music = musicService.getMusicById(long_id);
        byte[] song = music.getSong();
        response.setContentType("audio/mpeg");
        response.setContentLength((int) song.length);
        OutputStream os = response.getOutputStream();
        os.write(song);
        os.close();
        return response;
    }

    /**
     * Method for tests
     * @param model
     * @return
     */
    @RequestMapping(value = "hello")
    public String hello (ModelMap model) {
        try {
            model.addAttribute("message", vkService.getAudio("http://www.jplayer.org/audio/mp3/TSP-01-Cro_magnon_man.mp3"));
        } catch (IOException e) {
            model.addAttribute("message", "Error =(");
        }
        return "home";
    }
}

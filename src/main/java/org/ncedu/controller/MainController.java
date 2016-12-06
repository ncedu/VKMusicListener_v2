package org.ncedu.controller;

<<<<<<< HEAD
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
=======
>>>>>>> 426aef898b34d42efe5770061b30bab801e6f8f4
import org.ncedu.entity.*;
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
import java.util.*;

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
    @PostMapping(value = "/add_room")
    public ResponseEntity receiveRoom(@RequestBody MessageRoom messageRoom) {

        System.out.println("Received from client: " + messageRoom);
        roomService.addRoom(messageRoom.getName(),messageRoom.getDescription(),messageRoom.getCreator_id());
        return new ResponseEntity("Success", HttpStatus.OK);
    }

    //Реакция на нажатие кнопки "add_user"
    @PostMapping(value = "/add_user_to_room")
    public ResponseEntity receiveRoom(@RequestBody MessageUserToRoom messageUserToRoom) {
        System.out.println("Received from client: " + messageUserToRoom);
        System.out.println(userService.getUserByVk(messageUserToRoom.getUserVkId()));
        System.out.println(roomService.getRoomsByLink(messageUserToRoom.getRoomLink()));
        roomService.addUserToRoom(
                userService.getUserByVk(messageUserToRoom.getUserVkId()),
                roomService.getRoomsByLink(messageUserToRoom.getRoomLink()));
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
<<<<<<< HEAD
        model.addAttribute("room_id", room.getRoom_id());
        model.addAttribute("vk_id", creator.getVk_id());
=======
        model.addAttribute("room_link", room.getRoom_link());
>>>>>>> 426aef898b34d42efe5770061b30bab801e6f8f4
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

    @RequestMapping(value = "getUsersByRoom/{room_link}")
    public @ResponseBody Users[] getUsersByRoom (@PathVariable ("room_link") String room_link) {
        System.out.println("Received " + room_link);
        List<Users> users = roomService.getUsersByRoomLink(room_link);
        Users result[] = new Users[users.size()];
        for (int i = 0; i<users.size(); i++)
        {
            result[i] = new Users();
            result[i].setName(users.get(i).getName());
            result[i].setAccess_token(users.get(i).getAccess_token());
            result[i].setRegistration(users.get(i).getRegistration());
            result[i].setSession_id(users.get(i).getSession_id());
            result[i].setUser_id(users.get(i).getUser_id());
            result[i].setVk_id(users.get(i).getVk_id());
        }
        System.out.println("Found " + result);
        return result;
    }

    @RequestMapping(value = "mp3/{id}")
    public HttpServletResponse mp3 (@PathVariable ("id") String id,
                                    HttpServletResponse response)
            throws IOException {
        Long long_id = Long.parseLong(id);
        Music music = musicService.getMusicById(long_id);
        byte[] song = music.getSong();
        response.setContentType("audio/mpeg");
        response.setContentLength(song.length);
        OutputStream os = response.getOutputStream();
        os.write(song);
        os.flush();
        os.close();
        return response;
    }

    @RequestMapping (value = "music/{room_id}")
    public @ResponseBody MessageMusic[] getMusic (@PathVariable ("room_id") String room_id) {
        List<Music> musicList = musicService.getMusicByRoom(Long.parseLong(room_id));
        MessageMusic[] musics = new MessageMusic[musicList.size()];
        int i = 0;
        for (Music entry: musicList) {
            MessageMusic music = new MessageMusic();
            music.setLink(String.valueOf(entry.getMusic_id()));
            music.setAuthor(entry.getAuthor());
            music.setName(entry.getName());
            musics[i] = music;
            i++;
        }
        return musics;
    }

    @RequestMapping (value = "getaudio")
    public @ResponseBody Music downloadAndSaveAudio (@RequestParam (value = "uid") String uid,
                                                     @RequestParam (value = "room_id") String room_id,
                                                     @RequestParam (value = "link") String link,
                                                     @RequestParam (value = "name") String name,
                                                     @RequestParam (value = "author") String author) throws IOException {
        return vkService.getAudio(uid, room_id, link, name, author);
    }

    @RequestMapping (value = "search")
    public @ResponseBody MessageMusic[] searchMusic (@RequestParam(value = "q") String query,
                                                     @RequestParam(value = "uid") String uid) throws ClientException, ApiException {
        return vkService.searchAudio(uid, query);
    }

    @RequestMapping (value = "vkmusic/{uid}")
    public @ResponseBody MessageMusic[] getMusicByVk (@PathVariable (value = "uid") String uid) throws ClientException, ApiException {
        return vkService.getAudioList(Integer.parseInt(uid));
    }
    /**
     * Method for tests
     * @param model
     * @return
     */
    @RequestMapping(value = "hello")
    public String hello (ModelMap model) {
//        try {
//            model.addAttribute("message", vkService.getAudio("http://www.jplayer.org/audio/mp3/TSP-01-Cro_magnon_man.mp3"));
//        } catch (IOException e) {
//            model.addAttribute("message", "Error =(");
//        }
        return "home";
    }
}

package org.ncedu.controller;

import org.ncedu.entity.*;
import org.ncedu.service.VkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.io.IOException;

/**
 * Created by nick on 28.11.16.
 */
@Controller
public class WebSocketController {
    @Autowired
    VkService vkService;

    @MessageMapping (value = "/addMusic")
    @SendTo (value = "/topic/showResult")
    public Music addMusic (WebSocketMusic music) {
        try {
            return vkService.getAudio(music.getUid(),music.getRoom_id(),music.getLink(),music.getName(),music.getAuthor());
        } catch (IOException e) {
            return null;
        }
    }
}

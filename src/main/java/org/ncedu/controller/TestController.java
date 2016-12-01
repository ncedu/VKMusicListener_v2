package org.ncedu.controller;

import org.ncedu.entity.Hello;
import org.ncedu.entity.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by nick on 28.11.16.
 */
@Controller
public class TestController {

    @MessageMapping (value = "/hello")
    @SendTo (value = "/topic/greetings")
    public Hello hello (HelloMessage message) throws Exception {
        Thread.sleep(3000);
        return new Hello("Hello, " + message.getName() + "!");
    }
}

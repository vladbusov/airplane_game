package hello;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class GreetingController {

    private HashMap<String,Position> players;

    public GreetingController() {
        this.players = new HashMap<>();
    }

    // посылка сообщений из /hello в /topic/greetings
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(Message message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting(HtmlUtils.htmlEscape(message.getName()) + " : " +  HtmlUtils.htmlEscape(message.getMessage()) );
    }

    @MessageMapping("/airplane")
    @SendTo("/topic/plane/position")
    public ArrayList fly(Position message) throws Exception {
        if (message.getExist()) {
            try {
                if (!players.containsKey(message.getNickname())) {
                    players.put(message.getNickname(), message);
                } else {
                    players.get(message.getNickname()).setPositionX(message.getPositionX());
                    players.get(message.getNickname()).setPositionY(message.getPositionY());
                }
            } catch (NullPointerException ignore) {

            }
        } else {
            players.remove(message.getNickname());
        }
        return new ArrayList(players.values());
    }

}

package edu.udacity.java.nano.chat;

import org.json.JSONObject;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * WebSocket Server
 *
 * @see ServerEndpoint WebSocket Client
 * @see Session   WebSocket Session
 */

@Component
@ServerEndpoint("/chat/{username}")
public class WebSocketChatServer {

    /**
     * All chat sessions.
     */
    private static Map<String, Session> onlineSessions = new ConcurrentHashMap<>();

    private static void sendMessageToAll(String msg) {
        //TODO: add send message method.
        for (String key : onlineSessions.keySet()){
            try {
                onlineSessions.get(key).getBasicRemote().sendText(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Open connection, 1) add session, 2) add user.
     */
    @OnOpen
    public void onOpen(Session session,@PathParam("username") String username) {
        //TODO: add on open connection.
        Gson gson = new Gson();
        onlineSessions.put(username,session);
        Message message = new Message();
        message.setUsername(username);
        message.setMessage("Connected");
        message.setType("ENTER");
        message.setCount(onlineSessions.size());
        sendMessageToAll(gson.toJson(message));

    }

    /**
     * Send message, 1) get username and session, 2) send message to all.
     */
    @OnMessage
    public void onMessage(Session session, String jsonStr) {
        //TODO: add send message.
        Gson gson = new Gson();
        JSONObject json = new JSONObject(jsonStr);
        Message message = new Message();
        message.setUsername(json.getString("username"));
        message.setMessage(json.getString("msg"));
        message.setType("SPEAK");
        message.setCount(onlineSessions.size());
        sendMessageToAll(gson.toJson(message));

    }

    /**
     * Close connection, 1) remove session, 2) update user.
     */
    @OnClose
    public void onClose(Session session,@PathParam("username") String username) {
        //TODO: add close connection.
        Gson gson = new Gson();
        onlineSessions.remove(username);
        Message message = new Message();
        message.setMessage("Disconnected");
        message.setType("LEAVE");
        message.setCount(onlineSessions.size());
        message.setUsername(username);
        sendMessageToAll(gson.toJson(message));
    }

    /**
     * Print exception.
     */
    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

}

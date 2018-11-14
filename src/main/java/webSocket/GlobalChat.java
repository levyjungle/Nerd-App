package webSocket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/globalChatServer")
public class GlobalChat {
	
	static Set<Session> chatroomUsers = Collections.synchronizedSet(new HashSet<Session>());
	
	@OnOpen
	public void handleMessage(Session userSession) {
		chatroomUsers.add(userSession);
	}
	
	@OnMessage
	public void handleMessage(String message, Session userSession) throws IOException, EncodeException {
		String username = (String) userSession.getUserProperties().get("username");
		if(username == null) {
			/* get object name from DB replace message to object.name */
			userSession.getUserProperties().put("username", message);
			userSession.getBasicRemote().sendText(buildJsonData("Bem-vindo", " você está agora conectado " + message));
		} else {
			Iterator<Session> iterator = chatroomUsers.iterator();
			while(iterator.hasNext()) {
				iterator.next().getBasicRemote().sendText(buildJsonData(username, message));
			}
		}
	}
	
	private String buildJsonData(String username, String message) {
		JsonObject jo = Json.createObjectBuilder().add(username, message).build();
		return jo.toString();
	}

	@OnClose
	public void handleClose(Session userSession) {
		chatroomUsers.remove(userSession);
	}
}

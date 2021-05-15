package tn.esprit.esponline.frontcontroller;


import java.util.List;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tn.esprit.esponline.config.MessageMode;
import tn.esprit.esponline.dto.Message;
import tn.esprit.esponline.entities.User;
import tn.esprit.esponline.services.UserServiceImpl;
import tn.esprit.esponline.services.WebSocketService;

@Scope ("view")
@Component (value = "chatController")
@ELBeanName(value = "chatController")
@Join(path = "/chat", to = "/principal/chat.jsf")
public class ChatController {
	
    private List<User> users;
	private String message;
	
	
	
	@Autowired
	UserServiceImpl userService;
	
	
	
	@Autowired
	tn.esprit.esponline.frontcontroller.UserController loginController;
	
	User toUser;
	
	@Autowired
	WebSocketService wsService;
	
	public String sendMessage() throws Exception  {		
		 
		String [] wordsFromText = message.split(" ");	
		 
		
		     Message chatMessage = new Message(null, loginController.getAuthenticatedUser(),message, MessageMode.PUBLIC);
			 wsService.send("/topic/chat", chatMessage);
		 
		 
		 
	     message = "";
		 return message;	
	}

	public  List<User> refreshUsers() {
		return getUsers();
	}
	
	private List<User> findAllUsers() {
		return userService.mylist();
	}

	public List<User> getUsers() {
		users= userService.mylist();
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public User getToUser() {
		return toUser;
	}


	public void setToUser(User toUser) {
		this.toUser = toUser;
	}

	

}

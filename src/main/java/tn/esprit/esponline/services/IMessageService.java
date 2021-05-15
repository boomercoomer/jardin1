package tn.esprit.esponline.services;

import java.util.List;

import tn.esprit.esponline.entities.Message;

public interface IMessageService {
	
	//public void ajouterMessage(Message message);
		public List<Message> listmessage();
		public void deleteMessageById(Long ide);
		public Long ajouterMessage(Message message);
		public void mettreAjourBodyByMessageId(String Body, Long id);
		public List<String> getAllMessageTrieJPQL();
		List<Message> retrieveHistory();
		Message addMessage(Message message);

}

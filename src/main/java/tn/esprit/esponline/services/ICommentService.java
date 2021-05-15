package tn.esprit.esponline.services;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.esponline.entities.Comment;
import tn.esprit.esponline.entities.Comment_evaluation;


@Service
public interface ICommentService {
	
		
		 String addComment(Comment com,long user_id,long post_id) ;
		 Comment findbyid(long id);
		 List<Comment> list(long post_id);
		 List<Comment> mylist(long user_id);
		 void deleteComment(long id) ;
		 Comment updateComment(long id,String mot);
		 void addEv(Comment_evaluation e, long id);
		 List<Comment> Bestcomments();
		 Comment_evaluation Evaluation(long id);
}

package tn.esprit.esponline.services;



import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.esponline.entities.Comment;
import tn.esprit.esponline.entities.Comment_evaluation;
import tn.esprit.esponline.entities.Post;
import tn.esprit.esponline.entities.User;
import tn.esprit.esponline.repository.CommentRepository;
import tn.esprit.esponline.repository.Comment_evaluationRepository;
import tn.esprit.esponline.repository.DictionaryRepository;
import tn.esprit.esponline.repository.UserRepository;

@Service
public class CommentServiceImpl implements ICommentService {
	
	public String msg;
	@Autowired
	private CommentRepository var;

	@Autowired
	UserRepository var1;

	@Autowired
	private PostService var2;

	@Autowired
	private Comment_evaluationRepository var3;
	
	@Autowired
	private DictionaryRepository var4;


	////////////////////// add a comment/////////////////////////

	@Override
	public String addComment(Comment com,long userid,long postid) {
		
	
		User u = var1.findById(userid).get();
		Post s = var2.findbyid(postid);
		
		com.setUser(u);
		com.setPost(s);
		 if(com.getMot().equals("")) {
				msg= "you can't insert an empty comment" ;
				
			}
		 else {
			var.save(com); } 
		 return msg= "add successful "; } 
	
	
	@Override
	public List<Comment> list(long post_id) {

		Post s = var2.findbyid(post_id);
		return var.list(s);

	}

	@Override
	public void deleteComment(long id) {

		var.deleteById(id);
	}
	
	@Override
	public Comment findbyid(long id) {

		return var.findById(id).get();

	}

	@Override
	public List<Comment> mylist(long user_id) {

		User u = var1.findById(user_id).get();
		List<Comment> l = var.mylist(u);
		return l;

	}
	/// modify comment ////

	@Override
	public Comment updateComment(long id, String mot) {

		Comment com1 = var.findById(id).get();
		com1.setMot(mot);
		var.save(com1);
		return com1;

	}

	/////// evaluation/////////
	
@Override
@Transactional
public void addEv(Comment_evaluation e, long id) {

		Comment c = var.findById(id).get();
		
		List<Comment> my = var3.evsave();

		if (my.contains(c)) {
			Comment_evaluation v = var3.findev(c);
			v.setL(v.getL() + e.getL());
			v.setD(v.getD() + e.getD());
			v.setH(v.getH() + e.getH());
			v.setS(v.getS() + e.getS());
			v.setM(v.getM() + e.getM());
			var3.save(v);

		
		}else {

			e.setComment(c);
			var3.save(e);
		}

	}

	/////////////////// list get evaluation by comment id//////////////////
	public Comment_evaluation Evaluation(long id) {

		Comment c = var.findById(id).get();
		return  var3.findev(c);
		

	}

	/////////////////// comments + pertinents/////////////////////
	@Override
	public List<Comment> Bestcomments() {
		List<Comment> list1 = var3.myfind(var3.best1(), var3.best2());
		return list1;
	}

	

	

}

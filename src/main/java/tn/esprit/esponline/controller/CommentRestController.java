package tn.esprit.esponline.controller;


import java.util.List;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//import frontcontroller.ApplicationError;
import tn.esprit.esponline.entities.Comment;
import tn.esprit.esponline.entities.Comment_evaluation;
import tn.esprit.esponline.services.ICommentService;


@RestController
public class CommentRestController {
	
	@Autowired
	ICommentService cs;
	
	@Autowired
	UserController userJsfControl;
	
	//http://localhost:8081/springMVC/servlet/addComment/{user-id}/{post-id}        
    @PostMapping("/addComment/{user-id}/{post-id}")
    @ResponseBody
    public String addComment(@RequestBody Comment com,@PathVariable("user-id")long userid,@PathVariable("post-id")long postid) {
	cs.addComment(com,userid,postid);
	return "add successful ";
	}
    
   //http://localhost:8081/springMVC/servlet/removecomment/{comment-id} 
	@DeleteMapping("/removecomment/{comment-id}") 
	@ResponseBody
	public void removeComment(@PathVariable("comment-id") long id) {
		cs.deleteComment(id);         
	}


	 // http://localhost:8081/springMVC/servlet/modifycomment/{comment-id}/{mot}
	@PutMapping("/modifycomment/{comment-id}/{mot}")
	@ResponseBody
	public Comment modifyComment(@PathVariable("comment-id") long id,@PathVariable("mot")String mot) {
	return cs.updateComment(id,mot);         
	}
	
		
		//all comments 
	    //http://localhost:8081/springMVC/servlet/ListComment/{postId}
				@GetMapping("/ListComment/{postId}")
				@ResponseBody
				public Response list(@PathVariable("postId") long postId) {
				List<Comment> l = cs.list(postId);

				if (l.size()==0) {
					return Response.status(Status.NOT_FOUND).entity("There's no comment related to this post !").build();

					}
				else {
					return Response.status(Status.OK).entity(l).build();

				}
				}
		//all userconnected comments ajouter une exception
		//http://localhost:8081/springMVC/servlet/ListComment/{userId}
				@GetMapping("/myComments/{userId}")
				@ResponseBody
				public List<Comment> mylist(@PathVariable("userId") long userId) {
				List<Comment> l = cs.mylist(UserController.USERCONNECTED.getId());
				return l ;

				}
				
	
				///////////////////comment evaluation///////////////////
	//http://localhost:8081/springMVC/servlet/evaluate/{commentId}	
				@PostMapping("/evaluate/{commentId}")
				@ResponseBody
				public Response addevaluation(@RequestBody Comment_evaluation u,@PathVariable("commentId") Long commentId) {
					
					cs.addEv(u, commentId);
				return Response.status(Status.OK).entity("add successful").build();
				
				  }
				
					
					
				//////////////commentaires + pertinents /////////////////// 	
		//http://localhost:8081/springMVC/servlet/BestComments		
				@GetMapping("/BestComments")
				@ResponseBody
				public List<Comment> Best() {
				
					return cs.Bestcomments();
				
				}
			
			
	
		/**********************comment evaluation*****************/
		
		
		//Like : 
		//http://localhost:8081/springMVC/servlet/addlike/{comment-id}
		@PostMapping("/addlike/{comment-id}")
	    @ResponseBody
		public void addLevaluation(@PathVariable("comment-id")long commentId) {
			Comment_evaluation u = new Comment_evaluation();
			u.setL(1);
			cs.addEv(u, commentId);
			
		    }

		//Dislike:
		//http://localhost:8081/springMVC/servlet/adddislike/{comment-id}
		@PostMapping("/adddislike/{comment-id}")
	    @ResponseBody
		public void addDevaluation(@PathVariable("comment-id")long commentId) {
			Comment_evaluation v = new Comment_evaluation();

			v.setD(1);
			cs.addEv(v, commentId);
			
		  }

		//Happy : 
		//http://localhost:8081/springMVC/servlet/addhappy/{comment-id}
		@PostMapping("/addhappy/{comment-id}")
	    @ResponseBody
		public void addHevaluation(@PathVariable("comment-id")long commentId) {
			Comment_evaluation u1 = new Comment_evaluation();

			u1.setH(1);
			cs.addEv(u1, commentId);
			
		  }
		//Sad :
		//http://localhost:8081/springMVC/servlet/addsad/{comment-id}
		@PostMapping("/addsad/{comment-id}")
	    @ResponseBody
		public void addSevaluation(@PathVariable("comment-id")long commentId) {
			Comment_evaluation v1 = new Comment_evaluation();

			v1.setS(1);
			cs.addEv(v1, commentId);
			
		  }
		//Medium : 
		//http://localhost:8081/springMVC/servlet/addmed/{comment-id}
		@PostMapping("/addmed/{comment-id}")
	    @ResponseBody
		public void addMevaluation(@PathVariable("comment-id")long commentId) {
			Comment_evaluation v2 = new Comment_evaluation();

			v2.setM(1);
			cs.addEv(v2, commentId);
			
		  }
		/****************************get evaluations*********************/
		//http://localhost:8081/springMVC/servlet/getlike/{comment-id}
		@GetMapping("/getlike/{comment-id}")
		@ResponseBody
		public String getLike(@PathVariable("comment-id")long commentId) {
			Comment_evaluation c = cs.Evaluation(commentId) ;
		if (c == null) {
			
			return "0";
			}
		else {
			return String.valueOf(c.getL()) ;
					 
		}
		  }
	    //http://localhost:8081/springMVC/servlet/getdislike/{comment-id}
		@GetMapping("/getdislike/{comment-id}")
		@ResponseBody
		public String getDislike(@PathVariable("comment-id")long commentId) {
			
			Comment_evaluation c = cs.Evaluation(commentId) ;
		if (c == null) {
			
			return "0";
			}
		else {
			return String.valueOf(c.getD()) ;
					 
		}
		  }
		//http://localhost:8081/springMVC/servlet/gethappy/{comment-id}
		@GetMapping("/gethappy/{comment-id}")
		@ResponseBody
		public String getHappy(@PathVariable("comment-id")long commentId) {
			
			Comment_evaluation c = cs.Evaluation(commentId) ;
		if (c == null) {
			
			return "0";
			}
		else {
			return String.valueOf(c.getH()) ;
					 
		}
		  }
		
		//http://localhost:8081/springMVC/servlet/getsad/{comment-id}
		@GetMapping("/getsad/{comment-id}")
		@ResponseBody
		public String getSad(@PathVariable("comment-id")long commentId) {
			
			Comment_evaluation c = cs.Evaluation(commentId) ;
		if (c == null) {
			
			return "0";
			}
		else {
			return String.valueOf(c.getS()) ;
					 
		}
		  }
		//http://localhost:8081/springMVC/servlet/getmed/{comment-id}
		@GetMapping("/getmed/{comment-id}")
		@ResponseBody
		public String getMedium(@PathVariable("comment-id")long commentId) {
			
			Comment_evaluation c = cs.Evaluation(commentId) ;
		if (c == null) {
			
			return "0";
			}
		else {
			return String.valueOf(c.getM()) ;
					 
		}
		  }
		
	
		
	
		


}

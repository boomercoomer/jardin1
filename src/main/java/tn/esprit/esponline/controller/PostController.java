package tn.esprit.esponline.controller;

import java.io.File;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.esponline.entities.Post;
import tn.esprit.esponline.services.IPostService;

@RestController
public class PostController {

	@Autowired
	IPostService ipService;
	
	@Autowired
	UserController userControl;
	

	//http://localhost:8081/springMVC/servlet/uploadpost
    @PostMapping("/uploadpost")
    @ResponseBody
	public ResponseEntity<?> addPost(Post post,@RequestParam("file") MultipartFile file) {
    	String fileName = file.getOriginalFilename();
		post.setPhoto(fileName);      
    	ipService.addpost(post); 
    	try {
			file.transferTo(new File("C:\\Users\\Fileupload" + fileName));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.ok("save successfully.");
		          
	}
	//http://localhost:8081/springMVC/servlet/ajouterpost/{userId}     
    @PostMapping("/ajouterpost/{userId}")
    @ResponseBody
	public Post addPost(@RequestBody Post p,@PathVariable("userId") long usid) {
		      ipService.addPost(p,usid);     
	           return p;
	}
    

		//http://localhost:8081/springMVC/servlet/ajouterpost     
	    @PostMapping("/ajouterpost")
	    @ResponseBody
		public Post addPost(@RequestBody Post p) {
			      ipService.addpost(p);     
		           return p;
		}
    
	  //http://localhost:8081/springMVC/servlet/affecterPostAUser/{postId}/{userId}      
	    @PostMapping("/affecterPostAUser/{postId}/{userId}")
	    @ResponseBody
		public void affecterPostAUser(@PathVariable("postId") long ptid,@PathVariable("userId") long usid) {
			      ipService.affecterPostAUser(ptid,usid);     
		         
		}
    
/////get post by id/////
	//http://localhost:8081/springMVC/servlet/getpost/{post-id}
	@GetMapping("/getpost/{post-id}")
	@ResponseBody
	public Post findbyid(@PathVariable("post-id") long id) {
	return ipService.findbyid(id);            
	}
	    
	    

	 // http://localhost:8081/springMVC/servlet/allpost
	 		@GetMapping("/allpost")
	 		@ResponseBody
		public List<Post> getPosts() {
			List<Post> posts = ipService.myy();
			return posts;
		}
   
	 // http://localhost:8081/springMVC/servlet/remove-post/{post-id}
		@DeleteMapping("/remove-post/{post-id}")
		@ResponseBody
		public void deletePost(@PathVariable("post-id") long id) {
			ipService.deletePost(id); 
			
			}

	
		//http://localhost:8081/springMVC/servlet/modifypost
		@PutMapping("/modifypost")
		@ResponseBody
		public ResponseEntity<String> updatePost(@RequestBody Post post) {
		     ipService.updatePost(post); 
		     return new ResponseEntity<>("Post have been modified!", HttpStatus.OK);
		}


		//http://localhost:8081/springMVC/servlet/posts
		@GetMapping("/posts")
		@ResponseBody
		public List<Post> getPost() {
		List<Post> list = ipService.post();           
		return list;
		}
		

	
		
		
		
}		
		

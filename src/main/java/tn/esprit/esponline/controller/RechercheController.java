package tn.esprit.esponline.controller;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.esponline.entities.Post;
import tn.esprit.esponline.entities.Recherche;
import tn.esprit.esponline.entities.User;
import tn.esprit.esponline.services.IPostService;
import tn.esprit.esponline.services.IRechercheService;
import tn.esprit.esponline.services.IUserService;
import tn.esprit.esponline.services.UserServiceImpl;

@RestController
public class RechercheController {

	@Autowired
	IUserService ipService;
	@Autowired
	UserServiceImpl UserService;
	
	@Autowired
	IPostService pService;
	
	@Autowired
	IRechercheService rechercheService;
	
	//http://localhost:8081/springMVC/servlet/searchUser
	@PutMapping("/searchUser")
	@ResponseBody
         public List<User> searchProducts(@RequestBody User userSearch){
		String username=userSearch.getUsername();
		String firstname= userSearch.getFirstname();
		List<User> users = rechercheService.searchUser(username,firstname);
		return users;
    }
	
	
//////////////////save my search + return subjects researched/////////////////////
	//http://localhost:8081/springMVC/servlet/search/{type}
@GetMapping("/search/{type}")
@ResponseBody
public Response addSearch(@PathVariable("type") String type) {


Recherche r = new Recherche(type);
List<Post> list = pService.findbyType(type);
if (list.size()==0) {
return Response.status(Status.NOT_FOUND).entity( "There is no subject with the type provided !").build();        
}
else {

rechercheService.addSearch(r, UserService.findbyid(UserController.USERCONNECTED.getId()) );
return Response.status(Status.OK).entity(list).build();
}

}

/////////////////posts adéquats au profil/////////////////////
//http://localhost:8081/springMVC/servlet/search/findinterested
@GetMapping("/findinterested")
@ResponseBody
public Response findinterested() {

String max = rechercheService.extractt(UserController.USERCONNECTED.getId());
List<Post> list = pService.findbyType(max);
if (list.size()==0) {
return Response.status(Status.NOT_FOUND).entity( "Do a little search ;) ").build();                   
}
else{
return Response.status(Status.OK).entity(list).build();

}
}

	
	
}

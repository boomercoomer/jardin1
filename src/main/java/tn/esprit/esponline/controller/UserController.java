package tn.esprit.esponline.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.esponline.config.JwtTokenUtil;
import tn.esprit.esponline.entities.JwtRequest;
import tn.esprit.esponline.entities.JwtResponse;
import tn.esprit.esponline.entities.User;
import tn.esprit.esponline.entities.UserDTO;

import tn.esprit.esponline.services.UserServiceImpl;

@RestController
public class UserController {
	
	@Autowired
	UserServiceImpl UserService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	public static User USERCONNECTED ;
	
//	@RequestMapping("/")
//	@ResponseBody
//	public String welcome() { return "Bonjour, Bienvenue à l'application de test des Web ServicesREST"; }
	
	//http://localhost:8081/springMVC/servlet/register
	@PostMapping("/register")
	@ResponseBody
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
		System.out.println("*********Entring the register method ************");
		return ResponseEntity.ok(UserService.addUser(user));
	}
	//http://localhost:8081/springMVC/servlet/authenticate
	@PostMapping("/authenticate")
	@ResponseBody
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		try {
			authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

			final UserDetails userDetails = UserService.loadUserByUsername(authenticationRequest.getUsername());
			final User user = UserService.findUserByUsername(authenticationRequest.getUsername());
			USERCONNECTED = user ;
			System.out.println(USERCONNECTED.getRole());


			final String token = jwtTokenUtil.generateToken(userDetails);
			System.out.println(token);
			return ResponseEntity.ok(new JwtResponse(token));
		} catch (Exception e) {
			System.out.println(e.toString());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
	
	
	//http://localhost:8081/springMVC/servlet
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
	//http://localhost:8081/springMVC/servlet/mylist
	///list of users////
	@GetMapping("/mylist")
	@ResponseBody
	public List<User> getUsers() {
	List<User> list = UserService.mylist();
	return list;
	}
	
	//http://localhost:8081/springMVC/servlet/retrieve-user/{user-id}
	/////get user by id/////
	@GetMapping("/retrieve-user/{user-id}")
	@ResponseBody
	public User findbyid(@PathVariable("user-id") long userId) {
	return UserService.findbyid(userId);
	}
	
	//http://localhost:8081/springMVC/servlet/delete-user/{user-id}
    ////delete user////
    @DeleteMapping("/delete-user/{user-id}")
    @ResponseBody
    public void deleteUser(@PathVariable("user-id") long userId) {
    	UserService.deleteUser(userId);
    }
	
	/*@Autowired
	UserServiceImpl UserService;
	
	//http://localhost:8081/springMVC/servlet/ajouteruser
	//{ "username":"sana","password":"123456","firstName":"san","lastName":"romdh"}
	@PostMapping("/ajouteruser")
	@ResponseBody
	public User saveUser(@RequestBody User user)  {
		
		return UserService.addUser(user);
	}
	
	//http://localhost:8081/springMVC/servlet/listusers
	///list of users////
		@GetMapping("/listusers")
		@ResponseBody
		public List<User> getUsers() {
		List<User> list = UserService.mylist();
		return list;
		}
		
		//http://localhost:8081/springMVC/servlet/retrieve-user/{user-id}
		/////get user by id/////
		@GetMapping("/retrieve-user/{user-id}")
		@ResponseBody
		public User findbyid(@PathVariable("user-id") long userId) {
		return UserService.findbyid(userId);
		}
		
		//http://localhost:8081/springMVC/servlet/delete-user/{user-id} 
	    ////delete user////
	    @DeleteMapping("/delete-user/{user-id}")
	    @ResponseBody
	    public void deleteUser(@PathVariable("user-id") long userId) {
	    	UserService.deleteUser(userId);
	    } */

}

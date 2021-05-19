package tn.esprit.esponline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.esponline.filter.JwtProvider;
import tn.esprit.esponline.requests.LoginRequest;
import tn.esprit.esponline.requests.LoginResponse;
import tn.esprit.esponline.services.UserDetService;

import java.io.IOException;


@RestController
@RequestMapping("/home")
public class LoginController {

	@Autowired
	private AuthenticationManager authenticationManager ;
	@Autowired
	private JwtProvider jwtProvider ; 
	@Autowired
	private UserDetService userDetailsService ; 
	
	
/*	private void authenticate(String username, String password) throws Exception {
		try {
			System.out.println("starting auth");
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			System.out.println("starting aaaaaaaa");
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}*/
	
	@PostMapping("/Login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest loginRequest) throws AuthenticationException, IOException {

		// Perform the security
        Authentication authentication;
		//authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        System.out.println("firststep");
        
       
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );
            System.out.println("secondstep");

   
        

		final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
        //System.out.println("abababa"+userDetails.getUsername());
		final String jwt = jwtProvider.generateToken(userDetails);
		
		return ResponseEntity.ok(new LoginResponse(jwt));
	}
	
	
	
}

package tn.esprit.esponline.controller;

import org.springframework.http.HttpStatus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.esponline.entities.Jardin_enfant;
import tn.esprit.esponline.services.IJardinService;

@RestController
public class JardinController {
	
	@Autowired
	public IJardinService JardinSer;
	
	//http://localhost:8081/springMVC/servlet/addkindergaten
	@PostMapping("/addkindergaten")
    public Jardin_enfant addKindergarten(@RequestBody Jardin_enfant jardin) {
		JardinSer.save(jardin);
		return jardin;
	}
    
	//http://localhost:8081/springMVC/servlet/delete/{id}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteJardin(@PathVariable("id") int id){
		JardinSer.DeleteJardin(id);
		return new ResponseEntity<>( HttpStatus.OK);
	}
	//http://localhost:8081/springMVC/servlet/alljardins
		@GetMapping("/alljardins")
		public ResponseEntity<List<Jardin_enfant>>getAllJardin(){
			List<Jardin_enfant> c=JardinSer.findAllJardin() ;
			return new ResponseEntity<List<Jardin_enfant>>(c,HttpStatus.OK);	
		}
		//http://localhost:8081/springMVC/servlet/reputation/20/10/4
		@PostMapping("/reputation/{x}/{y}/{z}")
		public ResponseEntity<?>reputation(@PathVariable("x")int x,@PathVariable("y")int y,@PathVariable("z")int z){
			JardinSer.reputation(x, y, z);
			return new ResponseEntity<>(HttpStatus.OK);	
		}
		//http://localhost:8082/jardin/demandereputation/2
		/*@GetMapping("demandereputation/{parent_id}/{jardin_id}")
		public ResponseEntity<Integer>demandereputation(@PathVariable("parent_id")int id,@PathVariable("jardin_id")int jardin_id){
			int a=JardinSer.demendereputation(id,jardin_id);
			return new ResponseEntity<>(a,HttpStatus.OK);
		}*/

}

package rppim.ctrl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import rppim.jpa.Grupa;
import rppim.reps.GrupaRepository;

@RestController
public class GrupaRestController {

	@Autowired
	private GrupaRepository grupaRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@CrossOrigin
	@ApiOperation(value="Returns collection of all Grupa from database")
	@GetMapping("grupa")
	public Collection<Grupa> getAll(){
		return grupaRepository.findAll();
	}
	@CrossOrigin
	@ApiOperation(value="Returns grupa with id that was forwarded as path variable")
	@GetMapping("grupa/{id}")
	public Grupa getOne(@PathVariable("id") Integer id) {
		return grupaRepository.getOne(id);
	}
	@CrossOrigin
	@ApiOperation(value="Returns collection of grupa that contains oznaka that was forwarded as path variable")
	@GetMapping("grupa/oznaka/{oznaka}")
	public Collection<Grupa> getByNaziv(@PathVariable("oznaka") String oznaka){
		return grupaRepository.findByOznakaContainingIgnoreCase(oznaka);
	}
	@CrossOrigin
	@ApiOperation(value = "Adds instance of Grupa to database")
	@PostMapping("grupa")
	public ResponseEntity<HttpStatus> addGrupa(@RequestBody Grupa grupa){
		grupaRepository.save(grupa);
		
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	@CrossOrigin
	@ApiOperation(value = "Updates Grupa with id that was forwarded as path variable")
	@PutMapping("grupa/{id}")
	public ResponseEntity<HttpStatus> updateArtikl(@RequestBody Grupa grupa, 
			@PathVariable("id")Integer id){
		if(grupaRepository.existsById(id)) {
			grupa.setId(id);
			grupaRepository.save(grupa);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		
		
	}
	@CrossOrigin
	@ApiOperation(value = "Deletes Grupa with id that was forwarded as path variable")
	@DeleteMapping("grupa/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Integer id){
		if(id==-100 && !grupaRepository.existsById(-100)) {
			jdbcTemplate.execute("INSERT INTO grupa (\"id\", \"oznaka\", \"smer\") VALUES (-100, 'test', 1)");
		}
		
		if(grupaRepository.existsById(id)) {
			grupaRepository.deleteById(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}
	
	
}

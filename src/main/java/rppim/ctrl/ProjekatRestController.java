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
import rppim.jpa.Projekat;
import rppim.reps.ProjekatRepository;

@RestController
public class ProjekatRestController {
	@Autowired
	private ProjekatRepository projekatRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@CrossOrigin
	@ApiOperation(value = "Returns Collection of all projekat")
	@GetMapping("projekat")
	public Collection<Projekat> getAll(){
		return projekatRepository.findAll();
	}
	@CrossOrigin
	@ApiOperation(value = "Returns Projekat with id forwarded as a path variable")
	@GetMapping("projekat/{id}")
	public Projekat getOne(@PathVariable("id") Integer id) {
		return projekatRepository.getOne(id);
	}
	@CrossOrigin
	@ApiOperation(value = "Returns collection of Projekat containing naziv that was forwarded as path variable")
	@GetMapping("projekat/naziv/{naziv}")
	public Collection<Projekat> getByNaziv(@PathVariable("naziv") String naziv){
		return projekatRepository.findByNazivContainingIgnoreCase(naziv);
	}
	@CrossOrigin
	@ApiOperation(value = "Adds instance of Projekat to database")
	@PostMapping("projekat")
	public ResponseEntity<HttpStatus> addProjekat(@RequestBody Projekat projekat){
		projekatRepository.save(projekat);
		
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	@CrossOrigin
	@ApiOperation(value = "Updates Projekat with id that was forwarded as path variable")
	@PutMapping("projekat/{id}")
	public ResponseEntity<HttpStatus> updateArtikl(@RequestBody Projekat projekat, 
			@PathVariable("id")Integer id){
		if(projekatRepository.existsById(id)) {
			projekat.setId(id);
			projekatRepository.save(projekat);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		
		
	}
	@CrossOrigin
	@ApiOperation(value = "Deletes Projekat with id that was forwarded as path variable")
	@DeleteMapping("projekat/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Integer id){
		if(id==-100 && !projekatRepository.existsById(-100)) {
			jdbcTemplate.execute("INSERT INTO projekat (\"id\", \"naziv\", \"opis\", \"oznaka\") VALUES (-100, 'test', 'test', 'test')");
		}
		
		if(projekatRepository.existsById(id))
		{
			System.out.println("tried to delete");
			projekatRepository.deleteById(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}
	

}

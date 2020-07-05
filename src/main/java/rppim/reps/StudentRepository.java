package rppim.reps;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import rppim.jpa.Grupa;
import rppim.jpa.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	Collection<Student> findByBrojIndeksaContainingIgnoreCase(String brojIndeksa);
	Collection<Student> findByGrupa(Grupa grupa);
	
}

package rppim.reps;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import rppim.jpa.Projekat;

public interface ProjekatRepository extends JpaRepository<Projekat, Integer> {
	Collection<Projekat> findByNazivContainingIgnoreCase(String naziv);
}

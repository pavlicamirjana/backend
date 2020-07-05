package rppim.reps;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import rppim.jpa.Smer;

public interface SmerRepository extends JpaRepository<Smer, Integer> {
	Collection<Smer> findByNazivContainingIgnoreCase(String naziv);
}

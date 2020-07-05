package rppim.reps;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import rppim.jpa.Grupa;

public interface GrupaRepository extends JpaRepository<Grupa, Integer>{
	Collection<Grupa> findByOznakaContainingIgnoreCase(String oznaka);
}

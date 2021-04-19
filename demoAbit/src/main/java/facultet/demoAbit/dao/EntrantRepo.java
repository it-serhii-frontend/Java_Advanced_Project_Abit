package facultet.demoAbit.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import facultet.demoAbit.domain.Entrant;

@Repository
public interface EntrantRepo extends JpaRepository<Entrant, Integer> {

	Optional<Entrant> findByLastName(String lastName);
	
	Optional<Entrant> findByEmail(String email);
}

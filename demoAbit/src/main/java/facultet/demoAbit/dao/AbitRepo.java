package facultet.demoAbit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import facultet.demoAbit.domain.Abit;

public interface AbitRepo extends JpaRepository<Abit, Integer> {

}

package facultet.demoAbit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import facultet.demoAbit.dao.EntrantRepo;
import facultet.demoAbit.domain.Entrant;
import facultet.demoAbit.domain.EntrantAdmin;

@Service("entrantService")
public class EntrantService {

	@Autowired
	private EntrantRepo entrantRepo;
	
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	public void save(Entrant entrant) {
		entrant.setPassword(bCryptPasswordEncoder.encode(entrant.getPassword()));
		entrant.setPassword(bCryptPasswordEncoder.encode(entrant.getPasswordConfirm()));
		entrant.setRole(EntrantAdmin.Entrant);
		entrantRepo.save(entrant);
	}
	
	public List<Entrant> getAllEntrants(){
		return entrantRepo.findAll();
	}
}

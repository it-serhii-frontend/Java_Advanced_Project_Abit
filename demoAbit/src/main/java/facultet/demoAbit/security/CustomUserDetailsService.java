package facultet.demoAbit.security;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import facultet.demoAbit.dao.EntrantRepo;
import facultet.demoAbit.domain.Entrant;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private EntrantRepo entrantRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String lastName) throws UsernameNotFoundException {
		
		Optional <Entrant> userOpt = entrantRepo.findByLastName(lastName);
		
		if (userOpt.isPresent()) {
			Entrant entrant = userOpt.get();
			return new CustomUserDetails(entrant, Collections.singletonList(entrant.getRole().toString()));
		}
		throw new UsernameNotFoundException("No user present with lastName: "+lastName);
	}
}
package pl.finanse.zrzutek.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ZrzutekUserDetailsService implements UserDetailsService{
	@Autowired
	private UsersRepository usersRepository;

	public ZrzutekUserDetailsService(UsersRepository usersRepository) {
		super();
		this.usersRepository = usersRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = this.usersRepository.findByUsername(username);
		if(null==user)
		{
			throw new UsernameNotFoundException("cannot find username: "+ username);
		}
		return new ZrzutekUserPrincipal(user);
	}
	
	
}

package fi.haagahelia.lautapelit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fi.haagahelia.lautapelit.domain.ApplicationUser;
import fi.haagahelia.lautapelit.domain.ApplicationUserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	private static final Logger log = LoggerFactory.getLogger(UserDetailServiceImpl.class);
	private final ApplicationUserRepository repository;

	@Autowired
	public UserDetailServiceImpl(ApplicationUserRepository applicationUserRepository) {
		this.repository = applicationUserRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("loadUserByUsername: " + username);
		ApplicationUser curruser = repository.findByUsername(username);
		UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPasswordHash(),
				AuthorityUtils.createAuthorityList(curruser.getRole()));
		return user;
	}
}
package fi.haagahelia.lautapelit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import fi.haagahelia.lautapelit.controller.UserDetailServiceImpl;

import org.springframework.security.config.Customizer;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)  
@EnableWebSecurity 

public class WebSecurityConfig {
	@Autowired
	private UserDetailServiceImpl userDetailsService;

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {

		return http.authorizeRequests(auth -> {
			//Alla olevat tiedostot ovat kaikille saatavilla
			auth.antMatchers("/css/**").permitAll();
			auth.antMatchers("/h2-console/**").permitAll();
			auth.antMatchers("/h2-console").permitAll();
			// Ainoastaan ADMIN-tason käyttäjät pääsevät tyypit-kansioihin kiinni
			auth.antMatchers("/tyypit/**").hasAuthority("ADMIN");
			// kaikki HTTP-pyynnöt autentikoidaan
			auth.anyRequest().authenticated();
		}).csrf().ignoringAntMatchers("h2-console").and()
				
				.headers().frameOptions().disable().and()
			
				.csrf().ignoringAntMatchers("/h2-console/**").and()
				// Kun log in onnistuu vie sovellus käyttäjän lautapelilistaus-sivulle
				.formLogin().defaultSuccessUrl("/lautapelilistaus", true).and()
				// Kaikki voivat kirjautua ulos
				.logout().permitAll().and()
				.httpBasic(Customizer.withDefaults()).build();
	}

	@Autowired //Kirjautumiseen
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
}
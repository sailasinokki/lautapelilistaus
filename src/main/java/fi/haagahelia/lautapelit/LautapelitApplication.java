package fi.haagahelia.lautapelit;

import org.springframework.boot.SpringApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.lautapelit.domain.ApplicationUser;
import fi.haagahelia.lautapelit.domain.ApplicationUserRepository;
import fi.haagahelia.lautapelit.domain.Lautapeli;
import fi.haagahelia.lautapelit.domain.LautapeliRepository;
import fi.haagahelia.lautapelit.domain.Tyyppi;
import fi.haagahelia.lautapelit.domain.TyyppiRepository;


@SpringBootApplication
public class LautapelitApplication {
	private static final Logger Log = LoggerFactory.getLogger(LautapelitApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(LautapelitApplication.class, args); //Päämetodi
	}

	@Autowired
	ApplicationUserRepository applicationUserRepository; 
	
	

	@Bean
	public CommandLineRunner peliDemo(LautapeliRepository repository, TyyppiRepository trepository, ApplicationUserRepository applicationUserRepository) {  //Tämä metodi lähtee päälle kun sovellus on ladannut
		return (args) -> {
			
		/*	Log.info("Lautapelityypit");
			trepository.save(new Tyyppi ("Lautapeli"));
			trepository.save(new Tyyppi ("Korttipeli"));
			trepository.save(new Tyyppi ("Palapeli"));
			
			repository.save(new Lautapeli("Cluedo", "Hasbro", "5010993334858", 2016, 29.90, trepository.findByTnimi("Lautapeli").get(0)));
			repository.save(new Lautapeli("HGA Trivial Pursuit Classic Edition FI", "Hasbro", "5010993425716", 2014, 36.50, trepository.findByTnimi("Lautapeli").get(0)));
			repository.save(new Lautapeli("HGA Classic Monopoly FI", "Hasbro", "5010993414413", 2018, 33.80, trepository.findByTnimi("Lautapeli").get(0)));
			repository.save(new Lautapeli("Kuurupiilo", "Lautapelit.fi", "6430018276045", 2020, 8.95, trepository.findByTnimi("Palapeli").get(0)));
			
			
			//Käyttäjädataa H2-konsoliin
			Log.info("Luodaan kayttajia sovellukseen");
			ApplicationUser user1 = new ApplicationUser("Iines", "Ankka", "USER", "user", "$2a$10$l1KFNzL670PS0mo5Xkv3GexvycvQlMzsllYr2zug/w3eHI.uzZZv.");
			ApplicationUser user2 = new ApplicationUser("Pupu", "Tupuna", "ADMIN", "admin", "$2a$10$gxiWSFreoGML6Y2KQya0CerBTqOJlQUGpoM/GkIDtvldxEKcauFzi");
			applicationUserRepository.save(user1);
			applicationUserRepository.save(user2); */
			
			//Tulostetaan demodata konsoliin naytille
			Log.info("Kaikki pelit");
			for (Lautapeli lautapeli : repository.findAll()) {
				Log.info(lautapeli.toString());
			}
		};
	}	
	
}

package fi.haagahelia.lautapelit;

import org.springframework.boot.SpringApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.lautapelit.domain.Lautapeli;
import fi.haagahelia.lautapelit.domain.LautapeliRepository;
import fi.haagahelia.lautapelit.domain.Tyyppi;
import fi.haagahelia.lautapelit.domain.TyyppiRepository;


@SpringBootApplication
public class LautapelitApplication {
	private static final Logger Log = LoggerFactory.getLogger(LautapelitApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(LautapelitApplication.class, args); //Main method
	}

	@Bean
	public CommandLineRunner peliDemo(LautapeliRepository repository, TyyppiRepository trepository) {  //Run after the application has started
		return (args) -> {
			
			Log.info("Lautapelityypit");
			trepository.save(new Tyyppi ("Lautapeli"));
			trepository.save(new Tyyppi ("Korttipeli"));
			trepository.save(new Tyyppi ("Palapeli"));
			
			repository.save(new Lautapeli("Cluedo", "Hasbro", "5010993334858", 2016, 29.90, trepository.findByTnimi("Lautapeli").get(0)));
			repository.save(new Lautapeli("HGA Trivial Pursuit Classic Edition FI", "Hasbro", "5010993425716", 20114, 36.50, trepository.findByTnimi("Lautapeli").get(0)));
			repository.save(new Lautapeli("HGA Classic Monopoly FI", "Hasbro", "5010993414413", 2018, 33.80, trepository.findByTnimi("Lautapeli").get(0)));
			repository.save(new Lautapeli("Kuurupiilo", "Lautapelit.fi", "6430018276045", 2020, 8.95, trepository.findByTnimi("Palapeli").get(0)));
			
			Log.info("Hae pelit");
			for (Lautapeli lautapeli : repository.findAll()) {
				Log.info(lautapeli.toString());
			}
		};
	}	
	
}

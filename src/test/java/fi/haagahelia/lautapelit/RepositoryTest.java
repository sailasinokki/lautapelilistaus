package fi.haagahelia.lautapelit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import fi.haagahelia.lautapelit.domain.Lautapeli;
import fi.haagahelia.lautapelit.domain.LautapeliRepository;
import fi.haagahelia.lautapelit.domain.Tyyppi;
import fi.haagahelia.lautapelit.domain.TyyppiRepository;

@DataJpaTest
class RepositoryTest {
	
	@Autowired
	LautapeliRepository repository;
	
	@Autowired
	TyyppiRepository trepository;
	

		//Testataan lautapelityypin etsimista jarjestelmasta
	
		@Test
		public void findByTyyppi() {
			
			Tyyppi tyyppi = repository.findById((long) 3).get().getTyyppi();
			System.out.println("Hae id:llä 3 " + tyyppi);
			
			assertEquals(tyyppi.getTnimi(), "Lautapeli");
		}
		
		//Testataan uuden lautapelin lisaamista jarjestelmaan
		 @Test
		 public void insertUusiLautapeli() {
			 
			 Lautapeli lautapeli = new Lautapeli("Afrikan Tähti", "Puolen Kuun Pelit", "52896374123", 2002, 5.50, null);
			 repository.save(lautapeli);
			 assertNotNull(lautapeli.getId());
		 }
		 

	}


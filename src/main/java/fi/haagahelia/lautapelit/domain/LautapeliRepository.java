package fi.haagahelia.lautapelit.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LautapeliRepository extends CrudRepository<Lautapeli, Long> {
	List<Lautapeli> findByNimi(String nimi);
	
	//Etsitaan tuotemerkkia RepositoryTest-tiedostossa
	List<Lautapeli> findByTuotemerkki(String tuotemerkki);
}

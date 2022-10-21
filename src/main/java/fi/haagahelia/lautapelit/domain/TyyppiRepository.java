package fi.haagahelia.lautapelit.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TyyppiRepository extends CrudRepository <Tyyppi, Long> {

	List<Tyyppi> findByTnimi(String tnimi);
}

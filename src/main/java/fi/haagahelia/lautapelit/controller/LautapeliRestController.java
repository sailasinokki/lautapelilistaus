package fi.haagahelia.lautapelit.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fi.haagahelia.lautapelit.domain.Lautapeli;
import fi.haagahelia.lautapelit.domain.LautapeliRepository;

@RestController //Tämä kontroller vastaa rajapintapyyntöihin
public class LautapeliRestController {

	@Autowired
	LautapeliRepository repository;
	
	//Nayttaa kaikki tietokannan lautapelit
	  @RequestMapping(value="/lautapelit", method = RequestMethod.GET)
	    public @ResponseBody List<Lautapeli> LautapeliApplication() {	
	        return (List<Lautapeli>) repository.findAll();
	    }  
	  
	  //Poista lautapeli
	  @RequestMapping(value="/lautapelit/{id}", method = RequestMethod.DELETE)
	  public Iterable<Lautapeli> poistaAuto(@PathVariable Long id) {
		  repository.deleteById(id);
		  return repository.findAll();
	  }
	  
	 //Lisaa uuden lautapelin
	  @RequestMapping(value="lautapelit", method = RequestMethod.POST)
	  Lautapeli newLautapeli (@RequestBody Lautapeli newLautapeli) {
		  return repository.save(newLautapeli);
	  }
	  
	  //Muokkaa olemassa olevaa pelia
	  @RequestMapping(value="/lautapelit/{id}", method = RequestMethod.PUT)
	  Lautapeli muokattuLautapeli(@RequestBody Lautapeli muokattuLautapeli, @PathVariable Long id) {
	  muokattuLautapeli.setId(id);
	  return repository.save(muokattuLautapeli);
	  }
	  
	  //Etsitaan joku tietty lautapeli
	  @RequestMapping(value="/lautapelit/{id}", method = RequestMethod.GET)
	  Optional<Lautapeli> getLautapeli (@PathVariable Long id) {
		  return repository.findById(id);
	  }
}

package fi.haagahelia.lautapelit.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.lautapelit.domain.Lautapeli;
import fi.haagahelia.lautapelit.domain.LautapeliRepository;
import fi.haagahelia.lautapelit.domain.TyyppiRepository;

@Controller

public class LautapeliController {

	@Autowired //repository class will be injected to controller class
	private LautapeliRepository repository;
	
	@Autowired
	private TyyppiRepository trepository;
	
	// Etsi kaikki lautapelit
	@RequestMapping(value = { "/", "lautapelilistaus" })
	public String lautapeliLista(Model model) {
		model.addAttribute("lautapelit", repository.findAll());
		return "lautapelilistaus";
	}

	// Poista peli
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteLautapeli(@PathVariable("id") Long lautapeliId, Model model) {
		repository.deleteById(lautapeliId);
		return "redirect:../lautapelilistaus";
	}

	// Lisaa peli
	@RequestMapping(value = "/add")
	public String addLautapeli(Model model) {
		model.addAttribute("lautapeli", new Lautapeli());
		model.addAttribute("tyypit", trepository.findAll());
		return "lisaapeli";
	}

	// Tallenna peli
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveLautapeli(Lautapeli lautapeli) {
		repository.save(lautapeli);
		return "redirect:lautapelilistaus";
	}
	
	 // Muokkaa pelia
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editLautapeli(@PathVariable("id") Long LautapeliId, Model model) {
    	model.addAttribute("lautapeli", repository.findById(LautapeliId));
    	model.addAttribute("tyypit", trepository.findAll());
    	return "muokkaapeli";
    }   
    
 // RESTful kaikkien lautapelien etsintään
    @RequestMapping(value="/lautapelit", method = RequestMethod.GET)
    public @ResponseBody List<Lautapeli> LautapeliApplication() {	
        return (List<Lautapeli>) repository.findAll();
    }  
}

package fi.haagahelia.lautapelit.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.lautapelit.domain.Lautapeli;
import fi.haagahelia.lautapelit.domain.LautapeliRepository;
import fi.haagahelia.lautapelit.domain.TyyppiRepository;

@Controller //Vastaa Thymeleafin komentoihin

public class LautapeliController {

	@Autowired //Repository luokka-injektoidaan controller-luokkaan
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
	@PreAuthorize("hasAuthority('ADMIN')")
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
	public String saveLautapeli(@Valid Lautapeli lautapeli, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			System.out.print("Error happened");
			return "lisaapeli";
		}
			repository.save(lautapeli);
		return "redirect:lautapelilistaus";
				}
	
	 // Muokkaa peliä
	@PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editLautapeli(@PathVariable("id") Long LautapeliId, Model model) {
    	model.addAttribute("lautapeli", repository.findById(LautapeliId));
    	model.addAttribute("tyypit", trepository.findAll());
    	return "muokkaapeli";
    }   
    
}

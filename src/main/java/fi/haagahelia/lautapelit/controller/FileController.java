package fi.haagahelia.lautapelit.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import fi.haagahelia.lautapelit.domain.FileModel;
import fi.haagahelia.lautapelit.domain.FileModelRepository;

@Controller

//Tiedoston lisaaminen sovellukseen

public class FileController {
@Autowired
private FileModelRepository repository; 
	
	@Value("${upload.path}")
	private String uploadFolder;
	
	// Upload-toiminnallisuuden haku lautapelilistaus-sivulla
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "lautapelilistaus";
	}

	// Tiedoston käsittely
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String fileUpload(@RequestParam("file") MultipartFile file, Model model) {
		   if (file.isEmpty()) {
	        	model.addAttribute("msg", "Lautaus tietokantaan epäonnistui");
	            return "uploadstatus";
	        }

	        try {
	            FileModel fileModel = new FileModel(file.getOriginalFilename(), file.getContentType(), file.getBytes());
	            repository.save(fileModel);
	    
	            return "redirect:/files";
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return "uploadstatus";
	    }
	 
}
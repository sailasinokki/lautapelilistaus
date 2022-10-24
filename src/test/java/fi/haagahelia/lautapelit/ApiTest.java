package fi.haagahelia.lautapelit;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class ApiTest {

	@Autowired
	private WebApplicationContext webAppContext;

	private MockMvc mockMvc;

	@BeforeEach

	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
	}

	//Kutsutaan kaikki lautapelit ja virhekasittely
	@Test
	public void checkStatus() {
		try {
			this.mockMvc.perform(get("/lautapelit")).andExpect(status().isOk());	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Haetaan entiteetti-luokasya tiedot rajapinnassa hakemiston api-alta
	@Test
	public void apiStatusOk() throws Exception {
		this.mockMvc.perform(get("/api/lautapelis")).andExpect(status().isOk());
	}
	
	}

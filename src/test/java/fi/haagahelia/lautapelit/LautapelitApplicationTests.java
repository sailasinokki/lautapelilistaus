package fi.haagahelia.lautapelit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import fi.haagahelia.lautapelit.controller.LautapeliController;

@SpringBootTest
class LautapelitApplicationTests {

	@Autowired
	LautapeliController lautapeliController;
	
	@Test
	public void contextLoads() throws Exception {
	assertThat(lautapeliController).isNotNull();
	}

}

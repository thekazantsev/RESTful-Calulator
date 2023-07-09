package theKazantsev.RESTfulCalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class GreetingControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void helloTestWithoutNameParam() throws Exception {
		this.mockMvc
			.perform(get("/greeting"))
			.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.content").value("Hello, World!"));
	}

	@Test
	public void helloTestWithNameParam() throws Exception {
		this.mockMvc
			.perform(get("/greeting").param("name", "alekseiKa"))
			.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.content").value("Hello, alekseiKa!"));
	}
}

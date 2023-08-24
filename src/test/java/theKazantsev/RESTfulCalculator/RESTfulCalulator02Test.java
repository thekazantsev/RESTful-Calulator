package theKazantsev.RESTfulCalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RESTfulCalulator02Test {

	@Autowired
	private MockMvc mockMvc;

	@ParameterizedTest
	@CsvSource({
		"1, 2, 3",
		"5, 10.1, 15.1",
		"0, -10, -10"
	})
	public void addTest(double arg1, double arg2, double expected) throws Exception {
		this.mockMvc
			.perform(get("/add").param("arg1", String.valueOf(arg1)).param("arg2", String.valueOf(arg2)))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.result").value(String.valueOf(expected)));
	}

	@ParameterizedTest
	@CsvSource({
		"1, 2, 0.5",
		"10, 5, 2",
		"-8, 4, -2",
		"0, 10, 0"
	})
	public void divideTest(double arg1, double arg2, double expected) throws Exception {
		this.mockMvc
			.perform(get("/divide").param("arg1", String.valueOf(arg1)).param("arg2", String.valueOf(arg2)))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.result").value(String.valueOf(expected)));
	}

	@Test
	public void divideByZeroTest() throws Exception {
		double arg1 = 1;
		double arg2 = 0;

		this.mockMvc
			.perform(get("/divide").param("arg1", String.valueOf(arg1)).param("arg2", String.valueOf(arg2)))
			.andDo(print())
			.andExpect(status().isBadRequest())
			.andExpect(jsonPath("$.error").value("Can't divide by zero"));
	}

	@ParameterizedTest
	@CsvSource({
		"1, 2, 2",
		"10, 5, 50",
		"-8, 4, -32",
		"0, 10, 0"
	})
	public void multiplyTest(double arg1, double arg2, double expected) throws Exception {
		this.mockMvc
			.perform(get("/multiply").param("arg1", String.valueOf(arg1)).param("arg2", String.valueOf(arg2)))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.result").value(String.valueOf(expected)));
	}

	@ParameterizedTest
	@CsvSource({
		"1, 2, 1",
		"10, 5, 100000",
		"-8, 4, 4096",
		"0, 10, 0"
	})
	public void powTest(double arg1, double arg2, double expected) throws Exception {
		this.mockMvc
			.perform(get("/pow").param("arg1", String.valueOf(arg1)).param("arg2", String.valueOf(arg2)))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.result").value(String.valueOf(expected)));
	}

	@ParameterizedTest
	@CsvSource({
		"4, 2",
		"25, 5",
		"9, 3",
		"0, 0"
	})
	public void sqrtTest(double arg1, double expected) throws Exception {
		this.mockMvc
			.perform(get("/sqrt").param("arg1", String.valueOf(arg1)))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.result").value(String.valueOf(expected)));
	}

	@ParameterizedTest
	@CsvSource({
		"1, 2, -1",
		"10, 5, 5",
		"-8, 4, -12",
		"0, 10, -10"
	})
	public void subtractTest(double arg1, double arg2, double expected) throws Exception {
		this.mockMvc
			.perform(get("/subtract").param("arg1", String.valueOf(arg1)).param("arg2", String.valueOf(arg2)))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.result").value(String.valueOf(expected)));
	}
}

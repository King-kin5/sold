package com.example.SALE;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private Respo Respo;

	@BeforeEach
	public void deleteAllBeforeTests() throws Exception {
		Respo.deleteAll();
	}

	@Test
	public void shouldReturnRepositoryIndex() throws Exception {

		mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(
				jsonPath("$._links.dom").exists());
	}

	@Test
	public void shouldCreateEntity() throws Exception {

		mockMvc.perform(post("/dom").content(
				"{\"RequestReference\": \"5263y3hhduruj\", \" BusinessId\":\"3\",\"ItemId\":\"42\",\"TransactionReference\":\"B3tt6je7\",\"TransactionType\":\"sale\",\"TransactionAmount\":\"4500\",\"TransactionDate\":\"12/9/2022\",\" Quantity\":\"7\"}")).andExpect(
				status().isCreated()).andExpect(
				header().string("Location", containsString("dom/")));
	}

	@Test
	public void shouldRetrieveEntity() throws Exception {

		MvcResult mvcResult = mockMvc.perform(post("/dom").content(
				"{\"RequestReference\": \"5263y3hhduruj\", \" BusinessId\":\"3\",\"ItemId\":\"42\",\"TransactionReference\":\"B3tt6je7\",\"TransactionType\":\"sale\",\"TransactionAmount\":\"4500\",\"TransactionDate\":\"12/9/2022\",\" Quantity\":\"7\"}")).andExpect(
				status().isCreated()).andReturn();

		String location = mvcResult.getResponse().getHeader("Location");
		mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
				jsonPath("$.RequestReference").value("5263y3hhduruj.")).andExpect(
				jsonPath("$.BusinessId").value("3")).andExpect(
				jsonPath("$.ItemId").value("42")).andExpect(
				jsonPath("$.TransactionReference").value("B3tt6je7")).andExpect(
				jsonPath("$.TransactionType").value("sale")).andExpect(
				jsonPath("$.TransactionAmount").value("4500")).andExpect(
				jsonPath("$.TransactionDate").value(12/9/2022));
	}

	@Test
	public void shouldQueryEntity() throws Exception {

		mockMvc.perform(post("/dom").content(
				"{\"RequestReference\": \"5263y3hhduruj\", \" BusinessId\":\"3\",\"ItemId\":\"42\",\"TransactionReference\":\"B3tt6je7\",\"TransactionType\":\"sale\",\"TransactionAmount\":\"4500\",\"TransactionDate\":\"12/9/2022\",\" Quantity\":\"7\" }")).andExpect(
				status().isCreated());

		mockMvc.perform(
				get("/dom/search/findByItemId?ItemId={ItemId}", "")).andExpect(
				status().isOk()).andExpect(
				jsonPath("$._embedded.dom[0].RequestReference").value("5263y3hhduruj.")).andExpect(
				jsonPath("$._embedded.dom[0].BusinessId").value("3")).andExpect(
				jsonPath("$._embedded.dom[0].TransactionReference").value("B3tt6je7")).andExpect(
				jsonPath("$._embedded.dom[0].TransactionType").value("sale")).andExpect(
				jsonPath("$._embedded.dom[0].TransactionAmount").value("4500")).andExpect(
				jsonPath("$._embedded.dom[0].TransactionDate").value(12/9/2022));

	}
	@Test
	public void shouldUpdateEntity() throws Exception {

		MvcResult mvcResult = mockMvc.perform(post("/dom").content(
				"{\"RequestReference\": \"5263y3hhduruj\", \" BusinessId\":\"3\",\"ItemId\":\"42\",\"TransactionReference\":\"B3tt6je7\",\"TransactionType\":\"sale\",\"TransactionAmount\":\"4500\",\"TransactionDate\":\"12/9/2022\",\" Quantity\":\"7\"}")).andExpect(
				status().isCreated()).andReturn();

		String location = mvcResult.getResponse().getHeader("Location");

		mockMvc.perform(put(location).content(
				"{\"RequestReference\": \"5263y3hhduruj\", \" BusinessId\":\"3\",\"ItemId\":\"42\",\"TransactionReference\":\"B3tt6je7\",\"TransactionType\":\"sale\",\"TransactionAmount\":\"4500\",\"TransactionDate\":\"12/9/2022\",\" Quantity\":\"7\"}")).andExpect(
				status().isNoContent());

		mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
				jsonPath("$.RequestReference").value("5263y3hhduruj.")).andExpect(
				jsonPath("$.BusinessId").value("3")).andExpect(
				jsonPath("$.ItemId").value("42")).andExpect(
				jsonPath("$.TransactionReference").value("B3tt6je7")).andExpect(
				jsonPath("$.TransactionType").value("sale")).andExpect(
				jsonPath("$.TransactionAmount").value("4500")).andExpect(
				jsonPath("$.TransactionDate").value(12/9/2022));
	}

	@Test
	public void shouldPartiallyUpdateEntity() throws Exception {

		MvcResult mvcResult = mockMvc.perform(post("/dom").content(
				"{\"RequestReference\": \"5263y3hhduruj\", \" BusinessId\":\"3\",\"ItemId\":\"42\",\"TransactionReference\":\"B3tt6je7\",\"TransactionType\":\"sale\",\"TransactionAmount\":\"4500\",\"TransactionDate\":\"12/9/2022\",\" Quantity\":\"7\"}")).andExpect(
				status().isCreated()).andReturn();

		String location = mvcResult.getResponse().getHeader("Location");

		mockMvc.perform(
				patch(location).content("{\"RequestReference\": \"5263y3hhduruj\", \" BusinessId\":\"3\",\"ItemId\":\"42\",\"TransactionReference\":\"B3tt6je7\",\"TransactionType\":\"sale\",\"TransactionAmount\":\"4500\",\"TransactionDate\":\"12/9/2022\",\" Quantity\":\"7\"}")).andExpect(
				status().isNoContent());

		mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
				jsonPath("$.RequestReference").value("5263y3hhduruj.")).andExpect(
				jsonPath("$.BusinessId").value("3")).andExpect(
				jsonPath("$.ItemId").value("42")).andExpect(
				jsonPath("$.TransactionReference").value("B3tt6je7")).andExpect(
				jsonPath("$.TransactionType").value("sale")).andExpect(
				jsonPath("$.TransactionAmount").value("4500")).andExpect(
				jsonPath("$.TransactionDate").value(12/9/2022));
	}

	@Test
	public void shouldDeleteEntity() throws Exception {

		MvcResult mvcResult = mockMvc.perform(post("/dom").content(
				"{\"RequestReference\": \"5263y3hhduruj\", \" BusinessId\":\"3\",\"ItemId\":\"42\",\"TransactionReference\":\"B3tt6je7\",\"TransactionType\":\"sale\",\"TransactionAmount\":\"4500\",\"TransactionDate\":\"12/9/2022\",\" Quantity\":\"7\" }")).andExpect(
				status().isCreated()).andReturn();

		String location = mvcResult.getResponse().getHeader("Location");
		mockMvc.perform(delete(location)).andExpect(status().isNoContent());

		mockMvc.perform(get(location)).andExpect(status().isNotFound());
	}
}

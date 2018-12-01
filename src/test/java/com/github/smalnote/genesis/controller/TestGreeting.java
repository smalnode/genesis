package com.github.smalnote.genesis.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.http.MediaType;

public class TestGreeting extends AbstractTextContext {

	@Test
	public void test() throws Exception {
		this.mockMvc.perform(get("/greeting").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk());
	}
}

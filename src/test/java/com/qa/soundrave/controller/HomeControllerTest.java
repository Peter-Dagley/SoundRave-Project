package com.qa.soundrave.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class HomeControllerTest {

	@Autowired
	private HomeController controller;
	
	@Test
	public void homeTest() {
		assertEquals("home.html", this.controller.home());
	}
	
	@Test
	public void artistTest() {
		assertEquals("artistpage.html", this.controller.artistpage());
	}
	
}

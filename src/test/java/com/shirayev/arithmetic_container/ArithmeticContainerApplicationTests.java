package com.shirayev.arithmetic_container;

import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Suite
@SelectPackages("com.shirayev.arithmetic_container.controllers")
class ArithmeticContainerApplicationTests {

	@Test
	void contextLoads() {
	}

}

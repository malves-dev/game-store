package com.game.store;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GameStoreApplication.class)
// @ContextConfiguration(locations = "classpath:prazo.properties")
@TestPropertySource(locations="classpath:url.properties")
public class GameStoreApplicationTests {

	@Test
	public void contexLoads() throws Exception {
		// assertThat(produtoController).isNotNull();
	}

}

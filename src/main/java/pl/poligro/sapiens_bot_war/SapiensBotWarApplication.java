package pl.poligro.sapiens_bot_war;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.poligro.sapiens_bot_war.responses.Response;

import java.util.Random;

@SpringBootApplication
public class SapiensBotWarApplication {

	public static void main(String[] args) {
		SpringApplication.run(SapiensBotWarApplication.class, args);
	}

    @Bean
    Random getRandom() {
	    return new Random();
    }

    @Bean
	Response getResponse() {
		return new Response();
	}

}

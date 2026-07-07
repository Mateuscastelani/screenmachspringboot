package br.com.castellani.screenmachspringboot;

import br.com.castellani.screenmachspringboot.service.ConsumoApi;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmachspringbootApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmachspringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumoApi consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("http://www.omdbapi.com/?t=lost&apikey=ddc92677");
		System.out.println(json);

	}
}

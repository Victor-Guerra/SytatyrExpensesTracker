package mx.tec.com;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SytatyrExpenseTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SytatyrExpenseTrackerApplication.class, args);
	}
	
	/**
	 * Create a Model Mapper for the Application
	 * @return A model Mapper for conversion between objects
	 */
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
}

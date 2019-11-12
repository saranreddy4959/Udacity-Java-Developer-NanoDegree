package com.saran.consumingsoap;

import com.dataaccess.webservicesserver.NumberToWords;
import com.dataaccess.webservicesserver.NumberToWordsResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@SpringBootApplication
public class ConsumingSoapApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConsumingSoapApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		NumberClient nc = new NumberClient();

		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

		marshaller.setContextPath("com.dataaccess.webservicesserver");


		nc.setMarshaller(marshaller);
		nc.setUnmarshaller(marshaller);


		NumberToWordsResponse response = nc.getWords("9876");

		System.out.println("Response is: "+ response.getNumberToWordsResult());
	}
}

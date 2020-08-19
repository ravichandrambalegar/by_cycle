package com.example.by_cycle;

import com.example.by_cycle.model.InputData;
import com.example.by_cycle.model.PartPrice;
import com.example.by_cycle.model.PartPriceStorage;
import com.example.by_cycle.model.Parts;
import com.example.by_cycle.threads.CalculatePrice;
import com.example.by_cycle.threads.GenerateCycle;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;


@SpringBootApplication
public class ByCycleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ByCycleApplication.class, args);

		BlockingQueue<List<Parts>> queue = new ArrayBlockingQueue<>(10);

		PartPriceStorage partPriceStorage = new PartPriceStorage();
		List<InputData> inputDataList = new ArrayList<>();
		try
		{
			//set input here from local
			String filePath = "/Users/ravichandrabalegar/Desktop/database.json";
			String filePath1 = "/Users/ravichandrabalegar/Desktop/user-input.json";
			byte[] priceData = Files.readAllBytes(new File(filePath).toPath());
			byte[] userInputData = Files.readAllBytes(new File(filePath1).toPath()); // change user input here
			PartPrice[] partPrices = null;

			ObjectMapper objectMapper = new ObjectMapper();
			partPrices = objectMapper.readValue(priceData, PartPrice[].class);
			List<PartPrice> partPriceList = Arrays.asList(partPrices);
			partPriceStorage.setPartPrices(partPriceList);


			InputData[] inputData = null;
			ObjectMapper objectMapper1 = new ObjectMapper();

			inputData = objectMapper1.readValue(userInputData,InputData[].class);
			inputDataList =  Arrays.asList(inputData);

		}
		catch(JsonMappingException ex)
		{
			ex.printStackTrace();
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		new Thread(new GenerateCycle(queue,inputDataList,partPriceStorage)).start();
		new Thread(new CalculatePrice(queue)).start();

	}

}

package com.example.by_cycle;

import com.example.by_cycle.enums.HighLevelComponent;
import com.example.by_cycle.enums.Months;
import com.example.by_cycle.model.*;
import com.example.by_cycle.threads.CalculatePrice;
import com.example.by_cycle.threads.GenerateCycle;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PriceEngineTest {
    @Test
    public void displayCyclePrice(){

        BlockingQueue<List<Parts>> queue = new ArrayBlockingQueue<>(10);

        List<InputData> inputDataList = new ArrayList<>();
        int count =0;
        // List of parts generator -- start
        while(count<10){
            InputData inputData = new InputData();
            List<PartsUserInput> userInputs = new ArrayList<>();
            Random random = new Random();
            int min = 1;
            userInputs.add(new PartsUserInput("Part " + (min+random.nextInt(2)), "Frame"));
            userInputs.add(new PartsUserInput("Part " + (min+random.nextInt(2)), "Handle with brake"));
            userInputs.add(new PartsUserInput("Part " + (min+random.nextInt(2)), "Seating"));
            userInputs.add(new PartsUserInput("Part " + (min+random.nextInt(2)), "Wheels"));
            userInputs.add(new PartsUserInput("Part " + (min+random.nextInt(2)), "Chain assembly"));
            Date pricingDate = new Date();
            inputData.setParts(userInputs);
            inputData.setPricingDate(new SimpleDateFormat("dd-MM-yyyy").format(pricingDate));
            inputDataList.add(inputData);
            count++;
        }

        // com.priceengine.test.models.Parts price storage -- start
        List<PartPrice> partPrices = new ArrayList<>();
        PartPriceStorage partPriceStorage = new PartPriceStorage();
        for(Months months : Months.values()){
            for(HighLevelComponent highLevelComponent : HighLevelComponent.values()){
                for(int i=1;i<=3;i++){
                    int min = 1;
                    PartPrice partPrice = new PartPrice();
                    partPrice.setPartName("Part "+ i);
                    partPrice.setPartPrice(BigDecimal.valueOf((min+new Random().nextInt(100))));
                    partPrice.setMonths(months);
                    partPrice.setHighLevelComponent(highLevelComponent);
                    partPrices.add(partPrice);
                }
            }
        }
        partPriceStorage.setPartPrices(partPrices);
        new Thread(new GenerateCycle(queue,inputDataList,partPriceStorage)).start();
//System.out.println("queue:::::"+queue);
new Thread(new CalculatePrice(queue)).start();
    }
}
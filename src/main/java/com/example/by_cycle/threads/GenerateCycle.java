package com.example.by_cycle.threads;

import com.example.by_cycle.model.InputData;
import com.example.by_cycle.model.PartPriceStorage;
import com.example.by_cycle.model.Parts;
import com.example.by_cycle.model.PartsUserInput;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class GenerateCycle implements Runnable{

    private final BlockingQueue<List<Parts>> queue;

    private final List<InputData> inputData;

    private final PartPriceStorage partPriceStorage;

    public GenerateCycle(BlockingQueue<List<Parts>> queue, List<InputData> inputData, PartPriceStorage partPriceStorage) {
        this.queue = queue;

        this.inputData = inputData;
        this.partPriceStorage = partPriceStorage;
    }

    @Override
    public void run() {
        try{
            for(InputData inputData1 : inputData){
                createCycle(inputData1.getParts(),inputData1.getPricingDate(),partPriceStorage);
            }
        } catch (InterruptedException | ParseException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void createCycle(List<PartsUserInput> partsUserInputs, String pricingDate, PartPriceStorage partPriceStorage) throws InterruptedException, ParseException {

        List<Parts> partsList = new ArrayList<>();

        Date date = new SimpleDateFormat("dd-MM-yyyy").parse(pricingDate);

        String month = new SimpleDateFormat("MMM").format(date);

        for(PartsUserInput partsUserInput : partsUserInputs) {
            Parts parts = new Parts();
            parts.setPartName(partsUserInput.getPartName());
            parts.setComponent(partsUserInput.getComponent());
            parts.setPrice(partPriceStorage.getPartPrices().stream().filter(partPrice -> partPrice.getMonths().toString().equals(month) && partPrice.getPartName().equals(partsUserInput.getPartName())).findFirst().get().getPartPrice());
            partsList.add(parts);
            queue.put(partsList);
            System.out.println("New cycle  is generated.");
        }
    }


}

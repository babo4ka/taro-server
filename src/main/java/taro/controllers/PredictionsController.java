package taro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import taro.Application;
import taro.database.service.PredictionsService;
import taro.utils.PredictionRequester;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://192.168.0.103:3000"})
public class PredictionsController {

    @Autowired
    private PredictionsService predictionsService;

    private final String filesPath = "./src/main/resources/predictions/";

    @GetMapping("/getGeneral")
    public ResponseEntity<String> getGeneralPred() throws IOException {
        PredictionRequester pr = new PredictionRequester();
        String text = pr.request("1");


        String fileName = new Date().getTime() + ".txt";

        File predFile = new File(filesPath + "general/" +  fileName);
        FileWriter writer = new FileWriter(predFile);

        writer.write(text);
        writer.flush();

        try {
            predictionsService.addPrediction(new Date().getTime() / 1000, 1, fileName);
        }catch (Exception e){
            return new ResponseEntity<>("не так часто я не успеваю!!", HttpStatus.BAD_GATEWAY);
        }


        return new ResponseEntity<>(text, HttpStatus.OK);
    }


    @GetMapping("/getYN")
    public List<String> getYNPred() throws IOException, InterruptedException {
        PredictionRequester pr = new PredictionRequester();

        List<String> response = new ArrayList<>();

        String text;
        String fileName;

        for(int i =0; i<3; i++){
            text = pr.request("2");
            fileName = new Date().getTime() + ".txt";

            File predFile = new File(filesPath + "yn/" +  fileName);
            FileWriter writer = new FileWriter(predFile);

            writer.write(text);
            writer.flush();

            predictionsService.addPrediction(new Date().getTime() / 1000, 2, fileName);

            response.add(text);
            Thread.sleep(1000);
        }

        return response;
    }

    @GetMapping("/getPPF")
    public Map<String, String> getPPFPred() throws IOException, InterruptedException {
        //переменные
        PredictionRequester pr = new PredictionRequester();

        Map<String, String> response = new HashMap<>();

        String fileName;
        File file;
        FileWriter writer;

        //запрос о прошлом
        String pastText = pr.request("3");
        fileName = new Date().getTime() + ".txt";
        //запись в файл
        file = new File(filesPath + "past/" + fileName);
        writer = new FileWriter(file);
        writer.write(pastText);
        writer.flush();
        //сохранение
        predictionsService.addPrediction(new Date().getTime() / 1000, 3, fileName);
        response.put("past", pastText);
        Thread.sleep(1000);


        //запрос о настоящем
        String presentText = pr.request("4");
        fileName = new Date().getTime() + ".txt";
        //запись в файл
        file = new File(filesPath + "present/" + fileName);
        writer = new FileWriter(file);
        writer.write(presentText);
        writer.flush();
        //сохранение
        predictionsService.addPrediction(new Date().getTime() / 1000, 4, fileName);
        response.put("present", presentText);
        Thread.sleep(1000);


        //запрос о будущем
        String futureText = pr.request("5");
        fileName = new Date().getTime() + ".txt";
        //запись в файл
        file = new File(filesPath + "future/" + fileName);
        writer = new FileWriter(file);
        writer.write(futureText);
        writer.flush();
        //сохранение
        predictionsService.addPrediction(new Date().getTime() / 1000, 5, fileName);
        response.put("future", futureText);

        return response;
    }


}

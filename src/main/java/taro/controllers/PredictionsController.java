package taro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import taro.database.service.PredictionsService;

import java.util.Date;

@RestController
public class PredictionsController {

    @Autowired
    private PredictionsService predictionsService;

    @GetMapping("/getp")
    public void getPred(){
        predictionsService.addPrediction(new Date().getTime() / 1000, 2, "dsadasdsa.txt");

        System.out.println("ok");
    }


}

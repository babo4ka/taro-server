package taro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import taro.database.service.PredictionsService;
import taro.utils.PredictionRequester;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@RestController
public class PredictionsController {

    @Autowired
    private PredictionsService predictionsService;

    private final String filesPath = "C:\\Users\\evgeh\\Desktop\\кодер)0\\py проекты\\generated_texts\\";

    @GetMapping("/getp")
    public String getPred() throws IOException {
        PredictionRequester pr = new PredictionRequester();
        String fileName = pr.request("1");
        predictionsService.addPrediction(new Date().getTime() / 1000, 1, fileName);

        System.out.println(fileName);

        File textFile = new File(filesPath + "general/" + fileName);

        System.out.println(textFile.getAbsolutePath());

        FileReader fr = new FileReader(textFile);
        Reader reader = new InputStreamReader(
                new FileInputStream(textFile), "UTF-32");
        BufferedReader br = new BufferedReader(reader);

        String text = br.readLine();

        br.close();
        fr.close();
        System.out.println(text);

        return text;
    }


}

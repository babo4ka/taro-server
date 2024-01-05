package taro.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taro.database.repos.PredictionsRep;

@Service
public class PredictionServiceImpl implements PredictionsService{

    @Autowired
    private PredictionsRep predictionsRep;


    @Override
    public void addPrediction(long id, long type, String fileName) {
        predictionsRep.addPrediction(id, type, fileName);
    }
}

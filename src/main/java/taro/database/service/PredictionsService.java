package taro.database.service;

import org.springframework.stereotype.Service;


public interface PredictionsService {
    void addPrediction(long id, long type, String fileName);
}

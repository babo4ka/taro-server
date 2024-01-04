package taro.database.repos;

import org.springframework.data.repository.CrudRepository;
import taro.database.entities.Predictions;

public interface PredictionsRep extends CrudRepository<Predictions, Long> {
}

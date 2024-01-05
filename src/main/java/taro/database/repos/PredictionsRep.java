package taro.database.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import taro.database.entities.Predictions;

public interface PredictionsRep extends CrudRepository<Predictions, Long> {

    @Query(value = "call add_pred(:id, :pred_type, :file_name)",
            nativeQuery = true)
    void addPrediction(@Param("id") long id, @Param("pred_type") long type, @Param("file_name") String fileName);
}

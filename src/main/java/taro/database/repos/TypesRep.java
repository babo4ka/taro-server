package taro.database.repos;

import org.springframework.data.repository.CrudRepository;
import taro.database.entities.PredTypes;

public interface TypesRep extends CrudRepository<PredTypes, Long> {
}

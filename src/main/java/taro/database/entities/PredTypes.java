package taro.database.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity(name = "типы предсказаний")
public class PredTypes {

    @Id
    @Column(name = "номер", columnDefinition = "INT")
    private long ID;

    @Column(name = "название")
    private String name;

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }
}

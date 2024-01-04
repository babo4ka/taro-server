package taro.database.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@Entity(name = "предсказания")
public class Predictions {

    @Id
    @Column(name = "номер")
    private long ID;

    @Column(name = "тип предсказания", columnDefinition = "INT")
    private long type;
    @Column(name = "название файла")
    private String fileName;
    @Column(name = "дата")
    private Timestamp date;

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setType(long type) {
        this.type = type;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}

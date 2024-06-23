package cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n03.model.domain;

import jakarta.persistence.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "fruit")
public class Fruit {

    @Id
        private ObjectId id;
        private String name;
        private int quantityKg;

    public Fruit(String name, int quantityKg) {
        this.name = name;
        this.quantityKg = quantityKg;
    }

    public ObjectId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantityKg() {
        return quantityKg;
    }

    public void setQuantityKg(int quantityKg) {
        this.quantityKg = quantityKg;
    }

    @Override
    public String toString() {
        return "Fruit [id=" + id + ", name=" + name + ", quantityKg=" + quantityKg + "]";
    }
}

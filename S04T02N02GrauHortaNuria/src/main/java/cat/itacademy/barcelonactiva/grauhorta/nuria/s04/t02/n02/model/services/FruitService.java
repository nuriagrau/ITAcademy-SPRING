package cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n02.model.services;

import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n02.Entity.Fruit;

import java.util.List;
import java.util.Optional;

public interface FruitService {
    // Save operation
    Fruit savefruit(Fruit fruit);

    // Read operation
    List<Fruit> fetchFruitList();

    // Read one operation
    Optional<Fruit> findOneFruit(Long id);

    // Update operation
    Fruit updateFruit(Fruit fruit, Long id) throws NullPointerException;

    // Delete operation
    void deleteFruitById(Long id);
}

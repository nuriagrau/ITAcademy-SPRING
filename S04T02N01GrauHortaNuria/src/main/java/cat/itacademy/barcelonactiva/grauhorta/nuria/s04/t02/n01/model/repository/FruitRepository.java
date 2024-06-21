package cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n01.model.repository;

import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n01.model.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FruitRepository extends JpaRepository<Fruit, Integer> {

    List<Fruit> findByName(String name);

    List<Fruit> findByNameContaining(String name);

    Optional<Fruit> findById(int id);
}

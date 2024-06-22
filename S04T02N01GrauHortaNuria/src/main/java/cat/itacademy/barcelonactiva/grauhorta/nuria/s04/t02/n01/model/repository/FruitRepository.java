package cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n01.model.repository;

import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n01.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FruitRepository extends CrudRepository<Fruit, Long> {

}

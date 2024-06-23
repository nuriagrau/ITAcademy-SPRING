package cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n03.model.services.Impl;

import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n03.exception.FruitNotFoundException;
import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n03.model.domain.Fruit;
import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n03.model.repository.FruitRepository;
import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n03.model.services.FruitService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.dao.DataAccessException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService {
    @Autowired
    private FruitRepository fruitRepository;
    @Override
    public Fruit savefruit(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public List<Fruit> fetchFruitList() {
        return (List<Fruit>)fruitRepository.findAll();
    }

    public Optional<Fruit> findOneFruit(ObjectId id) throws FruitNotFoundException {
        Optional<Fruit> optionalFruit = fruitRepository.findById(id);

        if (optionalFruit.isEmpty()) {
            throw new FruitNotFoundException("Fruit not found: ID " + id + ".");
        }
        return optionalFruit;
    }

    @Override
    public Fruit updateFruit(Fruit fruit, ObjectId id) {
        Fruit newFruit = fruitRepository.findById(id).get();
        if (newFruit != null) {
            if (Objects.nonNull((fruit.getName())) && !"".equalsIgnoreCase(fruit.getName())) {
                newFruit.setName(fruit.getName());
            }
            if (Objects.nonNull((fruit.getQuantityKg()))) {
                newFruit.setQuantityKg(fruit.getQuantityKg());
            }
            return fruitRepository.save(newFruit);
        } else {
            throw new RuntimeException("Error when updating the fruit " + fruit.getName());
        }
    }


    @Override
    public void deleteFruitById(ObjectId id) {
        fruitRepository.deleteById(id);
    }
}

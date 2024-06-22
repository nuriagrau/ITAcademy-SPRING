package cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n02.model.services;

import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n02.Entity.Fruit;
import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n02.model.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Optional<Fruit> findOneFruit(Long id) {
        return fruitRepository.findById(id);
    }

    @Override
    public Fruit updateFruit(Fruit fruit, Long id) throws NullPointerException {
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
            throw new NullPointerException();
        }
    }


    @Override
    public void deleteFruitById(Long id) {
        fruitRepository.deleteById(id);
    }
}

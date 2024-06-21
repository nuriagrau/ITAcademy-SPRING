package cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n01.controllers;


import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n01.model.Fruit;
import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n01.model.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/fruits")
public class FruitController {

    @Autowired
    private FruitRepository fruitRepository;


    //http://localhost:8080/fruita/add
    @PostMapping("/add")
    public ResponseEntity<Fruit> createFruit(@RequestBody Fruit fruit) {
        try {
            Fruit _fruit = fruitRepository
                    .save(new Fruit(fruit.getName(), fruit.getQuantityKg()));
            return new ResponseEntity<>(_fruit, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //http://localhost:8080/fruita/update
    @PutMapping("/update")
    public ResponseEntity<Fruit> updateFruit(@RequestBody Fruit fruit) {
        Optional<Fruit> fruitData = fruitRepository.findById(fruit.getId());
        if (!fruitData.isEmpty()) {
            Fruit _fruit = fruitData.get();
            _fruit.setName(fruit.getName());
            _fruit.setQuantityKg(fruit.getQuantityKg());
            return new ResponseEntity<>(fruitRepository.save(_fruit), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //http://localhost:8080/fruita/delete/{id}
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteFruit(@PathVariable int id) {
        try {
            fruitRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //http://localhost:8080/fruita/getOne/{id}

    @GetMapping("/getOne({id}")
    public ResponseEntity<Fruit> getFruitById(@PathVariable int id) {
        Optional<Fruit> fruitData = fruitRepository.findById(id);

        if(fruitData.isPresent()) {
            return new ResponseEntity<>(fruitData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //http://localhost:8080/fruita/getAll
    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getAllFruits() {
        try {
            List<Fruit> fruits = new ArrayList<Fruit>();
            fruitRepository.findAll().forEach(fruits::add);

            if (fruits.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(fruits, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

package cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n02.Controllers;

import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n02.Entity.Fruit;
import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n02.model.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fruits")
public class FruitController {

    @Autowired
    private FruitService fruitService;


    //http://localhost:8080/fruita/add
    @PostMapping("/add")
    public ResponseEntity<Fruit> createFruit(@RequestBody Fruit fruit) {
        try {
            Fruit addedFruit = fruitService.savefruit(fruit);
            return new ResponseEntity<>(addedFruit, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //http://localhost:8080/fruita/update
    @PutMapping("/update")
    public ResponseEntity<Fruit> updateFruit(@RequestBody Fruit fruit) {
        try {
            Fruit updatedFruit = fruitService.updateFruit(fruit, fruit.getId());
            return new ResponseEntity<>(updatedFruit, HttpStatus.OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(fruit, HttpStatus.NOT_FOUND);
        }

    }

    //http://localhost:8080/fruita/delete/{id}
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteFruitById(@PathVariable("id") Long id) {
        try {
            fruitService.deleteFruitById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //http://localhost:8080/fruita/getOne/{id}

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruit> findOneFruit(@PathVariable("id") Long id) {
        Optional<Fruit> fruitData = fruitService.findOneFruit(id);
        if(fruitData.isPresent()) {
            return new ResponseEntity<>(fruitData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //http://localhost:8080/fruita/getAll
    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> fetchFruitList() {
        try {
            List<Fruit> fruits = fruitService.fetchFruitList();
            if (fruits.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(fruits, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

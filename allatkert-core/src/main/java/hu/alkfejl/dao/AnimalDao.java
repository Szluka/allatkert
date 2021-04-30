package hu.alkfejl.dao;

import hu.alkfejl.model.Animal;
import hu.alkfejl.model.Animal2;

import java.util.List;

public interface AnimalDao {

    List<Animal> get();

    List<Animal2> list2(String cloumn, String expression);

    List<Animal2> list();

    void update(Animal animal);

    void update2(int id);

    void add(Animal animal);

    void delete(Animal animal);

    void add(Animal2 animal);

    Animal2 getAnimalById(int id);


}

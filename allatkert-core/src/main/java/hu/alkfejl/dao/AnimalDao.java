package hu.alkfejl.dao;

import hu.alkfejl.model.Adoptive;
import hu.alkfejl.model.Animal;

import java.util.List;

public interface AnimalDao {

    List<Animal> get();

    void update(Animal animal);

    void add(Animal animal);

    void delete(Animal animal);
}

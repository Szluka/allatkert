package hu.alkfejl.dao;

import hu.alkfejl.model.Adoptive;
import hu.alkfejl.model.AdoptiveWeb;
import hu.alkfejl.model.Animal;
import hu.alkfejl.model.AnimalWeb;

import java.util.List;

public interface AnimalDao {

    List<Animal> get();

    List<AnimalWeb> list();

    void update(Animal animal);

    void add(Animal animal);

    void delete(Animal animal);

    void add(AnimalWeb animal);

    AnimalWeb getAnimalById(int id);


}

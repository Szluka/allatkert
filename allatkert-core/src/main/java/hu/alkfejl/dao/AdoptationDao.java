package hu.alkfejl.dao;

import hu.alkfejl.model.Adoptation;
import hu.alkfejl.model.Adoptation2;

import java.util.List;

public interface AdoptationDao {

    List<Adoptation> get();

    void add(Adoptation2 adoptation2);
}

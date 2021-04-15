package hu.alkfejl.dao;

import hu.alkfejl.model.Adoptive;

import java.util.List;

public interface AdoptiveDao {

    List<Adoptive> get();

    void add(Adoptive adoptive);

    void update(Adoptive adoptive);

    void delete(Adoptive adoptive);

}

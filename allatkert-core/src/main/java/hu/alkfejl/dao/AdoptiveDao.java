package hu.alkfejl.dao;

import hu.alkfejl.model.Adoptive;
import hu.alkfejl.model.Adoptive2;

import java.util.List;

public interface AdoptiveDao {

    List<Adoptive> get();

    List<Adoptive2> list();

    void add(Adoptive adoptive);

    void update(Adoptive adoptive);

    void delete(Adoptive adoptive);

    void add(Adoptive2 adoptive);


}

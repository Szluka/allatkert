package hu.alkfejl.dao;

import hu.alkfejl.model.Adoptive;
import hu.alkfejl.model.AdoptiveWeb;

import java.util.List;

public interface AdoptiveDao {

    List<Adoptive> get();

    List<AdoptiveWeb> list();

    void add(Adoptive adoptive);

    void update(Adoptive adoptive);

    void delete(Adoptive adoptive);

    void add(AdoptiveWeb adoptive);


}

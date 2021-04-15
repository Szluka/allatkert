package hu.alkfejl.model;

import javafx.beans.Observable;
import javafx.beans.property.*;
import javafx.collections.ObservableList;

import java.util.Arrays;

public class Animal {

    /*  Örökbefogadható állat:
        név (ha van már neki)
        faj
        fénykép
        bemutatkozó szöveg
        születési év
     */

    private IntegerProperty id = new SimpleIntegerProperty(this, "id");
    private StringProperty name = new SimpleStringProperty(this, "name");
    private StringProperty specie = new SimpleStringProperty(this, "specie");
    private IntegerProperty year = new SimpleIntegerProperty(this, "year");
    private StringProperty intro = new SimpleStringProperty(this, "intro");
    private StringProperty picture = new SimpleStringProperty(this, "picture");

    public String getPicture() {
        return picture.get();
    }

    public StringProperty pictureProperty() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture.set(picture);
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSpecies() {
        return specie.get();
    }

    public StringProperty specieProperty() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie.set(specie);
    }

    /*
        public Species getSpecies() {
            return species.get();
        }

        public ObjectProperty<Species> speciesProperty() {
            return species;
        }

        public void setSpecies(Species species) {
            this.species.set(species);
        }
    */
    public int getYear() {
        return year.get();
    }

    public IntegerProperty yearProperty() {
        return year;
    }

    public void setYear(int year) {
        this.year.set(year);
    }

    public String getIntro() {
        return intro.get();
    }

    public StringProperty introProperty() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro.set(intro);
    }

    /* ENUM */
    public enum Species{
        Dog("Dog"),
        Cat("Cat"),
        Horse("Horse"),
        Hamster("Hamster");

        private final StringProperty value = new SimpleStringProperty(this, "value");

        Species(String value) {
            this.value.set(value);
        }

        public String getValue() {
            return value.get();
        }

        public StringProperty valueProperty() {
            return value;
        }

        @Override
        public String toString() {
            return getValue();
        }

        public static Species fromString(String s) throws IllegalArgumentException {
            return Arrays.stream(Species.values())
                    .filter(v -> v.value.equals(s))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Unknown value: " + s));
        }
    }
    /* ENUM */
}

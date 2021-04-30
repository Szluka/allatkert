package hu.alkfejl.model;

public class Animal2 {

    private int id;
    private String name;
    private int year;
    private String specie;
    private String intro;
    private String picture;
    private int adopted;

    public Animal2(int id, String name, int year, String specie, String intro, String picture, int adopted) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.specie = specie;
        this.intro = intro;
        this.picture = picture;
        this.adopted = adopted;
    }

    public Animal2(String name, int year, String specie, String intro, String picture, int adopted) {
        this.name = name;
        this.year = year;
        this.specie = specie;
        this.intro = intro;
        this.picture = picture;
        this.adopted = adopted;
    }

    public Animal2() {

    }

    public int getAdopted() {
        return adopted;
    }

    public void setAdopted(int adopted) {
        this.adopted = adopted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}

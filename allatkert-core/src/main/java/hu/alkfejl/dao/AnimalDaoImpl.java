package hu.alkfejl.dao;

import hu.alkfejl.model.Animal;
import hu.alkfejl.model.Animal2;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class AnimalDaoImpl implements AnimalDao {

    private static final String INSERT_animal = "INSERT INTO animal (name, year, intro, picture, specie, adopted) VALUES (?,?,?,?,?,0)";
    private static final String UPDATE_animal = "UPDATE animal SET name=?, year=?, intro=?, picture=?, specie=?, adopted=? WHERE id=?";
    private static final String UPDATE_animal_adopted = "UPDATE animal SET  adopted=? WHERE id=?";
    private static final String DELETE_animal = "DELETE FROM animal WHERE id=?";
    private static final String GetByID_animal ="SELECT * FROM animal WHERE id=?";
    private static final String SEARCH_animal = "SELECT * FROM animal WHERE ? LIKE ?";
    private static final String ALL_animal = "SELECT * FROM animal";
    Properties props = new Properties();
    private String URL;

    public AnimalDaoImpl() {
        try {
            Class.forName("org.sqlite.JDBC");
            props.load(AnimalDaoImpl.class.getResourceAsStream("/application.properties"));
            URL = props.getProperty("db.url");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Animal> get() {
        List<Animal> list = new ArrayList<>();

        try {
            Connection con = DriverManager.getConnection(URL);
            PreparedStatement stmt = con.prepareStatement(ALL_animal);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Animal a = new Animal();
                a.setId(rs.getInt("id"));
                a.setName(rs.getString("name"));
                a.setYear(rs.getInt("year"));
                //a.setSpecie(Animal.Species.valueOf(rs.getString("specie")).toString());
                a.setSpecie(rs.getString("specie"));
                a.setIntro(rs.getString("intro"));
                a.setPicture(rs.getString("picture"));
                a.setAdopted(rs.getInt("adopted"));
                list.add(a);
            }
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.err.println("HIBA:" + e);
        }
        return list;
    }

    @Override
    public void update(Animal animal) {
        try {
            Connection con = DriverManager.getConnection(URL);
            PreparedStatement statement = con.prepareStatement(UPDATE_animal);

            statement.setString(1, animal.getName());
            statement.setInt(2, animal.getYear());
            statement.setString(3, animal.getIntro());
            statement.setString(4, animal.getPicture());
            statement.setString(5, animal.getSpecies());
            statement.setInt(6, animal.getAdopted());
            statement.setInt(7, animal.getId());
            statement.execute();
            con.close();
            System.out.println("FRISSÍTVE!");
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    @Override
    public void add(Animal animal) {
        try {
            Connection con = DriverManager.getConnection(URL);
            PreparedStatement statement = con.prepareStatement(INSERT_animal);

            statement.setString(1, animal.getName());
            statement.setInt(2, animal.getYear());
            statement.setString(3, animal.getIntro());
            statement.setString(4, animal.getPicture());
            statement.setString(5, animal.getSpecies());
            statement.execute();
            con.close();
            System.out.println("HOZZÁADVA!");
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    @Override
    public void delete(Animal animal) {

        try (Connection c = DriverManager.getConnection(URL);
             PreparedStatement statement = c.prepareStatement(DELETE_animal);
        ) {

            statement.setInt(1, animal.getId());
            System.out.println(statement);
            statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * WEB
     */

    @Override
    public void add(Animal2 animal) {
        try {
            Connection con = DriverManager.getConnection(URL);
            PreparedStatement statement = con.prepareStatement(INSERT_animal);

            statement.setString(1, animal.getName());
            statement.setInt(2, animal.getYear());
            statement.setString(3, animal.getIntro());
            statement.setString(4, animal.getPicture());
            statement.setString(5, animal.getSpecie());
            statement.execute();
            con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }

    }


    @Override
    public List<Animal2> list() {
        List<Animal2> list = new ArrayList<>();

        try {
            Connection con = DriverManager.getConnection(URL);
            PreparedStatement stmt = con.prepareStatement(ALL_animal);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Animal2 a = new Animal2(rs.getInt("id"), rs.getString("name"), rs.getInt("year"), rs.getString("specie"), rs.getString("intro"), rs.getString("picture"), rs.getInt("adopted"));
                list.add(a);
            }

            rs.close();
            con.close();

        } catch (SQLException e) {
            System.err.println("HIBA:" + e);
        }
        return list;
    }


    @Override
    public Animal2 getAnimalById(int id) {
        Animal2 a = null;

        try {Connection con = DriverManager.getConnection(URL);
            PreparedStatement statement = con.prepareStatement(GetByID_animal);

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                a = new Animal2(rs.getInt("id"), rs.getString("name"), rs.getInt("year"), rs.getString("specie"), rs.getString("intro"), rs.getString("picture"), rs.getInt("adopted"));
            }
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.err.println("HIBA:" + e);
        }
        return a;
    }

    @Override
    public List<Animal2> list2(String cloumn, String expression) {
        List<Animal2> list = new ArrayList<>();

        try {Connection con = DriverManager.getConnection(URL);
            PreparedStatement stmt = con.prepareStatement(SEARCH_animal);

            stmt.setString(1, cloumn);
            stmt.setString(2, "%" + expression + "%");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Animal2 a = new Animal2();
                a.setId(rs.getInt("id"));
                a.setName(rs.getString("name"));
                a.setYear(rs.getInt("year"));
                //a.setSpecie(Animal.Species.valueOf(rs.getString("specie")).toString());
                a.setSpecie(rs.getString("specie"));
                a.setIntro(rs.getString("intro"));
                a.setPicture(rs.getString("picture"));
                a.setAdopted(rs.getInt("adopted"));
                list.add(a);
            }
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.err.println("HIBA:" + e);
        }
        return list;
    }

    @Override
    public void update2(int id) {
        try {
            Connection con = DriverManager.getConnection(URL);
            PreparedStatement statement = con.prepareStatement(UPDATE_animal_adopted);

            statement.setInt(1, 1);
            statement.setInt(2, id);
            statement.execute();
            con.close();
            System.out.println("Adoptálva!");
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}

package hu.alkfejl.dao;

import hu.alkfejl.model.Animal;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class AnimalDaoImpl implements AnimalDao{

    private static final String INSERT_animal = "INSERT INTO animal (name, year, intro, picture, specie) VALUES (?,?,?,?,?)";
    private static final String UPDATE_animal = "UPDATE animal SET name=?, year=?, intro=?, picture=?, specie=? WHERE id=?";
    private static final String DELETE_animal = "DELETE FROM animal WHERE id=?";
    Properties props = new Properties();
    private String URL;

    public AnimalDaoImpl() {
        try {
            props.load(AnimalDaoImpl.class.getResourceAsStream("/application.properties"));
            URL = props.getProperty("db.url");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Animal> get() {
        List<Animal> list = new ArrayList<>();

        try {
            String sql = "SELECT * FROM animal";
            Connection con = DriverManager.getConnection(URL);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Animal a = new Animal();
                a.setId(rs.getInt("id"));
                a.setName(rs.getString("name"));
                a.setYear(rs.getInt("year"));
                //a.setSpecie(Animal.Species.valueOf(rs.getString("specie")).toString());
                a.setSpecie(rs.getString("specie"));
                a.setPicture(rs.getString("picture"));
                a.setIntro(rs.getString("intro"));
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
            statement.setInt(6, animal.getId());
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

        try(Connection c = DriverManager.getConnection(URL);
            PreparedStatement statement = c.prepareStatement(DELETE_animal);
        ){

            statement.setInt(1, animal.getId());
            System.out.println(statement);
            statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

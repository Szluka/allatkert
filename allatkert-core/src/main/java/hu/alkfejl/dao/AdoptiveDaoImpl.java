package hu.alkfejl.dao;

import hu.alkfejl.model.Adoptive;
import hu.alkfejl.model.Adoptive2;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class AdoptiveDaoImpl implements AdoptiveDao{

    private static final String INSERT_adoptive = "INSERT INTO adoptive (name, email) VALUES (?,?)";
    private static final String UPDATE_adoptive = "UPDATE adoptive SET name=?, email=? WHERE id=?";
    private static final String DELETE_adoptive = "DELETE FROM adoptive WHERE id=?";
    private static final String ALL_adoptive = "SELECT * FROM adoptive";
    Properties props = new Properties();
    private String URL;

    public AdoptiveDaoImpl() {
        try {
            Class.forName("org.sqlite.JDBC");
            props.load(AdoptiveDaoImpl.class.getResourceAsStream("/application.properties"));
            URL = props.getProperty("db.url");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Adoptive> get() {
        List<Adoptive> list = new ArrayList<>();

        try {
            Connection con = DriverManager.getConnection(URL);
            PreparedStatement stmt = con.prepareStatement(ALL_adoptive);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Adoptive a = new Adoptive();
                a.setId(rs.getInt("id"));
                a.setName(rs.getString("name"));
                a.setEmail(rs.getString("email"));
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
    public void add(Adoptive adoptive) {
        try {
            Connection con = DriverManager.getConnection(URL);
            PreparedStatement statement = con.prepareStatement(INSERT_adoptive);

            statement.setString(1, adoptive.getName());
            statement.setString(2, adoptive.getEmail());
            statement.execute();
            con.close();
            System.out.println("HOZZÁADVA!");
        } catch (SQLException e) {
            System.err.println(e);
        }

    }

    @Override
    public void update(Adoptive adoptive) {
        try {
            Connection con = DriverManager.getConnection(URL);
            PreparedStatement statement = con.prepareStatement(UPDATE_adoptive);

            statement.setString(1, adoptive.getName());
            statement.setString(2, adoptive.getEmail());
            statement.setInt(3, adoptive.getId());
            statement.execute();
            con.close();
            System.out.println(statement);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    @Override
    public void delete(Adoptive adoptive) {

        try(Connection c = DriverManager.getConnection(URL);
            PreparedStatement statement = c.prepareStatement(DELETE_adoptive);
        ){

            statement.setInt(1, adoptive.getId());
            System.out.println(statement);
            statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /** WEB */

    @Override
    public void add(Adoptive2 adoptive) {
        try {
            Connection con = DriverManager.getConnection(URL);
            PreparedStatement statement = con.prepareStatement(INSERT_adoptive);

            statement.setString(1, adoptive.getName());
            statement.setString(2, adoptive.getEmail());
            statement.execute();
            con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }

    }

    @Override
    public List<Adoptive2> list() {
        List<Adoptive2> list = new ArrayList<>();

        try {
            Connection con = DriverManager.getConnection(URL);
            PreparedStatement stmt = con.prepareStatement(ALL_adoptive);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Adoptive2 a = new Adoptive2(rs.getInt("id"), rs.getString("name"), rs.getString("email"));
                list.add(a);
            }
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.err.println("HIBA:" + e);
        }
        return list;
    }

}

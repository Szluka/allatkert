package hu.alkfejl.dao;

import hu.alkfejl.model.Adoptation;
import hu.alkfejl.model.Adoptation2;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class AdoptationDaoImpl implements AdoptationDao {

    private static final String INSERT_adoptation = "INSERT INTO adoption (adoptiveId, animalId, date, donationType, donationValue, donationFreq) VALUES (?,?,?,?,?,?)";
    private static final String ALL_adoptation = "SELECT * from adoption";
    Properties props = new Properties();
    private String URL;

    public AdoptationDaoImpl() {
        try {
            props.load(AdoptationDaoImpl.class.getResourceAsStream("/application.properties"));
            URL = props.getProperty("db.url");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Adoptation> get() {
        List<Adoptation> list = new ArrayList<>();

        try {
            Connection con = DriverManager.getConnection(URL);
            PreparedStatement stmt = con.prepareStatement(ALL_adoptation);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Adoptation a = new Adoptation();
                a.setId(rs.getInt("id"));
                a.setAdoptiveId(rs.getInt("adoptiveId"));
                a.setAnimalId(rs.getInt("animalId"));
                a.setDate(rs.getString("date"));
                a.setDonationType(rs.getString("donationType"));
                a.setDonationValue(rs.getInt("donationValue"));
                a.setDonationFreq(rs.getString("donationFreq"));
                list.add(a);
            }
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.err.println("HIBA:" + e);
        }
        return list;
    }

    /** WEB */

    @Override
    public void add(Adoptation2 adoptation2) {
            try {
                Connection con = DriverManager.getConnection(URL);
                PreparedStatement statement = con.prepareStatement(INSERT_adoptation);

                statement.setInt(1, adoptation2.getAdoptiveId());
                statement.setInt(2, adoptation2.getAnimalId());
                statement.setString(3, adoptation2.getDate());
                statement.setString(4, adoptation2.getDonationType());
                statement.setInt(5, adoptation2.getDonationValue());
                statement.setString(6, adoptation2.getDonationFreq());
                statement.execute();
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

    }

}

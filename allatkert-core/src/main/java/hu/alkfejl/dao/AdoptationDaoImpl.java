package hu.alkfejl.dao;

import hu.alkfejl.model.Adoptation;
import hu.alkfejl.model.AdoptationWeb;
import hu.alkfejl.model.AnimalWeb;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class AdoptationDaoImpl implements AdoptationDao {

    private static final String INSERT_adoptation = "INSERT INTO adoptation (adoptiveId, animalId, date, donationType, donationValue, donationFreq) VALUES (?,?,?,?,?,?)";
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
            String sql = "SELECT * FROM adoption";
            Connection con = DriverManager.getConnection(URL);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
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
    public void add(AdoptationWeb adoptationWeb) {
            try {
                Connection con = DriverManager.getConnection(URL);
                PreparedStatement statement = con.prepareStatement(INSERT_adoptation);

                statement.setInt(1, adoptationWeb.getAdoptiveId());
                statement.setInt(2, adoptationWeb.getAnimalId());
                statement.setString(3, adoptationWeb.getDate());
                statement.setString(4, adoptationWeb.getDonationType());
                statement.setInt(5, adoptationWeb.getDonationValue());
                statement.setString(6, adoptationWeb.getDonationFreq());
                statement.execute();
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

    }

}

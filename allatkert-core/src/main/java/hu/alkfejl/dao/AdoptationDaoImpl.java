package hu.alkfejl.dao;

import hu.alkfejl.model.Adoptation;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class AdoptationDaoImpl implements AdoptationDao {

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

}

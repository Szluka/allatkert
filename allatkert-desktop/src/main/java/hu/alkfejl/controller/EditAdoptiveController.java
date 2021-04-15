package hu.alkfejl.controller;

import hu.alkfejl.dao.AdoptiveDao;
import hu.alkfejl.dao.AdoptiveDaoImpl;
import hu.alkfejl.model.Adoptive;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Base64;
import java.util.ResourceBundle;

public class EditAdoptiveController implements Initializable {

    private final AdoptiveDao dao = new AdoptiveDaoImpl();

    @FXML
    private TextField adoptiveNameEdit;

    @FXML
    private TextField adoptiveEmailEdit;

    private int id;


    public void setAdoptive(Adoptive adoptive) {
        id = adoptive.getId();
        System.out.println(adoptive.getId() + " id");
        adoptiveNameEdit.setText(adoptive.getName());
        adoptiveEmailEdit.setText(adoptive.getEmail());
    }

    @FXML
    void goAdoptive(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/fxml/adoptive.fxml"));
            Scene scene = new Scene(parent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(scene);
            window.setTitle("Adoptives");
            window.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void saveButton(ActionEvent event) {
        Adoptive temp = new Adoptive();
        temp.setId(id);
        temp.setName(adoptiveNameEdit.getText());
        temp.setEmail(adoptiveEmailEdit.getText());
        dao.update(temp);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}

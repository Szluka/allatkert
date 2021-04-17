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

import java.net.URL;
import java.util.ResourceBundle;

public class AddAdoptiveController implements Initializable {

    @FXML
    private TextField adoptiveNameAdd;

    @FXML
    private TextField adoptiveEmailAdd;


    private final AdoptiveDao dao = new AdoptiveDaoImpl();


    @FXML
    void addAdoptive(ActionEvent event) {
        Adoptive temp = new Adoptive();
        temp.setName(adoptiveNameAdd.getText());
        temp.setEmail(adoptiveEmailAdd.getText());
        dao.add(temp);
    }

    @FXML
    void goAdoptive(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/fxml/adoptive.fxml"));
            Scene scene = new Scene(parent);
            scene.getStylesheets().add("/zooDesktopStyle.css");

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(scene);
            window.setTitle("Adoptives");
            window.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}

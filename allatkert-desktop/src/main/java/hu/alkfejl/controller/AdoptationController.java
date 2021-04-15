package hu.alkfejl.controller;

import hu.alkfejl.dao.*;
import hu.alkfejl.model.Adoptation;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AdoptationController implements Initializable {


    AdoptationDao dao = new AdoptationDaoImpl();

    @FXML
    private TableView<Adoptation> adoptationTable;

    @FXML
    private TableColumn<Adoptation, Integer> adoptiveId;

    @FXML
    private TableColumn<Adoptation, Integer> animalId;

    @FXML
    private TableColumn<Adoptation, String> date;

    @FXML
    private TableColumn<Adoptation, String> donationType;

    @FXML
    private TableColumn<Adoptation, Integer> donationValue;

    @FXML
    private TableColumn<Adoptation, String> donationFreq;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        {
            refreshtable();

            adoptationTable.getItems().setAll(dao.get());

            adoptiveId.setCellValueFactory(new PropertyValueFactory<>("adoptiveId"));
            animalId.setCellValueFactory(new PropertyValueFactory<>("animalId"));
            date.setCellValueFactory(new PropertyValueFactory<>("date"));
            donationType.setCellValueFactory(new PropertyValueFactory<>("donationType"));
            donationValue.setCellValueFactory(new PropertyValueFactory<>("donationValue"));
            donationFreq.setCellValueFactory(new PropertyValueFactory<>("donationFreq"));

        }

    }


    private void refreshtable() {
        adoptationTable.getItems().setAll(dao.get());
    }

    @FXML
    public void onExit() {
        Platform.exit();
    }


    @FXML
    public void goAdoptive(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/adoptive.fxml"));
            Parent parent = loader.load();

            Scene scene = new Scene(parent);


            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setTitle("Adoptives");
            window.setScene(scene);
            window.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    public void goAnimal(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/primary.fxml"));
            Parent parent = loader.load();

            Scene scene = new Scene(parent);


            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setTitle("Animals");
            window.setScene(scene);
            window.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
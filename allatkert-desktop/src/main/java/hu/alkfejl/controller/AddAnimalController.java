package hu.alkfejl.controller;

import hu.alkfejl.dao.AnimalDao;
import hu.alkfejl.dao.AnimalDaoImpl;
import hu.alkfejl.model.Animal;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Base64;
import java.util.ResourceBundle;

public class AddAnimalController implements Initializable {

    @FXML
    private TextField animalNameAdd;

    @FXML
    private TextField animalYearAdd;

    @FXML
    private TextField animalIntroAdd;

    @FXML
    private ComboBox<Animal.Species> specieComboBox;

    @FXML
    private ImageView img;

    private final AnimalDao dao = new AnimalDaoImpl();

    private String img64;

    @FXML
    void addAnimal(ActionEvent event) {
        Animal temp = new Animal();
        temp.setName(animalNameAdd.getText());
        temp.setYear(Integer.parseInt(animalYearAdd.getText()));
        temp.setIntro(animalIntroAdd.getText());
        temp.setPicture(img64);
        temp.setSpecie(specieComboBox.getSelectionModel().getSelectedItem().toString());
        dao.add(temp);
    }

    @FXML
    void backToAnimal(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/fxml/primary.fxml"));
            Scene scene = new Scene(parent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(scene);
            window.setTitle("Örökbefogadható Állatok");
            window.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void choosePicture(ActionEvent event) {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("*.png, *.jpg","*.png", "*.jpg"));
            File file = fileChooser.showOpenDialog(null);
            img64 = encodeFileToBase64Binary(file);
            getImageFromBase64String(img64);
        } catch (IOException e) {
            System.err.println("Hiba!");
        }
    }

    private static String encodeFileToBase64Binary(File file){
        String encodedFile = null;
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            fileInputStreamReader.read(bytes);
            encodedFile = new String(Base64.getEncoder().encode(bytes), "UTF-8");
        } catch (IOException e) {
            System.err.println("Hiba!");
        }

        return encodedFile;
    }

    private void getImageFromBase64String(String newValue) throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(Base64.getDecoder().decode(newValue));
        Image imgFile = new Image(inputStream);
        img.setImage(imgFile);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        specieComboBox.setItems( FXCollections.observableArrayList( Animal.Species.values()));
        specieComboBox.getSelectionModel().select(0);
    }
}

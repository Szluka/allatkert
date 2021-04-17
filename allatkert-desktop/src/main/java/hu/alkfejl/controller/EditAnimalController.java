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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Base64;
import java.util.ResourceBundle;

public class EditAnimalController implements Initializable {

    private final AnimalDao dao = new AnimalDaoImpl();

    @FXML
    private TextField animalNameEdit;

    @FXML
    private TextField animalYearEdit;

    @FXML
    private TextField animalIntroEdit;

    @FXML
    private ComboBox<Animal.Species> specieComboBox;

    private int id;

    private String kep;


    public void setAnimal(Animal animal) {
        id = animal.getId();
        kep = animal.getPicture();
        animalNameEdit.setText(animal.getName());
        animalYearEdit.setText(String.valueOf(animal.getYear()));
        animalIntroEdit.setText(animal.getIntro());
        System.out.println(Animal.Species.valueOf(animal.getSpecies()));
        specieComboBox.getSelectionModel().select(Animal.Species.valueOf(animal.getSpecies()));

        //System.out.println(animal.getName());
    }

    @FXML
    void backToAnimal(ActionEvent event) {
        try {
        Parent parent = FXMLLoader.load(getClass().getResource("/fxml/primary.fxml"));
        Scene scene = new Scene(parent);
        scene.getStylesheets().add("/zooDesktopStyle.css");

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.setTitle("Örökbefogadható Állatok");
        window.show();
    } catch (Exception e) {
        System.out.println(e);
    }
    }

    @FXML
    void saveButton(ActionEvent event) {
        Animal temp = new Animal();
        temp.setId(id);
        temp.setName(animalNameEdit.getText());
        temp.setYear(Integer.parseInt(animalYearEdit.getText()));
        temp.setIntro(animalIntroEdit.getText());
        temp.setPicture(kep);
        temp.setSpecie(specieComboBox.getSelectionModel().getSelectedItem().toString());
        dao.update(temp);

    }

    private static String encodeFileToBase64Binary(File file){
        String encodedfile = null;
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            fileInputStreamReader.read(bytes);
            encodedfile = new String(Base64.getEncoder().encode(bytes), "UTF-8");
        } catch (IOException e) {
            System.err.println("Hiba!");
        }

        return encodedfile;
    }

    @FXML
    void choosePicture(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("*.png, *.jpg","*.png", "*.jpg"));
        File file = fileChooser.showOpenDialog(null);
        kep = encodeFileToBase64Binary(file);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        specieComboBox.setItems( FXCollections.observableArrayList( Animal.Species.values()));

        System.out.println("AddEditAnimal");
    }
}

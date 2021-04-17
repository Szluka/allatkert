package hu.alkfejl.controller;

import java.net.URL;
import java.util.ResourceBundle;

import hu.alkfejl.dao.AnimalDao;
import hu.alkfejl.dao.AnimalDaoImpl;
import hu.alkfejl.model.Animal;
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
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PrimaryController implements Initializable {


    AnimalDao dao = new AnimalDaoImpl();

    @FXML
    private TableView<Animal> animalTable;

    @FXML
    private TableColumn<Animal, String> nameColumn;

    @FXML
    private TableColumn<Animal, Void> actionsColumn;

    @FXML
    private TableColumn<Animal, Integer> yearColumn;

    @FXML
    private TableColumn<Animal, Integer> specieColumn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        {
            refreshtable();

            animalTable.getItems().setAll(dao.get());

            nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
            specieColumn.setCellValueFactory(new PropertyValueFactory<>("specie"));

            actionsColumn.setCellFactory(param -> new TableCell<>() {

                private final Button deletebtn = new Button("Delete");
                private final Button editbtn = new Button("Edit");

                {
                    deletebtn.setOnAction(event -> {
                        Animal animal = getTableRow().getItem();
                        deleteAnimal(animal);
                        refreshtable();
                    });

                    editbtn.setOnAction(event -> {
                        Animal animal = getTableRow().getItem();
                        editAnimal(animal, event);
                        refreshtable();
                    });
                }

                @Override
                protected void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        HBox container = new HBox();
                        container.getChildren().addAll(editbtn, deletebtn);
                        container.setSpacing(10.0);
                        setGraphic(container);
                    }
                }
            });

        }

    }

    private void editAnimal(Animal animal, ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/edit_animal.fxml"));
            Parent parent = loader.load();


            Scene scene = new Scene(parent);
            scene.getStylesheets().add("/zooDesktopStyle.css");

            EditAnimalController controller = loader.getController();
            controller.setAnimal(animal);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setTitle("Szerkesztő");
            window.setScene(scene);
            window.show();
        } catch (Exception e) {
            System.out.println(e);
        }

    }


    private void deleteAnimal(Animal animal) {
        System.out.println(animal.getId());
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION,
                "Are you sure you want to delete this animal: " + animal.getName() + "?", ButtonType.YES, ButtonType.NO);
        confirm.showAndWait().ifPresent(buttonType -> {
            if(buttonType.equals(ButtonType.YES)){
                System.out.println(animal);
                System.out.println(animal.getId());
                dao.delete(animal);
            }
        });
    }

    private void refreshtable() {
        animalTable.getItems().setAll(dao.get());
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
            scene.getStylesheets().add("/zooDesktopStyle.css");

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setTitle("Adoptives");
            window.setScene(scene);
            window.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    public void goAdoptation(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/adoptation.fxml"));
            Parent parent = loader.load();

            Scene scene = new Scene(parent);
            scene.getStylesheets().add("/zooDesktopStyle.css");

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setTitle("Adoptations");
            window.setScene(scene);
            window.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    public void onCreateAnimal(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/add_animal.fxml"));
            Parent parent = loader.load();

            Scene scene = new Scene(parent);
            scene.getStylesheets().add("/zooDesktopStyle.css");

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setTitle("Add an Animal");
            window.setScene(scene);
            window.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
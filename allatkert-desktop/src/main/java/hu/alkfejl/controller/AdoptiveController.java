package hu.alkfejl.controller;

import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AdoptiveController implements Initializable {


    AdoptiveDao dao = new AdoptiveDaoImpl();

    @FXML
    private TableView<Adoptive> adoptiveTable;

    @FXML
    private TableColumn<Adoptive, String> nameColumn;

    @FXML
    private TableColumn<Adoptive, String> emailColumn;

    @FXML
    private TableColumn<Adoptive, Void> actionsColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        {
            refreshtable();

            adoptiveTable.getItems().setAll(dao.get());
            dao.get().forEach(System.out::println);
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

            actionsColumn.setCellFactory(param -> new TableCell<>() {

                private final Button deletebtn = new Button("Delete");
                private final Button editbtn = new Button("Edit");

                {
                    deletebtn.setOnAction(event -> {
                        Adoptive adoptive = getTableRow().getItem();
                        deleteAdoptive(adoptive);
                        refreshtable();
                    });

                    editbtn.setOnAction(event -> {
                        Adoptive adoptive = getTableRow().getItem();
                        editAdoptive(adoptive, event);
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

    @FXML
    void backtoAnimal(ActionEvent event) {
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

    private void editAdoptive(Adoptive adoptive, ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/edit_adoptive.fxml"));
            Parent parent = loader.load();

            Scene scene = new Scene(parent);
            scene.getStylesheets().add("/zooDesktopStyle.css");

            EditAdoptiveController controller = loader.getController();
            controller.setAdoptive(adoptive);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setTitle("Szerkesztő");
            window.setScene(scene);
            window.show();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void deleteAdoptive(Adoptive adoptive) {
        System.out.println(adoptive.getId());
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION,
                "Are you sure you want to delete this adoptive: " + adoptive.getName() + "?", ButtonType.YES, ButtonType.NO);
        confirm.showAndWait().ifPresent(buttonType -> {
            if(buttonType.equals(ButtonType.YES)){
                System.out.println(adoptive);
                System.out.println(adoptive.getId());
                dao.delete(adoptive);
            }
        });
    }

    public void addAdoptive(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/add_adoptive.fxml"));
            Parent parent = loader.load();

            Scene scene = new Scene(parent);
            scene.getStylesheets().add("/zooDesktopStyle.css");

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setTitle("Add an Adoptive");
            window.setScene(scene);
            window.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void refreshtable() {
        adoptiveTable.getItems().setAll(dao.get());
    }
}
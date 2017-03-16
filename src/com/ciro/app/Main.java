package com.ciro.app;

import com.ciro.app.controller.MainController;
import com.ciro.app.controller.NewPersonController;
import com.ciro.app.model.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        mainWindow();
    }

    public void mainWindow() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view/MainView.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            Scene scene = new Scene(anchorPane);

            MainController mainController = fxmlLoader.getController();
            mainController.setMain(this);

            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean newPersonWindow(Person person) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view/NewPersonView.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            Scene scene = new Scene(anchorPane);

            Stage stage = new Stage();

            NewPersonController newPersonController = fxmlLoader.getController();
            newPersonController.setMain(this, stage, person);

            stage.setScene(scene);
            stage.setResizable(false);
            stage.showAndWait();
            return newPersonController.isOkClicked();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private ObservableList<Person> personData = FXCollections.observableArrayList();
    public ObservableList<Person> getPersonData(){
        return personData;
    }

    public Main() {
        personData.add(new Person("Steve","Jobs","112233","London","156"));
        personData.add(new Person("AA","AA","888","AA","56656"));
    }

    public static void main(String[] args) {
        launch(args);
    }
}

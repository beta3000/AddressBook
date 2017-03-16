package com.ciro.app.controller;

import com.ciro.app.Main;
import com.ciro.app.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class MainController {
    private Main main;
    //Views
    @FXML
    TableView<Person> tableView;
    @FXML
    TableColumn<Person,String> firstNameColumn;
    @FXML
    TableColumn<Person,String> lastNameColumn;
    @FXML
    Label firstNameLabel,lastNameLabel,phoneLabel,cityLabel,postCodeLabel;


    public void initialize(){
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));

        tableView.getSelectionModel().selectedItemProperty().addListener(
                (observable,oldValue,newValue) -> showDetails(newValue));
    }

    public void showDetails(Person person){
        firstNameLabel.setText(person.getFirstName());
        lastNameLabel.setText(person.getLastName());
        phoneLabel.setText(person.getPhone());
        cityLabel.setText(person.getCity());
        postCodeLabel.setText(person.getPostCode());
    }

    public void setMain(Main main) {
        this.main = main;
        tableView.setItems(main.getPersonData());
    }

    @FXML
    public void handleNew(){
        main.newPersonWindow(null);
    }

    @FXML
    public void handleEdit(){
        Person person = tableView.getSelectionModel().getSelectedItem();
        boolean okClicked = main.newPersonWindow(person);
        if (okClicked){
            refreshTableView();
        }
    }

    private void refreshTableView() {
//        tableView.setItems(null);
//        tableView.layout();
//        tableView.setItems(main.getPersonData());
        tableView.refresh();
    }

    @FXML
    public void handleDelete(){
        int index = tableView.getSelectionModel().getSelectedIndex();
        main.getPersonData().remove(index);
    }
}

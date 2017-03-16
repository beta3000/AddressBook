package com.ciro.app.controller;


import com.ciro.app.Main;
import com.ciro.app.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewPersonController {
    private Main main;
    private Stage stage;
    private Person person;
    private boolean okClicked = false;

    //Views
    @FXML
    private TextField firstNameField,lastNameField,phoneField,cityField,postCodeField;

    public void setMain(Main main, Stage stage, Person person) {
        this.main = main;
        this.stage = stage;
        this.person = person;
        if (this.person != null){
            fillPersonDetails();
        }
    }

    public void fillPersonDetails(){
        firstNameField.setText(person.getFirstName());
        lastNameField.setText(person.getLastName());
        phoneField.setText(person.getPhone());
        cityField.setText(person.getCity());
        postCodeField.setText(person.getPostCode());
    }

    @FXML
    public void handleOk(){
        if (this.person != null){
            this.person.setFirstName(firstNameField.getText());
            this.person.setLastName(lastNameField.getText());
            this.person.setPhone(phoneField.getText());
            this.person.setCity(cityField.getText());
            this.person.setPostCode(postCodeField.getText());
            okClicked = true;
        }else {
            Person person = new Person(
                    firstNameField.getText(),
                    lastNameField.getText(),
                    phoneField.getText(),
                    cityField.getText(),
                    postCodeField.getText()
            );
            main.getPersonData().add(person);
        }

        stage.close();
    }

    @FXML
    public void handleCancel(){
        stage.close();
    }

    public boolean isOkClicked() {
        return okClicked;
    }
}

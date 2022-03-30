package com.platform.plugins.license.javaFx.main;

import com.platform.plugins.license.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 * @author itwang
 */
public class MainController implements Initializable{

    private Main application;

    private String textTest;

    public void setApp(Main application){
        this.application = application;
    }

    @FXML
    private void OUT_M(ActionEvent event) {
        application.useroutmain();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        textTest  = "789632145";
    }

}
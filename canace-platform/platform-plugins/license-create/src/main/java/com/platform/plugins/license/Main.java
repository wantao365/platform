package com.platform.plugins.license;

import com.platform.plugins.license.javaFx.login.LoginController;
import com.platform.plugins.license.javaFx.main.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * TODO
 * JavaFx 客户端
 * @author wantao
 * @version 1.0
 * @date 2022/3/29
 */
public class Main extends Application {

    private Stage stage;

    private final double MINIMUM_WINDOW_WIDTH = 400.0;

    private final double MINIMUM_WINDOW_HEIGHT = 250.0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setTitle("FXML Login Sample");
        stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
        stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
        stage.getIcons().add(new Image(new FileInputStream(Main.class.getClassLoader().getResource("").getPath()+"icon.jpg")));
        gotologin();
        stage.show();
    }

    public void gotologin(){
        try {
            LoginController login = (LoginController) replaceSceneContent("/fxml/login.fxml");
            login.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void gotomain(){
        try {
            MainController main = (MainController) replaceSceneContent("/fxml/main.fxml");
            main.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void userlogin(String account,String password){
        gotomain();
    }

    public void useroutmain(){
        gotologin();
    }

    private Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream resourceAsStream = this.getClass().getResourceAsStream(fxml);
        InputStream in = Main.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(Main.class.getResource(fxml));
        AnchorPane page;
        try {
            page = (AnchorPane) loader.load(resourceAsStream);
        } finally {
            resourceAsStream.close();
        }
        Scene scene = new Scene(page, 800, 600);
        stage.setScene(scene);
        stage.sizeToScene();
        return (Initializable) loader.getController();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
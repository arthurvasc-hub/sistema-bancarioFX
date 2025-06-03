package com.arthur.projetos.sistemabancariofx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;

        Parent screen = FXMLLoader.load(getClass().getResource("screens/client.fxml"));

        Scene scene = new Scene(screen);

        window.setScene(scene);
        window.show();

    }
}

package App;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javafx.application.*;
import java.text.*;
import java.util.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.stage.*;
import javafx.geometry.*;

public class Client {

    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException, IOException {

        //launch(args);
        MyService service = (MyService) Naming.lookup("rmi://localhost:5099/helloserver");
        System.out.println("---" + service.echo("hey server") + " " + service.getClass().getName());
    }

    /*@Override
    public void start(Stage stage) throws Exception {

        HBox root = new HBox();

        Button button = new Button("button");
        Label label = new Label("label");

        root.getChildren().addAll(button, label);

        Scene scene = new Scene(root, 700, 300);
        scene.getStylesheets().add("App/Style.css");
        stage.setScene(scene);

        stage.setTitle("Title");

        stage.show();

        System.out.println("Working Directory = "
                + System.getProperty("user.dir"));
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}

package App;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javafx.application.*;
import java.text.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.stage.*;
import javafx.geometry.*;

public class Client extends Application {

    final static File folder = new File("C:/Users/Maslz/Desktop/OSII_Project/RemoteFolder");
    static ArrayList files = new ArrayList();

    public static void main(String[] args) {

        System.out.println(javafx.scene.text.Font.getFamilies());
        listFilesForFolder(folder);
        String cwd = System.getProperty("user.dir");
        System.out.println("Current working directory : " + cwd);
        launch(args);
        /*MyService service = (MyService) Naming.lookup("rmi://localhost:5099/helloserver");
        System.out.println("---" + service.echo("hey server") + " " + service.getClass().getName());*/

    }

    @Override
    public void start(Stage stage) throws Exception {

        HBox root = new HBox();

        GridPane gridPane = new GridPane();

        /*try (Stream<Path> paths = Files.walk(Paths.get("C:/Users/Maslz/Desktop/OSII_Project/RemoteFolder"))) {
            paths.filter(Files::isRegularFile).forEach(System.out::println);
        }*/
        int row = 0, column = 0;

        for (int i = 0; i < files.size(); i++) {
            //Files
            String fileName = (String) files.get(i);
            final ProcessBuilder pb = new ProcessBuilder("Notepad.exe", "C:/Users/Maslz/Desktop/OSII_Project/RemoteFolder/" + fileName);

            //GUI
            Label fileLabel = new Label(fileName);
            Button openFile = new Button("open");
            Label br = new Label();
            br.setText(fileName);

            gridPane.add(fileLabel, column, row);
            column += 1;
            gridPane.add(openFile, column, row);
            row += 1;
            column = 0;

            //Button Action
            openFile.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        pb.start();
                    } catch (IOException ex) {
                        //Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });

            Label newFolderLabel = new Label("Create new folder");
            TextField newFolderName = new TextField();
            Button createFolder = new Button("Create");

            //Button Action
            createFolder.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    createFolder(newFolderName.getText());
                }
            });

            gridPane.add(newFolderLabel, 20, 0);
            gridPane.add(newFolderName, 20, 1);
            gridPane.add(createFolder, 20, 2);

            //Add to root
            //root.getChildren().add(fileLabel);
            //root.getChildren().add(openFile);
            //root.getChildren().add(br);
        }

        Scene scene = new Scene(gridPane, 700, 300);
        scene.getStylesheets().add("App/Style.css");
        stage.setScene(scene);

        stage.setTitle("Title");

        stage.show();

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void createFolder(String folderName) {
        String path = "C:/Users/Maslz/Desktop/OSII_Project/RemoteFolder";
        System.out.println("Enter the name of the desired a directory: ");
        path = path + "/" + folderName;
        //Creating a File object
        File file = new File(path);
        //Creating the directory
        boolean bool = file.mkdir();
        if (bool) {
            System.out.println("Directory created successfully");
        } else {
            System.out.println("Sorry couldn’t create specified directory");
        }
    }

    public static void listFilesForFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                System.out.println(fileEntry.getName());
                files.add(fileEntry.getName());
                listFilesForFolder(fileEntry);
            } else {
                System.out.println(fileEntry.getName());
                files.add(fileEntry.getName());
            }
        }
    }

}

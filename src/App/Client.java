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
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
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

//import org.riversum.promise.Promise;
public class Client extends Application {

    final static File folder = new File("RemoteFolder");
    static ArrayList files = new ArrayList();

    static boolean connected;

    public static void main(String[] args) throws RemoteException, NotBoundException {

        //Connection to server
        String cwd = System.getProperty("user.dir");
        System.out.println("Current working directory : " + cwd);
        System.out.println(javafx.scene.text.Font.getFamilies());
        launch(args);
        /*MyService service = (MyService) Naming.lookup("rmi://localhost:5099/helloserver");
        System.out.println("---" + service.echo("hey server") + " " + service.getClass().getName());*/

    }

    @Override
    public void start(Stage stage) throws Exception {

        //Promise.resolve("foo");
        HBox root = new HBox();

        Stage connectStage = new Stage();
        stage.setTitle("connected");
        //stage.setResizable(false);
        //stage.initModality(Modality.APPLICATION_MODAL);
        //stage.initOwner(stage);
        stage.initStyle(StageStyle.UTILITY);

        Button connectButton = new Button("Connect to server");
        connectButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    connected = connectToServer();
                    if (connected) {
                        listFilesForFolder(folder);
                        connectStage.close();

                    }
                } catch (RemoteException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotBoundException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        root.getChildren().add(connectButton);

        Scene connectScene = new Scene(root, 700, 300);
        connectScene.getStylesheets().add("App/Style.css");
        connectStage.setScene(connectScene);

        connectStage.showAndWait();

        if (connected) {

            System.out.println("connect: " + connected);

            System.out.println("Llegue perro");
            //connectStage.close();

            GridPane gridPane = new GridPane();
            int row = 0, column = 0;

            for (int i = 0; i < files.size(); i++) {
                //Files
                String fileName = (String) files.get(i);
                final ProcessBuilder pb = new ProcessBuilder("Notepad.exe", "./" + folder + "/" + fileName);

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

        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void createFolder(String folderName) {
        String path = folder.getPath();
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

    public static boolean connectToServer() throws RemoteException, NotBoundException {
        ChatInterface client = new Chat("Culo");
        Registry registry = LocateRegistry.getRegistry(8888);
        ChatInterface server = (ChatInterface) registry.lookup("ejempl");

        if (true) {
            System.out.println("Connection succesful");
            return true;
        } else {
            return false;
        }
    }

}

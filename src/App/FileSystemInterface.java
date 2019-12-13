/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

/**
 *
 * @author xioma
 */
import static App.TempClient.files;
import UserInterface.Client;
import java.io.File;
import java.io.IOException;
import java.rmi.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.tree.DefaultTreeModel;

public interface FileSystemInterface extends Remote {

    File folder = new File("RemoteFolder");

    public String getName() throws RemoteException;

    public void send(String msg) throws RemoteException;

    public ArrayList<FileSystemInterface> getClient() throws RemoteException;

    DefaultTreeModel loadDirectory() throws RemoteException;

    void createFile(String fileName) throws RemoteException, IOException;

    void createFolder(String fileName) throws RemoteException, IOException;

    void editFile(File filePath) throws RemoteException;

    void eraseFile(File filePath) throws RemoteException;

    void addClient(FileSystemInterface client) throws RemoteException;

    void dismountClient(String clientName) throws RemoteException;

}

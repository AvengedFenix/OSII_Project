/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import UserInterface.Client;
import static App.TempClient.files;
import static App.FileSystemInterface.folder;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class Middleware implements FileSystemInterface {

    //Variables
    File folder = new File("RemoteFolder");
    ArrayList<FileSystemInterface> clients = new ArrayList();
    String name;
    Client clientGUI;

    public Middleware(String name, Client clientGUI) {
        this.name = name;
        this.clientGUI = clientGUI;
    }

    @Override
    public String getName() throws RemoteException {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void send(String msg) throws RemoteException {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vector<FileSystemInterface> getClient() throws RemoteException {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createFile(String fileName) throws RemoteException, IOException {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createFolder(String fileName) throws RemoteException, IOException {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editFile(File filePath) throws RemoteException {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eraseFile(File filePath) throws RemoteException {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addClient(FileSystemInterface client) throws RemoteException {
        System.out.println("Getting client: " + client.getName());
        clients.add(client);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dismountClient(String clientName) throws RemoteException {
        try {
            for (int i = 0; i < clients.size(); i++) {
                if (clients.get(i).getName().equals(name)) {
                    clients.remove(i);
                    System.out.println("Client " + name + " dismounted correctly.");
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultTreeModel loadDirectory() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(new MyFiles(new File("RemoteFolder"), "", false, true));
        loadTree("RemoteFolder", root);
        return new DefaultTreeModel(root);
    }

    public void loadTree(String path, DefaultMutableTreeNode node) {
        File root = new File(path);
        File[] list = root.listFiles();
        MyFiles remainingFile;

        for (File file : list) {
            String filename = file.getName();
            if (file.isFile()) {
                String texto = readFile(file.getAbsolutePath());
                remainingFile = new MyFiles(file, texto, true, false);
                node.add(new DefaultMutableTreeNode(remainingFile));
            } else if (file.isDirectory()) {
                remainingFile = new MyFiles(file, "", false, true);
                DefaultMutableTreeNode subdir = new DefaultMutableTreeNode(remainingFile);
                File subdirfile = new File(root.getAbsolutePath(), filename);
                loadTree(subdirfile.getAbsolutePath(), subdir);
                node.add(subdir);
            }
        }
    }

    public static String readFile(String fileName) {
        String data = "";
        try {
            data = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            System.out.println(e);
        }
        return data;
    }

}

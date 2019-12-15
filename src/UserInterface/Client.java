/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import App.FileSystemInterface;
import App.Middleware;
import App.MyFiles;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author Maslz
 */
public class Client extends javax.swing.JFrame {

    /**
     * Creates new form UI
     */
    //Global variables
    //String ip = "localhost";
    //int port = 8000;
    String name;
    public Registry registry;
    public FileSystemInterface server;
    public FileSystemInterface client;
    public String open;
    boolean connected = false;
    boolean mount = true;

    public Client() throws RemoteException, NotBoundException {
        initComponents();
        name = JOptionPane.showInputDialog(this, "Ingrese un nombre para identificar al cliente", "INICIANDO CLIENTE", JOptionPane.INFORMATION_MESSAGE);
        client = new Middleware(name, this);
        registry = LocateRegistry.getRegistry(8888);
        server = (FileSystemInterface) registry.lookup("FileSystem");
        //server.addClient(client);

        server.addClient(client);
        loadFile();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_remoteDirectory = new javax.swing.JTree();
        jb_createFolder = new javax.swing.JButton();
        jb_createFile = new javax.swing.JButton();
        jb_dismount = new javax.swing.JButton();
        jb_deleteFile = new javax.swing.JButton();
        jb_montar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(233, 32, 79));
        jPanel2.setToolTipText("");

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel1.setText("Directory");

        jt_remoteDirectory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jt_remoteDirectoryMouseClicked(evt);
            }
        });
        jt_remoteDirectory.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jt_remoteDirectoryValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jt_remoteDirectory);

        jb_createFolder.setText("Crear Directorio");
        jb_createFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_createFolderActionPerformed(evt);
            }
        });

        jb_createFile.setText("Crear Archivo");
        jb_createFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_createFileActionPerformed(evt);
            }
        });

        jb_dismount.setText("Desmontar");
        jb_dismount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_dismountActionPerformed(evt);
            }
        });

        jb_deleteFile.setText("Borrar Archivo");
        jb_deleteFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_deleteFileActionPerformed(evt);
            }
        });

        jb_montar.setText("Montar");
        jb_montar.setVisible(!mount);
        jb_montar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_montarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jb_createFolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jb_createFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jb_dismount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jb_deleteFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jb_montar, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                        .addGap(21, 21, 21))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jb_createFolder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jb_createFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jb_deleteFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_dismount)
                    .addComponent(jb_montar))
                .addGap(26, 26, 26))
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Proyecto Sistemas Operativos II");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel2)
                .addContainerGap(105, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jt_remoteDirectoryValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jt_remoteDirectoryValueChanged
//        String fileName = (String) files.get(i);
        //final ProcessBuilder pb = new ProcessBuilder("Notepad.exe", "./" + folder + "/" + fileName);
        jt_remoteDirectory.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) jt_remoteDirectory.getLastSelectedPathComponent();
                    if (node == null) {
                        return;
                    }
                    Object nodeInfo = node.getUserObject();
                    System.out.println(nodeInfo.toString());
                    // Cast nodeInfo to your object and do whatever you want
                }
            }
        });

    }//GEN-LAST:event_jt_remoteDirectoryValueChanged

    private void jt_remoteDirectoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jt_remoteDirectoryMouseClicked
        if (evt.getClickCount() == 2) {
            ProcessBuilder pb = new ProcessBuilder();

            DefaultMutableTreeNode node = (DefaultMutableTreeNode) jt_remoteDirectory.getLastSelectedPathComponent();
            if (node == null) {
                return;
            }
            Object nodeInfo = node.getUserObject();
            System.out.println(nodeInfo.toString());

            if (nodeInfo.toString().contains(".")) {
                pb = new ProcessBuilder("Notepad.exe", "./" + folder + "/" + nodeInfo.toString());
            } else {
                System.out.println("Es directorio");
            }

            try {
                if (nodeInfo.toString().contains(".")) {
                    pb.start();
                } else {

                }
                // Cast nodeInfo to your object and do whatever you want
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jt_remoteDirectoryMouseClicked

    private void jb_createFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_createFolderActionPerformed
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) jt_remoteDirectory.getLastSelectedPathComponent();
        if (node == null) //Nothing is selected.  
        {
            return;
        }

        Object nodeInfo = node.getUserObject();

        MyFiles file = (MyFiles) nodeInfo;
        System.out.println(file.getFile().getPath());

        String folderName = (String) JOptionPane.showInputDialog(this, "Ingrese nombre");
        //String path = folder.getPath();
        System.out.println("Enter the name of the desired a directory: ");

        String path = file.getFile().getPath() + "\\" + folderName;
        System.out.println("path: " + path);

        //Creating a File object
        File file2 = new File(path);
        //Creating the directory
        boolean bool = file2.mkdir();
        if (bool) {
            reload();
            FileTreeCellRenderer x = new FileTreeCellRenderer();
            //x.getTreeCellRendererComponent(jt_remoteDirectory, file, bool, true, bool, ERROR, bool);
            System.out.println("Directory created successfully");

        } else {
            System.out.println("Sorry couldn’t create specified directory");
        }
    }//GEN-LAST:event_jb_createFolderActionPerformed

    private void jb_createFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_createFileActionPerformed
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) jt_remoteDirectory.getLastSelectedPathComponent();
        if (node == null) //Nothing is selected.  
        {
            return;
        }

        Object nodeInfo = node.getUserObject();

        MyFiles file2 = (MyFiles) nodeInfo;
        System.out.println(file2.getFile().getPath());

        String fileName = (String) JOptionPane.showInputDialog(this, "Ingrese nombre de archivo");
        //String path = folder.getPath();
        System.out.println("Enter the name of the desired a directory: ");
        String path2 = file2.getFile().getPath() + "\\" + fileName;
        System.out.println("path: " + path2);
        //Creating a File object
        //File file2 = new File(path);

        try {
            String fileData = "";
            FileOutputStream fos = new FileOutputStream(".\\" + path2 + ".txt");
            fos.write(fileData.getBytes());
            fos.flush();
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        reload();
        //FileTreeCellRenderer x = new FileTreeCellRenderer();
        //x.getTreeCellRendererComponent(jt_remoteDirectory, file, bool, true, bool, ERROR, bool);
        System.out.println("File created successfully");
    }//GEN-LAST:event_jb_createFileActionPerformed

    private void jb_dismountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_dismountActionPerformed
        // TODO add your handling code here:
        try {
            if (!mount) {
                jt_remoteDirectory.setEnabled(true);
                mount = !mount;
                server.addClient(client);
                loadFile();
            } else {
                server.dismountClient(name);

                // cerrar el archivo
                open = "";
                // volver a cargar la estructura

                mount = !mount;

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jb_dismountActionPerformed

    private void jb_deleteFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_deleteFileActionPerformed
        // TODO add your handling code here:
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) jt_remoteDirectory.getLastSelectedPathComponent();
        if (node == null) {
            return;
        }
        Object nodeInfo = node.getUserObject();
        System.out.println(nodeInfo.toString());

        try {
            String path = folder.getPath();
            System.out.println("Enter the name of the desired a directory: ");
            path = path + "/" + nodeInfo.toString();
            //Deleting a File object
            File file = new File(path);
            file.delete();

            reload();
            FileTreeCellRenderer x = new FileTreeCellRenderer();

        } catch (Exception e) {
        }

    }//GEN-LAST:event_jb_deleteFileActionPerformed

    private void jb_montarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_montarActionPerformed
        // TODO add your handling code here:
        try {
            name = JOptionPane.showInputDialog(this, "Ingrese un nombre para identificar al cliente", "INICIANDO CLIENTE", JOptionPane.INFORMATION_MESSAGE);
            client = new Middleware(name, this);
            registry = LocateRegistry.getRegistry(8888);
            server = (FileSystemInterface) registry.lookup("FileSystem");
            //server.addClient(client);

            server.addClient(client);
            loadFile();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jb_montarActionPerformed

    /**
     * @param args the command line arguments
     */
    final static File folder = new File("RemoteFolder");
    static ArrayList files = new ArrayList();

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Client().setVisible(true);
                } catch (RemoteException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotBoundException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public void conflict() {
        // se detecto un conflicto
        // notificarlo
        JOptionPane.showMessageDialog(this, "Se detecto un conflicto con el archivo que tiene abierto:\n" + open);
        // cerrar el archivo
        open = "";
        //ta_archivo.setVisible(false);
        //btn_guardar.setVisible(false);
        // volver a cargar la estructura
        loadFile();
    }

    public void loadFile() {
        try {
            DefaultTreeModel model = server.loadDirectory();
            jt_remoteDirectory.setModel(model);

            resetCache();

            roam((DefaultMutableTreeNode) jt_remoteDirectory.getModel());
        } catch (Exception e) {
        }
    }

    public void roam(DefaultMutableTreeNode nodo) throws IOException {
        // Recorrer todos los archivos en el arbol e imprimir su info
        MyFiles file = (MyFiles) nodo.getUserObject();

        boolean isFile = file.isFile;
        boolean isDir = file.isDir;

        File local = new File(dirLocal(file.getFile()));

        if (isFile) {
            local.getParentFile().mkdirs();
            local.createNewFile();
            writeFile(local.getAbsolutePath(), file.getText());
        }

        if (isDir) {
            local.mkdirs();
        }

        if (nodo.isLeaf()) {
            return;
        }

        for (int i = 0; i < nodo.getChildCount(); i += 1) {
            roam((DefaultMutableTreeNode) nodo.getChildAt(i));
        }
    }

    public String dirLocalServer(File dirServer) {
        // Obtener el dir local, dado el del server
        String[] spl = dirServer.getAbsolutePath().split("RootServer");
        if (spl.length == 1) {
            return "RootServer";
        }

        return "RootServer" + spl[1];
    }

    public String dirLocal(File dirServer) {
        // Obtener el dir local, dado el del server
        String[] spl = dirServer.getAbsolutePath().split("RootServer");
        if (spl.length == 1) {
            return "RootClient" + name;
        }

        return "RootClient" + name + spl[1];
    }

    public void writeFile(String filename, String text) {
        try {
            Files.write(Paths.get(filename), text.getBytes());
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void resetCache() {
        File rootClient = new File("RootClient" + name);

        // Borrar el directorio de cache del cliente
        deleteDirectories(rootClient);

        // Volver a crear el directorio
        rootClient.mkdirs();
    }

    public void deleteDirectories(File root) {
        File[] allContents = root.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectories(file);
            }
        }
        root.delete();
    }

    public void regenerar() {
        try {
            DefaultTreeModel modelo = server.loadDirectory();
            jt_remoteDirectory.setModel(modelo);
            jt_remoteDirectory.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
            jt_remoteDirectory.setSelectionRow(0);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void createFolder(String extention) {
        String folderName = (String) JOptionPane.showInputDialog(this, "Ingrese nombre");
        String path = folder.getPath();
        System.out.println("Enter the name of the desired a directory: ");
        path = path + "/" + folderName + extention;
        //Creating a File object
        File file = new File(path);
        //Creating the directory
        boolean bool = file.mkdir();
        if (bool) {
            reload();
            FileTreeCellRenderer x = new FileTreeCellRenderer();
            //x.getTreeCellRendererComponent(jt_remoteDirectory, file, bool, true, bool, ERROR, bool);
            System.out.println("Directory created successfully");

        } else {
            System.out.println("Sorry couldn’t create specified directory");
        }
    }

    class FileTreeCellRenderer extends DefaultTreeCellRenderer {

        @Override
        public Component getTreeCellRendererComponent(JTree tree,
                Object value, boolean sel, boolean expanded, boolean leaf,
                int row, boolean hasFocus) {
            JLabel renderer = (JLabel) super.getTreeCellRendererComponent(
                    tree, value, sel, expanded, leaf, row, hasFocus);
            File currentFile = (File) value;
            if (currentFile.isDirectory()) {
                if (expanded) {
                    renderer.setIcon(openIcon);
                } else {
                    renderer.setIcon(closedIcon);
                }
            } else {
                renderer.setIcon(leafIcon);
            }
            return renderer;
        }
    }

    public void reload() {
        try {
            DefaultTreeModel modelo = server.loadDirectory();
            jt_remoteDirectory.setModel(modelo);
            jt_remoteDirectory.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
            jt_remoteDirectory.setSelectionRow(0);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public boolean connectToServer() throws RemoteException, NotBoundException {
        FileSystemInterface client = new Middleware("Temporal name", this);
        Registry registry = LocateRegistry.getRegistry(8888);
        FileSystemInterface server = (FileSystemInterface) registry.lookup("ejempl");

        if (true) {
            System.out.println("Connection succesful");
            return true;
        } else {
            return false;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_createFile;
    private javax.swing.JButton jb_createFolder;
    private javax.swing.JButton jb_deleteFile;
    private javax.swing.JButton jb_dismount;
    private javax.swing.JButton jb_montar;
    private javax.swing.JTree jt_remoteDirectory;
    // End of variables declaration//GEN-END:variables
}

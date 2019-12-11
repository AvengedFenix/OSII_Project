/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.io.File;
import java.io.Serializable;
import java.util.Scanner;

public class MyFiles implements Serializable{

    public File file;
    public String texto;
    public boolean isFile;
    public boolean isDir;

    public MyFiles(File file, String texto, boolean isFile, boolean isDir) {
        this.file = file;
        this.texto = texto;
        this.isFile = isFile;
        this.isDir = isDir;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public File getFile() {
        return this.file;
    }

    public void setText(String texto) {
        this.texto = texto;
    }

    public String getText() {
        return this.texto;
    }

    public String info() {
        return "Archivo: \"" + file.getName() + "\"\n Path: \"" + file.getAbsolutePath() + "\"\nTexto: \"" + texto + "\"\n";
    }

    @Override
    public String toString() {
        return file.getName();
    }
}

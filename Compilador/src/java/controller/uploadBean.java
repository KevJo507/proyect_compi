/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.io.IOException;
import java.util.Scanner;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.Part;

/**
 *
 * @author josue
 */
@Named(value = "controller")
@RequestScoped
@ManagedBean

public class uploadBean {
    private Part file;

    
    public void upload() throws IOException {
        Scanner s = new Scanner(file.getInputStream());
        String fileContent = s.useDelimiter("\\A").next();
        System.out.println(fileContent);
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class GameRecord {

    private String record;

    public GameRecord() {
        record = "";
    }

    public void addPlay(String s) {
        record += s + ",";
    }

    public void saveRecord(String fileName) {
        Thread thread = new Thread(() -> {

            try {
                FileWriter writer = null;
                String temp;
                writer = new FileWriter(fileName, true);
                Date d = new Date();
                
                writer.append(d.toInstant().toString()+"\n");
                
                writer.append(record+"\n");
                
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(GameRecord.class.getName()).log(Level.SEVERE, null, ex);
            }
            
             

        });
        thread.start();

    }

}

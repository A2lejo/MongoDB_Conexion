package org.example;
import javax.swing.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import  org.bson.Document;


public class Main {
    static JFrame frame = new JFrame("Calificaciones");

    public static void main(String[] args) {

        frame.setContentPane(new form().pasatiempos);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(680,760);
        frame.setVisible(true);

    }
}

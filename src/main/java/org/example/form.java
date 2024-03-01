package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class form {
    private JTextField nombreTF;
    private JTextField cali2;
    JPanel calificaciones;
    private JTextField pasatiemposTF;
    private JTextField DescripcionTF;
    private JButton ingresarButton;

    public form(){

//        button1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                MongoClient mongoClient = MongoClients.create("mongodb+srv://esfot:esfot2024@cluster0.xzffuex.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0");

//                MongoDatabase database = mongoClient.getDatabase("mybd2");
//                MongoCollection<Document> collection = database.getCollection("mycollection");

//                Document document = new Document
//                        ( "name",nombre.getText())
//                        .append("Calificación 1:", cali1.getText())
//                        .append("Calificación 2:",cali2.getText());
//
//                collection.insertOne(document);
//                System.out.println("Insertados");
//            }
//        });
//        actualizarButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Main.frame.setContentPane(new form2().actualizarCalificaciones);
//                Main.frame.revalidate();
//            }
//        });
        ingresarButton.addActionListener(e -> {
            MongoClient mongoClient = MongoClients.create("mongodb+srv://esfot:esfot2024@cluster0.xzffuex.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0");

        });
    }
}

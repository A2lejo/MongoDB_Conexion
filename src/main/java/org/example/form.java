package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class form {
    private JTextField nombreTF;
    private JTextField cali2;
    JPanel pasatiempos;
    private JTextField pasatiemposTF;
    private JTextField DescripcionTF;
    private JButton ingresarButton;
    private JButton revisarButton;

    public form(){

        ingresarButton.addActionListener(e -> {
            MongoClient mongoClient = MongoClients.create("mongodb+srv://esfot:esfot2024@cluster0." +
                    "xzffuex.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0");
            MongoDatabase database = mongoClient.getDatabase("DeberPoo");
            MongoCollection<Document> collection = database.getCollection("Pasatiempos");
            Document document = new Document();
            document.append("Nombre",nombreTF.getText());
            document.append("Pasatiempo:",pasatiemposTF.getText());
            document.append("Descripcion:",DescripcionTF.getText());
            collection.insertOne(document);
            mongoClient.close();
        });
        revisarButton.addActionListener(e -> {
            MongoClient mongoClient = MongoClients.create("mongodb+srv://esfot:esfot2024@cluster0." +
                    "xzffuex.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0");
            MongoDatabase database = mongoClient.getDatabase("DeberPoo");
            MongoCollection<Document> collection = database.getCollection("Pasatiempos");
            for (Document doc : collection.find()) {
                System.out.println(doc.toJson());
            }

        });
    }

}

package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;


public class form {
    String usuario = "esfot";
    String password = "esfot2024";
    private JTextField nombreTF;
    JPanel pasatiempos;
    private JTextField pasatiemposTF;
    private JTextField DescripcionTF;
    private JButton ingresarButton;
    private JButton revisarButton;
    private JScrollPane mostar;
    private JTable tabla;


    public form(){

        ingresarButton.addActionListener(e -> {
            MongoClient mongoClient = MongoClients.create("mongodb+srv://"+usuario+":"+password+"@cluster0." +
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
            MongoClient mongoClient = MongoClients.create("mongodb+srv://"+usuario+":"+password+"@cluster0." +
                    "xzffuex.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0");
            MongoDatabase database = mongoClient.getDatabase("DeberPoo");
            MongoCollection<Document> collection = database.getCollection("Pasatiempos");

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Nombre");
            model.addColumn("Pasatiempo");
            model.addColumn("Descripcion");

            for (Document doc : collection.find()) {
                Vector<String> row = new Vector<>();
                row.add(doc.getString("Nombre"));
                row.add(doc.getString("Pasatiempo:"));
                row.add(doc.getString("Descripcion:"));
                model.addRow(row);
            }
            tabla.setModel(model);

            mongoClient.close();
        });
    }

}

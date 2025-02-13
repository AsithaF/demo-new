package com.hardwareproject.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.*;

public class LoadController {

    @FXML
    private TableView<Inventory> loadTable;

    @FXML
    public void initialize() {
        // Map columns to Inventory class fields
        loadTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("inventoryId"));
        loadTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("productName"));
        loadTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("productPrice"));
        loadTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("productQuty"));
    }

    @FXML
    void load(ActionEvent event) {
        loadTable.setItems(loadTableData()); // Load data into TableView
    }

    public ObservableList<Inventory> loadTableData() {
        ObservableList<Inventory> inventoryList = FXCollections.observableArrayList();
        try {
            // Database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hardware", "root", "Asitha@1998#");

            // SQL Query
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM inventroy");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("inventroy_id");
                String name = resultSet.getString("product_name");
                double price = resultSet.getDouble("product_price");
                int qty = resultSet.getInt("product_quty");

                // Create Inventory Object and Add to List
                inventoryList.add(new Inventory(id, name, price, qty));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inventoryList;
    }
}

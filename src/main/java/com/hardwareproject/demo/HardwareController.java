package com.hardwareproject.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HardwareController {

    @FXML
    private TextField txtName;


    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtQty;

    @FXML
    void cansel(ActionEvent event) {
        System.exit(0);

    }

    @FXML
    void save(ActionEvent event) throws ClassNotFoundException, RuntimeException {
          String product_name = txtName.getText();
          String product_price = txtPrice.getText();
          String product_quty = txtQty.getText();



        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hardware", "root", "Asitha@1998#");

            PreparedStatement preparedStatement = connection.prepareStatement("insert into inventroy(product_name,product_price,product_quty) values(?,?,?)");
            preparedStatement.setObject(1, product_name);
            preparedStatement.setObject(2, product_price);
            preparedStatement.setObject(3, product_quty);

            int i = preparedStatement.executeUpdate();


            if (i > 0) {
                System.out.println("Record inserted successfully");
            }else System.out.println("Record not inserted ");

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

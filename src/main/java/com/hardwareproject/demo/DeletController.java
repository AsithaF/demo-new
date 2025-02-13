package com.hardwareproject.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeletController {

    @FXML
    private TextField txtIdnum;

    @FXML
    void delet(ActionEvent event) throws ClassNotFoundException, RuntimeException  {
        int inventroy_id = Integer.parseInt(txtIdnum.getText());




        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hardware", "root", "Asitha@1998#");

            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM inventroy WHERE inventroy_id = ?");
            preparedStatement.setObject(1, inventroy_id);


            int i = preparedStatement.executeUpdate();
            if(i>0){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Delete");
                alert.setContentText("Deleted Successful.");
                alert.showAndWait();
            }else{
                Alert warning = new Alert(Alert.AlertType.INFORMATION);
                warning.setTitle("Failed");
                warning.setContentText("Deleted failed!! Give correct ID.");
                warning.showAndWait();
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        }

        public void play(){


        }

        public void  dance(){


        }

    }




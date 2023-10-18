package com.example.nasa;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class NasaTableController implements Initializable {

    @FXML
    private TableView<Mission> missionTableView;

    @FXML
    private TableColumn<Mission, Integer> serialNumberColumn;

    @FXML
    private TableColumn<Mission, String> missionNameColumn;

    @FXML
    private TableColumn<Mission, String> missionStartDateColumn;

    @FXML
    private TableColumn<Mission, String> missionEndDateColumn;

    @FXML
    private TableColumn<Mission, String> missionStatusColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Mission> missionData = getMissionDataFromDatabase();

        serialNumberColumn.setCellValueFactory(cellData -> cellData.getValue().snoProperty().asObject());
        missionNameColumn.setCellValueFactory(cellData -> cellData.getValue().missionNameProperty());
        missionStartDateColumn.setCellValueFactory(cellData -> cellData.getValue().missionStartDateProperty());
        missionEndDateColumn.setCellValueFactory(cellData -> cellData.getValue().missionEndDateProperty());
        missionStatusColumn.setCellValueFactory(cellData -> cellData.getValue().missionStatusProperty());

        missionTableView.setItems(missionData);
    }

    private ObservableList<Mission> getMissionDataFromDatabase() {
        ObservableList<Mission> missionList = FXCollections.observableArrayList();

        String jdbcUrl = "jdbc:mysql://172.31.22.43:3306/Diwash200542953";  // Update with your database URL
        String username = "Diwash200542953";  // Update with your username
        String password = "q3nREdBmMz";  // Update with your password

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM nasa_missions")) {

            while (resultSet.next()) {
                int sno = resultSet.getInt("SNo");
                String missionName = resultSet.getString("mission_name");
                String startDate = resultSet.getString("mission_start_date");
                String endDate = resultSet.getString("mission_end_date");
                String missionStatus = resultSet.getString("mission_status");

                Mission mission = new Mission(sno, missionName, startDate, endDate, missionStatus);
                missionList.add(mission);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return missionList;
    }
}

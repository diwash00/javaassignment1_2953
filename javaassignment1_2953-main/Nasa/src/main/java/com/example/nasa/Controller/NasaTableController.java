package com.example.nasa.Controller;

import com.example.nasa.Model.Mission;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
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
        // Fetch mission data from the database
        ObservableList<Mission> missionData = getMissionDataFromDatabase();

        // Set cell value factories for each column
        serialNumberColumn.setCellValueFactory(cellData -> cellData.getValue().snoProperty().asObject());
        missionNameColumn.setCellValueFactory(cellData -> cellData.getValue().missionNameProperty());

        // Use a StringConverter to convert LocalDate to String for TableView display
        missionStartDateColumn.setCellValueFactory(cellData ->
                Bindings.createStringBinding(() ->
                        cellData.getValue().missionStartDateProperty().get().toString(), cellData.getValue().missionStartDateProperty()));

        missionEndDateColumn.setCellValueFactory(cellData ->
                Bindings.createStringBinding(() ->
                        cellData.getValue().missionEndDateProperty().get().toString(), cellData.getValue().missionEndDateProperty()));

        missionStatusColumn.setCellValueFactory(cellData -> cellData.getValue().missionStatusProperty());

        // Set the items in the TableView
        missionTableView.setItems(missionData);
    }

    private ObservableList<Mission> getMissionDataFromDatabase() {
        ObservableList<Mission> missionList = FXCollections.observableArrayList();

        // Database connection details
        String jdbcUrl = "jdbc:mysql://172.31.22.43:3306/Diwash200542953";
        String username = "Diwash200542953";
        String password = "q3nREdBmMz";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM nasa_missions")) {

            // Iterate through the result set and create Mission objects
            while (resultSet.next()) {
                int sno = resultSet.getInt("SNo");
                String missionName = resultSet.getString("mission_name");

                // Check if the date is null before converting
                java.sql.Date startDateSql = resultSet.getDate("mission_start_date");
                LocalDate startDate = (startDateSql != null) ? startDateSql.toLocalDate() : null;

                // Similarly, check for the end date
                java.sql.Date endDateSql = resultSet.getDate("mission_end_date");
                LocalDate endDate = (endDateSql != null) ? endDateSql.toLocalDate() : null;

                String missionStatus = resultSet.getString("mission_status");

                // Create Mission object and add it to the list
                Mission mission = new Mission(sno, missionName, startDate, endDate, missionStatus);
                missionList.add(mission);
            }

        } catch (SQLException e) {
            // Handle exceptions more gracefully (e.g., show error message to the user)
            e.printStackTrace();
        }

        return missionList;
    }
}

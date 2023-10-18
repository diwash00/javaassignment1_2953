package com.example.nasa;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtilities {

    private static String user = "Diwash200542953";
    private static String pass = "q3nREdBmMz";
    private static String connectURL = "jdbc:mysql://172.31.22.43:3306/" + user;

    // Method to fetch missions from the database
    public static void fetchMissionsFromDB() {
        String sql = "SELECT * FROM nasa_missions";

        try (Connection conn = DriverManager.getConnection(connectURL, user, pass);
             PreparedStatement preparedStatement = conn.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int sno = resultSet.getInt("SNo");
                String missionName = resultSet.getString("mission_name");
                Date startDate = resultSet.getDate("mission_start_date");
                Date endDate = resultSet.getDate("mission_end_date");
                String missionStatus = resultSet.getString("mission_status");

                // Print mission details
                System.out.println("Serial Number: " + sno);
                System.out.println("Mission Name: " + missionName);
                System.out.println("Start Date: " + startDate);
                System.out.println("End Date: " + endDate);
                System.out.println("Mission Status: " + missionStatus);
                System.out.println("===========================");
            }

        } catch (SQLException e) {
            e.printStackTrace();  // Print any SQL exceptions that occur
        }
    }

    // Main method to demonstrate fetching missions from the database
    public static void main(String[] args) {
        fetchMissionsFromDB();  // Call the method to fetch missions
    }
}


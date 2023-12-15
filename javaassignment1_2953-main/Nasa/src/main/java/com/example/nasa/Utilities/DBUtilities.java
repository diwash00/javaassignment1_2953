package com.example.nasa.Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DBUtilities {

    private static final String user = "Diwash200542953";
    private static final String pass = "q3nREdBmMz";
    private static final String connectURL = "jdbc:mysql://172.31.22.43:3306/" + user;

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void fetchMissionsFromDB() {
        String sql = "SELECT * FROM nasa_missions";

        try (Connection conn = DriverManager.getConnection(connectURL, user, pass);
             PreparedStatement preparedStatement = conn.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int sno = resultSet.getInt("SNo");
                String missionName = resultSet.getString("mission_name");

                java.sql.Date startDateSql = resultSet.getDate("mission_start_date");
                LocalDate startDate = (startDateSql != null) ? startDateSql.toLocalDate() : null;

                java.sql.Date endDateSql = resultSet.getDate("mission_end_date");
                LocalDate endDate = (endDateSql != null) ? endDateSql.toLocalDate() : null;

                String missionStatus = resultSet.getString("mission_status");

                String formattedStartDate = (startDate != null) ? startDate.format(dateFormatter) : "N/A";
                String formattedEndDate = (endDate != null) ? endDate.format(dateFormatter) : "N/A";

                System.out.println("Serial Number: " + sno);
                System.out.println("Mission Name: " + missionName);
                System.out.println("Start Date: " + formattedStartDate);
                System.out.println("End Date: " + formattedEndDate);
                System.out.println("Mission Status: " + missionStatus);
                System.out.println("===========================");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        fetchMissionsFromDB();
    }
}

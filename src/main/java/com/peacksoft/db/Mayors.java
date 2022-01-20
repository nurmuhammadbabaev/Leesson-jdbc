package com.peacksoft.db;

import java.sql.*;

public class Mayors {
    private final static String url="jdbc:postgresql://localhost:5432/postgres";
    private final static String user="postgres";
    private final static String password="1805";

    public static Connection connection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgresSQL server\n" + "successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
    public static Mayors printMayors() {
        String SQL = "SELECT * FROM mayors";
        try (Connection conn = connection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            System.out.println("----+---------------+---------------+-------------------+-------+");
            while (rs.next()) {
                System.out.println(rs.getInt("id") +
                        "\t|\t" + rs.getString("fist_name") +
                        "\t| "+ rs.getString("last_name")+
                        "\t| "+ rs.getDate("data_birth_day")+
                        "\t\t\t| "+ rs.getString("nationality")+
                        "\t|");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); }
        return null;
    }
}

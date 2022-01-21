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
    public static void addMayors(String  fist_name,String  last_name,Date data_birth_day,String nationality){
        String SQL="insert into mayors(  fist_name,last_name,data_birth_day,nationality) values (?,?,?,?)";
        try(Connection conn=connection()) {
            PreparedStatement statement=conn.prepareStatement(SQL);
            statement.setString(1,  fist_name);
            statement.setString(2,last_name);
            statement.setDate(3,data_birth_day);
            statement.setString(4,nationality);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static Mayors printMayors() {
        String SQL = "SELECT * FROM mayors";
        try (Connection conn = connection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            System.out.println("\nThis is a Mayors Table:");
            System.out.println("#################################################################");
            System.out.println("id\t| fist_name\t\t|\tlast_name\t| data_birth_day|nationality|");
            System.out.println("----+---------------+---------------+---------------+-----------+");
            while (rs.next()) {
                System.out.println(rs.getInt("id") +
                        "\t|\t" + rs.getString("fist_name") +
                        "\t| "+ rs.getString("last_name")+
                        "\t| "+ rs.getDate("data_birth_day")+
                        "\t| "+ rs.getString("nationality")+
                        "\t|");
            }
            System.out.println("#################################################################");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); }
        return null;
    }
}

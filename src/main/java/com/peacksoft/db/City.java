package com.peacksoft.db;

import java.sql.*;

public class City {
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
    }   public static void addCity(String cityName,String cityArea,int population,String CountryOfThisCity){
        String SQL="insert into city(cityName,cityArea,population,CountryOfThisCity) values (?,?,?,?)";
        try(Connection conn=connection()) {
            PreparedStatement statement=conn.prepareStatement(SQL);
            statement.setString(1,cityName);
            statement.setString(2,cityArea);
            statement.setInt(3,population);
            statement.setString(4,CountryOfThisCity);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static City printCity() {
        String SQL = "SELECT * FROM city";
        try (Connection conn = connection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            System.out.println("\nThis is a City Table:");
            System.out.println("###################################################################");
            System.out.println("id\t| cityName\t|\tcityArea\t|\tpopulation\t|CountryOfThisCity|");
            System.out.println("----+-----------+---------------+---------------+-----------------+");
            while (rs.next()) {
                System.out.println(rs.getInt("id") +
                        "\t|" + rs.getString("cityName") +
                        "\t| "+ rs.getString("cityArea")+
                        "\t| "+ rs.getInt("population")+
                        "\t\t| "+ rs.getString("CountryOfThisCity")+
                        "\t  |");
            }

            System.out.println("###################################################################");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); }
        return null;
    }
}

package com.peacksoft.db;

import java.sql.*;
import java.util.ArrayList;

public class Country {

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
    public  int getCounterCount(){
        String SQL="select count(*) from country";
        int count=0;
        try {
            Connection conn=connection();
            Statement statement=conn.createStatement();
            ResultSet resultSet=statement.executeQuery(SQL);
            {
                resultSet.next();
                count=resultSet.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count; }
    public static void addCountry(String countryName,String countryArea,int population,int countryAge){
        String SQL="insert into country(countryName,countryArea,population,countryAge) values (?,?,?,?)";
        try(Connection conn=connection()) {
            PreparedStatement statement=conn.prepareStatement(SQL);
            statement.setString(1,countryName);
            statement.setString(2,countryArea);
            statement.setInt(3,population);
            statement.setInt(4,countryAge);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static Country printCountry() {
        String SQL = "SELECT * FROM country";
        try (Connection conn = connection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            System.out.println("\nThis is a Country Table:");
            System.out.println("######################################################################");
            System.out.println("id\t|\tcountryName\t|\tcountryArea\t|\tpopulation\t\t| countryAge |");
            System.out.println("----+---------------+---------------+-------------------+------------+");
            while (rs.next()) {
                System.out.println(rs.getInt("id") +
                        "\t|\t" + rs.getString("countryName") +
                        "\t| "+ rs.getString("countryArea")+
                        "\t| "+ rs.getInt("population")+
                        "\t\t\t|\t"+ rs.getInt("countryAge")+
                        "\t\t |");
            }
            System.out.println("######################################################################");

        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage()); }

        return null;
    }
}

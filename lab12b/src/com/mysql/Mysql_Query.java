package com.mysql;

import java.sql.*;
import java.util.Properties;

public class Mysql_Query {

    public static void main(String[] args) {

        try {

            Connection dbConnection = null;

            try {

                // LOAD DRIVER
                Class.forName("com.mysql.cj.jdbc.Driver");

                String url =
                        "jdbc:mysql://localhost:3306/test";

                Properties info =
                        new Properties();

                info.put("user", "root");

                info.put("password", "@shalini075881");

                dbConnection =
                        DriverManager.getConnection(url, info);

                if (dbConnection != null) {

                    System.out.println(
                            "Successfully connected to MySQL database test"
                    );
                }

            } catch (SQLException ex) {

                System.out.println(
                        "An error occurred while connecting MySQL database"
                );

                ex.printStackTrace();
            }

            // SQL QUERY
            String query =
                    "SELECT * FROM coffee WHERE coffee_name LIKE 'D%'";

            // CREATE STATEMENT
            Statement st =
                    dbConnection.createStatement();

            // EXECUTE QUERY
            ResultSet rs =
                    st.executeQuery(query);

            // DISPLAY RESULT
            while (rs.next()) {

                int id =
                        rs.getInt("id");

                String coffee_name =
                        rs.getString("coffee_name");

                int price =
                        rs.getInt("price");

                System.out.format(
                        "\n%d %s %d",
                        id,
                        coffee_name,
                        price
                );
            }

            rs.close();
            st.close();
            dbConnection.close();

        } catch (Exception e) {

            System.err.println("Got an exception!");

            System.err.println(e.getMessage());
        }
    }
}
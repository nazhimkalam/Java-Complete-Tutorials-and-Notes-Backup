package com.jdbc.nazhim;
import java.sql.*;

public class JDBC2 {        // inserting data into the database
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/studentdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String username = "root";
        String password = "";
        String query = "INSERT INTO student(stdName, stdAge, stdId) VALUES (?,?,?)";

        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded...");

        Connection connection = DriverManager.getConnection(url,username,password);
        System.out.println("Connected to database...");

        PreparedStatement statement = connection.prepareStatement(query);
        System.out.println("creating prepared statement...");

        String name = "fatheeha";
        int age = 18;
        int id = 2019282;

        statement.setString(1, name); // set name
        statement.setInt(2, age);    // set age
        statement.setInt(3, id);    // set id

        int count = statement.executeUpdate();  // returns the number of updates in the table
        System.out.println("executing the updates...");

        System.out.println(count + " row/s affected");
        statement.close();
        System.out.println("closing statement...");

        connection.close();
        System.out.println("closing connection...");

    }
}

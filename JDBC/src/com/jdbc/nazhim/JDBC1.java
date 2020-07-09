package com.jdbc.nazhim;
// 1. import the package
import java.sql.*;

/*
* The 7 main steps required when dealing with JDBC
*
* 1. import the package
* 2. load and register the driver
* 3. establish the connection
* 4. create the statement
* 5. execute the query
* 6. process the result
* 7. close
*
* */
public class JDBC1 {        // fetching data from the database
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {
        String url = "jdbc:mysql://localhost:3306/studentdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String username = "root";
        String password = "";
        String query1 = "SELECT stdName FROM student WHERE stdAge = 20";
        String query2 = "SELECT * FROM student";

        // 2. load and register the driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded...");

        // 3. establish the connection
        //      Connection is an interface, so we have a method called getConnection() which provides a instance of the
        //      Connection and getConnection() is a static method of the Class DriveManager
        Connection connection = DriverManager.getConnection(url,username,password);
        System.out.println("Connected to database...");

        // 4. create the statement
        Statement statement = connection.createStatement();
        System.out.println("creating statement...");

        // 5. execute the query
        ResultSet resultSet = statement.executeQuery(query2);
        System.out.println("executing the query...");

        // 6. process the result
        while (resultSet.next()) {            // moves the pointer to the first row cuz initially the pointer is above the first row and goes on
            String name = resultSet.getString("stdName") + " : " + resultSet.getString("stdAge");
            System.out.println(name);
        }
        // 7. close
        statement.close();
        System.out.println("closing statement...");

        connection.close();
        System.out.println("closing connection...");

    }
}

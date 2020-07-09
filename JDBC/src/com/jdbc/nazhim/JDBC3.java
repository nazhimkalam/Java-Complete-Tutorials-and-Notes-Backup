package com.jdbc.nazhim;
import java.sql.*;

public class JDBC3 {        // JDBC with some design pattern DAO { Data Access Object }
    public static void main(String[] args) throws Exception {
        // getting the student name by using the stdID
        Student s = new Student();
        String studentName = s.getName(2019281);
        System.out.println(studentName);

        // Adding a Student into the data base
        Student s1 = new Student();
        s1.addStudent("Abilash",17,2019255);
    }
}
class Student{
    String sname;
    int sId;
    int sAge;

    public String getName(int stdId) throws Exception {
        String url = "jdbc:mysql://localhost:3306/studentdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String username = "root";
        String password = "";
        this.sId = stdId;
        String query = "SELECT stdName FROM student WHERE stdId = " + sId;

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url,username,password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();
        String name = resultSet.getString("stdName");

        this.sname = name;
        return sname;

    }

    public void addStudent(String name, int age, int id) throws Exception {
        String url = "jdbc:mysql://localhost:3306/studentdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String username = "root";
        String password = "";
        String query = "INSERT INTO student(stdName, stdAge, stdId) VALUES (?,?,?)";

        sname = name;
        sAge = age;
        sId = id;

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(url,username,password);

        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, sname); // set name
        statement.setInt(2, sAge);    // set age
        statement.setInt(3, sId);     // set id

        int count = statement.executeUpdate();  // returns the number of updates in the table

        System.out.println(count + " row/s affected");  // if it says 0 row/s affected that means it did update properly

        statement.close();
        connection.close();
    }

}

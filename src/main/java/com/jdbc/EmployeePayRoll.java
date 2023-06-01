package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeePayRoll {
    public static void main(String[] args) {
            /*
         UC1: Creating a payroll service database
         * Set the database URL to LocalHost database have created.
         */
        String jdbcURL = "jdbc:mysql://localhost:3306/PayrollServiceDB";
        String userName = "root";
        String password = "drisya";
        //connection for the parameter
        try (Connection connection = DriverManager.getConnection(jdbcURL,userName,password)){
            //creating Table
            try(Statement statement = connection.createStatement()){
                String createTableQuery = "create table Payroll_Tb (id int primary key, name varchar(20), age int, gender varchar(20),address varchar(60),phoneNumber double,department varchar(20),salary double,basic_pay double," +
                        "deductions double,taxable_pay double,income_tax double,net_pay double)";
                statement.executeUpdate(createTableQuery);
                System.out.println("Table is created Successfully");
            }
            //Insert the values
            try (Statement statement = connection.createStatement()){
                String insertQuery = "insert into Payroll_Tb (id,name,gender,age,address,phoneNumber,department,salary,basic_pay,deductions,taxable_pay,income_tax,net_pay)" +
                        " values(1,'Drisya','female',20,'lumut',778889999,'CIVIL',5000,5000000,80000,10000,30000,1800000)," +
                        "(2,'Divya','female',22,'perak',9999999,'IT',6000,6000000,30000,10000,40000,2000000)," +
                        "(3,'Terissa','female',25,'kerala',888889999,'IT',10000,2000000,90000,12000,50000,2500000)";
                statement.executeUpdate(insertQuery);
                System.out.println("Values Added Successfully");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package com.naammm.superapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        //Ta sẽ dùng các class được cung cấp sẵn bởi JDk trong thư viện JBDC
        //JDBC sẽ tự động móc với JBDC driver
        //Tương tự MySql, ta cũng cần
        Connection conn = null;
        try {

            String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=HFS302;encrypt=true;trustServerCertificate=true";
            String user = "sa";
            String pass = "12345";
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(dbURL, user, pass);
            System.out.println("Connect to DB successfully");
            PreparedStatement stm = conn.prepareStatement("select * from Subject");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String code = rs.getString("Code");
                String name = rs.getString("Name");
                int credits = rs.getInt("Credits");
                int hours = rs.getInt("StudyHours");
                System.out.println(code + "|" + name + "|" + credits + "|" + hours);
                System.out.printf("|%10s|%40s|%2d|%4d|\n", code, name, credits, hours);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

//        String dbURL = "jdbc:sqlserver://NAAMMM;databaseName=HSF302;encrypt=true;trustServerCertificate=true";



    }
}
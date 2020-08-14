package com.humor.zxc.common.jdbc;

import java.sql.*;

public class JDBCUtil {


    public static void main1(String[] args) {
        Connection con;     //con class
        String driver= "com.mysql.jdbc.Driver";// driver
        String url="jdbc:mysql://192.168.1.111:3306/lv?serverTimezone=UTC";//url name
        String name="root";
        String passport="root";
        try {
            Class.forName(driver);// load driver
            try {
                con=DriverManager.getConnection(url,name,passport);
                if(!con.isClosed()){
                    System.out.println("sql connection success");
                }
                Statement state= con.createStatement();
                String sql="select * from test";
                ResultSet result =state.executeQuery(sql);
                while(result.next()){
                    System.out.println(result.getString("name"));
                    System.out.println(result.getString("code"));


                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {

        Connection connection;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://192.168.1.111:3306/lv?serverTimezone=UTC",
                    "root", "root");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select name from test where id =1");

            while (resultSet.next()) {

                String name = resultSet.getString("name");
                System.out.println("name = " + name);

            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            statement.execute("delete from test where id=1");
            ResultSet delresult = statement.executeQuery("select name from test where id=1");
            if (delresult.next()==false){
                System.out.println("delete success.you are good!!!");
            }
            else {
                while (delresult.next()) {
                    if (delresult.getString("id") != "1") {
                        System.out.println("delete success.you are good!!!");
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}

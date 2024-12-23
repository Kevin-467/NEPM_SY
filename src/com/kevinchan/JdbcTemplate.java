package com.foreknow.test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTemplate {
    private Connection conn;
    /**
     * 连接数据库
     */
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        //1. 加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获取连接
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_db",
                "root","123456");
        return conn;
    }

    /**
     * DML(insert delete update)操作
     * @param sql
     * @param values
     * @return
     * @throws SQLException
     */
    public int Dml(String sql,Object...values) throws SQLException { //insert into user(name,pass,age) values(?,?,?)
         PreparedStatement preparedStatement = conn.prepareStatement(sql);
         //给？替换值
         for (int i = 0;i<values.length;i++) {
             preparedStatement.setObject(i + 1,values[i]); //将第1个？替换一个值
         }
         int isRight = preparedStatement.executeUpdate();
         return isRight;
    }

    /**
     * 查询
     */
    public ResultSet query(String sql,Object...values) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        //给？替换值
        for (int i = 0;i<values.length;i++) {
            preparedStatement.setObject(i + 1, values[i]); //将第1个？替换一个值
        }
        return  preparedStatement.executeQuery();
    }


    public static void main(String[] args) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        try {
            //1. 连接数据库
            jdbcTemplate.getConnection();
            //int i = jdbcTemplate.Dml("insert into admin(name,pass) values(?,?)","tomcat","123456");
            ResultSet rs = jdbcTemplate.query("select * from admin where name=? and pass=?","fender","123456");
            List<Admin> list = new ArrayList<>();
                while (rs.next()) {
                    // 获取当前行数据
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String pass = rs.getString("pass");
                    //将当前行数据获取后封装到对象中再将对象添加到List集合中
                    Admin admin = new Admin();
                    admin.setId(id);
                    admin.setName(name);
                    admin.setPass(pass);
                    //list.add(admin);
                }
                //遍历输出
                for (Admin admin:list) {
                    System.out.println(admin.getName());
                }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 关闭资源
     */
//    public static void main(String[] args) {
//            try {
//                //1. 加载驱动程序
//                Class.forName("com.mysql.jdbc.Driver");
//                //2. 获取连接
//                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_db",
//                        "root","123456");
//                //3. 获取到Statement对象，主要用于执行静态的SQL语句
//                //Statement statement = conn.createStatement();
//                //PreparedStatement预编译对象主要用于执行动态的SQL语句
//                PreparedStatement preparedStatement = conn.prepareStatement("select * from admin where name=? and pass=?");
//                preparedStatement.setString(1,"fender"); //将第1个？替换一个值
//                preparedStatement.setString(2,"123456");//将第2个？替换一个值
//                // ResultSet	executeQuery(String sql) 执行给定的SQL语句，该语句返回单个 ResultSet对象
//                // int	executeUpdate(String sql) 执行给定的SQL语句，这可能是 INSERT ， UPDATE ，或 DELETE语句
//                //4. 操作数据库
//                //int isRight = preparedStatement.executeUpdate();
//                //System.out.println(isRight);
//                //int isRight = statement.executeUpdate("delete from admin where id=4");
//                //ResultSet表示结果集合,主要用于保存查询的结果
//                ResultSet rs = preparedStatement.executeQuery();
//                List<Admin> list = new ArrayList<>();
//                while (rs.next()) {
//                    // 获取当前行数据
//                    int id = rs.getInt("id");
//                    String name = rs.getString("name");
//                    String pass = rs.getString("pass");
//                    //将当前行数据获取后封装到对象中再将对象添加到List集合中
//                    Admin admin = new Admin();
//                    admin.setId(id);
//                    admin.setName(name);
//                    admin.setPass(pass);
//                    list.add(admin);
//                }
//                //遍历输出
//                for (Admin admin:list) {
//                    System.out.println(admin.getName());
//                }
//                //System.out.println(isRight);
//                //5. 关闭资源
//                preparedStatement.close();
//                conn.close();
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//
//
//    }
}

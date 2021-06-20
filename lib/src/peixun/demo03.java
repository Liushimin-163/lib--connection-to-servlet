package peixun;

import demo01.jdbcdemo01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class demo03 {
    public static void main(String[] args) throws Exception{
        jdbcdemo01 jdbcdemo01 = new jdbcdemo01();
        jdbcdemo01.demo1();
    }
    public void demo1() throws Exception{
// 注意：使用JDBC规范，采用都是 java.sql包下的内容
//1 注册驱动
        Connection conn = demo02.getConnection();
//3获得执行sql语句的对象
        Statement stmt = conn.createStatement();
//4执行SQL语句
        ResultSet rs = stmt.executeQuery("select * from category");
//5处理结果集
        while(rs.next()){
// 获得一行数据
            Integer id = rs.getInt("id");
            String name = rs.getString("name");
            String price = rs.getString("price");
            System.out.println(id + " , " + name+" ，"+price);
        }
//6释放资源
     demo02.closeResource(conn,stmt,rs);
    }
}

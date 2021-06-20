package test;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;

public class jcbcDemo01 {
    public static void main(String[] args) throws Exception{
        jcbcDemo01 jcbcDemo01 = new jcbcDemo01();
        jcbcDemo01.demo1();

    }
    public void demo1() throws Exception{
// 注意：使用JDBC规范，采用都是 java.sql包下的内容
    Connection conn=jcbcUtils.getConnection();
        Statement stmt = conn.createStatement();
//4执行SQL语句
        ResultSet rs = stmt.executeQuery("select * from teacher");
//5处理结果集
        while(rs.next()){
// 获得一行数据
            Integer tid = rs.getInt("tid");
            String tname = rs.getString("tname");
            System.out.println(tid + " , " + tname);
        }
//6释放资源
        jcbcUtils.closeResource(conn,stmt,rs);
    }
}

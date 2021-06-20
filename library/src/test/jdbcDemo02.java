package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbcDemo02 {
    public static void main(String[] args) throws Exception{
        jdbcDemo02 jdbcDemo02 = new jdbcDemo02();
        jdbcDemo02.demo02();

    }
    public void demo02() throws Exception{
        Connection conn=jdbcUtils.getConn();
        //Connection conn1=jdbcUtils.getConnStu();
        //Statement st2=conn1.createStatement();
        Statement st=conn.createStatement();
        /*ResultSet rs=st.executeQuery("select sid from score where num < 60");*/

        ResultSet rs1=st.executeQuery("Select sname from student where sid in (select student_id from score  where num< 60 and course_id = 1) ");
        int r=st.executeUpdate("insert into course values (6,'化学',2)");
        System.out.println(r);
       /* while(rs.next()){
            Integer sid=rs.getInt("sid");
            System.out.println(sid);
        }*/
        while(rs1.next()){
            String name=rs1.getString(1);
            System.out.println(name);
        }


        jdbcUtils.closeR(conn,st,rs1);

    }

}

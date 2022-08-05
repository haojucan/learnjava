import java.sql.*;

import static java.sql.DriverManager.*;

public class JDBCTest {
    public static void main(String[] args) {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;

            //1.注册数据库的驱动
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            // 2. 通过DriverManger获取数据库连接
            String url = "jdbc:mysql://localhost:3306/jdbc";
            String username = "root";
            String password = "Axu19870318..";
            try {
                conn = getConnection(url, username, password);
                //3.通过Connection对象获取Statement对象
                stmt = conn.createStatement();
                //4.使用Statement执行SQL语句
                String sql = "select * from users";
                rs = stmt.executeQuery(sql);
                //5.操作ResultSet结果集
                System.out.println("id | name | password | email | birthday");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String pwd = rs.getString("password");
                    String email = rs.getString("email");
                    Date birthday = rs.getDate("birthday");
                    System.out.println(id + " | " + name + " | " + pwd + " | " + email + " |" + birthday);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //6.回收数据库资源
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();

                }
                stmt = null;
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                conn = null;
            }
        }
    }
}

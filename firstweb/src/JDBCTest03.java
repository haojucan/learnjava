import java.sql.*;

public class JDBCTest03 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://localhost:3306/jdbc";
            String username = "root";
            String password = "Axu19870318..";
            //1.获取Connection 对象
            conn = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM  users;";
            //2. 设置Statement对象并设置常量
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //3.执行SQL 并将获取的数据信息存放在ResultSet中
            ResultSet rs = stmt.executeQuery(sql);
            // 4.取出ResultSet 中指定数据信息
            System.out.println("第2条数据name值为：");
            rs.absolute(2);
            System.out.println(rs.getString("name"));
            System.out.println("第1条数据name值为：");
            rs.beforeFirst();
            rs.next();
            System.out.println(rs.getString("name"));
            System.out.println("第最后一条数据的name为：");
            // 将指针定位结果集中最后一和数据之后
            rs.afterLast();
            //  将指针向前滚动
            rs.previous();
            System.out.println(rs.getString("name"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                stmt = null;
            }
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                   e.printStackTrace();
                }
            }
        }
    }
}

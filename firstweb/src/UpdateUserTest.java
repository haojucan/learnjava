import com.jdbc.test.User;
import com.jdbc.test.dao.UsersDao;

import java.util.Date;

public class UpdateUserTest {
    public static void main(String[] args) {
        UsersDao usersDao = new UsersDao();
        //update user info
        User user = new User();
        user.setId(1);
        user.setUsername("axu");
        user.setPassword("35434");
        user.setEmail("axu@sina.com");
        user.setBirthday(new Date());
        boolean b = usersDao.update(user);
        System.out.println(b);
    }
}

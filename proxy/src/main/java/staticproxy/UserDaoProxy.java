package staticproxy;

public class UserDaoProxy implements IUserDao {
    private UserDao userDao;
    public UserDaoProxy(UserDao userDao){
        this.userDao = userDao;
    }
    public void save() {
        System.out.println("userDaoProxy:begin");
        userDao.save();
        System.out.println("userDaoProxy:end");
    }

    @Override
    public String select(Long id) {
        System.out.println("userDaoProxy:begin");
        String name =  userDao.select(id);
        System.out.println("userDaoProxy:end");
        return name;
    }
}

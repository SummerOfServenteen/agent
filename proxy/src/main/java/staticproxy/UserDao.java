package staticproxy;

public class UserDao implements IUserDao {
    private String name;
    private UserDao(){}

    private UserDao(String name){
        this.name = name;
    }
    public static UserDao createUserDao(){
        return new UserDao();
    }
    public void save() {
        System.out.println("save：奇怪的上单");
    }

    public String select(Long id){
        System.out.println("select id=" + id);
        return "霸哥" + code;
    }
}

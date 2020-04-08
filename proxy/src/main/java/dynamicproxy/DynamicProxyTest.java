package dynamicproxy;

import staticproxy.IUserDao;
import staticproxy.UserDao;

import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        UserDao userDao = UserDao.createUserDao();
        UserInvocationHandler userInvocationHandler = new UserInvocationHandler(userDao);
        IUserDao proxyDao = (IUserDao)Proxy.newProxyInstance(userDao.getClass().getClassLoader(),userDao.getClass().getInterfaces(),userInvocationHandler);
        //proxyDao.save();
        String name = proxyDao.select(1L);
        System.out.println(name);
    }
}

package dynamicproxy;

import staticproxy.IUserDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class UserInvocationHandler implements InvocationHandler {
    private Object proxied = null;

    public UserInvocationHandler(){
    }

    public UserInvocationHandler(Object proxied){
        this.proxied = proxied;
    }

    public Object getProxied() {
        return proxied;
    }

    public void setProxied(Object proxied) {
        this.proxied = proxied;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        Object result = null ;
        if("save".equals(methodName)){
            System.out.println("userInvocationHandler:begin");
            result = method.invoke(proxied,args);
            System.out.println("userInvocationHandler:end");
        }
        if("select".equals(methodName)){
            Arrays.stream(args).forEach(arg -> System.out.println("arg:" + arg.toString()));
            System.out.println("userInvocationHandler:begin");
            result = method.invoke(proxied,args);
            System.out.println("userInvocationHandler:end");
            IUserDao iUserDao = (IUserDao) proxied;
            System.out.println(iUserDao.code);
        }



        return result;
    }
}

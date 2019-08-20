import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class MyTransformer  implements ClassFileTransformer {
    private String targetClassName;
    private String targetMethodName;

    public MyTransformer(String targetClassName, String targetMethodName) {
        this.targetClassName = targetClassName;
        this.targetMethodName = targetMethodName;
    }

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        className = className.replace("/", ".");

        if (className.equals(targetClassName)) {
            try {
                // 得到类信息
                CtClass ctclass = ClassPool.getDefault().get(className);
                // 得到方法信息
                CtMethod ctmethod = ctclass.getDeclaredMethod(targetMethodName);
                // 修改方法实现
                ctmethod.insertAfter("System.out.println(\"hello Agent!\");");
                return ctclass.toBytecode();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

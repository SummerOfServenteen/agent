import java.lang.instrument.Instrumentation;

public class MyPremain {
    public static void premain(String agentOps, Instrumentation inst) {
        String[] args = agentOps.split("&");
        // 绑定ClassFileTransformer
        inst.addTransformer(new MyTransformer(args[0], args[1]));
    }
}

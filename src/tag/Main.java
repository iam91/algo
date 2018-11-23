package tag;


import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) {
        LinkedHashMap c = new LinkedHashMap();
        System.out.println(Test.b);
        // System.out.println(Test.a);
    }
}

class Test {
    public static final int a = 1;
    public static final int b = "test".length();
    static {
        System.out.println("Test loaded.");
    }
}
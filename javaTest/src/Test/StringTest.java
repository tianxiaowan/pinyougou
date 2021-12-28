package Test;

public class StringTest {
    public static void main(String[] args) {
        //String初始化的值会从常量池中获取
        String a1 = "123";
        String a2 = "123";
        System.out.println(a1==a2);//true

        String a3 = "12"+"3";
        System.out.println(a1==a3);//true

        String a4 = "12";
        String a5 = "3";
        String a6 = a4+a5;
        System.out.println(a1==a6);//false
        System.out.println(a1.equals(a6));//true


    }
}

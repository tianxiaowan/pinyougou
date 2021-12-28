package Test;

public class IntegerTest {
    public static void main(String[] args) {
        //Integer有缓存，创建时先去拿缓存 127~-128
        Integer a3 = 127;
        Integer a4 = 127;
        System.out.println(a3==a4);//true

        Integer a5 = 128;
        Integer a6 = 128;
        System.out.println(a5==a6);//false

        Integer a7 = -127;
        Integer a8 = -127;
        System.out.println(a7==a8);//true

        Integer a9 = -128;
        Integer a10 = -128;
        System.out.println(a9==a10);//true

        Integer a11 = -129;
        Integer a12 = -129;
        System.out.println(a11==a12);//false
        System.out.println(a11.equals(a12));//true
    }
}

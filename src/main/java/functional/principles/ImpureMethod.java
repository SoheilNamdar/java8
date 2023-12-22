package functional.principles;

public class ImpureMethod {
    int m = 5;
    // case 1
    public int sum(int a, int b) {
        return a + b + m;
    }

    // case 2
    public int impure(int a, int b) {
        m++;
        return a + b;
    }

    // case 3
    public void print(String s) {
        System.out.println(s);
    }
}

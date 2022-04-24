package leetcode.string;

public class RevertString {
    public void reverseString(char[] s) {
        int n = s.length;
        for (int i = 0; i < n/2; i++) {
            char buf = s[n - 1 - i];
            s[n - 1 - i] = s[i];
            s[i] = buf;
        }
        System.out.println(s);
    }

    public void run() {
        char[] s = "hello".toCharArray();
        reverseString(s);
        System.out.println(s);
    }

    public static void main(String[] args) {
        new RevertString().run();
    }
}

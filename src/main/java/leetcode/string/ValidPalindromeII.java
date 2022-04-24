package leetcode.string;

public class ValidPalindromeII {
    public boolean isPalindrom (String s) {
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i)!=s.charAt(s.length()-i-1)) {
                return false;
            }
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int n=s.length();
        for (int i = 0; i < n/2; i++) {
            if (s.charAt(i)!=s.charAt(n-1-i)) {
                return (isPalindrom(s.substring(i,n-i-1))||isPalindrom(s.substring(i+1,n-i)));
            }
        }
        return true;
    }
//
    public void run() {
        System.out.println("abrccba " + validPalindrome("abrcdeedcba"));

        System.out.println("ececabbacec " + validPalindrome("aaaabbbbcccc"));
        System.out.println("ececabbacec " + validPalindrome("aaaabbbbcccc"));
        System.out.println("ececabbacec " + validPalindrome("ebcbbececabbacecbbcbe"));
        System.out.println("abca " + validPalindrome("abca"));
        System.out.println("abrccba " + validPalindrome("abrccba"));
        System.out.println("aba " + validPalindrome("aba"));
        System.out.println("abcba " + validPalindrome("abcba"));
        System.out.println("eedede " + validPalindrome("eedede"));
        System.out.println("abccba " + validPalindrome("abccba"));
        System.out.println("deeee " + validPalindrome("deeee"));
        System.out.println("tebbem " + validPalindrome("tebbem"));
        System.out.println("abc " + validPalindrome("abc"));

    }

    public static void main(String[] args) {
        new ValidPalindromeII().run();
    }
}

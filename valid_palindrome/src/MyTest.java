import org.junit.Test;

public class MyTest {
    protected static final int SECOND = 1000;

    @Test(timeout=SECOND)
    public void example(){
        String p1 = "racecar";
        String p2 = "anna";
        String p3 = "gabbag";
        String p4 = "rack a kcar";
        String p5 = "abcdrdcba";
        String p6 = "a bcdrdcba";
        String p7 = "A man, a plan, a canal: Panama";
        String p8 = "!!!";
        String p9 = "";
        String p10 = "aaakkk";

        assert(Main.isPalindrome(p1) == true);
        assert(Main.isPalindrome(p2) == true);
        assert(Main.isPalindrome(p3) == true);
        assert(Main.isPalindrome(p4) == true);
        assert(Main.isPalindrome(p5) == true);
        assert(Main.isPalindrome(p6) == true);
        assert(Main.isPalindrome(p7) == true);
        assert(Main.isPalindrome(p8) == true);
        assert(Main.isPalindrome(p9) == true);
        assert(Main.isPalindrome(p10) == false);
    }
}

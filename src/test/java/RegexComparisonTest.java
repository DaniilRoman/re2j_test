import org.junit.jupiter.api.Test;
import utils.TestUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class RegexComparisonTest {

    @Test
    public void standardRegexWithEmailInTextWithoutBacktrackingIssueTest() {
        String email = "test@test.com";
        long start = System.currentTimeMillis();

        String inputText = TestUtils.getRandomLongWord(email);
        Matcher matcher = Pattern.compile(TestUtils.emailRegex).matcher(inputText);
        String actualValue = matcher.replaceAll("XXX@XXX.XX");

        System.out.println(System.currentTimeMillis() - start); // it's about 38 ms
        assertFalse(actualValue.contains(email));
    }


    @Test
    public void standardRegexWithoutEmailInTextWithBacktrackingIssueTest() {
        long start = System.currentTimeMillis();

        String inputText = TestUtils.getRandomLongWord("");
        Matcher matcher = Pattern.compile(TestUtils.emailRegex).matcher(inputText);
        matcher.replaceAll("XXX@XXX.XX");

        System.out.println(System.currentTimeMillis() - start); // it's about 8308 ms
    }

    @Test
    public void re2jRegexWithEmailInTextWithoutBacktrackingIssueTest() {
        String email = "test@test.com";
        long start = System.currentTimeMillis();

        String inputText = TestUtils.getRandomLongWord("test@test.com");
        com.google.re2j.Matcher matcher = com.google.re2j.Pattern.compile(TestUtils.emailRegex).matcher(inputText);
        String actualValue = matcher.replaceAll("XXX@XXX.XX");

        System.out.println(System.currentTimeMillis() - start); // it's about 55 ms
        assertFalse(actualValue.contains(email));
    }


    @Test
    public void re2jRegexWithoutEmailInTextWithoutBacktrackingIssueTest() {
        long start = System.currentTimeMillis();

        String inputText = TestUtils.getRandomLongWord("");
        com.google.re2j.Matcher matcher = com.google.re2j.Pattern.compile(TestUtils.emailRegex).matcher(inputText);
        matcher.replaceAll("XXX@XXX.XX");

        System.out.println(System.currentTimeMillis() - start); // it's about 72 ms
    }

}
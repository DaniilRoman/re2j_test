import org.junit.jupiter.api.Test;
import utils.TestUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class RegexComparisonTest {

    @Test
    public void standardRegexWithEmailTest() {
        String email = "test@test.com";
        long start = System.currentTimeMillis();

        String inputText = TestUtils.getRandomLongWord(email);
        Matcher matcher = Pattern.compile(TestUtils.emailRegex).matcher(inputText);
        String actualValue = matcher.replaceAll("XXX@XXX.XX");

        System.out.println(System.currentTimeMillis() - start);
        assertFalse(actualValue.contains(email));
    }


    @Test
    public void standardRegexWithoutEmailTest() {
        long start = System.currentTimeMillis();

        String inputText = TestUtils.getRandomLongWord("");
        Matcher matcher = Pattern.compile(TestUtils.emailRegex).matcher(inputText);
        matcher.replaceAll("XXX@XXX.XX");

        System.out.println(System.currentTimeMillis() - start);
    }

    @Test
    public void re2jWithEmailTest() {
        String email = "test@test.com";
        long start = System.currentTimeMillis();

        String inputText = TestUtils.getRandomLongWord("test@test.com");
        com.google.re2j.Matcher matcher = com.google.re2j.Pattern.compile(TestUtils.emailRegex).matcher(inputText);
        String actualValue = matcher.replaceAll("XXX@XXX.XX");

        System.out.println(System.currentTimeMillis() - start);
        assertFalse(actualValue.contains(email));
    }


    @Test
    public void re2jWithoutEmailTest() {
        long start = System.currentTimeMillis();

        String inputText = TestUtils.getRandomLongWord("");
        com.google.re2j.Matcher matcher = com.google.re2j.Pattern.compile(TestUtils.emailRegex).matcher(inputText);
        matcher.replaceAll("XXX@XXX.XX");

        System.out.println(System.currentTimeMillis() - start);
    }

}
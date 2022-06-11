import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import org.junit.jupiter.api.Test;
import utils.TestUtils;


public class PatternSizeTest {
    @Test
    public void standardPatternSizeTest() {
        java.util.regex.Pattern citiesRegex = java.util.regex.Pattern.compile(String.join("|", TestUtils.usCitiesAndTowns));

        System.out.println(ObjectSizeCalculator.getObjectSize(citiesRegex)); // it's about 197608 bytes
    }

    @Test
    public void re2jPatternSizeTest() {
        com.google.re2j.Pattern citiesRegex = com.google.re2j.Pattern.compile(String.join("|", TestUtils.usCitiesAndTowns));

        System.out.println(ObjectSizeCalculator.getObjectSize(citiesRegex)); // it's about 1026872 bytes
    }
}

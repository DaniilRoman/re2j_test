import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import org.junit.jupiter.api.Test;
import utils.TestUtils;

import java.util.regex.Pattern;

public class PatternSizeTest {
    @Test
    public void standardPatternSizeTest() {
        Pattern citiesRegex = Pattern.compile(String.join("|", TestUtils.usCitiesAndTowns));

        System.out.println(ObjectSizeCalculator.getObjectSize(citiesRegex));
    }

    @Test
    public void re2jPatternSizeTest() {
        com.google.re2j.Pattern citiesRegex = com.google.re2j.Pattern.compile(String.join("|", TestUtils.usCitiesAndTowns));

        System.out.println(ObjectSizeCalculator.getObjectSize(citiesRegex));
    }
}

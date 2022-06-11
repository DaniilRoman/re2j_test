package benchmark;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import utils.TestUtils;

import java.util.regex.Pattern;


public class RegexBenchmark {

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 5)
    public void standartRegexWithCityDataBenchmark(MyState myState, Blackhole blackhole) {
        myState.citiesRegex.matcher(myState.cityInputTextWords).replaceAll("XXX");
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 5)
    public static void re2JWithCityDataBenchmark(MyState myState, Blackhole blackhole) {
        myState.re2jCitiesRegex.matcher(myState.cityInputTextWords).replaceAll("XXX");
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 5)
    public void standartRegexWithEmailDataBenchmark(MyState myState, Blackhole blackhole) {
        myState.emailRegex.matcher(myState.emailInputTextWords).replaceAll("XXX");
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 5)
    public static void re2JWithEmailDataBenchmark(MyState myState, Blackhole blackhole) {
        myState.re2jEmailRegex.matcher(myState.emailInputTextWords).replaceAll("XXX");
    }

    @State(Scope.Benchmark)
    public static class MyState {
        private String injectedCity = "Richmond";
        private String injectedEmail = "text@text.com";

        public Pattern citiesRegex = Pattern.compile(String.join("|", TestUtils.usCitiesAndTowns));
        public com.google.re2j.Pattern re2jCitiesRegex = com.google.re2j.Pattern.compile(String.join("|", TestUtils.usCitiesAndTowns));

        public Pattern emailRegex = Pattern.compile(TestUtils.emailRegex);
        public com.google.re2j.Pattern re2jEmailRegex = com.google.re2j.Pattern.compile(TestUtils.emailRegex);

        public String cityInputTextWords = TestUtils.getRandomWords(injectedCity);
        public String emailInputTextWords = TestUtils.getRandomWords(injectedEmail);
    }

}

// Benchmark                                          Mode  Cnt  Score    Error  Units
//RegexBenchmark.standartRegexWithCityDataBenchmark   avgt    5  0.159 ±  0.017   s/op
//RegexBenchmark.re2JWithCityDataBenchmark            avgt    5  0.633 ±  0.016   s/op

//RegexBenchmark.standartRegexWithEmailDataBenchmark  avgt    5  0.019 ±  0.002   s/op
//RegexBenchmark.re2JWithEmailDataBenchmark           avgt    5  0.002 ±  0.001   s/op


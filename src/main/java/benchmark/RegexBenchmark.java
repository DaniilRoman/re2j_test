package benchmark;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import utils.TestUtils;


public class RegexBenchmark {

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 5)
    public void standartRegexWithCityDataBenchmark(MyState myState, Blackhole blackhole) {
        myState.standartCitiesRegex.matcher(myState.cityInputTextWords).replaceAll("XXX");
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
        myState.standartEmailRegex.matcher(myState.emailInputTextWords).replaceAll("XXX");
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

        public java.util.regex.Pattern standartCitiesRegex = java.util.regex.Pattern.compile(String.join("|", TestUtils.usCitiesAndTowns));
        public com.google.re2j.Pattern re2jCitiesRegex = com.google.re2j.Pattern.compile(String.join("|", TestUtils.usCitiesAndTowns));

        public java.util.regex.Pattern standartEmailRegex = java.util.regex.Pattern.compile(TestUtils.emailRegex);
        public com.google.re2j.Pattern re2jEmailRegex = com.google.re2j.Pattern.compile(TestUtils.emailRegex);

        public String cityInputTextWords = TestUtils.getRandomLongWord(injectedCity);
        public String emailInputTextWords = TestUtils.getRandomLongWord(injectedEmail);
    }

}

// Benchmark                                          Mode  Cnt  Score    Error  Units
//RegexBenchmark.standartRegexWithCityDataBenchmark   avgt    5  0.147 ±  0.018   s/op
//RegexBenchmark.re2JWithCityDataBenchmark            avgt    5  0.625 ±  0.040   s/op

//RegexBenchmark.standartRegexWithEmailDataBenchmark  avgt    5  0.004 ±  0.001   s/op
//RegexBenchmark.re2JWithEmailDataBenchmark           avgt    5  0.002 ±  0.001   s/op


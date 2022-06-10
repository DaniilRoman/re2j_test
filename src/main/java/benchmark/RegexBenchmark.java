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
    public void testCityStandartRegex(MyState myState, Blackhole blackhole) {
        myState.citiesRegex.matcher(myState.cityInputText).replaceAll("XXX");
    }


    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 5)
    public static void testCityRe2JReplace(MyState myState, Blackhole blackhole) {
        myState.re2jCitiesRegex.matcher(myState.cityInputText).replaceAll("XXX");
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 5)
    public void testEmailStandartRegex(MyState myState, Blackhole blackhole) {
        myState.emailRegex.matcher(myState.emailInputText).replaceAll("XXX");
    }


    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 5)
    public static void testEmailRe2JReplace(MyState myState, Blackhole blackhole) {
        myState.re2jEmailRegex.matcher(myState.emailInputText).replaceAll("XXX");
    }

    @State(Scope.Benchmark)
    public static class MyState {
        private String injectedCity = "Richmond";
        private String injectedEmail = "text@text.com";

        public Pattern citiesRegex = Pattern.compile(String.join("|", TestUtils.usCitiesAndTowns));
        public com.google.re2j.Pattern re2jCitiesRegex = com.google.re2j.Pattern.compile(String.join("|", TestUtils.usCitiesAndTowns));

        public Pattern emailRegex = Pattern.compile(TestUtils.emailRegex);
        public com.google.re2j.Pattern re2jEmailRegex = com.google.re2j.Pattern.compile(TestUtils.emailRegex);

        public String cityInputText = TestUtils.getRandomLongWord(injectedCity);
        public String emailInputText = TestUtils.getRandomLongWord(injectedEmail);


        public String cityInputTextWords = TestUtils.getRandomWords(injectedCity);
        public String emailInputTextWords = TestUtils.getRandomWords(injectedEmail);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 5)
    public void testCityStandartRegex2(MyState myState, Blackhole blackhole) {
        myState.citiesRegex.matcher(myState.cityInputTextWords).replaceAll("XXX");
    }


    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 5)
    public static void testCityRe2JReplace2(MyState myState, Blackhole blackhole) {
        myState.re2jCitiesRegex.matcher(myState.cityInputTextWords).replaceAll("XXX");
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 5)
    public void testEmailStandartRegex2(MyState myState, Blackhole blackhole) {
        myState.emailRegex.matcher(myState.emailInputTextWords).replaceAll("XXX");
    }


    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 5)
    public static void testEmailRe2JReplace2(MyState myState, Blackhole blackhole) {
        myState.re2jEmailRegex.matcher(myState.emailInputTextWords).replaceAll("XXX");
    }

}

// ========================    RESULTS   ===========================
//Benchmark                              Mode  Cnt  Score    Error  Units
//RegexBenchmark.testCityRe2JReplace     avgt    5  0.711 ±  0.207   s/op
//RegexBenchmark.testCityStandartRegex   avgt    5  0.166 ±  0.021   s/op
//RegexBenchmark.testEmailRe2JReplace    avgt    5  0.002 ±  0.001   s/op
//RegexBenchmark.testEmailStandartRegex  avgt    5  0.020 ±  0.002   s/op


//Benchmark                              Mode  Cnt  Score    Error  Units
//RegexBenchmark.testCityRe2JReplace     avgt    5  0.635 ±  0.070   s/op
//RegexBenchmark.testCityStandartRegex   avgt    5  0.157 ±  0.011   s/op
//RegexBenchmark.testEmailRe2JReplace    avgt    5  0.002 ±  0.001   s/op
//RegexBenchmark.testEmailStandartRegex  avgt    5  0.004 ±  0.001   s/op
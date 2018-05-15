package ru.geekbrains;

//20:05

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static String method1(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        if (i % 2 == 0) stringBuilder.append("Two");
        if (i % 7 == 0) stringBuilder.append("Seven");
        return stringBuilder.toString().equals("") ?
                stringBuilder
                        .delete(0, stringBuilder.length())
                        .append(i)
                        .toString() :
                stringBuilder.toString();
    }

    public static BigInteger method2(int m, int r) {
        //m! / (r! * (m - r)!)
        if (m < 0 || r < 0 || r > m) return BigInteger.valueOf(-1);
        if (m == r || r == 0) return BigInteger.valueOf(1);
        int k = m - r;
        return factorial(m)
                .divide(factorial(r)
                        .multiply(factorial(k)));
    }

    private static BigInteger factorial(int value) {
        BigInteger fact = BigInteger.valueOf(1);
        for (int i = 1; i <= value; i++)
            fact = fact.multiply(BigInteger.valueOf(i));
        return fact;
    }

    public static Map<String, Long> method3(String text) {
        Map<String, Long> map = Stream.of(text).
                map(s -> s.replaceAll("[,]|[.]", ""))
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        return map.entrySet().parallelStream()
                .sorted(Map.Entry.comparingByValue((o1, o2) -> o2.compareTo(o1)))
                .collect(Collectors
                        .toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}
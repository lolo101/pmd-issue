package org.example.unnecessaryImport;

import java.util.Map;
import java.util.Map.*;

import static java.util.stream.Collectors.toMap;

public class Main {
    public static void main(String[] args) {
        Map<String, String> map = Map.of("key1", "value1");
        var weirdCopy = map.entrySet().stream().collect(toMap(Entry::getKey, Entry::getValue));
        System.out.println(weirdCopy);
    }
}

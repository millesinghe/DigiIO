package com.digio.processor;

import com.digio.model.LogObj;

import java.util.*;
import java.util.stream.Collectors;

public class TopKProcessor extends AbstractLogProcessor<List<String>> {

    private int K;
    private String attribute;

    @Override
    public void setArgs(Object... args) {
        K = Integer.parseInt(String.valueOf(args[0]));
        attribute = String.valueOf(args[1]);
    }

    @Override
    public List<String> execute(List<LogObj> logs) {
        Map<String, Long> processed = logs.stream()
                .map(l -> l.getKey(attribute))
                .collect(Collectors.groupingBy(l -> l, TreeMap::new, Collectors.counting()));

//        Map<String, Long> result = processed.entrySet().stream()
//                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
//                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        List<Map.Entry<String, Long>> toSort = new ArrayList<>();
        for (Map.Entry<String, Long> stringLongEntry : processed.entrySet()) {
            toSort.add(stringLongEntry);
        }
        toSort.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        Map<String, Long> result = new LinkedHashMap<>();
        int itemcount = toSort.size();
        if (K < itemcount) {
            itemcount = K;
        }

        List<String> output = new ArrayList<>();
        for (int i= 0 ; i <itemcount ; i++)  {
            Map.Entry<String, Long> stringLongEntry = toSort.get(i);
            result.putIfAbsent(stringLongEntry.getKey(), stringLongEntry.getValue());
            output.add(stringLongEntry.getKey());
        }
        return output;
    }
}

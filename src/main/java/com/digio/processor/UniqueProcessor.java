package com.digio.processor;

import com.digio.model.LogObj;

import java.util.List;
import java.util.stream.Collectors;

public class UniqueProcessor extends AbstractLogProcessor<Integer>{
    private String attribute;

    @Override
    public void setArgs(Object... args) {
        attribute = String.valueOf(args[0]);
    }

    @Override
    public Integer execute(List<LogObj> logs) {
        return  logs.stream()
                .map(l -> l.getKey(attribute)).collect(Collectors.toSet()).size();
    }

}

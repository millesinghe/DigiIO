package com.digio.processor;

import com.digio.util.LogProcessorTypes;

public class LogProcessorFactory {

    public AbstractLogProcessor createProcessor(LogProcessorTypes type)
    {
        switch (type) {
            case TOPK:
                return new TopKProcessor();
            case UNIQUE:
                return new UniqueProcessor();
            default:
                throw new IllegalArgumentException("unsupported processor type "+type.name());
        }
    }
}

package com.digio.service;

import com.digio.model.LogObj;
import com.digio.processor.LogProcessorFactory;
import com.digio.processor.TopKProcessor;
import com.digio.processor.UniqueProcessor;
import com.digio.util.AttributesTypes;
import com.digio.util.LogProcessorTypes;

import java.util.List;

public class LogFunctionProvider{
    public static List<String> getTop3URLS(List<LogObj>  logs){
        LogProcessorFactory logProcessorFactory = new LogProcessorFactory();
        TopKProcessor topKURLProcessor = (TopKProcessor) logProcessorFactory.createProcessor(LogProcessorTypes.TOPK);
        topKURLProcessor.setArgs(3, AttributesTypes.URL);
        return topKURLProcessor.execute(logs);
    }

    public  static List<String> getTop3IP(List<LogObj>  logs){
        LogProcessorFactory logProcessorFactory = new LogProcessorFactory();
        TopKProcessor topKIPProcessor = (TopKProcessor) logProcessorFactory.createProcessor(LogProcessorTypes.TOPK);
        topKIPProcessor.setArgs(3, AttributesTypes.IP);
        return topKIPProcessor.execute(logs);
    }

    public  static Integer getUniqueIP(List<LogObj>  logs){
        LogProcessorFactory logProcessorFactory = new LogProcessorFactory();
        UniqueProcessor uniqueProcessor = (UniqueProcessor) logProcessorFactory.createProcessor(LogProcessorTypes.UNIQUE);
        uniqueProcessor.setArgs(AttributesTypes.IP);
        return uniqueProcessor.execute(logs);
    }
}

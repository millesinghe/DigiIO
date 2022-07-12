package com.digio;

import com.digio.model.LogObj;
import com.digio.processor.LogProcessorFactory;
import com.digio.processor.TopKProcessor;
import com.digio.processor.UniqueProcessor;
import com.digio.service.LogFunctionProvider;
import com.digio.service.LogReader;
import com.digio.util.AttributesTypes;
import com.digio.util.LogProcessorTypes;

import java.net.URISyntaxException;
import java.util.List;

public class Executor {

    public static void main(String[] args) throws URISyntaxException {
//       String l = "177.71.128.21 - admin [10/Jul/2018:22:21:28 +0200] \"GET /intranet-analytics/ HTTP/1.1\" 200 3574 \"-\" \"Mozilla/5.0 (X11; U; Linux x86_64; fr-FR) AppleWebKit/534.7 (KHTML, like Gecko) Epiphany/2.30.6 Safari/534.7\"";
//        testExtraction(l);
        LogReader logReader =new LogReader();
        logReader.initLogProcessor();
        List<LogObj>  logs = logReader.getLogsLines();

        List<String> top3URLS = LogFunctionProvider.getTop3URLS(logs);
        System.out.println(top3URLS);

        List<String> top3IP = LogFunctionProvider.getTop3IP(logs);
        System.out.println(top3IP);

        Integer uniqueIP = LogFunctionProvider.getUniqueIP(logs);
        System.out.println(uniqueIP);

    }


    private static void testExtraction(String l){
        String [] split = l.split("- ([^\\s]+)");
        String strIP = split[0].trim();
        String strMethod = split[1].split(" \"")[1].split(" ")[0];
        String strUrl = split[1].split(" \"")[1].split(" ")[1].split(" ")[0];
        String user = split[1].split(" \"")[3];

        String dateTime = l.split("\\[")[1].split("\\]")[0];
        Integer response = 0;
        String fullContent = null;
    }
}

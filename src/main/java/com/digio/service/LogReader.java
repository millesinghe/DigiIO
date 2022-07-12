package com.digio.service;

import com.digio.model.LogObj;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogReader {

    private List<LogObj> logsLines;

    private boolean isValidLine(String line){
      if(line==null||line.isEmpty())
//              || line.split(" ").length!= 9)
                return false;
      return true;
    }

    public void initLogProcessor() {
        PropertyLoader propertyLoader = new PropertyLoader();
        propertyLoader.loadProps();
        String logFileName = propertyLoader.getLogFileName();
        try (Stream<String> stream = Files.lines(Paths.get(logFileName))) {
            logsLines =  stream.filter(this::isValidLine).map(l ->
            {
                String [] split = l.split("- ([^\\s]+)");
                String strIP = split[0].trim();
                String strMethod = split[1].split(" \"")[1].split(" ")[0];
                String strUrl = split[1].split(" \"")[1].split(" ")[1].split(" ")[0];
//                String user = split[1].split(" \"")[3];
//                String dateTime = l.split("\\[")[1].split("\\]")[0];
                Integer response = 0;
                String fullContent = null;
               return new LogObj(strIP, strMethod,strUrl,null,null,
                       response, l);
            }).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace(); //TODO
        }
    }

    public List<LogObj> getLogsLines() {
        return logsLines;
    }
}

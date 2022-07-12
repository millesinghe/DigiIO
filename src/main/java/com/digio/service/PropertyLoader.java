package com.digio.service;

import com.digio.Executor;

import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

    private final Properties prop = new Properties();

    public void loadProps(){
        try {
            prop.load(Executor.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getLogFileName(){
        return prop.getProperty("log.file.name");
    }
}

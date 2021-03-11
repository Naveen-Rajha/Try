package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) throws IOException {
        Logger log = Logger.getLogger(Main.class.getName());
        LogManager.getLogManager().readConfiguration(new FileInputStream("G:\\java\\logging.properties"));
        log.log(Level.INFO,"Hello");
        log.warning("This is a warning msg");

    }
}
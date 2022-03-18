package runnabletry;

import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * OneThread
 */
public class OneThread {

    static Logger log = Logger.getLogger(OneThread.class.getName());
    static Handler h = new ConsoleHandler();
    static Formatter f = new Formatter() {
        @Override
        public String format(LogRecord record) {
            return String.format(" %s : %s : %s %s",
                    Thread.currentThread().getName(), record.getMessage(),
                    new Date(record.getMillis()), System.lineSeparator());
        }
    };

    public static void main(String[] args) {
        log.setUseParentHandlers(false);
        h.setFormatter(f);
        log.addHandler(h);
        log.info("When a java program starts execution a main thread is spawned.");
        log.info("This program is currently executed by main thread");

        // a class which implements Runnable interface
        OneTask task = new OneTask(log);
        log.info("spawining OneTask in current thread ");
        task.run();
    }
}
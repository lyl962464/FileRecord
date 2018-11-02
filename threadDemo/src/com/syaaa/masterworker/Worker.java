package com.syaaa.masterworker;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author syaaa
 * @version 1.0
 * @date 17:29   2018/11/2
 **/
public class Worker implements Runnable {
    private HashMap<String, Thread> workers;
    private ConcurrentHashMap<String, Object> resultMap;

    public void setWorkQueue(HashMap<String, Thread> workers) {
        this.workers = workers;
    }

    public void setResultMap(ConcurrentHashMap<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

    @Override
    public void run() {

    }


}

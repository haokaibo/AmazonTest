package com.google;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
This problem is raised by Rodd Snook from Google.

Get the average execution time for each method from the log below:

CreateFoo start 1500000000100
CreateFoo end 1500000000201
UpdateBar start 1500000001100
CreateFoo start 1500000001101
UpdateBar end 1500000001222
ListAll start 1500000001572
ListAll end 1500000003629
CreateFoo end 1500000007629
…

 */

public class MethodAverageTime {

    class Times {
        long sumTime;
        int N;
        HashMap<String, Long> time = new HashMap<>();

        void put(String action, Long value) {
            time.put(action, value);
            if (action.equals("end")) {
                sumTime = value - time.get("start");
            }
            N++;
        }
    }

    HashMap<String, Times> methods = new HashMap<>();

    void readLog(String log) {
        String[] fields = log.split(" ");
        Times times;
        if (!methods.containsKey(fields[0])) {
            times = new Times();
            methods.put(fields[0], times);
        }
        times = methods.get(fields[0]);
        times.put(fields[1], Long.valueOf(fields[2]));
    }

    void getAverage() {
        Iterator<Map.Entry<String, Times>> iterator = methods.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Times> times = iterator.next();
            System.out.printf("%s: %f logCount: %d\n", times.getKey(),
                    times.getValue().sumTime * 1.0 / (2 * times.getValue().N),
                    times.getValue().N / 2);
        }
    }

    public static void main(String[] args) {
        String[] logs = new String[]{
                "CreateFoo start 1500000000100",
                "CreateFoo end 1500000000201",
                "UpdateBar start 1500000001100",
                "CreateFoo start 1500000001101",
                "UpdateBar end 1500000001222",
                "ListAll start 1500000001572",
                "ListAll end 1500000003629",
                "CreateFoo end 1500000007629"
        };

        MethodAverageTime methodAverageTime = new MethodAverageTime();
        for (String log : logs) {
            methodAverageTime.readLog(log);
        }
        methodAverageTime.getAverage();
    }

}

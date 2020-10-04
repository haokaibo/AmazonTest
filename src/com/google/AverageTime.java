package com.google;

/*
* given the text below calculate the time spent in average.
*
* CreateFoo start 1,500,000,000,100
CreateFoo end 1500000000201
UpdateBar start 1500000001100
CreateFoo start 1500000001101
UpdateBar end 1500000001222
ListAll start 1500000001572
ListAll end 1500000003629
CreateFoo end 1500000007629

* */

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AverageTime {
    static class Time {
        private final String flag;
        private final Long time;
        Long N = 0L;
        Long sum = 0L;

        Time(String flag, Long time) {
            this.flag = flag;
            this.time = time;
            put(flag, time);
        }

        public void put(String flag, Long time) {
            if (flag.equals("start"))
                sum -= time;
            else if (flag.equals("end")) {
                sum += time;
            }
            N++;
        }

        public long getAvg() {
            if (N > 0)
                return sum / (N / 2);
            else
                return 0;
        }
    }

    private final Map<String, Time> methods_sum_time = new TreeMap<String, Time>();

    public static void main(String[] args) {
        AverageTime averageTime = new AverageTime();
        //read the lines of from the log
        String[] logs = {
                "CreateFoo end 1500000000201",
                "UpdateBar start 1500000001100",
                "CreateFoo start 1500000001101",
                "UpdateBar end 1500000001222",
                "ListAll start 1500000001572",
                "ListAll end 1500000003629",
                "CreateFoo end 1500000007629",
        };
        for (int i = 0; i < logs.length; i++) {
            String[] fields = logs[i].split(" ");
            if (averageTime.methods_sum_time.containsKey(fields[0])) {
                Time time = averageTime.methods_sum_time.get(fields[0]);
                time.put(fields[1], Long.parseLong(fields[2]));
            } else {
                Time time = new Time(fields[1], Long.parseLong(fields[2]));
                averageTime.methods_sum_time.put(fields[0], time);
            }
        }

        for (Map.Entry<String, Time> time : averageTime.methods_sum_time.entrySet()) {
            System.out.printf("%s: %d\n", time.getKey(), time.getValue().getAvg());
        }


    }
}

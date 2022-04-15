package com.example.demo.thread.firstPart.classOne;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class Singleton {
    static Singleton instance;
    static Singleton getInstance(){
        if (instance==null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }


    public static void main(String[] args) {
        int watchDuration = 5056;
        int watchCount = 55;
        BigDecimal b2 = new BigDecimal(watchCount);
        double d1 = (double) watchDuration/watchCount;
        System.out.println(d1);

        BigDecimal b3 = new BigDecimal(watchDuration);
        int watchDurationI = b3.setScale(0, BigDecimal.ROUND_HALF_EVEN).intValue();
        System.out.println(watchDurationI);
        // 人均观看时长（分钟）
        BigDecimal avgLiveWatch = b3.divide(b2, 0, BigDecimal.ROUND_HALF_EVEN);
        int avgLiveWatchIntValue = avgLiveWatch.intValue();
        System.out.println(avgLiveWatchIntValue);
        // 完整观看百分比 人均观看时长/课程时长
        BigDecimal b4 = avgLiveWatch.divide(new BigDecimal(130L), 4, BigDecimal.ROUND_HALF_EVEN);
        System.out.println(b4.toString());









    }

}

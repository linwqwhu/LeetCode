package com.linwqwhu;

/**
 * 2651. 计算列车到站时间
 */
public class Test2651 {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }
}

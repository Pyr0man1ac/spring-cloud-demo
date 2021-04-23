package org.pyro.core.util;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ZYC MoronSlayer@outlook.com
 * @version 1.0
 * @date 2021/4/23 20:56
 */
@Slf4j
public class ThreadUtil {
    
    private ThreadUtil() {}
    
    public static void wakeAfterMillis(int milliseconds) {
        if (milliseconds <= 0) {
            throw new IllegalArgumentException("Millisecond must be POSITIVE!");
        }
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("After {} milliseconds, it's AWAKE!", milliseconds);
    }
    
}

package InterviewPractice.Design;

import java.util.HashMap;

public class LoggerRateLimiter {
    private HashMap<String, Integer> mapLogRateLimiter;

    public LoggerRateLimiter() {
        mapLogRateLimiter = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {

        if (!mapLogRateLimiter.containsKey(message)) {
            mapLogRateLimiter.put(message, timestamp);
            return true;
        }

        Integer oldTimestamp = mapLogRateLimiter.get(message);
        if (timestamp - oldTimestamp >= 10) {
            mapLogRateLimiter.put(message, timestamp);
            return true;
        } else
            return false;
    }

}

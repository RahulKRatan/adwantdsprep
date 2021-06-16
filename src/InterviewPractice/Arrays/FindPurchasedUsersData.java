package InterviewPractice.Arrays;

import java.util.*;

/** Wayfair Karat
 * Write a function to parse this data, determine how many times each ad was clicked, then return the ad text, that ad's number of clicks, and how many of those ad clicks were from users who made a purchase.
 */
public class FindPurchasedUsersData {

    public static List<String> findPurchasedUsersData(String[] completedPurchaseUsers, String[] adClicks,
                                                      String[] allUserIps) {
        List<String> result = new ArrayList<>();
        Map<String, List<String>> adTextMap = new HashMap<>();
        Map<String, String> ipUserMap = new HashMap<>();
        Set<String> usersWhoMadePurchases = new HashSet<>(Arrays.asList(completedPurchaseUsers));

        for (String ip : allUserIps) {
            String[] splits = ip.split(",");
            ipUserMap.put(splits[1], splits[0]);
        }

        for (String adClick : adClicks) {
            String[] splits = adClick.split(",");
            String iPAddress = splits[0];
            String userID = ipUserMap.getOrDefault(iPAddress, "");
            String adText = splits[2];
            List<String> inner = adTextMap.getOrDefault(adText, new ArrayList<>());
            inner.add(userID);
            adTextMap.put(adText, inner);
        }

        for (String key : adTextMap.keySet()) {
            int totalClicks = adTextMap.get(key).size();
            List<String> usersWhoClicked = adTextMap.get(key);
            int purchasedCount = getPurchasedCount(usersWhoClicked, usersWhoMadePurchases);
            String outputString = purchasedCount + " of " + totalClicks + "	 " + key;
            result.add(outputString);
        }

        return result;

    }

    public static int getPurchasedCount(List<String> usersWhoClicked, Set<String> usersWhoMadePurchases) {
        int count = 0;
        for (String user : usersWhoClicked) {
            if (usersWhoMadePurchases.contains(user)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] argv) {
        String[] completedPurchaseUsers = { "3123122444", "234111110", "8321125440", "99911063" };

        // "IP Address, timestamp, Ad text"
        String[] adClicks = { "122.121.0.1,2016-11-03 11:41:19,Buy wool coats for your pets",
                "96.3.199.11,2016-10-15 20:18:31,2017 Pet Mittens",
                "122.121.0.250,2016-11-01 06:13:13,The Best Hollywood Coats",
                "82.1.106.8,2016-11-12 23:05:14,Buy wool coats for your pets",
                "92.130.6.144,2017-01-01 03:18:55,Buy wool coats for your pets",
                "122.121.0.155,2017-01-01 03:18:55,Buy wool coats for your pets",
                "92.130.6.145,2017-01-01 03:18:55,2017 Pet Mittens" };

        // "User ID, IP address"
        String[] allUserIps = { "2339985511,122.121.0.155", "234111110,122.121.0.1", "3123122444,92.130.6.145",
                "39471289472,2001:0db8:ac10:fe01:0000:0000:0000:0000", "8321125440,82.1.106.8",
                "99911063,92.130.6.144" };

        System.out.println(findPurchasedUsersData(completedPurchaseUsers, adClicks, allUserIps));

    }
}

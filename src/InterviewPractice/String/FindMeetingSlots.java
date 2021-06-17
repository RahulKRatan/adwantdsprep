package InterviewPractice.String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * We are writing a tool to help users manage their calendars. Given an unordered list of times of day when people are busy, write a function that tells us the intervals during the day when ALL of them are available.
 *
 * Each time is expressed as an integer using 24-hour notation, such as 1200 (12:00), 1530 (15:30), or 800 (8:00).
 */
public class FindMeetingSlots {
        private List<int[]> findMeeting(List<int[][]> slots) {
            List<int[]> combinedList = new ArrayList<>();

            for (int[][] participant : slots) {
                for (int[] pa : participant) {
                    combinedList.add(pa);
                }
            }
            //sort the list on the basis of start time
            Collections.sort(combinedList, (a, b) -> a[0] > b[0] ? 1 : -1);


            //create a list to store the output
            List<int[]> result = new ArrayList<>();

            int  min = combinedList.get(0)[0];
            int max = combinedList.get(0)[1];
            //if low is greater than 0
            if( min > 0){
                int[] te = {0, min};
                result.add(te);
            }
            for(int i  =0; i< combinedList.size(); i++){
                if(max < combinedList.get(i)[0]){
                    int[] te = {max, combinedList.get(i)[0]};
                    result.add(te);
                    max =  combinedList.get(i)[1];
                }else {
                    max = Math.max(max, combinedList.get(i)[1]);
                }
            }
            //if high is less than max
            if (max < 2400) {
                int[] ne = { max, 2400 };
                result.add(ne);
            }
            return result;
        }

        public static void main(String[] args) {
            FindMeetingSlots slo = new FindMeetingSlots();

            int[][] p1Meetings = { { 1230, 1300 }, { 845, 900 }, { 1300, 1500 } };
            int[][] p2Meetings = { { 0, 844 }, { 930, 1200 }, { 1515, 1546 }, { 1600, 2400 } };
            int[][] p3Meetings = { { 845, 915 }, { 1515, 1545 }, { 1235, 1245 } };

            int[][] p4Meetings = { { 1, 5 }, { 844, 900 }, { 1515, 1600 } };
            System.out.println("Participants 1");
            List<int[][]> participants = new ArrayList<int[][]>();
            participants.add(p1Meetings);
            participants.add(p2Meetings);
            participants.add(p3Meetings);
            List<int[]> result  = slo.findMeeting(participants);
            for(int[] r : result){
                System.out.println("[ " + r[0]+ "," + r[1]+" ]");
            }

            System.out.println("Participants 2");
            List<int[][]> participants2 = new ArrayList<int[][]>();
            participants2.add(p1Meetings);
            // participants.add(p2Meetings);
            participants2.add(p3Meetings);
            result =  slo.findMeeting(participants2);
            for (int[] r : result) {
                System.out.println("[ " + r[0] + "," + r[1] + " ]");
            }
            System.out.println("Participants 3");
            List<int[][]> participants3 = new ArrayList<int[][]>();
            // participants.add(p1Meetings);
            participants3.add(p2Meetings);
            participants3.add(p4Meetings);
            result = slo.findMeeting(participants3);
            for (int[] r : result) {
                System.out.println("[ " + r[0] + "," + r[1] + " ]");
            }

        }

}

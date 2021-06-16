package InterviewPractice.Graphs;

import java.util.*;

/** Wayfair Karat
 * 
 * You're developing a system for scheduling advising meetings with students in a Computer Science program. Each meeting should be scheduled when a student has completed 50% of their academic program.
 *
 * Each course at our university has at most one prerequisite that must be taken first. No two courses share a prerequisite. There is only one path through the program.
 *
 * Write a function that takes a list of (prerequisite, course) pairs, and returns the name of the course that the student will be taking when they are halfway through their program. (If a track has an even number of courses, and therefore has two "middle" courses, you should return the first one.)
 *
 * Sample input 1: (arbitrarily ordered)
 * prereqs_courses1 = [
 * 	["Foundations of Computer Science", "Operating Systems"],
 * 	["Data Structures", "Algorithms"],
 * 	["Computer Networks", "Computer Architecture"],
 * 	["Algorithms", "Foundations of Computer Science"],
 * 	["Computer Architecture", "Data Structures"],
 * 	["Software Design", "Computer Networks"]
 * ]
 *
 * In this case, the order of the courses in the program is:
 * 	Software Design
 * 	Computer Networks
 * 	Computer Architecture
 * 	Data Structures
 * 	Algorithms
 * 	Foundations of Computer Science
 * 	Operating Systems
 *
 * Sample output 1:
 * 	"Data Structures"
 *
 *
 * Sample input 2:
 * prereqs_courses2 = [
 * 	["Data Structures", "Algorithms"],
 * 	["Algorithms", "Foundations of Computer Science"],
 * 	["Foundations of Computer Science", "Logic"]
 * ]
 *
 *
 * Sample output 2:
 * 	"Algorithms"
 *
 * Sample input 3:
 * prereqs_courses3 = [
 * 	["Data Structures", "Algorithms"],
 * ]
 *
 *
 * Sample output 3:
 * 	"Data Structures"
 *
 * Complexity analysis variables:
 *
 * n: number of pairs in the input
 *
 *
 * """
 *
 * prereqs_courses1 = [
 *     ["Foundations of Computer Science", "Operating Systems"],
 *     ["Data Structures", "Algorithms"],
 *     ["Computer Networks", "Computer Architecture"],
 *     ["Algorithms", "Foundations of Computer Science"],
 *     ["Computer Architecture", "Data Structures"],
 *     ["Software Design", "Computer Networks"]
 * ]
 *
 * prereqs_courses2 = [
 *     ["Data Structures", "Algorithms"],
 *     ["Algorithms", "Foundations of Computer Science"],
 *     ["Foundations of Computer Science", "Logic"]
 *  ]
 *
 * prereqs_courses3 = [
 *     ["Data Structures", "Algorithms"]
 * ]
 */
public class PrereqCourseMeeting {

    public static void course(String[][] prereq) {
        Map<String, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for(String[] course: prereq) {
            set.add(course[1]);
            map.put(course[0], course[1]);
        }
        String course = "";
        int count = 0;
        for(String key: map.keySet()) {
            if(!set.contains(key)) {
                course = key;
                break;
            }
        }

        while(count<(set.size()/2)) {
            course = map.get(course);
            count++;
        }

        System.out.println(course);
    }

    public static void main(String[] args) {
        String[][] prereqs_courses1= new String[][] {
                {"Foundations of Computer Science", "Operating Systems"},
                {"Data Structures", "Algorithms"},
                {"Computer Networks", "Computer Architecture"},
                {"Algorithms", "Foundations of Computer Science"},
                {"Computer Architecture", "Data Structures"},
                {"Software Design", "Computer Networks"}
        };
        String[][] prereqs_courses2 = {
                {"Data Structures", "Algorithms"},
                {"Algorithms", "Foundations of Computer Science"},
                {"Foundations of Computer Science", "Logic"}
        };

        String[][] prereqs_courses3 = {
                {"Data Structures", "Algorithms"},
        };
        course(prereqs_courses1);
        course(prereqs_courses2);
        course(prereqs_courses3);
    }
}

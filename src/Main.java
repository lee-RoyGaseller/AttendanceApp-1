import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n\nHello, AttendanceApp!\n");

        // Customized welcome message
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Welcome, " + name + "!");

        // Create and output list of absences
        ArrayList<Integer> absences = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < name.length() ; i++) {
            absences.add(rand.nextInt(11));
        }
        System.out.println("The elements are " + absences);

        // Number of students with perfect attendance
        int countPerfect = 0;
        for (int i = 0; i < absences.size() ; i++) {
            if (absences.get(i)== 0) {
                countPerfect++;
            }
        }
        System.out.println(countPerfect + " student(s) had perfect attendance.");

        // Calculate average of absences
        double avg = average(absences);
        System.out.println("the average number of absences is " + avg);

        // percent of students who had less than three absences with perfect attendance
        double percentOfPerfectLessThanThree = percentOf(perfectAttendance(absences), fewerThanBlankAbsences(absences,3));
        int fewerThanThreeAbsences = fewerThanBlankAbsences(absences,3);
        int perfectAttendance = perfectAttendance(absences);
        System.out.println("fewerThanThree = "+ fewerThanThreeAbsences);
        System.out.println("the percent of students who had less than three absences with perfect attendance is " + percentOfPerfectLessThanThree + "%");


    }

    private static double percentOf(int part, int total){
        double percentage = 0;
        percentage =((double)part*100)/(double)total;
        return percentage;
    }

    private static double average(ArrayList<Integer> absences) {
        return (double)sum(absences)/absences.size();
    }

    private static int sum(ArrayList<Integer> absences) {
        int sum = 0;
        for (int i = 0; i <absences.size() ; i++) {
            sum +=absences.get(i);
        }
        return sum;
    }

    private static int perfectAttendance(ArrayList<Integer> absences){
        int countPerfect = 0;
        for (int i = 0; i < absences.size() ; i++) {
            if (absences.get(i)== 0) {
                countPerfect++;
            }
        }
        return countPerfect;
    }

    private static int fewerThanBlankAbsences(ArrayList<Integer> absences, int numOfAbsences) {
        int fewerThan = 0;
        for (int i = 0; i < absences.size() ; i++) {
            if (absences.get(i) < numOfAbsences){
                fewerThan++;
            }

        }
        return fewerThan;
    }

}
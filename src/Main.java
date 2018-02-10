import java.util.*;

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
        System.out.printf("the average number of absences is %.2f%%\n", avg);

        // percent of students who had less than three absences with perfect attendance
        double percentOfPerfectLessThanThree = percentOf(perfectAttendance(absences), fewerThanBlankAbsences(absences,3));
        int fewerThanThreeAbsences = fewerThanBlankAbsences(absences,3);
        int perfectAttendance = perfectAttendance(absences);
        System.out.println("fewerThanThree = "+ fewerThanThreeAbsences);
        System.out.println("the percent of students who had less than three absences with perfect attendance is " + percentOfPerfectLessThanThree + "%");

        // Which students had [X] absences?
        System.out.print("what specified absence do you want?: ");
        int specifiedAbsences = sc.nextInt();
        ArrayList<Integer> studentsWhoMissed =numOfSpecifiedAbsences(specifiedAbsences, absences);
        System.out.println("the students who had " + specifiedAbsences +" absences were: " + studentsWhoMissed);

        // Which and what percentage of the students have FE'd the course?
        System.out.print("how many times does your class meet per week?: ");
        int numOfMeetsPerWeek =sc.nextInt();
        int missedTwoMoreThanTheNumOfMeetsPerWeek =0;

        for (int i = 0; i <absences.size() ; i++) {
            if(absences.get(i) >= numOfMeetsPerWeek+2){
                missedTwoMoreThanTheNumOfMeetsPerWeek++;
            }

        }
        double percentOfFedStudents = percentOf(missedTwoMoreThanTheNumOfMeetsPerWeek,absences.size());
        System.out.printf("the percent of fe'd students is %.2f%%\n", percentOfFedStudents);

        //Add [X] to any absences greater than [Y].
        System.out.println("The absences are "+ absences);
        addNumToelementGreaterThan(absences,2,3);
        System.out.println("The modified absences are "+ absences +"\n");

        //Sort the absences using a library function.
        System.out.println("The unsorted absences are "+ absences);
        Collections.sort(absences);
        System.out.println("The sorted absences are "+ absences);

        //Shuffle the absences using a library function.
        System.out.println("The unshuffled absences are "+ absences);
        Collections.shuffle(absences);
        System.out.println("The shuffled absences are "+ absences);

        //How many absences are unique?
        int uniqueAbsences = uniqueAbsences(absences);
        System.out.println("The number of unique absences are " + uniqueAbsences);

        //How many of each absence value are there?
        Map<Integer, Integer>eachAbsenceMap = new HashMap<>();
        for (int key: absences) {
            if (!eachAbsenceMap.containsKey(key)) {
                eachAbsenceMap.put(key, 1);
            } else {
                int value = eachAbsenceMap.get(key) +1;
                eachAbsenceMap.put(key, value);
            }
        }
        System.out.println("Each absence map: "+ eachAbsenceMap);



        System.out.println();
        //Sort the absences using a user-defined sort function.
        Sort(absences);
        System.out.println("the sorted absences using my own sort function " + absences);


        //Shuffle the absences using a user-defined shuffle() function.
        shuffle(absences);
        System.out.println("the shuffled absences using my own shuffle function");



        //Create and output an ArrayList of 5 distinct names.
        ArrayList<String> names = new ArrayList<>();
        names.add("Lee-Roy");
        names.add("Jacob");
        names.add("Chris");
        names.add("Bobby");
        names.add("Brown");
        System.out.println(names);





















    }

    private static void howManyOfEach(ArrayList<Integer> absences) {
        for (int i = 0; i < absences.size() ; i++) {
            System.out.printf("%2d " ,absences.get(i));
            for (int j = 0; j <absences.size() ; j++) {
                if (absences.get(j) == absences.get(i)){
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    private static int uniqueAbsences(ArrayList<Integer> absences) {
        Set<Integer> uniques = new HashSet<>();
        for (int i = 0; i <absences.size() ; i++) {
            uniques.add(absences.get(i));


        }
        return uniques.size();
    }

    public static void shuffle( ArrayList<Integer> absences){
        Random rand = new Random();
        for (int i = 0; i < absences.size() ; i++) {
            int randInt = rand.nextInt(absences.size());
            int temp = absences.get(randInt);
            absences.set(randInt, absences.get(i));
            absences.set(i, temp);

        }
    }

    private static void Sort(ArrayList<Integer> absences){
        for (int i = 0; i <absences.size() ; i++) {
            for (int j = 0; j <absences.size() ; j++) {
                if(absences.get(i) < absences.get(j)){
                    int temp = absences.get(i);
                    absences.set(i,absences.get(j));
                    absences.set(j,temp);
                }

            }

        }
    }


    private static void addNumToelementGreaterThan(ArrayList<Integer> absences, int addAmount, int greaterThan){
        for (int i = 0; i < absences.size(); i++) {
            if(absences.get(i) > greaterThan){
                absences.set(i,absences.get(i)+addAmount);
            }

        }
    }


    private static ArrayList<Integer> numOfSpecifiedAbsences(int specifiedAbsenceNum, ArrayList<Integer> absences){
        ArrayList<Integer> studentsWhoMissed = new ArrayList<>();
        for (int i = 0; i < absences.size(); i++) {
            if (absences.get(i) == specifiedAbsenceNum) {
                studentsWhoMissed.add(i+1);
            }
        }
        return studentsWhoMissed;
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
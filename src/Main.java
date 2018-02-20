import java.time.LocalDate;
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
        addNumToElementGreaterThan(absences,2,3);
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


        //Shuffle the absences using a user-defined shuffle() function
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

        //Shuffle the names using a user-defined shuffle function.
        shuffleString(names);
        System.out.println("Shuffled names: " + names);

        //Using the 5 names, create another list that has the same size as the absences list.
        ArrayList<String> anotherListOfNames = new ArrayList<>();
        Random randNum = new Random();
        for (int i = 0; i <absences.size() ; i++) {
            int randName = randNum.nextInt(5);
            anotherListOfNames.add(names.get(randName));
        }
        System.out.println("new list: " + anotherListOfNames);

        //Were all 5 names used at least once?
        wereAllNamesUsed(names,anotherListOfNames);
        
        //What are the names of the students with perfect attendance?
        System.out.println("absences: " +absences);
        System.out.println("names: " + anotherListOfNames);
        for (int i = 0; i < absences.size(); i++){
            if (absences.get(i) ==0 ){
                System.out.println(anotherListOfNames.get(i)+ " has perfect attendance");
            }
        }

        //What are the names of the students who have FE'd some course?
        System.out.println("Students who have Fe'd a course " + whoFedACourse(anotherListOfNames,absences, 4));

        //Generate today's date and output it.
        LocalDate today = LocalDate.now();
        System.out.println("today is "+ today);

        //how many days have I been alive?
        System.out.println("you've been alive for " +howManyDaysSince(1999,07,10) + " days.");

        //Create a list of LocalDate objects
        ArrayList<LocalDate> dateArrayList = createADateArrayList(absences.size());
        System.out.println("The dates are " + dateArrayList);
        //What are the names of the students with the fewest absences?
        ArrayList<String> personWithLeastAmountOfAbsences = leastAmountOfAbsences(anotherListOfNames,absences);
        System.out.println("the people with the least amount of absences " + personWithLeastAmountOfAbsences);

       //What are the names of students who have the longest number of days since an absence?
        System.out.println(anotherListOfNames);
        System.out.println("the students who have the longest number of days since an absence are "+ longestDaysSinceLastAbscence(anotherListOfNames,dateArrayList));

        //What is the range of absence dates?
        int range = absenceRange(dateArrayList);
        System.out.println("The range of absences is " +range);

        //What are the indexes of the students who have  [X] absence date?
        System.out.println("students who were absent on this date " + whoWasAbsentOnThisDate(dateArrayList,LocalDate.of(2018,02,18),anotherListOfNames));









    }

    private static Set<String> whoFedACourse(ArrayList<String> anotherListOfNames, ArrayList<Integer> absences, int meetsPerWeek) {
        Set<String> studentsWhoFed = new HashSet<>();
        for (int i = 0; i < absences.size() ; i++) {
            if(absences.get(i) >= meetsPerWeek+2){
                studentsWhoFed.add(anotherListOfNames.get(i));
            }

        }
        return studentsWhoFed;
    }

    private static ArrayList<String> whoWasAbsentOnThisDate (ArrayList<LocalDate> dates, LocalDate date, ArrayList<String> names){
        ArrayList<String> studentsWhoHadThatDate = new ArrayList<>();
        for (int i = 0; i <dates.size(); i++) {
            if (dates.get(i) == date){
                studentsWhoHadThatDate.add(names.get(i));
            }

        }
        return studentsWhoHadThatDate;
    }

    private static int absenceRange(ArrayList<LocalDate> dates){
        LocalDate today = LocalDate.now();
        int longestDif = diffDays(today,dates.get(0));
        for (int i = 0; i < dates.size(); i++) {
            int dif = diffDays(today, dates.get(i));
            if(dif>longestDif){
                longestDif = dif;
            }

        }
        return longestDif;
    }

    private static ArrayList<String> longestDaysSinceLastAbscence(ArrayList<String> names,ArrayList<LocalDate> dates){
        ArrayList<String> longestSinceAbsence = new ArrayList<>();
        LocalDate today = LocalDate.now();
        int longestDif = diffDays(today,dates.get(0));
        int index = 0;
        for (int i = 0; i <dates.size(); i++) {
            int dif = diffDays(today,dates.get(i));
            if (dif>longestDif){
                longestDif = dif;
                index = i;
            }
        }
        for (int i = 0; i < dates.size(); i++) {
            int longestCheck = diffDays(today,dates.get(i));
            if(longestCheck == longestDif){
                longestSinceAbsence.add(names.get(i));
            }
        }
        return longestSinceAbsence;


    }

    private static int diffDays(LocalDate date1, LocalDate date2) {
        int diff = date1.getDayOfYear()-date2.getDayOfYear();
        return diff;
    }

    private static ArrayList<String> leastAmountOfAbsences(ArrayList<String> names, ArrayList<Integer> absences) {
        ArrayList<String> leastAbsences = new ArrayList<>();
        int min = absences.get(0);

        for (int i = 1; i <absences.size() ; i++) {
            if (absences.get(i)<min){
                min = absences.get(i);
            }
        }
        for (int i = 0; i <absences.size() ; i++) {
            if(absences.get(i)==min){
                leastAbsences.add(names.get(absences.get(i)));
            }
        }
        return leastAbsences;
    }

    private static ArrayList<LocalDate>  createADateArrayList(int size) {
        ArrayList<LocalDate> dates = new ArrayList<>();
        Random rand = new Random();
        LocalDate today = LocalDate.now();
        for (int i = 0; i < size ; i++) {
            dates.add(today.minusDays(rand.nextInt(21)));
        }
        return dates;
    }

    private static int howManyDaysSince(int year, int month, int day) {
        LocalDate birthday = LocalDate.of(year,month,day);
        LocalDate today = LocalDate.now();
        int dayDiff = today.getDayOfYear()- birthday.getDayOfYear();
        int yearDif = today.compareTo(birthday);
        int daysSince = ((yearDif*365)-Math.abs(dayDiff)+5) ;
        return daysSince;
    }

    private static void wereAllNamesUsed(ArrayList<String> names, ArrayList<String> anotherListOfNames) {
        ArrayList<Boolean> check = new ArrayList<Boolean>();
        for (int i = 0; i < names.size() ; i++) {
            for (int j = 0; j <anotherListOfNames.size() ; j++) {
                if (!names.get(i).equals(anotherListOfNames.get(j))){
                    check.add(i,false);
                }
                else {
                    check.add(i,true);
                }

            }

        }
        boolean allUsed = false;
        for (int i = 0; i <check.size() ; i++) {
            if (check.get(i)!=true){
                allUsed = false;

            }
            else{
                allUsed = true;
            }

        }
        if (allUsed == true){
            System.out.println("not, not every name was used in the new array");
        }
        else {
            System.out.println("yes, all names were used in the new array");
        }
    }

    private static void shuffleString(ArrayList<String> anotherListOfNames) {
        Random rand = new Random();
        for (int i = 0; i < anotherListOfNames.size() ; i++) {
            int randInt = rand.nextInt(anotherListOfNames.size());
            String temp = anotherListOfNames.get(randInt);
            anotherListOfNames.set(randInt, anotherListOfNames.get(i));
            anotherListOfNames.set(i, temp);

        }

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


    private static void addNumToElementGreaterThan(ArrayList<Integer> absences, int addAmount, int greaterThan){
        for (int i = 0; i < absences.size(); i++) {
            if(absences.get(i) > greaterThan){
                absences.set(i,absences.get(i)+addAmount);
            }
            if(absences.get(i) <0){
                absences.set(i, 0);
            }
            if (absences.get(i) >15)
            {
                absences.set(i, 15);
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
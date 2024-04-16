import java.util.Scanner;
public class GpaCalculator {
    public static void main(String[] args) {

        
        Scanner cal = new Scanner(System.in);
        //declare the new Scanner
        int[] creditHour = { 3, 2, 3, 3, 3, 1, 1 };
        // Subject Credit Hour According to the Listed Array
        String[] subject = { "P.F", "I.C.T", "Maths", "English", "Physics" };
        String[] Lab = { "Pf Lab", "ICT-lab" };
        float[] marks = new float[7];
        // Declare for storing marks of Subject
        float[] calGpa = new float[7];
        // Declare for storing gpa of subject
        for (int i = 0; i < subject.length; i++) {
            System.out.println("Enter the Number  of  " + subject[i]);
            marks[i] = cal.nextFloat();
            calGpa[i] = calculateGpa(marks[i]);
        }
        // For Lab marks Input
        for (int a = 0; a < Lab.length; a++) {
            System.out.println("Enter the  marks of \t" + Lab[a]);
            marks[a + 5] = cal.nextFloat();
            float[] num = new float[2];
            num[a] = (marks[a + 5] / 50) * 100; 
            // use for converting lab marks into percentage for gpa calcualtion
            marks[a + 5] = num[a];
            //assingning the calculated gpa to the index 6 & 7 
            calGpa[a + 5] = calculateGpa(num[a]);  
            //we use a+5 in array because we have acess the index number 5 & 6 for lab (zero based indexing )
        }
        float[] ml = new float[7];
        // Use for Storing prd of crdit hour and subject Gpa
        float tot = 0;
        // Declare for totaling the crd*gpa
        System.out.println("Subject \t" + "Marks\t" + "\t" + " GPA" + "\t" + "CreditHour");
        // for making the Table
        for (int j = 0; j < subject.length; j++) {
            System.out.print(subject[j] + "\t" + "\t");
            System.out.print(marks[j] + "\t" + "\t");
            System.out.print(calGpa[j] + "\t" + "\t");
            System.out.println(creditHour[j] + "\t" + "\t");

            ml[j] = calGpa[j] * creditHour[j];
            tot += ml[j];
        }

        //for printing the lab marks 

        for (int b = 0; b < Lab.length; b++) {
            System.out.print(Lab[b] + "\t" + "\t");
            System.out.print(marks[5 + b] + "\t" + "\t");
            System.out.print(calGpa[5 + b] + "\t" + "\t");
            System.out.println(creditHour[5 + b] + "\t" + "\t");
            ml[5 + b] = calGpa[5 + b] * creditHour[5 + b];
            tot += ml[5 + b];

        }
        // System.out.println(tot);
        //final output all calculation is done above 
        float gpa = tot / 16;
        System.out.println("Your Gpa is " + gpa);
        System.out.println("Thanks for using this Program!");
        System.out.println("Made By Muhammad Shayan Bhatti");
        cal.close();
    }
    // declare for deciding the subject point avg
//This is make according to bbsul it subject point avg calculation
 
public static float calculateGpa(float marks) {
        if (marks >= 85 && marks <= 100) {
            return 4.0f;
        } else if (marks >= 80) {
            return 3.70f;
        } else if (marks >= 75) {
            return 3.3f;
        } else if (marks >= 70) {
            return 3.0f;
        } else if (marks >= 65) {
            return 2.7f;
        } else if (marks >= 61) {
            return 2.3f;
        } else if (marks >= 58) {
            return 2.0f;
        } else if (marks >= 55) {
            return 1.7f;
        } else if (marks >= 50) {
            return 1.0f;
        } else {
            return 0.0f;
        }
    }
}

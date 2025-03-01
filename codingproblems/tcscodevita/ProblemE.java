package codingproblems.tcscodevita;

/*
 * CollegeRanklll
— Problem Description
Marks: 200
College Admissions are done by allocating a seat to a student based on his/her preference and percentage scored. Students are asked to provide three colleges of their choice. Each college will have a quota of S seats (S can vary per
college). Admissions will be processed based on •percentage scored' and availability of seats as per 'choice of preference'.
Admissions will first be granted based on percentage scored. If there is a tie, on percentage scored, then admission will be granted based on student ld i.e. student with a lower ld will be given preference over student with higher ld.
In Round 1 all admissions will be processed based on students' choice i.e. if a student is eligible to get admitted in any of the 3 colleges, s/he will have to be admitted. Similarly, it will be binding on the student to get admitted. Obviously,
first choice will get first preference, second choice will get second preference and so on,
Round 2 will process all the remaining students (those who didnt get admitted in Round I) according to their percentages and in order of maximum availability of seats in colleges.
For E.g.
college, vacant seats>
c-1, 15
c-22, 14
c-32, 13
c-43, 12
<student-id, percentage>
Student-88, 64.0
Student-103, 63.7
Student-128, 58.28
Here, now Student-88 will get admitted to C-1.
Now, Student-103 could potentially get admitted to C-1 or C-22. Suppose we mandate that ties should be broken in favour of college with least ID, then again Student-103 will get admitted to C-1. Now C-1 has 13 vacant seats whereas C-
22 has 14 vacant seats.
Next, Student-128 will get admitted to C-22. Now again C-1, C-22 and C-32 have 1 3 vacant seats. So, the next three students (hypothetically) will get admitted to C-1 , C-22 and C-32 respectively.
— Constraints
— Input
First line contains two integers viz. C and N where,
C is number of colleges and
N is number of students
Second line contains C spaced integers denoting Sl,S2 and so on till Sc - where Sl is number of seats in college 1, S2 in college 2 etc.
Next, N lines comprise of 5 data items, viz <student-id, percentage, Choice 1, Choice 2, Choice
— Output
Display the cut-off percentages of all the colleges in sorted order (descending order). Display the college with no students in last line as •n/a.
The output format is «college cut-off_percentage»
For better understanding go through the Examples given below
— Time Limit (secs)
— Examples
Input
35
312
student-I
Output
c-1 80.83
c-2 48.03
c-3 41.23
Explanation
Here student-I with highest percentage gets his first preferred college, then the next top scorer, Student-3 gets his first preferred college and so on.
However, we can see that there are only three seats in college 1 so only students with good percentage get admitted (i.e., student-I, student-3, student-4).
Now college 1 allocation quota is complete. Hence no new student can be admitted to college 1. college 2 and college 3 still have one and two seats respectively. Now, Student-2 and Student-5 are yet to be admitted.
Both student's priority is college 2 as second choice, but Student-2 is admitted to college 2 due to higher percentage (i.e., Student-2 Percentages Student-5 Percentage).
Now there are only O, O, 2 seats left in college 1, college 2 and college 3 respectively. So, Student-3 is admitted to college 3 based on his preference. Here there is no need of round 2 as all students are admitted to colleges and none of
them are awaiting admissions.
Now, C-1 = [Student-I, Student-3, Student-41, For C-1, Cut-off is 80.83 because Student with least percentage in C-1 is Student-4. Similarly for C-3, it is 41.23 Display these Cut-off in sorted order.
Example 2
Input
5 5
2 1 1 1 2
Student-I
,C-2,C-3
Output
c-1 85.69
c-3 80.83
c-2 48.03
c-5 41.2
C-4 n/a
Explanation
Here allocation is done based on percentage and preference, that is student with high percentage is admitted based on his choice of preference. So, Student-I, Student-2, Student-3, Student-4 are admitted based on their score and
choice.
However, Student-5 is not admitted because all the choice of his/her colleges is full. So, now round 2 starts for student-5. Student-5 is admitted based on his/her percentage and maximum number of seats available in a college.
Student-5 can be admitted to C-5 since it has highest number of vacant seats viz 2.
Now, C-1= [Student-I, Student-3], C-3=[Student-4], C-4= C-5=[Student-5].
So, Cut-off for C-4 is 'n/a•, because no student is admitted to it and Cut-off for C-5 is 41.23(student with least percentage i.e., 41.23).
Display the cut-offs of colleges in descending order. Since no student got admitted to college 4 display it in last line as C-4 n/a.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ProblemE {
    static BufferedReader reader;
    static StringTokenizer st;
    static PrintWriter out;

    static String next() throws IOException {
        while (st == null || !st.hasMoreElements())
            st = new StringTokenizer(reader.readLine());
        return st.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);

        int C = nextInt();
        int N = nextInt();
        int[] seats = new int[C];
        double[] collegeCutOff = new double[C];
        Arrays.fill(collegeCutOff, 100);
        for (int i = 0; i < C; i++)
            seats[i] = nextInt();
        Student[] students = new Student[N];
        for (int i = 0; i < N; i++) {
            String[] split = next().trim().split(",");
            students[i] = new ProblemE().new Student(split[0], Double.parseDouble(split[1]),
                    Integer.parseInt(split[2].substring(2)), Integer.parseInt(split[3].substring(2)),
                    Integer.parseInt(split[4].substring(2)));
        }
        Arrays.sort(students);
        System.out.println();
        for (Student student : students)
            System.out.println(student);

        for (Student student : students) {
            if (seats[student.choiceOne - 1] > 0) {
                seats[student.choiceOne - 1]--;
                collegeCutOff[student.choiceOne - 1] = Math.min(collegeCutOff[student.choiceOne - 1],
                        student.percentage);
                System.out.println("College - " + student.choiceOne + " " + collegeCutOff[student.choiceOne - 1]);
            } else if (seats[student.choiceTwo - 1] > 0) {
                seats[student.choiceTwo - 1]--;
                collegeCutOff[student.choiceTwo - 1] = Math.min(collegeCutOff[student.choiceTwo - 1],
                        student.percentage);
            } else if (seats[student.choiceThree - 1] > 0) {
                seats[student.choiceThree - 1]--;
                collegeCutOff[student.choiceThree - 1] = Math.min(collegeCutOff[student.choiceThree - 1],
                        student.percentage);
            }
        }
        System.out.println();
        for (int i = 0; i < C; i++)
            System.out.println(collegeCutOff[i]);

        out.flush();
        reader.close();
        out.close();
    }

    /**
     * Student
     */
    public class Student implements Comparable<Student> {
        public String studentId;
        public double percentage;
        public int choiceOne;
        public int choiceTwo;
        public int choiceThree;

        Student(String studentId, double percentage, int choiceOne, int choiceTwo, int choiceThree) {
            this.studentId = studentId;
            this.percentage = percentage;
            this.choiceOne = choiceOne;
            this.choiceTwo = choiceTwo;
            this.choiceThree = choiceThree;
        }

        public String toString() {
            return studentId + " " + percentage + " " + choiceOne + " " + choiceTwo + " " + choiceThree;
        }

        @Override
        public int compareTo(Student o) {
            return Double.compare(o.percentage, this.percentage);
        }
    }

    /**
     * college
     */
    public class College {
        String collegeId;
        int seats;
        double cutOff;

        College(String collegeId, int seats) {
            this.collegeId = collegeId;
            this.seats = seats;
        }
    }
}

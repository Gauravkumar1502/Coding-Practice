package codingproblems.tcscodevita;

/*
 * Worker
— Problem Description
Marks: 100
This is a resource to task allocation problem. There are two types of tasks viz. one that the human needs to do and the other which as amenable to machine processing. A human-oriented task cannot be performed by machine and vice-
versa. Also, assume that all human workers are equally efficient. So, the same task will be performed in the same time, irrespective of which human worker does that task.
Given the number of workers, number of tasks and time taken to finish each task, compute which task was finished at what time and which worker performed that task. Some rules and conventions that need to be adhered to while
doing task allocation to workers are as below.
Machine processing for any task takes 0 minutes
Time taken (in minutes) by a human worker to complete a particular task is mentioned in the input
Workers and tasks are identified by their suffixes i.e„ Worker 1 is WI and Task 1 is TI.
Task information is provided in the input in form of a tuple that consists of 3 things viz. <Taskname, TaskType, CompletionTime» where
o Taskname will be of form Tl, T2, T3 etc.
o TaskType will be a keyword which can be either {Manual, Machine}
o CompletionTime is a number denoting time in minutes needed for manual tasks and 0 for machine-bound tasks
A worker will still need to be assigned even if a task can be done only by the machine
Tasks need to be processed in sequential order i.e., Tl has to be allocated before T2
Initially when all workers are free, worker Wi will be allocated task before worker Wi+l i.e., in general a worker with lower suffix will be assigned to the task before worker with a higher suffix.
If one or more workers are available at the same time, then the worker who processed lower suffix task will get the next task allocated prior to the other workers.
Assume the switching time from one task to another as O min
Refer Examples section for better understanding of how tasks are allocated to workers
Compute which task was completed at what time and which worker performed that task. The output specifications provide information on how output should be printed.
— Constraints
-10
= 100
— Input
First line contains an integer N which denotes the number of workers
Second line contains an integer M which denotes the number of tasks
Next M lines contain a task information tuple as described in the previous section
— Output
Output should adhere to the following specifications.
• Each output should be a tuple comprising of 3 pieces of information viz <Worker name, task name, time at which the task was completed*
• The tuple should be first sorted in ascending order of completion time and then in ascending order of task name
For better understanding refer to the Examples section.
— Time Limit (secs)
— Examples
Input
3
4
TI Machine
T2 Manual 5
T3 Machine
T4 Machine
Output
Explanation:
Here, denotes number of workers WI, W2, W3.
First, Workers WI, W2, W3 will be assigned with tasks T 1, T2, T3 at the 0th minute, respectively.
Here, Tl is Machine-bound so it will be completed in 0th minute and then WI will be available for the remaining tasks. T2 is Manual and it will be completed in 5th minute. So, W2 will be free after 5 minutes. T3 again is Machine-bound so
it will be completed in 0th minute and then W3 will be available for remaining tasks.
Now, Workers available for pending tasks in 0th minute = {WI , W3}
Here, WI will be assigned with next pending task first, because the worker WI completed task with lower suffix (T I) than W3 (T3).
WI will be assigned the next task T4 at 0th minute which is a Machine-bound task which will also be completed in 0th minute.
As the number of pending tasks are zero, no further assignment takes place.
W2 will complete T2 at the end of 5th minute. Hence,
First line of output is "WI TI O", where TI is the task completed by Worker WI 0th minute.
Second line of output is "W3 T3 0', where T3 is the task completed by Worker W3 in 0th minute.
Third line of output is "WI T4 0", where T4 is the task completed by worker WI in 0th minute.
Fourth line of output is "W2 T2 5', where T2 is the task completed by W2 in 5th minute.
So, the output is as follows:
WI T4 0
Example 2
Input
3
4
Tl Machine
T2 Machine
T3 Machine
T4 Machine
Output
W2T20
Explanation:
Given N = 3 denotes number of workers WI, W2 and W3
First, Workers WI, W2, W3 will be assigned with tasks T 1, T2, T3 in 0th minute, respectively.
Here, T 1, T2 and T3 are Machine-bound and will be completed in 0th minute, after completion of these tasks WI , W2, W3 will be available for the remaining tasks.
Since WI is the first worker in the list of available workers at 0th minute. WI will pick up the 4th task and will complete it in 0th minute, because it is also a machine bounded task.
Hence the output is as follows:
W3T30
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProblemD {
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

        int N = nextInt();
        int M = nextInt();
        String[] tasks = new String[3];
        for (int i = 0; i < M; i++)
            tasks[i] = reader.readLine().trim();
        solve(N, M, tasks);
        out.flush();
        reader.close();
        out.close();
    }

    private static void solve(int n, int m, String[] tasks) {

    }
}

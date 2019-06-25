package ExamPreparation_JavaAdvanced.Archive_AdvancedJava_Exams.JavaAdvancedExam_10June2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class p01Internships {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        ArrayDeque<String> problemsStack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            problemsStack.push(reader.readLine());
        }
        ArrayDeque<String> candidateQueue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            String token = reader.readLine();
            if (token.matches("[A-Z][a-z]+ [A-Z][a-z]+")) {
                candidateQueue.offer(token);
            }
        }

        while (!problemsStack.isEmpty()) {

            String candidate = candidateQueue.peek();
            String problem = problemsStack.peek();

            int sumCandidate = 0;
            if (candidate != null) {
                sumCandidate = candidate.chars().sum();
            }
            int sumProblem = problem.chars().sum();
            if (sumCandidate > sumProblem) {// move da e s ravno ne e qsno uslovieto
                problemsStack.pop();
                candidateQueue.poll();
                candidateQueue.offer(candidate);
                System.out.println(String.format("%s solved %s.", candidate, problem));
            } else {
                problemsStack.pop();
                problemsStack.addLast(problem);
                candidateQueue.poll();
                System.out.println(candidate + " failed " + problem + ".");
            }
            if (candidateQueue.size() == 1) {
                System.out.print(candidateQueue.poll() + " gets the job!");
                return;
            }
        }


        System.out.println(candidateQueue.toString().replaceAll("[\\]\\[]", ""));

    }
}

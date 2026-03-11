import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VoteCountingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> voteMap = new HashMap<>();

        int choice;

        do {
            System.out.println("\n===== VOTE COUNTING SYSTEM =====");
            System.out.println("1. Add Candidate");
            System.out.println("2. Cast Vote");
            System.out.println("3. View Vote Count");
            System.out.println("4. Show Winner");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter candidate name: ");
                    String candidate = sc.nextLine();

                    if (voteMap.containsKey(candidate)) {
                        System.out.println("Candidate already exists.");
                    } else {
                        voteMap.put(candidate, 0);
                        System.out.println("Candidate added successfully.");
                    }
                    break;

                case 2:
                    if (voteMap.isEmpty()) {
                        System.out.println("No candidates available. Add candidates first.");
                        break;
                    }

                    System.out.print("Enter candidate name to vote: ");
                    String voteCandidate = sc.nextLine();

                    if (voteMap.containsKey(voteCandidate)) {
                        voteMap.put(voteCandidate, voteMap.get(voteCandidate) + 1);
                        System.out.println("Vote cast successfully for " + voteCandidate + ".");
                    } else {
                        System.out.println("Candidate not found.");
                    }
                    break;

                case 3:
                    if (voteMap.isEmpty()) {
                        System.out.println("No candidates available.");
                    } else {
                        System.out.println("\n===== VOTE COUNT =====");
                        for (Map.Entry<String, Integer> entry : voteMap.entrySet()) {
                            System.out.println(entry.getKey() + " -> " + entry.getValue() + " vote(s)");
                        }
                    }
                    break;

                case 4:
                    if (voteMap.isEmpty()) {
                        System.out.println("No candidates available.");
                    } else {
                        String winner = null;
                        int maxVotes = -1;
                        boolean tie = false;

                        for (Map.Entry<String, Integer> entry : voteMap.entrySet()) {
                            if (entry.getValue() > maxVotes) {
                                maxVotes = entry.getValue();
                                winner = entry.getKey();
                                tie = false;
                            } else if (entry.getValue() == maxVotes) {
                                tie = true;
                            }
                        }

                        if (maxVotes == 0) {
                            System.out.println("No votes have been cast yet.");
                        } else if (tie) {
                            System.out.println("There is a tie between top candidates with " + maxVotes + " vote(s).");
                        } else {
                            System.out.println("Winner: " + winner + " with " + maxVotes + " vote(s).");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}
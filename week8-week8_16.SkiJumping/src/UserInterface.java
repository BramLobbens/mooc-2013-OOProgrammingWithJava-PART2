
import java.util.Scanner;

public class UserInterface {

    private Scanner reader;
    private Tournament skijump;

    public UserInterface(Scanner reader, Tournament skijump) {
        this.reader = reader;
        this.skijump = skijump;
    }

    public void start() {
        System.out.println("Kumpula ski jumping week\n");
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");
        
        // Enter Participants
        while (true) {
            System.out.print("  Particpant name:");
            String name = reader.nextLine();
            
            if (name.isEmpty()) {
                break;
            }
            
            skijump.addParticipant(name);
        }
        System.out.println("");
        System.out.println("The tournament begins!\n");
        
        // Run tournament
        while (true) {
            System.out.print("Write \"jump\" to jump; otherwise you quit:");
            String command = reader.nextLine();
            
            if (command.toLowerCase().equals("jump")) {
                startRound();
            }
            else {
                break;   
            }
        }
        System.out.println("Thanks!\n");
        printTournamentResults();
    }
    
    private void startRound() {
        
        System.out.println("");
        System.out.println("Round " + skijump.getRound());
        
        
        printJumpingOrder();
        skijump.judgeJump();
        printRoundResults();
        skijump.nextRound();
    }
   
    private void printJumpingOrder() {
        System.out.println("");
        System.out.println("Jumping order:");
        int n = 1; // show order
        for (Participant p : skijump.getParticipants()) {
            System.out.println("  " + n++ + ". " + p);
        }
    }
    
    private void printRoundResults() {
        System.out.println("");
        System.out.println("Results of round " + skijump.getRound());
        for (Participant p : skijump.getParticipants()) {
            System.out.println(p.getName());
            System.out.println("    length: " + p.getLastJump());
            System.out.println("    judge votes: " + StringFormat.formatScores(skijump.getJudgeScores().get(p)));
        }
    }
    
    private void printTournamentResults() {
        System.out.println("Tournament results:");
        System.out.println("Position    Name");
        int n = 1; // show order
        boolean descending = true;
        for (Participant p : skijump.getParticipants(descending)) {
            System.out.println(n++ + "           " + p);
            System.out.println("            jump lengths: " + StringFormat.formatDistances(p));
        }
    }
}

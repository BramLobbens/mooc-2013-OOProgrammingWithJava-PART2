
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Tournament {

    private int round;
    private Map<Participant, int[]> judgeScores;
    private List<Participant> participants;

    public Tournament() {
        round = 1;
        judgeScores = new HashMap<Participant, int[]>();
        participants = new ArrayList<Participant>();
    }

    public int getRound() {
        return round;
    }

    public void nextRound() {
        round++;
        Collections.sort(participants);
    }

    public void addParticipant(String name) {
        participants.add(new Participant(name, 0));
    }
    
    public List<Participant> getParticipants() {
        
        return participants;  
        
    }
    
    public List<Participant> getParticipants(boolean descending) {
        
        if (descending) {
           Collections.sort(participants);
           Collections.reverse(participants);
        }
        return participants;  
        
    }
    
    public void judgeJump() {
        for (Participant p : participants) {
            int distance = p.jump();
            int points = getPoints(p);
            p.givePoints(distance + points);
        }
    }

    private int getPoints(Participant p) {
        // get 5 random scores
        int min = 10;
        int max = 20;
        int judges = 5;

        Random rand = new Random();
        int[] scores = new int[5];
        for (int i = 0; i < judges; i++) {
            int score = min + rand.nextInt(max - min);
            scores[i] = score;
        }
        judgeScores.put(p, scores);

        // do not take into account lowest and highest score
        Arrays.sort(scores);
        int points = 0;
        for (int i = 1; i < scores.length - 1; i++) {
            points += scores[i];
        }

        return points;
    }

    public Map<Participant, int[]> getJudgeScores() {
        return judgeScores;
    }
    
    
}


import java.util.ArrayList;
import java.util.List;

public class StringFormat {

    public static String formatScores(int[] scores) {
        String output = "[";
        for (int i = 0; i < scores.length - 1; i++) {
            output += "" + scores[i] + ", ";
        }
        output += "" + scores[scores.length - 1] + "]";
        return output;
    }

    public static String formatDistances(Participant p) {
        String output = "";
        List<Integer> list = new ArrayList(p.getDistances());
        Integer[] arr = list.toArray(new Integer[list.size()]);
        for (int i = 0; i < arr.length - 1; i++) {
            output += "" + arr[i] + " m,";
        }
        output += "" + arr[arr.length - 1] + " m";
        return output;
    }
}

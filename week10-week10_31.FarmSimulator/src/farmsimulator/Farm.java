package farmsimulator;

import java.util.ArrayList;
import java.util.List;

public class Farm implements Alive {

    private String owner;
    private Barn barn;
    private List<Cow> cows;

    public Farm(String owner, Barn barn) {
        this.owner = owner;
        this.barn = barn;
        cows = new ArrayList<Cow>();
    }

    public String getOwner() {
        return owner;
    }

    public void installMilkingRobot(MilkingRobot milkingRobot) {
        barn.installMilkingRobot(milkingRobot);
    }

    @Override
    public void liveHour() {
        for (Alive cow : cows) {
            cow.liveHour();
        }
    }

    public void addCow(Cow cow) {
        cows.add(cow);
    }

    public void manageCows() {
        barn.takeCareOf(cows);
    }

//    @Override
//    public String toString() {
//        String s = "Farm owner: " + owner + "\n"
//                + "Barn bulk tank: " + barn.getBulkTank().toString() + "\n";
//        if (cows.isEmpty()) {
//            s += "No cows";
//        } else {
//            s += "Animals:" + "\n";
//            for (Alive cow : cows) {
//                s += "\t" + cow.toString() + "\n";
//            }
//        }
//        return s.substring(0, s.length() - 1);
//    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Farm owner: ");
        sb.append(owner);
        sb.append("\n");
        sb.append("Barn bulk tank: ");
        sb.append(barn.getBulkTank());
        sb.append("\n");

        if (cows.isEmpty()) {
            sb.append("No cows.");
        } else {
            sb.append("Animals:\n");
            for (Cow cow : cows) {
                sb.append("        ");
                sb.append(cow);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}

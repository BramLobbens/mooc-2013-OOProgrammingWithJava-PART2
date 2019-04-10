
public class Calculator {

    private Reader reader;
    private int stats;

    public Calculator() {
        reader = new Reader();
        stats = 0;
    }

    public void start() {
        while (true) {
            System.out.print("command: ");
            String command = reader.readString();
            if (command.equals("end")) {
                break;
            }

            if (command.equals("sum")) {
                sum();
                stats++;
            } else if (command.equals("difference")) {
                difference();
                stats++;
            } else if (command.equals("product")) {
                product();
                stats++;
            }
        }

        statistics();
    }
    
    private int[] getInput() {
        int[] vals = new int[2];
        System.out.print("Value1: ");
        vals[0] = reader.readInteger();
        System.out.print("Value2: ");
        vals[1] = reader.readInteger();
        
        return vals;
    }

    private void sum() {
        int[] vals = getInput();
        int sum = vals[0] + vals[1];
        System.out.println("sum of the values " + sum);
    }

    private void difference() {
        int[] vals = getInput();
        int diff = vals[0] - vals[1];
        System.out.println("difference of the values: " + diff);
    }

    private void product() {
        int[] vals = getInput();
        int prod = vals[0] * vals[1];
        System.out.println("product of the values: " + prod);
    }

    private void statistics() {
        System.out.println("Calculations done " + stats);
    }
}

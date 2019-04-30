public class Main {
    public static void main(String[] args) {
        // Test your code here!
        
        CivilService s1 = new CivilService();
        MilitaryService s2 = new MilitaryService(200);
        
        int n = 365;
        while (n-- > 0) {
            s1.work();
            s2.work();
        }
        
        System.out.println(s1.getDaysLeft());
        System.out.println(s2.getDaysLeft());
    }
}

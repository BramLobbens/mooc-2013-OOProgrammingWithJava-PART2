
public class Smileys {

    private static void printWithSmileys(String characterString) {
        int len = characterString.length();
        String space = "";
        int numSmileys = (len + 6) / 2;
        if (len % 2 != 0) {
            numSmileys += 1;
            space = " ";
        }
        for (int i = 0; i < numSmileys; i++) {
            System.out.print(":)");
        }
        System.out.println("");
        System.out.println(":) " + characterString + space  + " :)");
        for (int i = 0; i < numSmileys; i++) {
            System.out.print(":)");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        // Test your method at least with the following
        printWithSmileys("Method");
        printWithSmileys("Beerbottle");
        printWithSmileys("Interface");

        printWithSmileys("\\:D/");
        printWithSmileys("87.");
    }

}

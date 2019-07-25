package dungeon;

import character.Vampire;
import character.Player;
import character.Character;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
* TO DO:
* - fix collision with enemies
* - implement win mechanic
*/

public class Dungeon {

    private Scanner reader;

    private int length;
    private int height;
    private int vampires;
    private int moves;
    private boolean vampiresMove;

    private Player player;
    private Set<Character> enemies;

    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.length = length;
        this.height = height;
        this.vampires = vampires;
        this.moves = moves;
        this.vampiresMove = vampiresMove;

        reader = new Scanner(System.in);
    }

    public void run() {
        populate();

        while (true) {
            // update screen
            displayStats();
            drawDungeon();

            // get user input
            String command = reader.nextLine();
            if (command.toLowerCase().equals("x")) {
                break;
            }
            for (char c : command.toCharArray()) {
                handleInput(c + "");
            }

            moves--;
            if (moves == 0) {
                break;
            }
        }

        System.out.println("Game over!");
    }

    private void populate() {
        this.player = new Player('@');
        this.enemies = new HashSet<Character>();
        for (int i = 0; i < vampires; i++) {
            enemies.add(new Vampire(length, height, 'v'));
        }
    }

    private void displayStats() {
        StringBuilder sb = new StringBuilder();
        sb.append(moves + "\n\n");
        sb.append(player + "\n");
        for (Character e : enemies) {
            sb.append(e + "\n");
        }
        System.out.println(sb);
    }

    private void drawDungeon() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {

                boolean drawn = false;

                // draw enemy positions
                for (Character e : enemies) {
                    if (e.getPos().isPosition(j, i)) {
                        System.out.print(e.getSymbol());
                        drawn = true;
                    }
                }
                
                // draw player's position
                if (player.getPos().isPosition(j, i)) {
                    System.out.print(player.getSymbol());
                    drawn = true;
                }
                
                if (!drawn) {
                    System.out.print(".");
                }
            }
            // start new line
            System.out.println();
        }
    }

    private void handleInput(String command) {

        // up
        if (command.toLowerCase().equals("w")) {
            if (!isOutOfBounds(player.getPos().getX(), player.getPos().getY() - 1)) {
                player.up();
            }
        }
        // down
        if (command.toLowerCase().equals("s")) {
            if (!isOutOfBounds(player.getPos().getX(), player.getPos().getY() + 1)) {
                player.down();
            }
        }
        // left
        if (command.toLowerCase().equals("a")) {
            if (!isOutOfBounds(player.getPos().getX() - 1, player.getPos().getY())) {
                player.left();
            }
        }
        // right
        if (command.toLowerCase().equals("d")) {
            if (!isOutOfBounds(player.getPos().getX() + 1, player.getPos().getY())) {
                player.right();
            }
        }
    }

    private boolean isOutOfBounds(int x, int y) {
        return (x < 0) || (x > length - 1) || (y < 0) || (y > height - 1);
    }
    
}

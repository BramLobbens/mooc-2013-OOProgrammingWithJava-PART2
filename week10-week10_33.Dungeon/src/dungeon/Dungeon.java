package dungeon;

import character.Vampire;
import character.Player;
import character.Character;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
* TO DO:
* - implement random movement vampires
* - fix collision with enemies before stats updated
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
    private Set<Character> killedEnemies;
    
    private final char playerChar = '@';
    private final char vampireChar = 'v';
    private final char terrainChar = '.';

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
        boolean win = false;
        
        while (true) {
            // update screen
            displayStats();
            drawDungeon();
            
            // check win condition
            if (enemies.isEmpty()) {
                win = true;
                break;
            }
            
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
        
        String message = win ? "YOU WIN" : "YOU LOSE";
        System.out.println(message);
    }

    private void populate() {
        this.player = new Player(playerChar);
        this.enemies = new HashSet<Character>();
        this.killedEnemies = new HashSet<Character>();
        for (int i = 0; i < vampires; i++) {
            enemies.add(new Vampire(length, height, vampireChar));
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

                // draw player's position
                if (player.getPos().isPosition(j, i)) {
                    System.out.print(player.getSymbol());
                    drawn = true;
                }
                
                // draw enemy positions
                for (Character e : enemies) {
                    if (e.getPos().isPosition(j, i)) {
                        
                        // queue enemy to be killed if player on enemy position
                        if (drawn) {
                            killedEnemies.add(e);
                        }
                        else {
                            System.out.print(e.getSymbol());
                            drawn = true;
                        }
                    }
                }
                
                if (!drawn) {
                    System.out.print(terrainChar); // terrain is drawn if no character is on this position
                }
                
                enemies.removeAll(killedEnemies);
            }
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

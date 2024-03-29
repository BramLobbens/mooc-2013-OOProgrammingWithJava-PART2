package dungeon;

import character.Vampire;
import character.Player;
import character.Character;
import character.Position;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Dungeon {

    private Scanner reader;

    private int length;
    private int height;
    private int vampires;
    private int moves;
    private boolean vampiresMove;

    private Player player;
    private Set<Character> enemies;
    private List<Character> toBeRemoved;

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

            // check collisions
            for (Character e : enemies) {
                if (e.getPos().equals(player.getPos())) {
                    toBeRemoved.add(e);
                }
            }
            enemies.removeAll(toBeRemoved);
            
            // vampires move
            if (vampiresMove) {
                for (Character e : enemies) {
                    e.move(length, height);
                }
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
        for (int i = 0; i < vampires; i++) {
            enemies.add(new Vampire(length, height, vampireChar));
        }
        this.toBeRemoved = new ArrayList<Character>();
    }

    private void displayStats() {
        StringBuilder sb = new StringBuilder();
        sb.append("Torchlight: " + moves + "\n\n");
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
                if (player.getPos().equals(new Position(j, i))) {
                    System.out.print(player.getSymbol());
                    drawn = true;
                }

                // draw enemy positions
                for (Character e : enemies) {
                    if (e.getPos().equals(new Position(j, i))) {
                        System.out.print(e.getSymbol());
                        drawn = true;
                    }
                }

                // terrain is drawn if no character is on this position
                if (!drawn) {
                    System.out.print(terrainChar);
                }
            }
            System.out.println();
        }
    }

    private void handleInput(String command) {

        // up
        if (command.toLowerCase().equals("w")) {
            if (!isOutOfBounds(player.getPos().getX(), player.getPos().getY() - 1)) {
                player.move(0, -1);
            }
        }
        // down
        if (command.toLowerCase().equals("s")) {
            if (!isOutOfBounds(player.getPos().getX(), player.getPos().getY() + 1)) {
                player.move(0, 1);
            }
        }
        // left
        if (command.toLowerCase().equals("a")) {
            if (!isOutOfBounds(player.getPos().getX() - 1, player.getPos().getY())) {
                player.move(-1, 0);
            }
        }
        // right
        if (command.toLowerCase().equals("d")) {
            if (!isOutOfBounds(player.getPos().getX() + 1, player.getPos().getY())) {
                player.move(1, 0);
            }
        }
    }

    private boolean isOutOfBounds(int x, int y) {
        return (x < 0) || (x > length - 1) || (y < 0) || (y > height - 1);
    }

}

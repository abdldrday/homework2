import java.util.Scanner;

public class MUDController {
    private final Player player;
    private boolean running;
    private final Scanner scanner;


    public MUDController(Player player) {
        this.player = player;
        this.running = true;
        this.scanner = new Scanner(System.in);
    }



    public void runGameLoop() {
        System.out.println("Type 'help' for commands.");
        while (running) {
            System.out.print("> ");
            String input = scanner.nextLine().trim().toLowerCase();
            handleInput(input);
        }
        System.out.println("Game Over");
    }


    public void handleInput(String input) {
        if (input.isEmpty()) return;

        String[] parts = input.split(" ", 2);
        String command = parts[0];
        String argument = parts.length > 1 ? parts[1] : "";

        switch (command) {
            case "look":
                lookAround();
                break;
            case "move":
                move(argument);
                break;
            case "pick":
                pickUp(argument);
                break;
            case "inventory":
                checkInventory();
                break;
            case "help":
                showHelp();
                break;
            case "quit":
                running = false;
                break;
            default:
                System.out.println("Unknown command.");
        }
    }

    private void lookAround() {
        System.out.println("You look around:");
    }

    private void move(String direction) {
        if (direction.isEmpty()) {
            System.out.println("Move where? (forward, back, left, right)");
            return;
        }
        System.out.println("You move " + direction + ".");
    }


    private void pickUp(String arg) {
        if (arg.isEmpty()) {
            System.out.println("Pick up what?");
            return;
        }
        System.out.println("You picked up " + arg + ".");
    }
    private void checkInventory() {
        System.out.println("Your inventory:");
        player.showInventory();
    }



    private void showHelp() {
        System.out.println("Available commands:");
        System.out.println("look");
        System.out.println("move <direction>");
        System.out.println("pick <item>");
        System.out.println("inventory");
        System.out.println("help");
        System.out.println("quit");
    }
}

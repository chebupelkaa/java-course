import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename = "data.txt";
        FileManager fileManager = new FileManager(filename);

        boolean running = true;
        while (running) {
            displayMenu();

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        List<String> content = fileManager.readFromFile();
                        if (content.isEmpty()) {
                            System.out.println("The file is empty");
                        } else {
                            System.out.println("Data:");
                            for (String line : content) {
                                System.out.println(line);
                            }
                        }
                        break;

                    case 2:
                        List<String> linesToAdd = readUserInput(scanner);
                        if (!linesToAdd.isEmpty()) {
                            fileManager.appendToFile(linesToAdd);
                        }
                        break;

                    case 3:
                        List<String> linesToWrite = readUserInput(scanner);
                        if (!linesToWrite.isEmpty()) {
                            fileManager.writeToFile(linesToWrite);
                        }
                        break;

                    case 4:
                        System.out.print("Are you sure you want to clear the file? (y/n): ");
                        String confirm = scanner.nextLine();
                        if ("y".equalsIgnoreCase(confirm)) {
                            fileManager.cleanFile();
                        } else {
                            System.out.println("Cleaning cancelled");
                        }
                        break;

                    case 5:
                        running = false;
                        System.out.println("Exit");
                        break;

                    default:
                        System.out.println("Incorrect choice, please select from 1 to 5");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please, enter number from 1 to 5");
            } catch (CustomException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Read from file");
        System.out.println("2. Add to file");
        System.out.println("3. Overwrite file");
        System.out.println("4. Clean file");
        System.out.println("5. Exit");
        System.out.print("Choose option: ");
    }

    private static List<String> readUserInput(Scanner scanner) {
        System.out.println("Enter text to add (type 'exit' to finish):");
        List<String> lines = new ArrayList<>();
        while (true) {
            String input = scanner.nextLine();
            if ("exit".equalsIgnoreCase(input)) {
                break;
            }
            lines.add(input);
        }
        return lines;
    }
}


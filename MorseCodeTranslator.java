/*
    Samarth Patel and shp5246@psu.edu.
    I declare that what has been written in this work has been written by me and that no
    part has been copied from scientific publications, the Internet or from other online
    sources or was already presented in the academic field by me or by other students.
*/
/*
Give user a choice if they want to convert text to morse or the other way around.
Define a method textToMorseCode to convert text to Morse code.
Take user input text.
Convert the text to uppercase.
If it's a space, append a space character to the Morse code string.
Use a switch-case statement to handle each character case and return its Morse code string.
And save it and ask user for the file name they want to save it for
Define a method textToMorseCode to convert text to Morse code.
Take user input Morse code.
Split the Morse code string by spaces to get individual Morse code characters.
If it's an empty string (indicating a space), append a space character to the text string.
Use a switch-case statement to handle each Morse code case and return its character.
Again svae it using hte same method and display it after asking the file name to user for its location
Exit
*/

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

public class MorseCodeTranslator {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Translate text to Morse code and save");
            System.out.println("2. Translate Morse code to text and save");
            System.out.println("3. Restore and display data from a file");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    translateAndSave(true); // true for text to Morse code
                    break;
                case 2:
                    translateAndSave(false); // false for Morse code to text
                    break;
                case 3:
                    restoreAndDisplay();
                    break;
                case 4:
                    System.out.println("Exiting the program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please select again.");
                    break;
            }
        }
    }
    //method for Translating and saving the result
    private static void translateAndSave(boolean isTextToMorse) {
        System.out.print("Enter " + (isTextToMorse ? "text" : "Morse code") + " to translate: ");
        String input = scanner.nextLine();
        String translated = isTextToMorse ? textToMorseCode(input) : MorseToText(input);
        System.out.println("Translated " + (isTextToMorse ? "Morse code: " : "text: ") + translated);
        System.out.print("Enter filename to save the translated data: ");
        String filename = scanner.nextLine();
        saveToFile(translated, filename);
    }
    // Method to display the results stored in files
    private static void restoreAndDisplay() {
        System.out.print("Enter the file name to restore from: ");
        String filename = scanner.nextLine();
        System.out.println("Data from file '" + filename + "':");
        System.out.println(restoreFromFile(filename));
    }
    // Method for saving it in file
    private static void saveToFile(String data, String filename) {
        try (PrintWriter out = new PrintWriter(filename)) {
            out.println(data);
            System.out.println("Data saved to " + filename);
        } catch (FileNotFoundException e) {
            System.err.println("Error saving to file: " + e.getMessage());
        }
    }

    private static String restoreFromFile(String filename) {
        StringBuilder data = new StringBuilder();
        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNextLine()) {
                data.append(fileScanner.nextLine()).append("\n");
            }
        } catch (FileNotFoundException e) {
            return "File not found: " + filename;
        }
        return data.toString();
    }

    public static String textToMorseCode(String text) {
        StringBuilder morseCode = new StringBuilder();

        for (char c : text.toUpperCase().toCharArray()) {
            if (c == ' ') {
                morseCode.append(" ");
                continue;
            }
            String code = textToMorseCode(c);
            if (code != null) {
                morseCode.append(code).append(" ");
            }
        }

        return morseCode.toString().trim();
    }
    // Translate individual characters to Morse code
    public static String textToMorseCode(char c) {
        switch (c) {
            case 'A':
                return "O_";
            case 'B':
                return "_OOO";
            case 'C':
                return "_O_O";
            case 'D':
                return "_OO";
            case 'E':
                return "O";
            case 'F':
                return "OO_O";
            case 'G':
                return "__O";
            case 'H':
                return "OOOO";
            case 'I':
                return "OO";
            case 'J':
                return "O___";
            case 'K':
                return "_O_";
            case 'L':
                return "O_OO";
            case 'M':
                return "__";
            case 'N':
                return "_O";
            case 'O':
                return "___";
            case 'P':
                return "O__O";
            case 'Q':
                return "__O_";
            case 'R':
                return "O_O";
            case 'S':
                return "OOO";
            case 'T':
                return "_";
            case 'U':
                return "OO_";
            case 'V':
                return "OOO_";
            case 'W':
                return "O__";
            case 'X':
                return "_OO_";
            case 'Y':
                return "_O__";
            case 'Z':
                return "__OO";
            case '1':
                return "O____";
            case '2':
                return "OO___";
            case '3':
                return "OOO__";
            case '4':
                return "OOOO_";
            case '5':
                return "OOOOO";
            case '6':
                return "_OOOO";
            case '7':
                return "__OOO";
            case '8':
                return "___OO";
            case '9':
                return "____O";
            case '0':
                return "_____";
            default:
                return null;
        }

    }
    // Translate Morse code to text
    public static String MorseToText(String code) {
        StringBuilder text = new StringBuilder();
        String[] morseCharacters = code.split(" "); // Split Morse code by spaces

        for (String MorseCode : morseCharacters) {
            if (MorseCode.equals("")) {
                // Handle space character
                text.append(" ");
            } else {
                char character = MorseCodeToText(MorseCode);
                text.append(character);
            }
        }

        return text.toString();
    }
    // Translate individual Morse code characters to text
    public static char MorseCodeToText(String code) {
        switch (code) {
            case "O_":
                return 'A';
            case "_OOO":
                return 'B';
            case "_O_O":
                return 'C';
            case "_OO":
                return 'D';
            case "O":
                return 'E';
            case "OO_O":
                return 'F';
            case "__O":
                return 'G';
            case "OOOO":
                return 'H';
            case "OO":
                return 'I';
            case "O___":
                return 'J';
            case "_O_":
                return 'K';
            case "O_OO":
                return 'L';
            case "__":
                return 'M';
            case "_O":
                return 'N';
            case "___":
                return 'O';
            case "O__O":
                return 'P';
            case "__O_":
                return 'Q';
            case "O_O":
                return 'R';
            case "OOO":
                return 'S';
            case "_":
                return 'T';
            case "OO_":
                return 'U';
            case "OOO_":
                return 'V';
            case "O__":
                return 'W';
            case "_OO_":
                return 'X';
            case "_O__":
                return 'Y';
            case "__OO":
                return 'Z';
            case "O____":
                return '1';
            case "OO___":
                return '2';
            case "OOO__":
                return '3';
            case "OOOO_":
                return '4';
            case "OOOOO":
                return '5';
            case "_OOOO":
                return '6';
            case "__OOO":
                return '7';
            case "___OO":
                return '8';
            case "____O":
                return '9';
            case "_____":
                return '0';
            default:
                return ' ';
        }
    }


}



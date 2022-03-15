package essentials.interaction;

import java.util.Scanner;

/**
 * Класс для получения данных из скрипта
 */
public class ScriptInteraction implements UserInteraction{


    private final Scanner scanner;


    public ScriptInteraction(Scanner scanner) {
        this.scanner = scanner;
    }


    @Override
    public void print(boolean newLine, String message) {
        new ConsoleInteraction().print(newLine, message);
    }

    @Override
    public String getData() {
        return scanner.nextLine();
    }
}

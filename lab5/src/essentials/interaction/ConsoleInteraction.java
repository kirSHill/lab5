package essentials.interaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

/**
 * Класс для получения данных из консоли
 */
public class ConsoleInteraction implements UserInteraction {


    @Override
    public void print(boolean newLine, String message) {
        if (newLine) {
            System.out.println(message);
        } else {
            System.out.print(message);
        }
    }

    @Override
    public String getData() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
                } catch (IOException | NoSuchElementException e) {
            try {
                System.in.reset();
            } catch (IOException ex) {
                print(true, "Завершение работы");
                return "exit";
            }
            return "";
        }
    }
}

package essentials.commands;

import elements.City;
import essentials.Commander;
import essentials.interaction.ScriptInteraction;
import essentials.interaction.UserInteraction;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ExecuteScript implements Command{


    private final UserInteraction interaction;
    private final String argument;
    private final LocalDateTime creationDate;
    private final LocalDateTime initDate;
    private final File file;


    public ExecuteScript(UserInteraction interaction, ArrayList<String> args, LocalDateTime creationDate, LocalDateTime initDate, File file) {
        this.interaction = interaction;
        this.argument = args.get(0);
        this.creationDate = creationDate;
        this.initDate = initDate;
        this.file = file;
    }


    @Override
    public boolean execute(PriorityQueue<City> collection) throws Exception {
        File fileScript = new File(argument);
        Scanner fileScanner;

        try {
            fileScanner = new Scanner(fileScript);
        } catch (FileNotFoundException e) {
            interaction.print(true,"Введённого файла не существует.");
            return true;
        }
        int lineNum = 1;
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            if (line.equals("executeScript script.txt")) {
                interaction.print(true, "Запрещено выполнять скрипт из другого скрипта!");
                return true;
            }
            try {
                Command command = Commander.proceedCommand(line, true, new ScriptInteraction(fileScanner), creationDate, initDate, file);
                if (command == null) {
                    continue;
                }
                command.execute(collection);
            } catch (Exception e) {
                interaction.print(true,"Возникла ошибка при выполнении " + lineNum + " строки:\n" + line);
                break;
            }
            lineNum++;
        }
        return true;
    }
}

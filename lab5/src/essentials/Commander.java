package essentials;

import elements.City;
import essentials.commands.*;
import essentials.commands.Help;
import essentials.commands.Info;
import essentials.interaction.UserInteraction;
import java.io.File;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.PriorityQueue;

public abstract class Commander {


    private static PriorityQueue<City> collection = new PriorityQueue<>();


    /**
     * Метод работы с вводимыми пользователем командами
     */
    public static Command proceedCommand(String potencialCommand, boolean fromScript, UserInteraction interaction, LocalDateTime creationDate, LocalDateTime initDate, File file) {
        potencialCommand = potencialCommand.trim();
        String[] commandParts = potencialCommand.split("\\s+");
        String command = commandParts[0];
        ArrayList<String> args = new ArrayList<>();
        for (int i = 1; i < commandParts.length; i++) {
            String arg = commandParts[i].replaceAll("\\s+", "");
            if (!arg.isEmpty()) {
                args.add(arg);
            }
        }


        switch (command) {
            case "help":
                return new Help(interaction);
            case "info":
                return new Info(interaction, initDate);
            case "show":
                return new Show(interaction);
            case "add":
                return new Add(interaction, fromScript, 0, collection);
            case "save":
                return new Save(interaction, creationDate, file);
            case "clear":
                return new Clear(interaction);
            case "removeById":
                if(args.size() == 0) {
                    interaction.print(true, "Отсутствуют необходимые параметры.");
                    return null;
                }
                return new RemoveById(interaction, args);
            case "updateId":
                if(args.size() == 0) {
                    interaction.print(true, "Отсутствуют необходимые параметры.");
                    return null;
                }
                return new UpdateId(interaction, args, collection);
            case "executeScript":
                if (args.size() == 0) {
                    interaction.print(true, "Отстутствуют необходимые параметры.");
                    return null;
                }
                return new ExecuteScript(interaction, args, creationDate, initDate, file);
            case "exit":
                return new Exit();
            case "removeFirst":
                return new RemoveFirst(interaction);
            case "head":
                return new Head(interaction);
            case "addIfMin":
                return new AddIfMin(interaction, fromScript, 0, collection);
            case "countByClimate":
                if (args.size() == 0) {
                    interaction.print(true, "Отсутствуют необходимые параметры.");
                    return null;
                }
                return new CountByClimate(interaction, args);
            case "countGreaterThanGovernment":
                if (args.size() == 0) {
                    interaction.print(true, "Отсутствуют необходимые параметры.");
                    return null;
                }
                return new CountGreaterThanGovernment(interaction, args);
            case "printDescending":
                return new PrintDescending(interaction);
            default:
                interaction.print(true,"Команды '" + command + "' не существует. " +
                        "Воспользуйтесь 'help' для получения списка команд.");
                return null;
        }
    }
}

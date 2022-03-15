package essentials.commands;

import elements.City;
import essentials.interaction.UserInteraction;
import java.util.PriorityQueue;

public class Help implements Command {


    private final UserInteraction interaction;


    public Help(UserInteraction interaction) {
        this.interaction = interaction;
    }


    @Override
    public boolean execute(PriorityQueue<City> collection) {
        interaction.print(true, "Cправка по доступным командам: \n" +
                "help: вывести справку по доступным командам \n" +
                "info: вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов) \n" +
                "show: вывести в стандартный поток вывода все элементы коллекции в строковом представлении \n" +
                "add: добавить новый элемент в коллекцию \n" +
                "updateId {id}: обновить значение элемента коллекции, id которого равен заданному \n" +
                "removeById {id}: удалить элемент из коллекции по его id \n" +
                "clear: очистить коллекцию \n" +
                "save: сохранить коллекцию в файл \n" +
                "executeScript {file_name}: считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме. \n" +
                "exit: завершить программу (без сохранения в файл) \n" +
                "removeFirst: удалить первый элемент из коллекции \n" +
                "head: вывести первый элемент коллекции \n" +
                "addIfMin: добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции \n" +
                "countByClimate {climate}: вывести количество элементов, значение поля climate которых равно заданному \n" +
                "countGreaterThanGovernment {government}: вывести количество элементов, значение поля government которых больше заданного \n" +
                "printDescending: вывести элементы коллекции в порядке убывания \n" + "\n");
        return true;
    }
}

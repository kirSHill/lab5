package essentials.commands;

import elements.City;
import essentials.interaction.UserInteraction;
import java.time.LocalDateTime;
import java.util.PriorityQueue;

public class Info implements Command {


    private final UserInteraction interaction;
    private final LocalDateTime initDate;


    public Info(UserInteraction interaction, LocalDateTime initDate) {
        this.interaction = interaction;
        this.initDate = initDate;
    }


    @Override
    public boolean execute(PriorityQueue<City> collection) {
        interaction.print(true, "Информация о коллекции: \n" +
                "Тип: " + City.class.getName() + "\n" +
                "Дата инициализации: " + initDate + "\n" +
                "Количество элементов: " + collection.size() + "\n");
        return true;
    }
}

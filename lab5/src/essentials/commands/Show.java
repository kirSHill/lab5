package essentials.commands;

import elements.City;
import essentials.interaction.UserInteraction;
import java.util.PriorityQueue;

public class Show implements Command {


    private final UserInteraction interaction;


    public Show(UserInteraction interaction) {
        this.interaction = interaction;
    }


    @Override
    public boolean execute(PriorityQueue<City> collection) {
        if (collection.size() == 0) {
            interaction.print(true, "В коллекции нет элементов.");
        } else {
            interaction.print(true, "Всего: " + collection.size() + "\nВсе элементы коллекции: ");
            for (City city : collection) {
                interaction.print(true, city.toString());
            }
        }
        return true;
    }
}

package essentials.commands;

import elements.City;
import essentials.interaction.UserInteraction;
import java.util.PriorityQueue;

public class RemoveFirst implements Command{


    private final UserInteraction interaction;


    public RemoveFirst(UserInteraction interaction) {
        this.interaction = interaction;
    }


    @Override
    public boolean execute(PriorityQueue<City> collection) throws Exception {
        if (collection.size() == 0) {
            interaction.print(true,"В коллекции нет элементов.");
        } else {
            collection.remove();
            interaction.print(true,"Первый элемент коллекции удалён.");
        }
        return true;
    }
}

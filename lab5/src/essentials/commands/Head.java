package essentials.commands;

import elements.City;
import essentials.interaction.UserInteraction;
import java.util.PriorityQueue;

public class Head implements Command{


    private final UserInteraction interaction;


    public Head(UserInteraction interaction) {
        this.interaction = interaction;
    }


    @Override
    public boolean execute(PriorityQueue<City> collection) throws Exception {
        interaction.print(true,"Первый элемент коллекции: \n" + collection.peek());
        return true;
    }
}

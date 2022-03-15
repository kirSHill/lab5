package essentials.commands;

import elements.City;
import essentials.interaction.UserInteraction;
import java.util.PriorityQueue;

public class Clear implements Command{


    private final UserInteraction interaction;


    public Clear(UserInteraction interaction) {
        this.interaction = interaction;
    }


    @Override
    public boolean execute(PriorityQueue<City> collection) throws Exception {
        collection.clear();
        interaction.print(true, "Коллекция очищена. \n");
        return true;
    }
}

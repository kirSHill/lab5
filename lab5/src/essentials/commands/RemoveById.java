package essentials.commands;

import elements.City;
import essentials.interaction.UserInteraction;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class RemoveById implements Command,ById{


    private final UserInteraction interaction;
    private final String argument;


    public RemoveById(UserInteraction interaction, ArrayList<String> args) {
        this.interaction = interaction;
        this.argument = args.get(0);
    }


    @Override
    public boolean execute(PriorityQueue<City> collection) throws Exception {
        search(interaction, collection, argument);
        return true;
    }


}

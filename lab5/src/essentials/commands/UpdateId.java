package essentials.commands;

import elements.City;
import essentials.interaction.UserInteraction;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class UpdateId implements Command, ById{


    private final UserInteraction interaction;
    private final PriorityQueue<City> collection;
    private final String argument;


    public UpdateId(UserInteraction interaction, ArrayList<String> args, PriorityQueue<City> collection) {
        this.interaction = interaction;
        this.argument = args.get(0);
        this.collection = collection;
    }


    @Override
    public boolean execute(PriorityQueue<City> collection) throws Exception {
        search(interaction, collection, argument);
        return true;
    }


    @Override
    public void remove(UserInteraction interaction, PriorityQueue<City> collection, String argument) throws Exception {
        int size = collection.size() + 1;
        PriorityQueue<City> helper = new PriorityQueue<>();
        City city;

        for (int i = 1; i < size; i++) {
            city = collection.remove();
            if (city.getId() != Integer.parseInt(argument)) {
                helper.add(city);
            } else {
                break;
            }
        }
        Add add = new Add(interaction, false, Integer.parseInt(argument), collection);
        add.execute(collection);
        for (City cityy : helper) {
            while (!helper.isEmpty()) {
                cityy = helper.remove();
                collection.add(cityy);
            }
        }
        interaction.print(true,"Элемент с id " + argument + " был заменён.");

    }
}

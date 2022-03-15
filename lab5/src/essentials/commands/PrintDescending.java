package essentials.commands;

import elements.City;
import essentials.interaction.UserInteraction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class PrintDescending implements Command{


    private final UserInteraction interaction;


    public PrintDescending(UserInteraction interaction) {
        this.interaction = interaction;
    }


    @Override
    public boolean execute(PriorityQueue<City> collection) throws Exception {
        ArrayList<City> reverse = new ArrayList<>(collection);
        Collections.reverse(reverse);
        for (City city : reverse) {
            interaction.print(true, city.toString());
        }
        return true;
    }
}

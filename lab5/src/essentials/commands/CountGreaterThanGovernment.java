package essentials.commands;

import elements.City;
import elements.Government;
import essentials.interaction.UserInteraction;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class CountGreaterThanGovernment implements Command{


    private final UserInteraction interaction;
    private final String argument;


    public CountGreaterThanGovernment(UserInteraction interaction, ArrayList<String> args) {
        this.interaction = interaction;
        this.argument = args.get(0);
    }


    @Override
    public boolean execute(PriorityQueue<City> collection) throws Exception {
        Government government = Government.getByName(argument);
            int count = 0;
            interaction.print(true,"Список городов, значение правительства в которых больше введённого: ");
            for (City city : collection) {
                if (city.getGovernment().toString().length() > government.toString().length()) {
                    count++;
                    interaction.print(true,count + ". " + city.getName());
                }
            }
        return true;
    }
}

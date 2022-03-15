package essentials.commands;

import elements.City;
import elements.Climate;
import essentials.interaction.UserInteraction;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class CountByClimate implements Command{


    private final UserInteraction interaction;
    private final String argument;


    public CountByClimate(UserInteraction interaction, ArrayList<String> args) {
        this.interaction = interaction;
        this.argument = args.get(0);
    }


    @Override
    public boolean execute(PriorityQueue<City> collection) throws Exception {
        Climate climate = Climate.getByName(argument);
        int count = 0;
        interaction.print(true, "Список городов, значение климата в которых равно введённому: ");
        for (City city : collection) {
            if (city.getClimate().equals(climate)) {
                count++;
                interaction.print(true,count + ". " + city.getName());
            }
        }
        return true;
    }
}

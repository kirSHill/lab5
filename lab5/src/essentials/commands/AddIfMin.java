package essentials.commands;

import elements.City;
import essentials.interaction.UserInteraction;
import java.util.PriorityQueue;

public class AddIfMin extends Add implements Command{


    private final UserInteraction interaction;
    private final boolean fromScript;
    private final int update;
    private final PriorityQueue<City> collection;


    public AddIfMin(UserInteraction interaction, boolean fromScript, int update, PriorityQueue<City> collection) {
        super(interaction, fromScript, update, collection);
        this.interaction = interaction;
        this.fromScript = fromScript;
        this.update = update;
        this.collection = collection;
    }


    @Override
    public boolean execute(PriorityQueue<City> collection) throws Exception {
        City city = createCity(interaction, fromScript, update, collection);
        if (city.getPopulation() < collection.peek().getPopulation()) {
            collection.add(city);
            interaction.print(true, "В введённом Вами городе население ниже, чем в минимальном элементе коллекции, поэтому элемент добавлен в коллекцию.");
        } else {
            interaction.print(true, "В введённом Вами городе население выше, чем в минимальном элементе коллекции. Выберите другое значение. (начните с 'addIfMin')");
        }
        return true;
    }
}

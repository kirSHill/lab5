package essentials.commands;

import elements.City;
import essentials.interaction.UserInteraction;
import java.util.PriorityQueue;

public interface ById {

    default void search(UserInteraction interaction, PriorityQueue<City> collection, String argument) throws Exception {
        int count = 0;

        for (City cityy : collection) {
            if (cityy.getId() == Integer.parseInt(argument)) {
                count++;
            }
        }
        switch(count) {
            case 0:
                interaction.print(true,"Элемент с id " + argument + " отсутствует в коллекции. \nВоспользуйтесь 'show' для просмотра всех элементов коллекции.");
                break;
            case 1:
                remove(interaction, collection, argument);
                break;
            default:
                interaction.print(true,"В коллекции несколько элементов с одинаковыми id.");
                break;
        }
    }

    default void remove(UserInteraction interaction, PriorityQueue<City> collection, String argument) throws Exception {
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
        for (City cityy : helper) {
            while (!helper.isEmpty()) {
                cityy = helper.remove();
                collection.add(cityy);
            }
        }
        interaction.print(true,"Элемент с id " + argument + " был удалён из коллекции.");

    }
}

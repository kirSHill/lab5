package essentials.commands;

import elements.City;
import java.util.PriorityQueue;

public interface Command {
    boolean execute(PriorityQueue<City> collection) throws Exception;
}

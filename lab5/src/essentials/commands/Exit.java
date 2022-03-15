package essentials.commands;

import elements.City;
import java.util.PriorityQueue;

public class Exit implements Command{


    public Exit() {}


    @Override
    public boolean execute(PriorityQueue<City> collection) throws Exception {
        return false;
    }
}

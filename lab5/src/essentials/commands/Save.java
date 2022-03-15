package essentials.commands;

import elements.City;
import elements.QueueInfo;
import essentials.Xml;
import essentials.interaction.UserInteraction;
import java.io.File;
import java.time.LocalDateTime;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.PriorityQueue;

public class Save implements Command{


    private final UserInteraction interaction;
    private final LocalDateTime creationDate;
    private final File file;


    public Save(UserInteraction interaction, LocalDateTime creationDate, File file) {
        this.interaction = interaction;
        this.creationDate = creationDate;
        this.file = file;
    }


    @Override
    public boolean execute(PriorityQueue<City> collection) throws Exception {
            try {
                BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file));
                fileWriter.write(Xml.toXml(new QueueInfo(collection, City.getMaxId(), creationDate)));
                fileWriter.flush();
            } catch (Exception e) {
                interaction.print(true,"Возникла ошибка при сохранении в файл: " + e.getMessage());
                return true;
            }
        interaction.print(true, "Файл успешно сохранён.");
        return true;
    }
}

package essentials;

import elements.City;
import elements.QueueInfo;
import essentials.commands.*;
import essentials.interaction.ConsoleInteraction;
import essentials.interaction.UserInteraction;
import java.io.*;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Главный класс программы
 * @author kirSHill
 * @version 2.0
 */
public class Main {

    /**
     * Поля класса
     */
    private static PriorityQueue<City> collection;
    private static LocalDateTime creationDate;
    private static LocalDateTime initDate;
    private static File file;
    private final static UserInteraction interaction = new ConsoleInteraction();

    public static void main(String[] args) throws Exception {
        if (System.getenv("FILE_LOC") != null && !System.getenv("FILE_LOC").trim().isEmpty()) {
            file = new File(System.getenv("FILE_LOC"));
            if (!prepare()) {
                return;
            }
            runInteraction(QueueInfo.getCollection());
        } else {
            interaction.print(true, "Не найдена переменная окружения FILE_LOC или не задано имя файла.");
        }
    }

    public static void uploadInformation() throws FileNotFoundException, NoSuchFieldException, IllegalAccessException {
        QueueInfo queueInfo = Xml.fromXml(file);
        collection = Objects.requireNonNull(queueInfo).getCollection();
        creationDate = queueInfo.getCreationDate();
        Field field = City.class.getDeclaredField("maxId");
        field.setAccessible(true);
        field.setInt(null, queueInfo.getMaxId());
    }

    public static boolean prepare() {
        try {
            uploadInformation();
            initDate = LocalDateTime.now();
        } catch (FileNotFoundException | NoSuchFieldException | IllegalAccessException | NullPointerException e) {
            interaction.print(true, "Возникли проблемы при обработке файла. Данные не считаны.");
            creationDate = LocalDateTime.now();
            City.setMaxId(0);
        }
        BufferedWriter fileWriter;
        try {
            fileWriter = new BufferedWriter(new FileWriter(file, true));
            fileWriter.close();
        } catch (IOException e) {
            interaction.print(true, "Файл не может быть создан, недостаточно прав доступа или формат имени файла неверен.");
            interaction.print(true, "Сообщение об ошибке: " + e.getMessage());
            return false;
        }
        return true;
    }

    private static void runInteraction(PriorityQueue<City> collection) throws Exception{

        interaction.print(true, "Здравствуйте! Вы запустили консольное приложение для работы с коллекциями. Введите 'help', чтобы увидеть список команд: ");
        boolean run = true;
        while (run) {
            interaction.print(false, "\nВведите команду: ");
            String potentialCommand = interaction.getData();
            if (potentialCommand == null) {
                continue;
            }
            Command command = Commander.proceedCommand(potentialCommand, false, interaction, creationDate, initDate, file);
            if (command != null) {
                run = command.execute(collection);
            }
        }
    }
}






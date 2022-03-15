package essentials;

import elements.*;
import essentials.interaction.UserInteraction;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.PriorityQueue;
import java.util.Scanner;


/**
 * Класс работы с файлом xml
 */
public abstract class Xml {


    /**
     * Конвертация коллекции в xml
     * @param queueInfo - информация о коллекции
     * @return - коллекция в формате xml
     */
    public static String toXml(QueueInfo queueInfo) {
        StringBuilder fileString = new StringBuilder();
        for (City xmlConvertable : queueInfo.getCollection()) {
            fileString.append(xmlConvertable.convertToXmlString());
        }

        fileString = new StringBuilder(String.format("<element-list>%s</element-list>", fileString));
        fileString = new StringBuilder(String.format("<creation-date>%s</creation-date>%s", queueInfo.getCreationDate(), fileString));
        fileString = new StringBuilder(String.format("<max-id>%d</max-id>%s", queueInfo.getMaxId(), fileString));
        fileString = new StringBuilder(String.format("<collection>%s</collection>", fileString));

        return fileString.toString();
    }

    /**
     * Создание тэгов для xml
     * @param xmlCode - значение поля xmlCode
     * @param tag - значение поля tag
     * @return тэг
     */
    private static boolean tagExists(String xmlCode, String tag) {
        int startIndex = xmlCode.indexOf(String.format("<%s>", tag));
        int endIndex = xmlCode.indexOf(String.format("</%s>", tag));
        return !(startIndex == -1 || endIndex == -1);
    }

    /**
     * Присвоение полю значения из xml
     * @param xmlCode - значение поля xmlCode
     * @param tag - значение поля tag
     * @return - значение поля
     * @throws Exception - исключение при неверном вводе тэга
     */
    private static String parseTagFirst(String xmlCode, String tag) throws Exception {
        int startIndex = xmlCode.indexOf(String.format("<%s>", tag));
        int endIndex = xmlCode.indexOf(String.format("</%s>", tag));
        if (startIndex == -1 || endIndex == -1) {
            throw new Exception("Неверный формат файла, или тега не существует.");
        }
        return xmlCode.substring(startIndex + String.format("<%s>", tag).length(), endIndex);
    }

    /**
     * Удаление текущей строки
     * @param xmlCode - значение поля xmlCode
     * @param tag - значение поля tag
     * @return - xmlCode без текущей строки
     * @throws Exception - исключение при неверном вводе тэга
     */
    private static String deleteTagFirst(String xmlCode, String tag) throws Exception {
        int startIndex = xmlCode.indexOf(String.format("<%s>", tag));
        int endIndex = xmlCode.indexOf(String.format("</%s>", tag));
        if (startIndex == -1 || endIndex == -1) {
            throw new Exception("Неверный формат файла, или тега не существует.");
        }
        return xmlCode.substring(endIndex + String.format("</%s>", tag).length());
    }

    /**
     * Парсинг коллекции из xml
     * @param xmlCode - значеие поля xmlCode
     * @return - коллекция
     */
    public static QueueInfo fromXml(String xmlCode) {
        xmlCode = xmlCode.replaceAll("\\s+", "");
        QueueInfo queueInfo;
        try {
            LocalDateTime creationDate = LocalDateTime.parse(parseTagFirst(xmlCode, "creation-date"));
            int maxId = Integer.parseInt(parseTagFirst(xmlCode, "max-id"));
            PriorityQueue<City> collection = new PriorityQueue<>();
            String arrayCode = parseTagFirst(xmlCode, "element-list");
            while (tagExists(arrayCode, "city")) {
                String cityCode = parseTagFirst(arrayCode, "city");
                int id = Integer.parseInt(parseTagFirst(cityCode, "id"));
                Climate climate = Climate.getByName(parseTagFirst(cityCode, "climate"));
                Government government = Government.getByName(parseTagFirst(cityCode, "government"));
                String name = parseTagFirst(cityCode, "name");
                int population = Integer.parseInt(parseTagFirst(cityCode, "population"));
                int area = Integer.parseInt(parseTagFirst(cityCode, "area"));
                int masl = Integer.parseInt(parseTagFirst(cityCode, "meters-above-sea-level"));
                boolean capital = Boolean.parseBoolean(parseTagFirst(cityCode, "capital"));
                Long x = Long.parseLong(parseTagFirst(cityCode, "coordinate-x"));
                int y = Integer.parseInt(parseTagFirst(cityCode, "coordinate-y"));
                String nameG = parseTagFirst(cityCode, "nameG");
                Long age = Long.parseLong(parseTagFirst(cityCode, "age"));
                double height = Double.parseDouble(parseTagFirst(cityCode, "height"));
                Human governor = new Human(nameG, age, height);


                City city = new City();
                city.setId(id);
                city.setClimate(climate);
                city.setGovernment(government);
                city.setName(name);
                city.setPopulation(population);
                city.setCapital(capital);
                city.setMetersAboveSeaLevel(masl);
                city.setArea(area);
                city.setCoordinates(x, y);
                city.setGovernor(governor);

                collection.add(city);

                arrayCode = deleteTagFirst(arrayCode, "city");

            }

            queueInfo = new QueueInfo(collection, maxId, creationDate);
        } catch (Exception e) {
            return null;
        }
        return queueInfo;
    }

    public static QueueInfo fromXml(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(file));
        StringBuilder xml = new StringBuilder();
        while (scanner.hasNextLine()) {
            xml.append(scanner.nextLine());
        }
        return Xml.fromXml(xml.toString());
    }
}
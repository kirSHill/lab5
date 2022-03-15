package elements;

import java.time.LocalDateTime;
import java.util.PriorityQueue;

/**
 * Класс информации о коллекции для xml
 */
public class QueueInfo {


    /**
     * Поля класса
     */
    private static PriorityQueue<City> collection;
    private final int maxId;
    private final LocalDateTime creationDate;


    /**
     * Конструктор класса
     * @param collection - значение поля collection
     * @param maxId - значение поля maxId
     * @param creationDate - значение поля creationDate
     * @throws Exception - исключение о пустых полях класса
     */
    public QueueInfo(PriorityQueue<City> collection, int maxId, LocalDateTime creationDate) throws Exception {
            if (collection != null && maxId != 0 && creationDate != null) {
                this.collection = collection;
                this.maxId = maxId;
                this.creationDate = creationDate;
            } else {
                throw new Exception("Параметры не могут быть null.");
            }
        }


    /**
     * Получение коллекции
     * @return - коллекция
     */
    public static PriorityQueue<City> getCollection() {
        return collection;
    }
    /**
     * Получение maxId
     * @return - максимальный id в коллекции
     */
    public int getMaxId() {
        return maxId;
    }
    /**
     * Получение даты создания
     * @return - дата создания файла
     */
    public LocalDateTime getCreationDate() {
        return creationDate;
    }
}


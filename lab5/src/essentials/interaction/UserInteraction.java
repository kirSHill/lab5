package essentials.interaction;

/**
 * Интерфейс для получения информации от пользователя
 */
public interface UserInteraction {
    void print(boolean newLine, String message);
    String getData();
}

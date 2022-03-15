package elements;

import java.util.Objects;

/**
 * enum форма правления
 */
public enum Government {


    GERONTOCRACY("геронтократия"),
    THALASSOCRACY("талассократия"),
    THEOCRACY("теократия"),
    TECHNOCRACY("технократия");


    /**
     * Поле класса
     */
    private final String name;


    /**
     * Конструктор класса
     * @param name - значение поля name
     */
    Government(String name) {
        this.name = name;
    }


    /**
     * Получение значения формы правления
     * @param name - значение поля name
     * @return - значение формы правления
     */
    public static Government getByName(String name) {
        for (Government government : Government.values()) {
            if (Objects.equals(government.name, name)) {
                return government;
            }
        }
        return null;
    }


    /**
     * Переопределение метода toString
     * @return - название формы правления
     */
    @Override
    public String toString() {
        return this.name;
    }
}


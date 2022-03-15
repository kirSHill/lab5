package elements;

import java.util.Objects;

/**
 * enum климат
 */
public enum Climate {


    MONSOON("дождливый"),
    HUMIDSUBTROPICAL("влажный субтропический"),
    HUMIDCONTINENTAL("влажный континентальный"),
    STEPPE("степенной"),
    SUBARCTIC("субарктический");


    /**
     * Поле класса
     */
    private final String name;


    /**
     * Конструктор климата
     * @param name - значение поля name
     */
    Climate(String name) {
        this.name = name;
    }

    /**
     * Получение значения климата
     * @param name - значение поля name
     * @return - климат
     */
    public static Climate getByName(String name) {
        for (Climate climate : Climate.values()) {
            if (Objects.equals(climate.name, name)) {
                return climate;
            }
        }
        return null;
    }


    /**
     * Переопределение метода toString
     * @return - название enum
     */
    @Override
    public String toString() {
        return this.name;
    }
}

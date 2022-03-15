package elements;

/**
 * Класс координат
 */
public class Coordinates {


    /**
     * Поля класса
     */
    private Long x; //Значение поля должно быть больше -834, Поле не может быть null
    private int y; //Максимальное значение поля: 904


    /**
     * Конструктор класса
     * @param x - значение поля x
     * @param y - значение поля y
     * @throws Exception - исключение о недопустимом формате полей x и y
     */
    public Coordinates(Long x, int y) throws Exception {
        setX(x);
        setY(y);
    }


    /**
     * Установка новой координаты x
     *
     * @param x - значение поля x
     */
    public void setX(Long x) throws Exception {
        if (x == null) {
            throw new Exception("Координата x не может быть null!");
        } else if (x <= -834) {
            throw new Exception("Координата x не может быть меньше -834!");
        } else
            this.x = x;
    }

    /**
     * Установка новой координаты y
     *
     * @param y - значение поля y
     */
    public void setY(int y) throws Exception {
        if (y > 904) {
            throw new Exception("Координата y не может быть больше 904!");
        } else
            this.y = y;
    }


    /**
     * Получение координаты x
     * @return - значение поля x
     */
    public Long getX() {
        return this.x;
    }
    /**
     * Получение координаты y
     * @return - значение поля y
     */
    public int getY() {
        return this.y;
    }


    /**
     * Переопределение метода toString
     * @return - значения полей x и y
     */
    @Override
    public String toString() {
        return x + " " + y;
    }
}


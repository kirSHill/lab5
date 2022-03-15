package elements;

import essentials.interaction.UserInteraction;

/**
 * Класс губернатора
 */
public class Human {


    /**
     * Поля класса
     */
    private String nameG; //Поле не может быть null, Строка не может быть пустой
    private Long age; //Значение поля должно быть больше 0
    private double height; //Значение поля должно быть больше 0

    /**
     * Конструктор класса
     * @param nameG - значение поля nameG
     * @param age - значение поля age
     * @param height - значение поля height
     */
    public Human(String nameG, Long age, double height) throws Exception {
        setNameG(nameG);
        setAge(age);
        setHeight(height);
    }

    public Human() {
    }


    /**
     * Установка имени
     * @param nameG - значение поля name
     */
    public void setNameG(String nameG) throws Exception {
        if (nameG.equals(null)) {
            throw new Exception("Поле nameG не может быть null!");
        } else if (nameG.equals("")) {
            throw new Exception("Поле nameG не может быть пустой строкой!");
        } else {
            this.nameG = nameG;
        }
    }
    /**
     * Установка возраста
     *
     * @param age - значение поля age
     */
    public void setAge(Long age) throws Exception {
        if (age <= 0) {
            throw new Exception("Поле age не может быть меньше или равно 0!");
        } else {
            this.age = age;
        }
    }
    /**
     * Установка роста
     *
     * @param height - значение поля height
     */
    public void setHeight(double height) throws Exception {
        if (height <= 0) {
            throw new Exception("Поле height не может быть меньше или равно 0!");
        } else {
            this.height = height;
        }
    }


    /**
     * Получение имени губернатора
     * @return - имя губернатора
     */
    public String getNameG() {
        return nameG;
    }
    /**
     * Получение возраста губернатора
     * @return - возраст губернатора
     */
    public Long getAge() {
        return age;
    }
    /**
     * Получение роста губернатора
     * @return - рост губернатора
     */
    public double getHeight() {
        return height;
    }


    /**
     * Переопределение метода toString
     * @return - поля класса Human
     */
    @Override
    public String toString() {
        return this.nameG + ", " + this.age + ", " + this.height;
    }
}
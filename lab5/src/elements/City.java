package elements;

import essentials.XmlConvertable;
import java.time.LocalDate;

/**
 * Класс город
 * @author kirSHill
 * @version 1.0
 */
public class City implements Comparable<City>, XmlConvertable {

    /**
     * Описание полей класса
     */
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private static int maxId = 0;
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int area; //Значение поля должно быть больше 0
    private int population; //Значение поля должно быть больше 0
    private int metersAboveSeaLevel; //Значение поля должно быть больше 0
    private boolean capital;
    private Climate climate; //Поле может быть null
    private Government government; //Поле может быть null
    private Human governor; //Поле может быть null

    /**
     * Конструктор класса для добавления в коллекцию
     * @param id - значение поля id
     * @param name - значение поля name
     * @param coordinates - значение поля coordinates
     * @param area - значение поля area
     * @param population - значение поля population
     * @param masl - значение поля masl
     * @param isCapital - значение поля isCapital
     * @param climate - значение поля climate
     * @param government - значение поля government
     * @param governor - значение поля governor
     * @throws Exception - исключения, связанные со значениями полей
     */
    public City(Integer id, String name, Coordinates coordinates, int area, int population, int masl, boolean isCapital, Climate climate, Government government, Human governor) throws Exception {
        setId(id);
        setName(name);
        setArea(area);
        setCapital(isCapital);
        setClimate(climate);
        setCoordinates(coordinates);
        setGovernment(government);
        setGovernor(governor);
        setMetersAboveSeaLevel(masl);
        setPopulation(population);
    }

    /**
     * Конструктор класса для управления командами
     */
    public City() {}


    /**
     * Установка id
     */
    public void setId() {
        if (this.id == null) {
            maxId++;
            this.id = maxId;

        }
    }
    /**
     * Установка id
     * @param id - значение поля id
     */
    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            setId();
        }
    }
    /**
     * Установка maxId
     * @param newMaxId - значение поля newMaxId
     */
    public static void setMaxId(int newMaxId) {
        maxId = newMaxId;
    }
    /**
     * Установка нового имени
     * @param name - значение поля name
     */
    public void setName(String name) throws Exception {
        if (name == null) {
            throw new Exception("Поле name не может быть null!");
        } else if (name.equals("")) {
            throw new Exception("Поле name не может быть пустой строкой!");
        }
        this.name = name;
    }
    /**
     * Установка новых координат
     * @param coordinates  - значение поля coordinates
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;

    }
    /**
     * Установка новых координат
     * @param x - значение поля x
     * @param y - значение поля y
     * @throws Exception - исключение, связанное с недопустимым значением координат
     */
    public void setCoordinates(Long x, int y) throws Exception {
        this.coordinates = new Coordinates(x, y);
    }
    /**
     * Установка даты
     */
    public void setCreationDate() {
        this.creationDate = LocalDate.now();
    }
    /**
     * Установка новой площади
     * @param area - значение поля area
     */
    public void setArea(int area) throws Exception{
        if (area <= 0) {
            throw new Exception("Поле area не может быть меньше или равно 0!");
        }
            this.area = area;
    }
    /**
     * Установка численности населения
     * @param population - значение поля population
     */
    public void setPopulation(int population) throws Exception {
        if (population <= 0) {
            throw new Exception("Поле population не может быть меньше или равно 0!");
        }
            this.population = population;
    }
    /**
     * Установка значения высоты над уровнем моря
     * @param masl - значение поля metersAboveSeaLevel
     */
    public void setMetersAboveSeaLevel(int masl) {
            this.metersAboveSeaLevel = masl;
        }
    /**
     * Установка столицы
     * @param isCapital - значение поля capital
     */
    public void setCapital(boolean isCapital) {
        this.capital = isCapital;
    }
    /**
     * Установка климата
     * @param climate - значение поля climate
     */
    public void setClimate(Climate climate) {
        if (climate != null) {
            this.climate = climate;
        }
    }
    /**
     * Установка правительства
     * @param government - значение поля government
     */
    public void setGovernment(Government government) {
        this.government = government;
    }
    /**
     * Установка губернатора
     * @param governor - значение поля governor
     */
    public void setGovernor(Human governor) {
        this.governor = governor;
    }


    /**
     * Получение id
     * @return - значение поля id
     */
    public Integer getId() {return this.id;}
    /**
     * Получение maxId
     * @return - значение поля maxId
     */
    public static Integer getMaxId() {return maxId;}
    /**
     * Получение имени
     * @return - значение поля name
     */
    public String getName() {return name;}
    /**
     * Получение координат
     * @return - значение поля coordinates
     */
    public Coordinates getCoordinates() {return coordinates;}
    /**
     * Получение даты
     * @return - значение поля creationDate
     */
    public LocalDate getCreationDate() {return creationDate;}
    /**
     * Получение площади
     * @return - значение поля area
     */
    public int getArea() {return area;}
    /**
     * Получение численности населения
     * @return - значение поля population
     */
    public int getPopulation() {return population;}
    /**
     * Получение высоты над уровнем моря
     * @return - значение поля metersAboveSeaLevel
     */
    public int getMetersAboveSeaLevel() {return metersAboveSeaLevel;}
    /**
     * Получение информации о столице
     * @return - значение поля capital
     */
    public boolean isCapital() {return capital;}
    /**
     * Получение климата
     * @return - значение поля climate
     */
    public Climate getClimate() {return climate;}
    /**
     * Получение формы правления
     * @return - значение поля government
     */
    public Government getGovernment() {return government;}
    /**
     * Получение губернатора
     * @return - значение поля governor
     */
    public Human getGovernor() {return governor;}


    /**
     * Переопределение метода toString
     * @return - значения всех полей класса City
     */
    @Override
    public String toString() {
        return id + ", " + name + ", " + coordinates.toString() +
                ", " + area + ", " +
                population + ", " + metersAboveSeaLevel + ", " + capital + ", "
                + climate.toString() + ", " + government.toString() + ", " + governor.toString();
    }

    /**
     * Переопределение метода compareTo
     * @param city - значение поля city
     * @return - результат сравнения элементов коллекции по их id
     */
    @Override
        public int compareTo (City city){
            if (this.getId().compareTo(city.getId()) > 0) {
                return 1;
            } else if (this.getId().compareTo(city.getId()) < 0) {
                return -1;
            } else {
                return 0;
            }
        }

    /**
     * Переопределение метода convertToXmlString
     * @return - элемент коллекции в формате xml
     */
    @Override
    public String convertToXmlString() {
        String element = "";
        element += String.format("<id>%d</id>", getId());
        element += String.format("<name>%s</name>", getName());
        element += String.format("<coordinate-x>%d</coordinate-x>", getCoordinates().getX());
        element += String.format("<coordinate-y>%s</coordinate-y>", getCoordinates().getY());
        element += String.format("<area>%s</area>", getArea());
        element += String.format("<population>%s</population>", getPopulation());
        element += String.format("<meters-above-sea-level>%s</meters-above-sea-level>", getMetersAboveSeaLevel());
        element += String.format("<capital>%s</capital>", isCapital());
        element += String.format("<climate>%s</climate>", getClimate());
        element += String.format("<government>%s</government>", getGovernment());
        element += "<governor>";
        element += String.format("<nameG>%s</nameG>", governor.getNameG());
        element += String.format("<age>%s</age>", governor.getAge());
        element += String.format("<height>%s</height>", governor.getHeight());
        element += "</governor>";
        element = String.format("<city>%s</city>", element);
        return element;
    }
}


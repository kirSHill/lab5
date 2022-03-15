package essentials.commands;

import elements.*;
import essentials.interaction.UserInteraction;

import java.util.Objects;
import java.util.PriorityQueue;

public class Add implements Command{


    private final UserInteraction interaction;
    private final boolean fromScript;
    private final int update;
    private final PriorityQueue<City> collection;


    public Add(UserInteraction interaction, boolean fromScript, int update, PriorityQueue<City> collection) {
        this.interaction = interaction;
        this.fromScript = fromScript;
        this.update = update;
        this.collection = collection;
    }


    @Override
    public boolean execute(PriorityQueue<City> collection) throws Exception{
        if ((update == 0) && (!fromScript)){
            interaction.print(true, "Добавление элемента в коллекцию.");
        }
        collection.add(createCity(interaction, fromScript, update, collection));
        if ((update == 0) && (!fromScript)) {
            interaction.print(true, "Элемент успешно добавлен. Для сохранения коллекции в файл введите 'save'.");
        }
        return true;
    }


    public City createCity(UserInteraction interaction, boolean fromScript, int update, PriorityQueue<City> collection) {
        City city = new City();
        if (update == 0) {
            city.setId();
        } else {
            city.setId(update);
        }
        chooseName(city, interaction, fromScript);
        chooseCoordinates(city, interaction, fromScript);
        chooseArea(city, interaction, fromScript);
        choosePopulation(city, interaction, fromScript);
        chooseMetersAboveSeaLevel(city, interaction, fromScript);
        chooseCapital(city, interaction, fromScript);
        chooseClimate(city, interaction, fromScript);
        chooseGovernment(city, interaction, fromScript);
        createGovernor(city, interaction, fromScript);
        for (City cityy : collection) {
            if (Objects.equals(city.getId(), cityy.getId())) {
                interaction.print(true, "В коллекции уже есть элемент с таким же id. Возникла ошибка, введите 'clear', чтобы очистить коллекцию.");
            }
        }
        return city;
    }

    public void chooseName(City city, UserInteraction interaction, boolean fromScript) {
        boolean result = false;
        while (!result) {
            if (!fromScript) {
                interaction.print(false, "Введите название города: ");
            }
            try {
                city.setName(interaction.getData());
            } catch (Exception e) {
                interaction.print(true, "Название города не может являться пустой строкой! Повторите ввод. ");
                continue;
            }
            result = true;
        }
    }

    public void chooseCoordinates(City city, UserInteraction interaction, boolean fromScript) {
        boolean result = false;
        while (!result) {
            if(!fromScript) {
                interaction.print(false, "Введите координаты города через пробел: ");
            }
            String[] xy = interaction.getData().split(" ");
            long x;
            int y;
            try {
                x = Long.parseLong(xy[0]);
                y = Integer.parseInt(xy[1]);
            } catch (NumberFormatException e) {
                interaction.print(true, "Координаты должы быть числами! Повторите ввод.");
                continue;
            }
            try {
                city.setCoordinates(x,y);
            } catch (Exception e) {
                interaction.print(true, "Введены неверные данные. x не может быть меньше -834, y не может быть больше 904! Повторите ввод.");
                continue;
            }
            result = true;
        }
    }

    public void chooseArea(City city, UserInteraction interaction, boolean fromScript) {
        boolean result = false;
        while(!result) {
            if(!fromScript) {
                interaction.print(false, "Введите площадь города: ");
            }
            try {
                city.setArea(Integer.parseInt(interaction.getData()));
            } catch (NumberFormatException e) {
                interaction.print(true, "Площадь должна быть целым числом! Повторите ввод.");
                continue;
            } catch (Exception e) {
                interaction.print(true, "Площадь не может быть меньше 0! Повторите ввод.");
                continue;
            }
            result = true;
        }
    }

    public void choosePopulation(City city, UserInteraction interaction, boolean fromScript) {
        boolean result = false;
        while(!result) {
            if(!fromScript) {
                interaction.print(false, "Введите численность населения города: ");
            }
            try {
                city.setPopulation(Integer.parseInt(interaction.getData()));
            } catch (NumberFormatException e) {
                interaction.print(true, "Численность населения должна быть целым числом! Повторите ввод.");
                continue;
            } catch (Exception e) {
                interaction.print(true, "Численность населения не может быть меньше 0! Повторите ввод.");
                continue;
            }
            result = true;
        }
    }

    public void chooseMetersAboveSeaLevel(City city, UserInteraction interaction, boolean fromScript) {
        boolean result = false;
        while(!result) {
            if(!fromScript) {
                interaction.print(false, "Введите высоту города над уровнем моря: ");
            }
            try {
                city.setMetersAboveSeaLevel(Integer.parseInt(interaction.getData()));
            } catch (NumberFormatException e) {
                interaction.print(true, "Высота города над уровнем моря должна быть целым числом! Повторите ввод.");
                continue;
            } catch (Exception e) {
                interaction.print(true, "Высота города над уровнем моря не может быть меньше 0! Повторите ввод.");
                continue;
            }
            result = true;
        }
    }
    public void chooseCapital(City city, UserInteraction interaction, boolean fromScript) {
        boolean result = false;
        boolean isCapital;
        while(!result) {
            if(!fromScript) {
                interaction.print(false, "Город является столицей? Введите 'да' или 'нет': ");
            }
            String getData = interaction.getData();
            if(getData.equals("да")) {
                isCapital = true;
            } else if(getData.equals("нет")) {
                isCapital = false;
            } else {
                interaction.print(true, "Введите 'да' или 'нет'!");
                continue;
            }
            city.setCapital(isCapital);
            result = true;
        }
    }

    public void chooseClimate(City city, UserInteraction interaction, boolean fromScript) {
        boolean result = false;
        while(!result) {
            if(!fromScript) {
                interaction.print(false, "Выберите климат в городе: 'дождливый', 'влажный субтропический', 'влажный континентальный', 'степенной' или 'субарктический': ");
            }
            try {
                city.setClimate(Climate.getByName(interaction.getData()));
            } catch (Exception e) {
                interaction.print(true, "Введены неверные данные! Повторите ввод.");
                continue;
            }
            result = true;
        }
    }

    public void chooseGovernment(City city, UserInteraction interaction, boolean fromScript) {
        boolean result = false;
        while(!result) {
            if(!fromScript) {
                interaction.print(false, "Выберите форму правления в городе: 'геронтократия', 'талассократия', 'теократия' или 'технократия': ");
            }
            try {
                city.setGovernment(Government.getByName(interaction.getData()));
            } catch (Exception e) {
                interaction.print(true, "Введены неверные данные! Повторите ввод.");
                continue;
            }
            result = true;
        }
    }

    public void createGovernor(City city, UserInteraction interaction, boolean fromScript) {
        Human governor = new Human();
        chooseNameG(governor, interaction, fromScript);
        chooseAge(governor, interaction, fromScript);
        chooseHeight(governor, interaction, fromScript);
        city.setGovernor(governor);
    }

    public void chooseNameG(Human governor, UserInteraction interaction, boolean fromScript) {
        boolean result = false;
        while(!result) {
            if(!fromScript) {
                interaction.print(false, "Введите имя губернатора города: ");
            }
            try {
                governor.setNameG(interaction.getData());
            } catch (Exception e) {
                interaction.print(true, "Название города не может являться пустой строкой! Повторите ввод. ");
                continue;
            }
            result = true;
        }
    }

    public void chooseAge(Human governor, UserInteraction interaction, boolean fromScript) {
        boolean result = false;
        while(!result) {
            if(!fromScript) {
                interaction.print(false, "Введите возраст губернатора города: ");
            }
            try {
                governor.setAge(Long.parseLong(interaction.getData()));
            } catch (NumberFormatException e) {
                interaction.print(true, "Возраст губернатора города должен быть целым числом! Повторите ввод.");
                continue;
            } catch (Exception e) {
                interaction.print(true, "Возраст губернатора города не может быть меньше 0! Повторите ввод.");
                continue;
            }
            result = true;
        }
    }

    public void chooseHeight(Human governor, UserInteraction interaction, boolean fromScript) {
        boolean result = false;
        while(!result) {
            if(!fromScript) {
                interaction.print(false, "Введите рост губернатора города: ");
            }
            try {
                governor.setHeight(Double.parseDouble(interaction.getData()));
            } catch (NumberFormatException e) {
                interaction.print(true, "Рост губернатора города должен быть числом! Повторите ввод.");
                continue;
            } catch (Exception e) {
                interaction.print(true, "Рост губернатора города не может быть меньше 0! Повторите ввод.");
                continue;
            }
            result = true;
        }
    }
}

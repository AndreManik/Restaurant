package com.javarush.task.task27.task2712.kitchen;

import java.util.Arrays;

public enum Dish {
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    /*1. Предположим, что нам известно время приготовления каждого блюда в минутах. Захардкодим его в классе Dish.
        1.1. Измени создание элементов enum — Fish(25), Steak(30), Soup(15), Juice(5), Water(3);
        1.2. Создай поле private int duration с геттером.
        Чтобы создать геттер, нажмите Alt+Insert и выберите пункт Getter. Далее выберите имя поля и нажмите OK(Enter).
    */

    private int duration;

    public int getDuration() {
        return duration;
    }

    Dish(int duration){
        this.duration = duration;
    }

    /*  Чтобы пользователь мог выбрать себе блюда, нужно их все ему отобразить.
            Для этого в Dish создай метод public static String allDishesToString(),
            который сформирует строку из всех блюд.
            Пример: «Fish, Steak, Soup, Juice, Water«. Формируй строку динамически.
        */
    public static String allDishesToString(){

        return values().length == 0 ? "" : Arrays.toString(values()).substring(1, Arrays.toString(values()).length() - 1);
    }
}

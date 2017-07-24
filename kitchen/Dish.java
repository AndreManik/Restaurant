package com.javarush.task.task27.task2712.kitchen;

import java.util.Arrays;

public enum Dish {
    Fish,
    Steak,
    Soup,
    Juice,
    Water;

    /*  Чтобы пользователь мог выбрать себе блюда, нужно их все ему отобразить.
        Для этого в Dish создай метод public static String allDishesToString(),
        который сформирует строку из всех блюд.
        Пример: «Fish, Steak, Soup, Juice, Water«. Формируй строку динамически.
    */
    public static String allDishesToString(){

        return values().length == 0 ? "" : Arrays.toString(values()).substring(1, Arrays.toString(values()).length() - 1);
    }
}

package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.util.List;

public class Order {

    protected List<Dish> dishes;        // список выбранных блюд в классе
    private Dish dish;                  // список всех блюд
    private final Tablet tablet;        // номер столика для заказа

    public Order(Tablet tablet) {       // Конструктор должен принимать один параметр типа Tablet и инициализировать поле tablet.
        this.tablet = tablet;
    }
}

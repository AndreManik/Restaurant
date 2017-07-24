package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {

    protected List<Dish> dishes;        // список выбранных блюд в классе
    private Dish dish;                  // список всех блюд
    private final Tablet tablet;        // номер столика для заказа

    public Order(Tablet tablet) throws IOException {       // Конструктор должен принимать один параметр типа Tablet и инициализировать поле tablet.
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }


    /*Перепиши метод toString в классе Order. Пусть он возвращает пустую строку,
    если нет блюд в заказе, иначе вывод должен быть аналогичным примеру
    в порядке добавления блюд. Используй ConsoleHelper.
     */
    @Override
    public String toString() {
        return dishes.isEmpty() ? "" : String.format("Your order: %s of %s", dishes, tablet.toString());
    }

    /*посчитает суммарное время приготовления всех блюд в заказе.*/
    public int getTotalCookingTime(){
        int totalTime = 0;
        for(Dish d : dishes){
            totalTime += d.getDuration();
        }
        return totalTime;
    }

    //В классе Order создай вспомогательный метод public boolean isEmpty(),
    // который будет определять, есть ли какие либо блюда в заказе.
    public boolean isEmpty(){
        return dishes.isEmpty();
    }
}

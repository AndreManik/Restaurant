package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Order;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet {
    /* это номер планшета, чтобы можно было однозначно установить,
     * откуда поступил заказ. Номер планшета должен инициализироваться
     * в конструкторе переданным параметром.
     */
    final int number;

    /*  У нас все завязано на работу с консолью. Однако, при возникновении исключений,
        наше приложение умрет.
        Чтобы узнать причину — добавим в Tablet статическое поле logger типа java.util.logging.Logger,
        инициализированное именем класса (Logger.getLogger(Tablet.class.getName())).
    */
    private static Logger logger = Logger.getLogger(Tablet.class.getName());


    public Tablet(int number) {
        this.number = number;
    }


    /* будет создавать заказ из тех блюд, которые выберет пользователь
    *  Для этого создадим класс Order, который поместим в пакет kitchen.
    */
    public void createOrder(){
        try {
            final Order newOrder = new Order(this);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
            return;
        }
    }

    /*Также измени метод toString в классе Tablet
    (внутри класса Tablet нажмите Alt+Insert -> toString()).
     */
    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}

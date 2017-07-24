package com.javarush.task.task27.task2712;

public class Tablet {
    /* это номер планшета, чтобы можно было однозначно установить,
     * откуда поступил заказ. Номер планшета должен инициализироваться
     * в конструкторе переданным параметром.
     */
    final int number;

    public Tablet(int number) {
        this.number = number;
    }


    /* будет создавать заказ из тех блюд, которые выберет пользователь
    *  Для этого создадим класс Order, который поместим в пакет kitchen.
    */
    public void createOrder(){}

}

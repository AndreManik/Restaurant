package com.javarush.task.task27.task2712;

/*Создай класс ConsoleHelper с единственным BufferedReader, через который будем работать с консолью.
  Запомни, этот класс не хранит никаких данных и состояний, поэтому все методы будут статическими.
*/

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //для вывода message в консоль
    public static void writeMessage(String message){
        System.out.println(message);
    }

    //для чтения строки с консоли
    public static String readString() throws IOException{
        String string = reader.readLine();
        return string;
    }

    //просит пользователя выбрать блюдо и добавляет его в список.
    public static List<Dish> getAllDishesForOrder() throws IOException{
        writeMessage("Выберите блюдо: ");
        writeMessage(Dish.allDishesToString());
        writeMessage("Введите название блюда, для выхода наберите 'exit'");

        List<Dish> dishes = new ArrayList<>();

        String order;

        while (!(order = reader.readLine()).equalsIgnoreCase("exit")){
            try{
                dishes.add(Dish.valueOf(order));
            } catch (IllegalArgumentException e){
                writeMessage("Такого блюда нет в меню, попробуйте набрать снова или 'exit'");
            }
        }

        return dishes;
    }
}

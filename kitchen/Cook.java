package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer{

    private String name;

    public Cook(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
    //когда повар узнал, что заказ сформирован
    @Override
    public void update(Observable o, Object arg) {
        ConsoleHelper.writeMessage(String.format("Start cooking - %s, cooking time %smin", arg, ((Order)arg).getTotalCookingTime()));

        /*  Зарегистрируй событие для повара во время приготовления еды.
            Добавь геттер для поля dishes в класс Order, используйте его при создании события.*/

        StatisticManager statisticManager = StatisticManager.getInstance();
        CookedOrderEventDataRow cookedOrderEventDataRow = new CookedOrderEventDataRow(((Tablet)o).toString(), name, ((Order)arg).getTotalCookingTime() * 60, ((Order)arg).getDishes());
        statisticManager.register(cookedOrderEventDataRow);

        setChanged();
        notifyObservers(arg);
    }
}

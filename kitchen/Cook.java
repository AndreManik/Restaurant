package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;

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
        ConsoleHelper.writeMessage(String.format("Start cooking - %s", arg));

        setChanged();
        notifyObservers(arg);
    }
}

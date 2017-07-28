package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;

import java.util.*;

public class StatisticManager {

    private static StatisticManager statisticManager;

    /* Чтобы менеджер мог получить доступ к хранилищу, нужно в классе StatisticManager создать поле statisticStorage типа StatisticStorage.
        Инициализируй его экземпляром класса.*/
    private StatisticStorage statisticStorage = new StatisticStorage();

    //Создай в классе StatisticManager множество (Set) поваров (cooks) и добавь в него повара.
    private Set<Cook> cooks = new HashSet<>();

    private StatisticManager(){}

    public static StatisticManager getInstance(){
        if (statisticManager == null){
            statisticManager = new StatisticManager();
        }
        return statisticManager;
    }

    //Метод register с одним параметром типа EventDataRow должен регистрировать полученное событие в statisticStorage.
    public void register(EventDataRow data){
        statisticStorage.put(data);
    }

    public void register(Cook cook){
        cooks.add(cook);
    }

    /*  Хранилище связано 1 к 1 с менеджером, т.е. один менеджер и одно хранилище на приложение.
        К хранилищу может доступиться только StatisticManager. Поэтому…
        Из вышеперечисленного следует, что хранилище должно быть приватным иннер классом.
        Назовем его StatisticStorage.*/
    // Внутри класса StatisticManager создать приватный иннер класс StatisticStorage.
    private class StatisticStorage{

        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        public StatisticStorage(){
            for(EventType eventType : EventType.values()){
                storage.put(eventType, new ArrayList<EventDataRow>());
            }
        }

        //Сделай так, чтобы к методу void put(EventDataRow data) нельзя было получить доступ за пределами класса StatisticManager.
        private void put(EventDataRow data){
            storage.get(data.getType()).add(data);
        }
    }
}

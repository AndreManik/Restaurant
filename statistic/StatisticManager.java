package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticManager {

    private static StatisticManager statisticManager;

    /* Чтобы менеджер мог получить доступ к хранилищу, нужно в классе StatisticManager создать поле statisticStorage типа StatisticStorage.
        Инициализируй его экземпляром класса.*/
    private StatisticStorage statisticStorage = new StatisticStorage();

    private StatisticManager(){}

    public static StatisticManager getInstance(){
        if (statisticManager == null){
            statisticManager = new StatisticManager();
        }
        return statisticManager;
    }

    public void register(EventDataRow data){}

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

    }
}

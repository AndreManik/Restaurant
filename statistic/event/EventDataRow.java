package com.javarush.task.task27.task2712.statistic.event;

import java.util.Date;

public interface EventDataRow {
    /*  1. Внутри StatisticStorage создай метод void put(EventDataRow data).
        2. Чтобы методом put(EventDataRow data) добавить объект data в данные карты, нужен тип события — EventType.
            Будет правильно, если событие будет хранить в себе свой тип. Поэтому:
            2.1. В интерфейс EventDataRow добавь метод EventType getType()
            2.2. Реализуй этот метод в каждом классе-событии: CookedOrderEventDataRow, NoAvailableVideoEventDataRow, VideoSelectedEventDataRow
    */
    EventType getType();
    Date getDate(); //реализация которого вернет дату создания записи
    int getTime(); //реализация которого вернет время — продолжительность
}

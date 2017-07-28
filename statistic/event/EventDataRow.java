package com.javarush.task.task27.task2712.statistic.event;

public interface EventDataRow {
    /*  1. Внутри StatisticStorage создай метод void put(EventDataRow data).
        2. Чтобы методом put(EventDataRow data) добавить объект data в данные карты, нужен тип события — EventType.
            Будет правильно, если событие будет хранить в себе свой тип. Поэтому:
            2.1. В интерфейс EventDataRow добавь метод EventType getType()
            2.2. Реализуй этот метод в каждом классе-событии: CookedOrderEventDataRow, NoAvailableVideoEventDataRow, VideoSelectedEventDataRow
    */
    EventType getType();
}

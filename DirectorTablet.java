package com.javarush.task.task27.task2712;

/*Давай подумаем что нужно сделать, чтобы директор мог посмотреть:
        1. какую сумму заработали на рекламе, сгруппировать по дням;
        2. загрузка (рабочее время) повара, сгруппировать по дням;
        3. список активных роликов и оставшееся количество показов по каждому;
        4. список неактивных роликов (с оставшемся количеством показов равным нулю).

        Для каждого пункта добавим соответствующий метод в StatisticManager.
        Директор будет вызывать метод, StatisticManager будет делать различные подсчеты.*/


public class DirectorTablet {

    public void printAdvertisementProfit(){}
    public void printCookWorkloading(){}
    public void printActiveVideoSet(){}
    public void printArchivedVideoSet(){}
}

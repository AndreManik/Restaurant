package com.javarush.task.task27.task2712.ad;

//у каждого планшета будет свой объект менеджера,
// который будет подбирать оптимальный набор роликов
// и их последовательность для каждого заказа.
//Он также будет взаимодействовать с плеером и отображать ролики.

import com.javarush.task.task27.task2712.ConsoleHelper;

public class AdvertisementManager {

    //В AdvertisementManager создадим final поле-ссылку на экземпляр AdvertisementStorage и назовем ее storage.
    //Не забудь инициализировать созданное поле!
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private int timeSeconds;

    /*Определим необходимые данные для объекта AdvertisementManager — это время выполнения заказа поваром.
    Т.к. продолжительность видео у нас хранится в секундах, то и и время выполнения заказа тоже будем принимать в секундах.
    В классе AdvertisementManager создай конструктор, который принимает один параметр — int timeSeconds.
    Создай соответствующее поле и сохраните это значение в него.*/

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

   /* AdvertisementManager выполняет только одно единственное действие — обрабатывает рекламное видео.*/
    public void processVideos(){
        ConsoleHelper.writeMessage("calling processVideos method");
    }


}

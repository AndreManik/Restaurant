package com.javarush.task.task27.task2712.ad;

// хранилище рекламных роликов.
// Так как хранилище рекламных роликов AdvertisementStorage
// единственное для всего ресторана, то сделаем его синглтоном.

import java.util.ArrayList;
import java.util.List;

public class AdvertisementStorage {

    /*
        Видео должно где-то храниться, пусть это будет список.
        Создадим поле videos и инициализируем его пустым листом.
    */

    private final List<Advertisement> videos = new ArrayList<>();

    private static AdvertisementStorage storage;

    public static AdvertisementStorage getInstance(){

        if (storage == null){
            storage = new AdvertisementStorage();
        }

        return storage;
    }

    //Чтобы как-то работать с видео, создай публичные методы:
    //list() — который вернет список всех существующих доступных видео.
    public List<Advertisement> list(){
        return this.videos;
    }

    //add(Advertisement advertisement) — который добавит новое видео в список videos
    public void add(Advertisement advertisement){
        videos.add(advertisement);
    }


    private AdvertisementStorage(){

        //В конструкторе класса добавим в список videos какие-то данные. У меня это:
        Object someContent = new Object();
        videos.add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60)); // 3 min
        videos.add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60)); //15 min
        videos.add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60)); //10 min

    }

}

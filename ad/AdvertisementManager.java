package com.javarush.task.task27.task2712.ad;

//у каждого планшета будет свой объект менеджера,
// который будет подбирать оптимальный набор роликов
// и их последовательность для каждого заказа.
//Он также будет взаимодействовать с плеером и отображать ролики.

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
    public void processVideos() throws NoVideoAvailableException{
        if (storage.list().isEmpty()){
                   /* регистрируем событие, видео не выбрано*/

            throw new NoVideoAvailableException();
        }

        setPermutationList(getRelevantList());

        List<Advertisement> best = bestList(summList(permutationList));

        Collections.sort(best, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {

                long dif = o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying();
                if (dif == 0) dif = o2.getDuration()- o1.getDuration();
                return (int) dif;
            }
        });

            /* регистрируем событие выбора видеороликов */
        long totalAmount = 0;
        int totalDuration = 0;
        for (Advertisement a : best){
            totalAmount += a.getAmountPerOneDisplaying();
            totalDuration += a.getDuration();
        }


        for (Advertisement b : best){

            ConsoleHelper.writeMessage(b.getName() + " is displaying... " + b.getAmountPerOneDisplaying() + ", " + 1000 * b.getAmountPerOneDisplaying()/b.getDuration());
            b.revalidate();
        }
    }


    //подобрать список видео из доступных, просмотр которых обеспечивает максимальную выгоду

    //составить список из рекламных роликов не выходящих за продолжительность приготовления пищи
    private List<Advertisement> getRelevantList(){
        List<Advertisement> relevantList = new ArrayList<>();
        for (Advertisement a: storage.list()) {
            if ((a.getDuration() <= timeSeconds) && (a.getHits() > 0)){
                relevantList.add(a);
            }
        }
        return relevantList;
    }


    //блок генерации всех возможных пеерстановок из подобранного списка
    private List<List<Advertisement>> permutationList = new ArrayList<>();

    private void setPermutationList(List<Advertisement> relevantList){
        if (!relevantList.isEmpty()){
            List<Advertisement> base = new ArrayList<>();
            setPermutationList(base, relevantList);
        }
    }

    private void setPermutationList(List<Advertisement> base, List<Advertisement> remainder) {
        if (remainder.size() <= 1) {
            base.add(remainder.get(0));
            permutationList.add(base);

        } else {


            for (int i = 0; i < remainder.size(); i++) {
                List<Advertisement> temp = new ArrayList<>();
                temp.addAll(subList(remainder, 0, i));
                temp.addAll(subList(remainder, i+1));

                List<Advertisement> newPermutation = new ArrayList<>();
                newPermutation.addAll(base);
                newPermutation.add(remainder.get(i));

                setPermutationList(newPermutation, temp);
            }

        }
    }

    private List<Advertisement> subList(List<Advertisement> list, int startIndex){
        List<Advertisement> temp = new ArrayList<>();

        for (int i = startIndex; i < list.size(); i++){
            temp.add(list.get(i));
        }

        return temp;
    }

    private List<Advertisement> subList(List<Advertisement> list, int startIndex, int endIndex){
        List<Advertisement> temp = new ArrayList<>();

        for (int i = startIndex; i < endIndex; i++){
            temp.add(list.get(i));
        }

        return temp;
    }

    //блок выбора списка длины рекламного потока
    private List<List<Advertisement>> summList(List<List<Advertisement>> permutationListList){

        List<List<Advertisement>> goodList = new ArrayList<>();

        for (List<Advertisement> list : permutationListList){

            List<Advertisement> temp = new ArrayList<>();
            long countDuration = 0;

            for (int i = 0; i < list.size(); i++){
                if ((countDuration += list.get(i).getDuration()) > timeSeconds){
                    break;
                }
                temp.add(list.get(i));
            }
            goodList.add(temp);
        }
        return goodList;
    }


    //лучший список
    private List<Advertisement> bestList(List<List<Advertisement>> sumList){
        long amountGolbal = 0;
        long timeGlobal = 0;
        long sizeGlobal = 0;


        List<Advertisement> adList = new ArrayList<>();

        for (List<Advertisement> ad : sumList){
            long amounount = 0;
            long time = 0;
            for (Advertisement a : ad){
                amounount += a.getAmountPerOneDisplaying();
                time += a.getDuration();
            }

            if (amounount > amountGolbal){
                amountGolbal = amounount;
                timeGlobal = time;
                sizeGlobal = ad.size();
                adList.clear();
                adList.addAll(ad);
            } else if (amounount == amountGolbal){
                if (time > timeGlobal){
                    timeGlobal = time;
                    sizeGlobal = ad.size();
                    adList.clear();
                    adList.addAll(ad);
                } else if (time == timeGlobal){
                    if (ad.size() < sizeGlobal){
                        sizeGlobal = ad.size();
                        adList.clear();
                        adList.addAll(ad);
                    }
                }
            }

        }

        return adList;
    }

}

package com.example.smallbusinessmanagementsystem.statistika;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class StatistikosManager {
    private List<StatistikosVienetas> vienetasList;

    public StatistikosManager() {
    }

    public List<StatistikosVienetas> fillMissingDates(List<StatistikosVienetas> statistikosVienetasList) {

        Set<Date> distinctDatesSet = new HashSet<>();
        for (StatistikosVienetas statistikosVienetas : statistikosVienetasList) {
            List<StatistikosElementas> statistikosElementasList = statistikosVienetas.getStatistikosElementasList();
            for(StatistikosElementas statistikosElementas : statistikosElementasList)
            {
                distinctDatesSet.add(statistikosElementas.getData());
            }
        }

        List<Date> distinctDatesList = returnSortedList(distinctDatesSet);


        for (StatistikosVienetas statistikosVienetas : statistikosVienetasList) {

            List<StatistikosElementas> oldList= statistikosVienetas.getStatistikosElementasList();
            List<Date> elementsToAdd = getDistinctDatesInSecondList(oldList, distinctDatesList);

            statistikosVienetas.setStatistikosElementasList(addZeroesToDistinctDates(oldList,elementsToAdd));

            sortListByDate(statistikosVienetas.getStatistikosElementasList());
        }

        return statistikosVienetasList;
    }

    private List<Date> returnSortedList(Set<Date> dateSet) {
        List<Date> dateList = new ArrayList<>(dateSet);

        Collections.sort(dateList);

        return dateList;
    }

    private void sortListByDate(List<StatistikosElementas> listToSort) {

        Collections.sort(listToSort, Comparator.comparing(StatistikosElementas::getData));
    }

    private List<Date> getDistinctDatesInSecondList(List<StatistikosElementas> firstList, List<Date> secondList) {
        // Extract distinct dates from the second list that are not present in the first list
        List<Date> distinctDates = secondList.stream()
                .filter(date -> !firstList.stream().anyMatch(element -> element.getData().equals(date)))
                .collect(Collectors.toList());

        return distinctDates;
    }

    private List<StatistikosElementas> addZeroesToDistinctDates(List<StatistikosElementas> statistikosElementasList, List<Date> distinctDates) {

        //System.out.println("Missing dates:" + distinctDates);
        for(Date missingDate: distinctDates) {
            statistikosElementasList.add(new StatistikosElementas(0,"",missingDate));
        }

        return statistikosElementasList;
    }
}

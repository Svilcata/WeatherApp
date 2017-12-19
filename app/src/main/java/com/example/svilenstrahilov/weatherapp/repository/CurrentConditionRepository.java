package com.example.svilenstrahilov.weatherapp.repository;

import com.example.svilenstrahilov.weatherapp.data.models.CurrentCondition;

public interface CurrentConditionRepository {
    void addItem(CurrentCondition item);

//    void addItems(List<CurrentCondition> items);

    void updateItem(CurrentCondition item);

//    void updateItems(List<CurrentCondition> items);

    void removeItemById(String id);

//    List<CurrentCondition> getItems();

    CurrentCondition getItemById(String id);
}

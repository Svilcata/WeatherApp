package com.example.svilenstrahilov.weatherapp.repository;

import java.util.List;

public interface WeatherDataSource<T> {
    void addItem(T item);

    void addItems(List<T> items);

    void updateItem(T item);

    void updateItems(List<T> items);

    void removeItemById(String id);

    List<T> getItems();

    T getItemById(String id);
}

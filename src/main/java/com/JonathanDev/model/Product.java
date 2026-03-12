package com.JonathanDev.model;

import java.util.Date;

/**
 * Record para representar un producto con sus atributos id, name, price y dateCreate.
 * @param id
 * @param name
 * @param price
 * @param dateCreate
 */
public record Product(Long id, String name, int price, Date dateCreate) {
    @Override
    public String toString() {
        return "ID : " + id + " | " +
                "Nombre : " + name + " | " +
                "Precio : " + price + " | " +
                "Date : " + dateCreate;
    }
}

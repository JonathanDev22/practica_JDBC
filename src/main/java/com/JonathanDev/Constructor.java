package com.JonathanDev;

import com.JonathanDev.Utils.ConnectionBD;
import com.JonathanDev.Utils.QuerysBD;
import com.JonathanDev.model.Product;

import java.sql.*;

public class Constructor {
    public static void main(String[] args) {
        int contador = 0;
        System.out.println("Inicio de aplicacion usando JDBC");
        try (Statement stmt = ConnectionBD.getConnection().createStatement()) {
            stmt.executeUpdate(QuerysBD.INSERT_PRODUCT);
            stmt.executeQuery(QuerysBD.SELECT_ALL_PRODUCTS);
            try (ResultSet rs = stmt.getResultSet()) {
                while (rs.next()) {
                    Product p = new Product(
                            rs.getLong("id"),
                            rs.getString("name"),
                            rs.getInt("price"),
                            rs.getDate("date_create")
                    );
                    System.out.println(p);
                    contador++;

                }
                if (contador == 0) {
                    System.out.println("####### No se ha encontrado ningun registro ######");
                }
                System.out.println("####### Resultados encontrados: " + contador + " #######");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

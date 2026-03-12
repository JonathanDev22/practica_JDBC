package com.JonathanDev.service;

import com.JonathanDev.Utils.ConnectionBD;
import com.JonathanDev.Utils.QuerysBD;
import com.JonathanDev.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Launcher {
    public void launch() {
        int contador = 0;
        System.out.println("Inicio de aplicacion usando JDBC");
        try (Statement stmt = ConnectionBD.getConnection().createStatement()) {
            stmt.executeUpdate(QuerysBD.INSERT_PRODUCT);
            stmt.executeQuery(QuerysBD.SELECT_ALL_PRODUCTS);
            try (ResultSet rs = stmt.getResultSet()) {
                contador = getCounter(rs, contador);
                if (contador == 0) {
                    System.out.println("####### No se ha encontrado ningun registro ######");
                }
                System.out.println("####### Resultados encontrados: " + contador + " #######");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private int getCounter(ResultSet rs, int contador) throws SQLException {
        while (rs.next()) {
            Product p = getProduct(rs);
            System.out.println(p);
            contador++;
        }
        return contador;
    }

    private Product getProduct(ResultSet rs) throws SQLException {
        Product p = new Product(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getInt("price"),
                rs.getDate("date_create")
        );
        return p;
    }
}

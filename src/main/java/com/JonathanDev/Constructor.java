        package com.JonathanDev;

        import java.sql.*;

        public class Constructor {
            public static void main(String[] args) {
                String URL = "jdbc:postgresql://localhost:5432/repo_local";
                String USER = "admin";
                String PASSWORD = "root";
                int contador = 0;
                String sql = "SELECT * FROM products";
                //String insert = "INSERT INTO products (name, price, date_create) VALUES ('Producto de prueba', 9.99 , CURRENT_DATE)";
                System.out.println("Inicio de aplicacion usando JDBC");
                try {
                    Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
                    Statement stmt = conexion.createStatement();
                  //  stmt.executeUpdate(insert);
                    stmt.execute(sql);
                    ResultSet rs = stmt.getResultSet();
                    while (rs.next()){
                        contador++;
                        System.out.print("ID : " + rs.getInt("id"));
                        System.out.print(" | ");
                        System.out.print("Nombre : " + rs.getString("name"));
                        System.out.print(" | ");
                        System.out.print("Precio : " + rs.getDouble("price"));
                        System.out.print(" | ");
                        System.out.println("Date : " + rs.getDate("date_create"));
                    }
                    if (contador == 0 ){
                        System.out.println("####### No se ha encontrado ningun registro ######");
                    }
                    System.out.println("####### Resultados encontrados: " + contador + " #######");

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } finally {
                    System.out.println("Fin de aplicacion usando JDBC");
                }
            }
        }
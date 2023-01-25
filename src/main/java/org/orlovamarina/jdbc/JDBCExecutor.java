package org.orlovamarina.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCExecutor {
    public static void main(String[] args) {
        DatabaseConnectionManager connectionManager = new DatabaseConnectionManager("localhost",
                "marinaorlova", "marinaorlova", "");

        try{
            Connection connection = connectionManager.getConnection();
            OrderDAO orderDAO = new OrderDAO(connection);
            Order order = orderDAO.findById(1000);
            System.out.println(order);
        }catch(SQLException exc){
            exc.printStackTrace();
        }
    }
}

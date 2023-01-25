package org.orlovamarina.jdbc;

import org.orlovamarina.jdbc.util.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderDAO extends DataAccessObject<Order> {
    private final static String GET_BY_ID = "SELECT o.order_id, o.creation_date, o.total_due, o.status,  " +
            "c.first_name, c.last_name, s.first_name AS sales_first_name, s.last_name AS sales_last_name, " +
            "ol.quantity, ol.order_item_id, p.product_id, p.code, p.name, p.size, p.variety, p.price " +
            "FROM orders o JOIN customer c on o.customer_id = c.customer_id " +
            "JOIN salesperson s on o.salesperson_id = s.salesperson_id " +
            "JOIN order_item ol on ol.order_id = o.order_id " +
            "JOIN product p on ol.product_id = p.product_id where o.order_id = ?";

    public OrderDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Order findById(long id) {
        Order order = new Order();
        try(PreparedStatement statement = this.connection.prepareStatement(GET_BY_ID)){
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                order.setId(resultSet.getLong("order_id"));
                order.setCreationDate(resultSet.getDate("creation_date"));
                order.setTotalDue(resultSet.getDouble("total_due"));
                order.setStatus(resultSet.getString("status"));
                order.setCustomerFirstName(resultSet.getString("first_name"));
                order.setCustomerLastName(resultSet.getString("last_name"));
                order.setSalespersonFirstName(resultSet.getString("sales_first_name"));
                order.setSalespersonLastName(resultSet.getString("sales_last_name"));

                OrderLine orderLine = new OrderLine();
                orderLine.setOrderId(resultSet.getLong("order_id"));
                orderLine.setOrderItemId(resultSet.getLong("order_item_id"));
                orderLine.setQuantity(resultSet.getInt("quantity"));
                orderLine.setProductId(resultSet.getLong("product_id"));
                orderLine.setCode(resultSet.getString("code"));
                orderLine.setVariety(resultSet.getString("variety"));
                orderLine.setPrice(resultSet.getDouble("price"));
                orderLine.setName(resultSet.getString("name"));
                orderLine.setSize(resultSet.getInt("size"));
                order.addItem(orderLine);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return order;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public Order update(Order dto) {
        return null;
    }

    @Override
    public Order create(Order dto) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}

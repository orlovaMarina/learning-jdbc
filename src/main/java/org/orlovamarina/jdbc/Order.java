package org.orlovamarina.jdbc;

import org.orlovamarina.jdbc.util.DataTransferObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order implements DataTransferObject {
    private long id;
    private Date creationDate;
    private double totalDue;
    private String status;
    private String customerFirstName;
    private String customerLastName;
    private String salespersonFirstName;
    private String salespersonLastName;


    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getSalespersonLastName() {
        return salespersonLastName;
    }

    public void setSalespersonLastName(String salespersonLastName) {
        this.salespersonLastName = salespersonLastName;
    }

    public String getSalespersonFirstName() {
        return salespersonFirstName;
    }

    public void setSalespersonFirstName(String salespersonFirstName) {
        this.salespersonFirstName = salespersonFirstName;
    }

    private List<OrderLine> orderItems = new ArrayList<>();

    public void addItem(OrderLine orderLine){
        this.orderItems.add(orderLine);
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public double getTotalDue() {
        return totalDue;
    }

    public void setTotalDue(double totalDue) {
        this.totalDue = totalDue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", totalDue=" + totalDue +
                ", status='" + status + '\'' +
                ", customerLastName='" + customerLastName + '\'' +
                ", customerFirstName='" + customerFirstName + '\'' +
                ", salespersonLastName='" + salespersonLastName + '\'' +
                ", salespersonFirstName='" + salespersonFirstName + '\'' +
                ", orderItems=" + "\n" + orderItems +
                '}';
    }
}


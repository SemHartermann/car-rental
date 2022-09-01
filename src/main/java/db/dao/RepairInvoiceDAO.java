package db.dao;

import db.entities.Order;

import java.sql.ResultSet;

public interface RepairInvoiceDAO {

    public RepairInvoiceDAO extractOrder(ResultSet rs);

}

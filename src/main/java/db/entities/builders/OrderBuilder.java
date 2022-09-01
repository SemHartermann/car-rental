package db.entities.builders;/*package db.entities.builders;

import com.mv.schelokov.carent.model.entity.Car;
import com.mv.schelokov.carent.model.entity.RejectionReason;
import com.mv.schelokov.carent.model.entity.RentOrder;
import com.mv.schelokov.carent.model.entity.User;

import java.util.Date;

*//**
 *
 * @author Maxim Chshelokov <schelokov.mv@gmail.com>
 *//*
public class OrderBuilder {
    
    private final RentOrder rentOrder;
    
    public OrderBuilder() {
        this.rentOrder = new RentOrder();
    }
    
    public OrderBuilder withId(int id) {
        this.rentOrder.setId(id);
        return this;
    }
    
    public OrderBuilder selectedCar(Car car) {
        this.rentOrder.setCar(car);
        return this;
    }
    
    public OrderBuilder byUser(User user) {
        this.rentOrder.setUser(user);
        return this;
    }
    
    public OrderBuilder startsAtDate(Date startDate) {
        this.rentOrder.setStartDate(startDate);
        return this;
    }
    
    public OrderBuilder endsByDate(Date endDate) {
        this.rentOrder.setEndDate(endDate);
        return this;
    }
    
    public OrderBuilder approvedBy(User approvedBy) {
        this.rentOrder.setApprovedBy(approvedBy);
        return this;
    }
    
    public OrderBuilder rejectedDueReason(RejectionReason rejectionReason) {
        this.rentOrder.setRejectionReason(rejectionReason);
        return this;
    }
    
    public RentOrder getRentOrder() {
        return this.rentOrder;
    }
}*/

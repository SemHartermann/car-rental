package db.entities;

import java.sql.Date;

public class Order extends Entity {

    private static final long serialVersionUID = -8603843450683498202L;

    private int id;
    private int userId;

    private int carId;

    private boolean driverStatus;

    private Date startDate;

    private Date endDate;

    private int price;

    private int driverPrice;

    private int statusId;

    private String rejectionReason;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public boolean isDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(boolean driverStatus) {
        this.driverStatus = driverStatus;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date endDate) {
        this.startDate = endDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int orderPrice) { this.price = orderPrice; }



    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }


    @Override
    public String toString() {
        return "Order [userId=" + userId + ", carId=" + carId
                + ", driverStatus=" + driverStatus + ", startDate=" + startDate
                + ", endDate=" + endDate + ", price=" + price
                + ", statusId=" + statusId + ", rejectionReason="
                + rejectionReason + "]";
    }

}

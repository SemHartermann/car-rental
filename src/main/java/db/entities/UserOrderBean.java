package db.entities;

import java.sql.Date;


public class UserOrderBean extends Entity {



	private int orderId;

	private String userFirstName;

	private String userLastName;

	private String carName;

	private boolean driverStatus;

	private Date startDate;

	private Date endDate;

	private int orderPrice;

	private String statusName;

	private String rejectionReason;

	private boolean damage;

	private int priceForRepairs;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
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

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getRejectionReason() {
		return rejectionReason;
	}

	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
	}

	public boolean isDamage() {
		return damage;
	}

	public void setDamage(boolean damage) {
		this.damage = damage;
	}

	public int getPriceForRepairs() {
		return priceForRepairs;
	}

	public void setPriceForRepairs(int priceForRepairs) {
		this.priceForRepairs = priceForRepairs;
	}

	@Override
	public String toString() {
		return "UserOrderBean [orderId=" + orderId + ", userFirstName="
				+ userFirstName + ", userLastName=" + userLastName
				+ ", carName=" + carName + ", driverStatus=" + driverStatus
				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", orderPrice=" + orderPrice + ", statusName=" + statusName
				+ ", rejectionReason=" + rejectionReason + ", damage=" + damage
				+ ", priceForRepairs=" + priceForRepairs + "]";
	}

}

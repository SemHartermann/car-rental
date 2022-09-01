package db.entities;

import db.entities.Entity;

import java.sql.Date;

/**
 * Provide records for virtual table:
 * 
 * <pre>
 * |order.id|user.firstName|user.lastName|car.name|order.driverStatus|order.orderdata|
 * |order.returnData|order.price|status.name|order.rejectionReason|order.damage|
 * |order.priceForRepairs|
 * </pre>
 * 
 * @author A.Yegorov
 *
 */

public class UserOrderBean extends Entity {

	private static final long serialVersionUID = 8083719550752604379L;

	private int orderId;

	private String userFirstName;

	private String userLastName;

	private String carName;

	private boolean driverStatus;

	private Date orderData;

	private Date returnData;

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

	public Date getOrderData() {
		return orderData;
	}

	public void setOrderData(Date orderData) {
		this.orderData = orderData;
	}

	public Date getReturnData() {
		return returnData;
	}

	public void setReturnData(Date returnData) {
		this.returnData = returnData;
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
				+ ", orderData=" + orderData + ", returnData=" + returnData
				+ ", orderPrice=" + orderPrice + ", statusName=" + statusName
				+ ", rejectionReason=" + rejectionReason + ", damage=" + damage
				+ ", priceForRepairs=" + priceForRepairs + "]";
	}

}

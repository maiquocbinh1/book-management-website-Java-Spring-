package com.example.bookshop.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Shipping")
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ShippingID")
    private Integer shippingID;

    @JoinColumn(name = "OrderID")
    private Order orderID;

    @Enumerated(EnumType.STRING)
    @Column(name = "ShippingMethod", nullable = false)
    private ShippingMethod shippingMethod = ShippingMethod.TIEU_CHUAN;

    @Enumerated(EnumType.STRING)
    @Column(name = "ShippingStatus", nullable = false)
    private ShippingStatus shippingStatus = ShippingStatus.CHO_XAC_NHAN;

    @Column(name = "TrackingNumer", unique = true, length = 50)
    private String trackingNumber;

    @Column(name = "Carrier", length = 50)
    private String carrier;

    @Column(name = "ShippingFee", precision = 10, scale = 2)
    private BigDecimal shippingFee;

    public Shipping() {
    }

    public enum ShippingStatus {
        CHO_XAC_NHAN,
        DANG_VAN_CHUYEN,
        DA_GIAO,
        DA_HUY,
        DOI_TRA_HANG
    }

    public enum ShippingMethod {
        TIEU_CHUAN,
        NHANH,
        SIEU_NHANH
    }

    public Integer getShippingID() {
        return shippingID;
    }

    public void setShippingID(Integer shippingID) {
        this.shippingID = shippingID;
    }

    public Order getOrderID() {
        return orderID;
    }

    public void setOrderID(Order orderID) {
        this.orderID = orderID;
    }

    public ShippingMethod getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public ShippingStatus getShippingStatus() {
        return shippingStatus;
    }

    public void setShippingStatus(ShippingStatus shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public BigDecimal getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(BigDecimal shippingFee) {
        this.shippingFee = shippingFee;
    }
}

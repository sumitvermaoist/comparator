package com.mppkvvcl.comparator.beans;

import com.opencsv.bean.CsvBindByName;

import java.math.BigDecimal;

/**
 * Created by sumit verma on 04-02-2018.
 */
public class NGBBillFile {
    @CsvBindByName(column = "CONS_NO_1")
    private String consumerNo;

    @CsvBindByName(column = "TOT_UNITS_1")
    private BigDecimal totUnits1;

    @CsvBindByName(column = "OLD_CONS_NO")
    private String oldConsNo;

    @CsvBindByName(column = "NET_BILL_1")
    private String netBill1;

    @CsvBindByName(column = "ENCH")
    private BigDecimal energyCharge;

    @CsvBindByName(column = "FXCH")
    private BigDecimal fixedCharge;

    @CsvBindByName(column = "DUTY")
    private BigDecimal duty;

    @CsvBindByName(column = "RENT")
    private BigDecimal rent;

    @CsvBindByName(column = "ADJMT")
    private BigDecimal adjustment;

    @CsvBindByName(column = "SEC_DEP")
    private BigDecimal securityDeposit;

    @CsvBindByName(column = "SD_INT")
    private BigDecimal securityDepositInterest;

    @CsvBindByName(column = "LOCK_CR")
    private BigDecimal lockCredit;

    @CsvBindByName(column = "SUBSIDY")
    private BigDecimal subsidy;

    @CsvBindByName(column = "MONTH_BILL")
    private BigDecimal monthBill;

    @CsvBindByName(column = "ARRS")
    private BigDecimal arrear;

    public String getConsumerNo() {
        return consumerNo;
    }

    public void setConsumerNo(String consumerNo) {
        this.consumerNo = consumerNo;
    }

    public BigDecimal getTotUnits1() {
        return totUnits1;
    }

    public void setTotUnits1(BigDecimal totUnits1) {
        this.totUnits1 = totUnits1;
    }

    public String getOldConsNo() {
        return oldConsNo;
    }

    public void setOldConsNo(String oldConsNo) {
        this.oldConsNo = oldConsNo;
    }

    public String getNetBill1() {
        return netBill1;
    }

    public void setNetBill1(String netBill1) {
        this.netBill1 = netBill1;
    }

    public BigDecimal getEnergyCharge() {
        return energyCharge;
    }

    public void setEnergyCharge(BigDecimal energyCharge) {
        this.energyCharge = energyCharge;
    }

    public BigDecimal getFixedCharge() {
        return fixedCharge;
    }

    public void setFixedCharge(BigDecimal fixedCharge) {
        this.fixedCharge = fixedCharge;
    }

    public BigDecimal getDuty() {
        return duty;
    }

    public void setDuty(BigDecimal duty) {
        this.duty = duty;
    }

    public BigDecimal getRent() {
        return rent;
    }

    public void setRent(BigDecimal rent) {
        this.rent = rent;
    }

    public BigDecimal getAdjustment() {
        return adjustment;
    }

    public void setAdjustment(BigDecimal adjustment) {
        this.adjustment = adjustment;
    }

    public BigDecimal getSecurityDeposit() {
        return securityDeposit;
    }

    public void setSecurityDeposit(BigDecimal securityDeposit) {
        this.securityDeposit = securityDeposit;
    }

    public BigDecimal getSecurityDepositInterest() {
        return securityDepositInterest;
    }

    public void setSecurityDepositInterest(BigDecimal securityDepositInterest) {
        this.securityDepositInterest = securityDepositInterest;
    }

    public BigDecimal getLockCredit() {
        return lockCredit;
    }

    public void setLockCredit(BigDecimal lockCredit) {
        this.lockCredit = lockCredit;
    }

    public BigDecimal getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(BigDecimal subsidy) {
        this.subsidy = subsidy;
    }

    public BigDecimal getMonthBill() {
        return monthBill;
    }

    public void setMonthBill(BigDecimal monthBill) {
        this.monthBill = monthBill;
    }

    public BigDecimal getArrear() {
        return arrear;
    }

    public void setArrear(BigDecimal arrear) {
        this.arrear = arrear;
    }
}

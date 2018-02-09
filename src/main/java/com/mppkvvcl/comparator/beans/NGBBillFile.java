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
}

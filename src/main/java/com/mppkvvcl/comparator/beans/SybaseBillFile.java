package com.mppkvvcl.comparator.beans;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import java.util.Date;
/**
 * Created by sumit verma on 04-02-2018.
 */
public class SybaseBillFile {
    private String divisionName;

    private String locationCode;

    private String groupNo;

    private String readerNo;

    private String consumerNo;

    private String billMonth;

    private String billNo;

    private String billDate;

    private  String totalUnits;

    private String consumerName;

    private String addr1;

    private String netBill1;

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(String groupNo) {
        this.groupNo = groupNo;
    }

    public String getReaderNo() {
        return readerNo;
    }

    public void setReaderNo(String readerNo) {
        this.readerNo = readerNo;
    }

    public String getConsumerNo() {
        return consumerNo;
    }

    public void setConsumerNo(String consumerNo) {
        this.consumerNo = consumerNo;
    }

    public String getBillMonth() {
        return billMonth;
    }

    public void setBillMonth(String billMonth) {
        this.billMonth = billMonth;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getTotalUnits() {
        return totalUnits;
    }

    public void setTotalUnits(String totalUnits) {
        this.totalUnits = totalUnits;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    public String getNetBill1() {
        return netBill1;
    }

    public void setNetBill1(String netBill1) {
        this.netBill1 = netBill1;
    }

    @Override
    public String toString() {
        return "SybaseBillFile{" +
                "divisionName='" + divisionName + '\'' +
                ", locationCode='" + locationCode + '\'' +
                ", groupNo='" + groupNo + '\'' +
                ", readerNo='" + readerNo + '\'' +
                ", consumerNo='" + consumerNo + '\'' +
                ", billMonth='" + billMonth + '\'' +
                ", billNo='" + billNo + '\'' +
                ", billDate='" + billDate + '\'' +
                ", totalUnits='" + totalUnits + '\'' +
                ", consumerName='" + consumerName + '\'' +
                ", addr1='" + addr1 + '\'' +
                ", netBill1='" + netBill1 + '\'' +
                '}';
    }
}

package com.mppkvvcl.comparator.beans;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

/**
 * Created by sumit verma on 04-02-2018.
 */
public class SybaseBillFile {
    private String divisionName;

    private String locationCode;

    private String groupNo;

    private String readerNo;

    private String consumerNo;

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

    @Override
    public String toString() {
        return "SybaseBillFile{" +
                "divisionName='" + divisionName + '\'' +
                ", locationCode='" + locationCode + '\'' +
                ", groupNo='" + groupNo + '\'' +
                ", readerNo='" + readerNo + '\'' +
                ", consumerNo='" + consumerNo + '\'' +
                '}';
    }
}

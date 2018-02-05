package com.mppkvvcl.comparator.beans;

import com.opencsv.bean.CsvBindByName;

/**
 * Created by sumit verma on 04-02-2018.
 */
public class NGBBillFile {
    @CsvBindByName(column = "CONS_NO_1")
    private String consumerNo;

    public String getConsumerNo() {
        return consumerNo;
    }

    public void setConsumerNo(String consumerNo) {
        this.consumerNo = consumerNo;
    }
}

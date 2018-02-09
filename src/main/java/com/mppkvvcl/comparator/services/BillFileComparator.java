package com.mppkvvcl.comparator.services;

import com.mppkvvcl.comparator.beans.NGBBillFile;
import com.mppkvvcl.comparator.beans.SybaseBillFile;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by sumit verma on 04-02-2018.
 */
public class BillFileComparator {
    private static final String DOMESTIC_CSV_FILE_PATH_NGB = "C:\\Users\\SUMIT\\Downloads\\NGB_Bill_file\\NGB_Bill_file\\BillFile_DEC-2017_IGY11_ENGLISH_DOMESTIC (4).txt";
    private static final String DOMESTIC_CSV_FILE_PATH_SYBASE = "C:\\Users\\SUMIT\\Downloads\\sybase_bill_file\\sybase_bill_file\\BNG_INGO_DL_DEC17.mats";
    private static final String DOMESTIC_CSV_FILE_PATH_WRITE = "E:\\output.csv";
    public static void compare() throws IOException {
        final String methodName = "compare() : ";

        /**
         * Reading from NGB-BILL-FILE for Domestic starts here
         */
        Reader ngbReader = Files.newBufferedReader(Paths.get(DOMESTIC_CSV_FILE_PATH_NGB));
        CsvToBean ngbCsvToBean = new CsvToBeanBuilder(ngbReader)
                .withType(NGBBillFile.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        List<NGBBillFile> ngbBillFiles = ngbCsvToBean.parse();
        if(ngbBillFiles != null && ngbBillFiles.size() > 0){
            //System.out.println(methodName + "Consumer No is " + ngbBillFiles.get(0).getConsumerNo());
            System.out.println(methodName + "Size of NGB Bill File is " + ngbBillFiles.size());
            System.out.println(methodName + "Total units is " + ngbBillFiles.get(0).getTotUnits1());
        }

        /**
         * Reading from Sybase-Bill-File for Domestic starts here
         */
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(SybaseBillFile.class);
        String[] columns = new String[]{"divName","locCode1",	"groupNo1",	"readerNo1",	"consNo1",	"billMonth1",	"billNo1",	"billDate",	"totUnits1",	"consName1",	"addr1",	"netBill1",	"addr2",	"addr3",	"chqDate1",	"cshDate1",	"phone1",	"mobile",	"pole",	"meterNo",	"phase",	"cirName1",	"rdgDate",	"connLoad",	"loadUnit",	"rdgType",	"rdgCurr",	"rdgPrev",	"mf",	"pf",	"mtrUnits",	"assUnits",	"totUnits2",	"locName",	"locAddr1",	"ench",	"locAddr2",	"fxch",	"locPhone",	"duty",	"cess",	"rent",	"offrName",	"adjmt",	"offrPhone",	"sdInst",	"och",	"deName",	"advAmt",	"surch",	"sdInt",	"netInclSURCH",	"empRebate",	"lockCr",	"purpose",	"secDep",	"subsidy",	"billType",	"sdDue",	"monthBill",	"arrs",	"prevPymtHDR",	"surchBal",	"cashMsg1",	"netBill2",	"cashMsg2",	"cashMsg3",	"month1",	"rdgDate1",	"rdg1",	"month2",	"rdgDate2",	"rdg2",	"month3",	"rdgDate3",	"rdg3",	"month4",	"rdgDate4",	"rdg4",	"month5",	"rdgDate5",	"rdg5",	"month6",	"rdgDate6",	"rdg6",	"avg1",	"avg2",	"cirName2",	"billMsg1",	"billMsg2",	"billMsg3",	"billMsg4",	"billMsg5",	"billMsg6",	"scrnMsg",	"billMonth2",	"billNo2",	"locCode2",	"groupNo2",	"readerNo2",	"consNo2",	"consName2",	"chqDate2",	"cshDate2",	"netBill3",	"cons1",	"cons2",	"cons3",	"cons4",	"cons5",	"cons6"};
        strategy.setColumnMapping(columns);
        CsvToBean csvToBean = new CsvToBean();
        //CsvToBean csvToBean1 = new CsvToBeanBuilder().withSeparator('\t').withType(SybaseBillFile.class).
        CSVReader csvReader = new CSVReader(new FileReader(DOMESTIC_CSV_FILE_PATH_SYBASE),'\t');
        List<SybaseBillFile> sybaseBillFiles = csvToBean.parse(strategy,csvReader);
        //System.out.println(methodName + "Before if " + sybaseBillFiles);
        if(sybaseBillFiles != null && sybaseBillFiles.size() > 0){
            System.out.println(methodName + "Size of Sybase Bill File is " + sybaseBillFiles.size());
            System.out.println(methodName + "Total units is " + sybaseBillFiles.get(1).getTotUnits1());
        }

        Writer writer = Files.newBufferedWriter(Paths.get(DOMESTIC_CSV_FILE_PATH_WRITE));

        CSVWriter csvWriter = new CSVWriter(writer,CSVWriter.DEFAULT_SEPARATOR,CSVWriter.NO_QUOTE_CHARACTER,CSVWriter.DEFAULT_ESCAPE_CHARACTER,CSVWriter.DEFAULT_LINE_END);
        String[] headerRow = {"NEW_CONSUMER_NO","NGB_OLD_CONSUMER_NO","SYBASE_OLD_CONSUMER_NO",
                                "SYBASE_TOTAL_UNIT","NGB_TOTAL_UNIT","DIFF_TOTAL_UNIT",
                                "SYBASE_NET_BILL1","NGB_NET_BILL1","DIFF_NET_BILL1",
                                "SYBASE_ENERGY_CHARGE","NGB_ENERGY_CHARGE","DIFF_ENERGY_CHARGE"};
        csvWriter.writeNext(headerRow);

        int consumerMatchCount = 0;
        for(NGBBillFile ngbBillFile : ngbBillFiles){
            String oldConsumerNo = ngbBillFile.getOldConsNo();
            String[] split = oldConsumerNo.split("-");
            String ngbConsNo1 = split[2].trim();

            int count =0;
            for(SybaseBillFile sybaseBillFile : sybaseBillFiles){
                if(sybaseBillFile == null || count == 0){
                    count++;
                    //System.out.println(methodName + "For count " + count + " For " + sybaseBillFile);
                    continue;
                }
                String sybaseConsNo1 = sybaseBillFile.getConsNo1().replaceFirst("^0+(?!$)", "");
                //System.out.println(methodName + sybaseConsNo1 + " " + ngbConsNo1);
                if(sybaseConsNo1.trim().equalsIgnoreCase(ngbConsNo1.trim())){
                    consumerMatchCount++;
                    //System.out.println(methodName + ngbBillFile.getConsumerNo() + "," + ngbConsNo1 + "," + sybaseConsNo1 + "," +"Sybase Total Unit," + sybaseBillFile.getTotUnits1() + "," + "NGB Total Unit," + ngbBillFile.getTotUnits1());
                    //Total Unit
                    BigDecimal sybaseTotUnit1 = new BigDecimal(sybaseBillFile.getTotUnits1());
                    BigDecimal ngbTotUnit1 = ngbBillFile.getTotUnits1();

                    //Net Bill
                    BigDecimal sybaseNetBill1 = new BigDecimal(sybaseBillFile.getNetBill1());
                    BigDecimal ngbNetBill1 = new BigDecimal(ngbBillFile.getNetBill1());

                    //Energy Charge
                    BigDecimal sybaseEnergyCharge = new BigDecimal(sybaseBillFile.getEnch());
                    BigDecimal ngbEnergyCharge = ngbBillFile.getEnergyCharge();
                    String[] row = {ngbBillFile.getConsumerNo(),ngbConsNo1,sybaseConsNo1,
                            sybaseBillFile.getTotUnits1(),String.valueOf(ngbBillFile.getTotUnits1()),String.valueOf(sybaseTotUnit1.subtract(ngbTotUnit1)),
                            sybaseBillFile.getNetBill1(),ngbBillFile.getNetBill1(),String.valueOf(sybaseNetBill1.subtract(ngbNetBill1)),
                            sybaseBillFile.getEnch(),String.valueOf(ngbBillFile.getEnergyCharge()),String.valueOf(sybaseEnergyCharge.subtract(ngbEnergyCharge).setScale(4,BigDecimal.ROUND_HALF_EVEN))
                    };
                    csvWriter.writeNext(row);
                }
            count++;
            }
        }
        System.out.println(methodName + "Total Count for match is " + consumerMatchCount);

    }

}

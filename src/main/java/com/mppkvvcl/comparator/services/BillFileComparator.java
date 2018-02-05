package com.mppkvvcl.comparator.services;

import com.mppkvvcl.comparator.beans.NGBBillFile;
import com.mppkvvcl.comparator.beans.SybaseBillFile;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by sumit verma on 04-02-2018.
 */
public class BillFileComparator {
    private static final String DOMESTIC_CSV_FILE_PATH_NGB = "C:\\Users\\sumit verma\\Downloads\\NGB_Bill_file\\NGB_Bill_file\\BillFile_DEC-2017_IGY11_ENGLISH_DOMESTIC (4).txt";
    private static final String DOMESTIC_CSV_FILE_PATH_SYBASE = "C:\\Users\\sumit verma\\Downloads\\sybase_bill_file\\sybase_bill_file\\BNG_INGO_DL_DEC17.mats";
    public static void compare() throws IOException {
        final String methodName = "compare() : ";

        /*          Reader ngbReader = Files.newBufferedReader(Paths.get(DOMESTIC_CSV_FILE_PATH_NGB));
                  CsvToBean ngbCsvToBean = new CsvToBeanBuilder(ngbReader)
                          .withType(NGBBillFile.class)
                          .withIgnoreLeadingWhiteSpace(true)
                          .build();
                  List<NGBBillFile> ngbBillFiles = ngbCsvToBean.parse();
                  if(ngbBillFiles != null && ngbBillFiles.size() > 0){
                      //System.out.println(methodName + "Consumer No is " + ngbBillFiles.get(0).getConsumerNo());
                      System.out.println(methodName + "Size of NGB Bill File is " + ngbBillFiles.size());
                  }

                  Reader sybaseReader = Files.newBufferedReader(Paths.get(DOMESTIC_CSV_FILE_PATH_SYBASE));
        */
        System.out.println(methodName + "Character value of" + Character.valueOf('\t') + "PLAIN t" + Character.valueOf('9'));
            /*CsvToBean sybaseCsvToBean = new CsvToBeanBuilder(sybaseReader).withSeparator('9')
                    .withType(SybaseBillFile.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            List<SybaseBillFile> sybaseBillFiles = sybaseCsvToBean.parse();
            System.out.println(methodName + "Before if " + sybaseBillFiles);
            if(sybaseBillFiles != null && sybaseBillFiles.size() > 0){
                System.out.println(methodName + "Size of Sybase Bill File is " + sybaseBillFiles.size());
            }
*/
            /*ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
            strategy.setType(SybaseBillFile.class);
            String[] columns = new String[]{"divisionName","locationCode","groupNo","readerNo","consumerNo"};
            strategy.setColumnMapping(columns);
            CsvToBean csvToBean = new CsvToBean();
            CsvToBean csvToBean1 = new CsvToBeanBuilder().withSeparator('\t').withType(SybaseBillFile.class).
            CSVReader csvReader = new CSVReader(new FileReader(DOMESTIC_CSV_FILE_PATH_SYBASE),'\t');
            List<SybaseBillFile> sybaseBillFiles = csvToBean.parse(strategy,csvReader);
            System.out.println(methodName + "Before if " + sybaseBillFiles);
            if(sybaseBillFiles != null && sybaseBillFiles.size() > 0){
                System.out.println(methodName + "Size of Sybase Bill File is " + sybaseBillFiles.get(0));
            }*/


    }
}

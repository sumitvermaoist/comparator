package com.mppkvvcl.comparator.services;

import com.mppkvvcl.comparator.beans.NGBBillFile;
import com.mppkvvcl.comparator.beans.OSybaseBillFile;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OBillFileComparator {
    //private static final String OTHER_THAN_DOMESTIC_CSV_FILE_PATH_NGB = "E:\\ngb\\NDL\\BRR";
    //private static final String OTHER_THAN_DOMESTIC_CSV_FILE_PATH_NGB = "E:\\ngb\\NDL\\IGY";
    //private static final String OTHER_THAN_DOMESTIC_CSV_FILE_PATH_NGB = "E:\\ngb\\NDL\\JHP";
    //private static final String OTHER_THAN_DOMESTIC_CSV_FILE_PATH_NGB = "E:\\ngb\\NDL\\KRK";
    //private static final String OTHER_THAN_DOMESTIC_CSV_FILE_PATH_NGB = "E:\\ngb\\NDL\\PRJ";
    private static final String OTHER_THAN_DOMESTIC_CSV_FILE_PATH_NGB = "E:\\ngb\\NDL\\RNZ";
    //private static final String OTHER_THAN_DOMESTIC_CSV_FILE_PATH_SYBASE = "E:\\sybase\\NDL\\BNG_BNGR_OT_DEC17.mats";
    //private static final String OTHER_THAN_DOMESTIC_CSV_FILE_PATH_SYBASE = "E:\\sybase\\NDL\\BNG_INGO_OT_DEC17.mats";
    //private static final String OTHER_THAN_DOMESTIC_CSV_FILE_PATH_SYBASE = "E:\\sybase\\NDL\\BNG_JPUR_OT_DEC17.mats";
    //private static final String OTHER_THAN_DOMESTIC_CSV_FILE_PATH_SYBASE = "E:\\sybase\\NDL\\BNG_KKHURD_OT_DEC17.mats";
    //private static final String OTHER_THAN_DOMESTIC_CSV_FILE_PATH_SYBASE = "E:\\sybase\\NDL\\BNG_PZAR_OT_DEC17.mats";
    private static final String OTHER_THAN_DOMESTIC_CSV_FILE_PATH_SYBASE = "E:\\sybase\\NDL\\BNG_RUNIJAOT_FEB18.mats";

    public static void compare() throws IOException {
        final String methodName = "compare() : ";

        /**
         * Reading from NGB-BILL-FILE for Domestic starts here
         */
        File[] files = getFiles(OTHER_THAN_DOMESTIC_CSV_FILE_PATH_NGB);
        List<NGBBillFile> ngbBillFiles = new ArrayList<>();
        for(File file : files){
            List<NGBBillFile> temp = getNGBBillFiles(file.getCanonicalPath());
            if(temp != null && temp.size() > 0){
                ngbBillFiles.addAll(temp);
            }
        }

        /**
         * Reading from Sybase-Bill-File for Domestic starts here
         */
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(OSybaseBillFile.class);
        String[] columns = new String[]{"divName",	"tariff",	"locCode1",	"groupNo1",	"readerNo1",	"consNo1",	"billMonth1",	"billNo1",	"billDate",	"totUnits1",	"consName1",	"addr1",	"netBill1",	"addr2",	"addr3",	"phone1",	"mobile",	"chqDate1",	"cshDate1",	"pole",	"meterNo",	"phase",	"cirName1",	"rdgDate",	"connLoad",	"loadUnit",	"rdgType",	"contDem",	"maxDem",	"rdgCurr",	"rdgPrev",	"mf",	"pf",	"mtrUnits",	"assUnits",	"totUnits2",	"todUnits",	"locName",	"locAddr1",	"ench",	"locAddr2",	"fxch",	"locPhone",	"duty",	"cess",	"rent",	"offrName",	"adjmt",	"offrPhone",	"sdInst",	"capSch",	"deName",	"penalCh",	"dePhone",	"todSch",	"purpose",	"secDep",	"och",	"billType",	"sdDue",	"advAmt",	"sdInt",	"prevPymtHdr",	"lfRebate",	"cashMsg1",	"lockCr",	"cashMsg2",	"subsidy",	"cashMsg3",	"monthBill",	"arrs",	"netBill2",	"month1",	"rdgDate1",	"rdg1",	"surch",	"month2",	"rdgDate2",	"rdg2",	"netInclSurch1",	"month3",	"rdgDate3",	"rdg3",	"month4",	"rdgDate4",	"rdg4",	"month5",	"rdgDate5",	"rdg5",	"month6",	"rdgDate6",	"rdg6",	"avg1",	"avg2",	"cirName2",	"billMsg1",	"billMsg2",	"billMsg3",	"billMsg4",	"billMsg5",	"scrnMsg",	"billMonth2",	"billNo2",	"locCode2",	"groupNo2",	"readerNo2",	"consNo2",	"consName2",	"chqDate2",	"cshDate2",	"netBill3",	"netInclSurch2",	"cons1",	"cons2",	"cons3",	"cons4",	"cons5",	"cons6"};
        strategy.setColumnMapping(columns);
        CsvToBean csvToBean = new CsvToBean();
        //CsvToBean csvToBean1 = new CsvToBeanBuilder().withSeparator('\t').withType(SybaseBillFile.class).
        CSVReader csvReader = new CSVReader(new FileReader(OTHER_THAN_DOMESTIC_CSV_FILE_PATH_SYBASE),'\t');
        List<OSybaseBillFile> sybaseBillFiles = csvToBean.parse(strategy,csvReader);
        //System.out.println(methodName + "Before if " + sybaseBillFiles);
        if(sybaseBillFiles != null && sybaseBillFiles.size() > 0){
            System.out.println(methodName + "Size of Sybase Bill File is " + sybaseBillFiles.size());
            System.out.println(methodName + "Total units is " + sybaseBillFiles.get(1).getTotUnits1());
        }

        //Writer writer = Files.newBufferedWriter(Paths.get(DOMESTIC_CSV_FILE_PATH_WRITE));

        //CSVWriter csvWriter = new CSVWriter(writer,CSVWriter.DEFAULT_SEPARATOR,CSVWriter.NO_QUOTE_CHARACTER,CSVWriter.DEFAULT_ESCAPE_CHARACTER,CSVWriter.DEFAULT_LINE_END);
        String[] headerRow = {"NEW_CONSUMER_NO","NGB_OLD_CONSUMER_NO","SYBASE_OLD_CONSUMER_NO",
                "SYBASE_TOTAL_UNIT","NGB_TOTAL_UNIT","DIFF_TOTAL_UNIT",
                "SYBASE_NET_BILL1","NGB_NET_BILL1","DIFF_NET_BILL1",
                "SYBASE_ENERGY_CHARGE","NGB_ENERGY_CHARGE","DIFF_ENERGY_CHARGE",
                "SYBASE_FIXED_CHARGE","NGB_FIXED_CHARGE","DIFF_FIXED_CHARGE",
                "SYBASE_DUTY","NGB_DUTY","DIFF_DUTY",
                "SYBASE_RENT","NGB_RENT","DIFF_RENT",
                "SYBASE_ADJUSTMENT","NGB_ADJUSTMENT","DIFF_ADJUSTMENT",
                "SYBASE_SEC_DEP","NGB_SEC_DEP","DIFF_SEC_DEP",
                "SYBASE_SD_INT","NGB_SD_INT","DIFF_SD_INT",
                "SYBASE_LOCK_CREDIT","NGB_LOCK_CREDIT","DIFF_LOCK_CREDIT",
                "SYBASE_SUBSIDY","NGB_SUBSIDY","DIFF_SUBSIDY",
                "SYBASE_MONTH_BILL","NGB_MONTH_BILL","DIFF_MONTH_BILL",
                "SYBASE_ARREAR","NGB_ARREAR","DIFF_ARREAR"};

        FileWriter fileWriterException = new FileWriter("e:\\Exception.txt",true);
        //csvWriter.writeNext(headerRow);
        writeToFile(headerRow);
        int consumerMatchCount = 0;
        for(NGBBillFile ngbBillFile : ngbBillFiles){
            String oldConsumerNo = ngbBillFile.getOldConsNo();
            String[] split = oldConsumerNo.split("-");
            String ngbConsNo1 = split[2].trim();
            String[] row = null;
            try{
                row = getRow(sybaseBillFiles,ngbBillFile,ngbConsNo1);
            }catch (Exception e){
                System.out.println(methodName + "Exception occured for " + ngbConsNo1);

                fileWriterException.write("Exception occured for " + "," + ngbConsNo1);
                fileWriterException.write("\r\n");


            }

            if(row != null){
                consumerMatchCount++;
                //csvWriter.writeNext(row);
                writeToFile(row);
            }
        }
        System.out.println(methodName + "Total Count for match is " + consumerMatchCount);
        fileWriterException.close();
    }

    public static String [] getRow(List<OSybaseBillFile> sybaseBillFiles,NGBBillFile ngbBillFile,String ngbConsNo1){
        final String methodName = "getRow() : ";
        System.out.println(methodName + "called");
        int count = 0;
        for(OSybaseBillFile sybaseBillFile : sybaseBillFiles){
            if(sybaseBillFile != null && count > 0){
                String sybaseConsNo1 = sybaseBillFile.getConsNo1().replaceFirst("^0+(?!$)", "");
                if(sybaseConsNo1.trim().equalsIgnoreCase(ngbConsNo1.trim())){

                    //Total Unit
                    BigDecimal sybaseTotUnit1 = new BigDecimal(sybaseBillFile.getTotUnits1());
                    BigDecimal sybaseTodUnits = new BigDecimal(sybaseBillFile.getTodUnits());

                    sybaseTodUnits = sybaseTodUnits.max(sybaseTotUnit1);
                    /*if(sybaseTodUnits.compareTo(BigDecimal.ZERO) == 0){
                        sybaseTodUnits = sybaseTotUnit1;
                    }
                    */
                    BigDecimal ngbTotUnit1 = ngbBillFile.getTotUnits1();

                    //Net Bill
                    BigDecimal sybaseNetBill1 = new BigDecimal(sybaseBillFile.getNetBill1());
                    BigDecimal ngbNetBill1 = new BigDecimal(ngbBillFile.getNetBill1());

                    //Energy Charge
                    BigDecimal sybaseEnergyCharge = new BigDecimal(sybaseBillFile.getEnch());
                    BigDecimal ngbEnergyCharge = ngbBillFile.getEnergyCharge();

                    //Fixed Charge
                    BigDecimal sybaseFixedCharge = new BigDecimal(sybaseBillFile.getFxch());
                    BigDecimal ngbFixedCharge = ngbBillFile.getFixedCharge();

                    //Penal Charge
                    BigDecimal sybasePenalCharge = new BigDecimal(sybaseBillFile.getPenalCh());
                    if(sybasePenalCharge != null){
                        sybaseFixedCharge = sybaseFixedCharge.add(sybasePenalCharge);
                        System.out.println("Sybase Penal Charge " + sybasePenalCharge + " Sybase Fixed Charge " +sybaseFixedCharge);
                    }

                    //Electricity Duty
                    BigDecimal sybaseDuty = new BigDecimal(sybaseBillFile.getDuty());
                    BigDecimal ngbDuty = ngbBillFile.getDuty();

                    //Rent
                    BigDecimal sybaseRent = new BigDecimal(sybaseBillFile.getRent());
                    BigDecimal ngbRent = ngbBillFile.getRent();

                    //Adjustment
                    BigDecimal sybaseAdjustment = new BigDecimal(sybaseBillFile.getAdjmt());
                    BigDecimal ngbAdjustment = ngbBillFile.getAdjustment();

                    //Security Deposit
                    BigDecimal sybaseSecurityDeposit = new BigDecimal(sybaseBillFile.getSecDep());
                    BigDecimal ngbSecurityDeposit = ngbBillFile.getSecurityDeposit();

                    //SD interest
                    BigDecimal sybaseSDInterest = new BigDecimal(sybaseBillFile.getSdInt());
                    BigDecimal ngbSDInterest = ngbBillFile.getSecurityDepositInterest();

                    //Lock Credit
                    BigDecimal sybaseLockCredit = new BigDecimal(sybaseBillFile.getLockCr());
                    BigDecimal ngbLockCredit = ngbBillFile.getLockCredit();

                    //Subsidy
                    BigDecimal sybaseSubsidy = new BigDecimal(sybaseBillFile.getSubsidy());
                    BigDecimal ngbSubsidy = ngbBillFile.getSubsidy();

                    //Month Bill
                    BigDecimal sybaseMonthBill = new BigDecimal(sybaseBillFile.getMonthBill());
                    BigDecimal ngbMonthBill = ngbBillFile.getMonthBill();

                    //Arrear
                    BigDecimal sybaseArrear = new BigDecimal(sybaseBillFile.getArrs());
                    BigDecimal ngbArrear = ngbBillFile.getArrear();

                    //Advance Amount
                    BigDecimal advanceAmount = new BigDecimal(sybaseBillFile.getAdvAmt());
                    sybaseArrear = sybaseArrear.add(advanceAmount);
                    String[] row = {ngbBillFile.getConsumerNo(),ngbConsNo1,sybaseConsNo1,
                            String.valueOf(sybaseTodUnits),String.valueOf(ngbBillFile.getTotUnits1()),String.valueOf(sybaseTodUnits.subtract(ngbTotUnit1)),
                            sybaseBillFile.getNetBill1(),ngbBillFile.getNetBill1(),String.valueOf(sybaseNetBill1.subtract(ngbNetBill1)),
                            sybaseBillFile.getEnch(),String.valueOf(ngbBillFile.getEnergyCharge()),String.valueOf(sybaseEnergyCharge.subtract(ngbEnergyCharge).setScale(4,BigDecimal.ROUND_HALF_EVEN)),
                            String.valueOf(sybaseFixedCharge),String.valueOf(ngbBillFile.getFixedCharge()),String.valueOf(sybaseFixedCharge.subtract(ngbFixedCharge).setScale(4,BigDecimal.ROUND_HALF_EVEN)),
                            sybaseBillFile.getDuty(),String.valueOf(ngbBillFile.getDuty()),String.valueOf(sybaseDuty.subtract(ngbDuty).setScale(4,BigDecimal.ROUND_HALF_EVEN)),
                            sybaseBillFile.getRent(),String.valueOf(ngbBillFile.getRent()),String.valueOf(sybaseRent.subtract(ngbRent).setScale(4,BigDecimal.ROUND_HALF_EVEN)),
                            sybaseBillFile.getAdjmt(),String.valueOf(ngbBillFile.getAdjustment()),String.valueOf(sybaseAdjustment.subtract(ngbAdjustment).setScale(4,BigDecimal.ROUND_HALF_EVEN)),
                            sybaseBillFile.getSecDep(),String.valueOf(ngbBillFile.getSecurityDeposit()),String.valueOf(sybaseSecurityDeposit.subtract(ngbSecurityDeposit).setScale(4,BigDecimal.ROUND_HALF_EVEN)),
                            sybaseBillFile.getSdInt(),String.valueOf(ngbBillFile.getSecurityDepositInterest()),String.valueOf(sybaseSDInterest.add(ngbSDInterest).setScale(4,BigDecimal.ROUND_HALF_EVEN)),
                            sybaseBillFile.getLockCr(),String.valueOf(ngbBillFile.getLockCredit()),String.valueOf(sybaseLockCredit.subtract(ngbLockCredit).setScale(4,BigDecimal.ROUND_HALF_EVEN)),
                            sybaseBillFile.getSubsidy(),String.valueOf(ngbBillFile.getSubsidy()),String.valueOf(sybaseSubsidy.add(ngbSubsidy).setScale(4,BigDecimal.ROUND_HALF_EVEN)),
                            sybaseBillFile.getMonthBill(),String.valueOf(ngbBillFile.getMonthBill()),String.valueOf(sybaseMonthBill.subtract(ngbMonthBill).setScale(4,BigDecimal.ROUND_HALF_EVEN)),
                            String.valueOf(sybaseArrear),String.valueOf(ngbBillFile.getArrear()),String.valueOf(sybaseArrear.subtract(ngbArrear).setScale(4,BigDecimal.ROUND_HALF_EVEN))
                    };
                    //csvWriter.writeNext(row);
                    return row;
                }
            }
            count++;
        }
        return null;
    }

    public static final String FILE_PATH = "e:\\DIFFERENCE.txt";

    public static void writeToFile(String[] row){
        String methodName = "writeToFile() : ";
        System.out.println(methodName + "called");
        if(row != null){
            try{
                FileWriter fileWriter = new FileWriter(FILE_PATH,true);
                for(String data : row){
                    fileWriter.write(data);
                    fileWriter.write(",");
                }
                fileWriter.write("\r\n");
                fileWriter.close();
            }catch (IOException ioException){
                System.out.println(methodName + "IOException while creating txt file " + ioException);
                ioException.printStackTrace();
            }
        }
    }

    private static List<NGBBillFile> getNGBBillFiles(String path) throws IOException {
        final String methodName = "getNGBBillFiles() : ";
        System.out.println(methodName + "called");
        Reader ngbReader = Files.newBufferedReader(Paths.get(path));
        CsvToBean ngbCsvToBean = new CsvToBeanBuilder(ngbReader)
                .withType(NGBBillFile.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        List<NGBBillFile> ngbBillFiles = ngbCsvToBean.parse();
        if(ngbBillFiles != null && ngbBillFiles.size() > 0){
            System.out.println(methodName + "File " + path + " has " + ngbBillFiles.size() + "records");
        }
        return ngbBillFiles;
    }

    private static File[] getFiles(String folderPath) throws IOException{
        final String methodName = "getFiles() : ";
        System.out.println(methodName + "called");
        File[] files = new File(folderPath).listFiles();
        return files;
    }

}

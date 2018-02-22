package com.mppkvvcl.comparator;

import com.mppkvvcl.comparator.services.BillFileComparator;
import com.mppkvvcl.comparator.services.OBillFileComparator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ComparatorApplication {

	public static void main(String[] args) throws IOException {
		//BillFileComparator.compare();
		//SpringApplication.run(ComparatorApplication.class, args);
		OBillFileComparator.compare();
	}
}

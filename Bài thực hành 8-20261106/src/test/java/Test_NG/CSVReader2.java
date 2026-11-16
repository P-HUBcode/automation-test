package Test_NG;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.Test;
import com.opencsv.CSVReader;

public class CSVReader2 {
    @Test
    public void ReadCSVFile() throws Exception {
        String path = "csvtest.csv";
        if (!new File(path).exists()) {
            path = "F:\\csvtest.csv";
        }
        
        Reader reader = new FileReader(path);
        try (CSVReader csvreader = new CSVReader(reader)) {
            List<String[]> list = csvreader.readAll();
            Iterator<String[]> ite = list.iterator();
            while (ite.hasNext()) {
                String[] data = ite.next();
                if (data.length >= 3) {
                    System.out.println("TestID: " + data[0]); // Ví dụ: Lấy nội dung này nạp tự động vô ô Textbox "TestID"
                    System.out.println("Địa chỉ: " + data[1]); // Ví dụ: Lấy nội dung này nạp tự động vô ô Textbox "Địa chỉ"
                    System.out.println("Kịch bản: " + data[2]); // Ví dụ: Lấy nội dung này nạp tự động vô ô Textbox "Kịch bản"
                    if (data.length > 3) {
                        System.out.println("Mô tả: " + data[3]); // Ví dụ: Lấy nội dung này nạp tự động vô ô Textbox "Mô tả"
                    }
                }
                System.out.println("--------------------");
            }
        }
    }
}

package OpenCSV;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
   /*
    #Use the car sales data set for this task

1)print the number of rows from this data set
2)Print a list of manufacturers in the data set
3)print the model whose horsepower is the maximum
4)show data of cars whose fuel efficiency was between 10 to 15
5)show data of cars whose latest launch was in 2011

    */

    public static void main(String[] args) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get("Car_sales.csv"));

        CSVParser parser = new CSVParserBuilder()
                .withSeparator(',')
                .build();

        CSVReader obj = new CSVReaderBuilder(reader)
                .withCSVParser(parser)
                .build();
        //Print list of manufactures data in the dataset
        Iterator<String[]> itr = obj.iterator();//it has no data now it is not for storing data
        List<String> l1 = new LinkedList<>();
        while (itr.hasNext()) {
            String[] temp = itr.next();//here data is obtained
            l1.add(temp[0]);
        }
        l1.stream()
                .limit(10)
                .forEach(x-> System.out.println(x[10]));
        
        //Print the model whose fuel efficiiency was beetween 10 to 15
        Iterator<String[]> itr1 = obj.iterator();//it has no data now it is not for storing data
        List<String> l2 = new LinkedList<>();
        while (itr.hasNext()) {
            String[] temp = itr.next();//here data is obtained
            l2.add(temp[13]);
        }
        l2.stream()
                .filter(x->x[13]<15 && x[13]>10)
                .forEach(x-> System.out.println(x[13]));
        //Show data of cars whose latest launch was in 2011
        Iterator<String[]> itr2 = obj.iterator();//it has no data now it is not for storing data
        List<String> l3 = new LinkedList<>();
        while (itr.hasNext()) {
            String[] temp = itr.next();//here data is obtained
            l3.add(temp[14]);
        }
        l3.stream()
                .filter(x->x[14].matches("2011"))
                .forEach(x-> System.out.println(x[14]));
        
    }
}

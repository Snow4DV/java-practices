package ru.snow4dv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String PATH = "/home/m1ke/temp/movementList.csv";
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> outcomeSums = new ArrayList<>();
        double incomeSum = 0;
        double outcomeSum = 0;

        try(CSVReader reader = new CSVReader(new FileReader(PATH))) {
            List<String[]> operations = reader.readAll();
            for (String[] operation :
                    operations) {
                double income = Double.parseDouble(operation[6].replace(',', '.'));
                double outcome = Double.parseDouble(operation[7].replace(',', '.'));

                if(outcome != 0) {
                    String company = operation[5].substring(28, 60).replace("/","");
                    outcomeSums.add(company + " " + outcome + operation[2]);
                }
                incomeSum += income;
                outcomeSum+=outcome;
            }

            System.out.printf("Сумма расходов: %f\n", outcomeSum);
            System.out.printf("Сумма доходов: %f\n", incomeSum);
            System.out.println("Сумма расходов по организациям:");
            for (String expense :
                    outcomeSums) {
                System.out.println(expense);
            }
        } catch(IOException exception) {
            System.err.println("I/O Error. Check if file is present.");
        } catch(CsvException exception) {
            System.err.println("CSV file parsing error.");
            System.err.println(exception.toString());
        }

    }
}
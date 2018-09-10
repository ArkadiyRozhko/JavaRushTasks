package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String personFromFile=fileScanner.nextLine();
            String[]data=personFromFile.split(" ",4);
            String firstName=data[1];
            String middleName=data[2];
            String lastName=data[0];
            SimpleDateFormat format=new SimpleDateFormat("dd MM yyyy");
            Date birthDate = null;
            try {
                birthDate=format.parse(data[3]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Person person=new Person(firstName,middleName,lastName,birthDate);

            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();

        }
    }
}

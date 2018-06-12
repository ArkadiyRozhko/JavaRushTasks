package com.javarush.task.task17.task1710;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        String name;
        Sex sex;
        Date db;
        Person person;
        int id;
        int index;
        DateFormat format = new  SimpleDateFormat("dd/MM/yy");

        switch (args[0]){
            case "-c":
                db=format.parse(args[3]);
                name=args[1];

                if (args[2].equals("м")) {
                    allPeople.add(Person.createMale(name,db));
                }else if (args[2].equals("ж")) {
                    allPeople.add(Person.createFemale(name,db));
                }
                id=allPeople.size()-1;
                System.out.println(id);
                break;
            case "-u":
                id=Integer.parseInt(args[1]);
                name=args[2];
                db=format.parse(args[4]);
                person=allPeople.get(id);
                person.setName(name);
                if (args[3].equals("м")) {
                    sex=Sex.MALE;
                    person.setSex(sex);
                }else if (args[3].equals("ж")){
                    sex=Sex.FEMALE;
                    person.setSex(sex);
                }
                person.setBirthDay(db);
                break;
            case "-d":
                id=Integer.parseInt(args[1]);
                name=null;
                db=null;
                person=allPeople.get(id);
                person.setName(name);
                person.setSex(null);
                person.setBirthDay(db);
                break;
            case "-i":
                DateFormat format1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                id=Integer.parseInt(args[1]);
                person=allPeople.get(id);
                name=person.getName();
                sex=person.getSex();
                db=person.getBirthDay();
                if (sex==Sex.MALE){
                    System.out.println(name +" м "+format1.format(db));
                }else if (sex==Sex.FEMALE){
                    System.out.println(name + " ж " +format1.format(db));
                }
                break;
        }
    }

}

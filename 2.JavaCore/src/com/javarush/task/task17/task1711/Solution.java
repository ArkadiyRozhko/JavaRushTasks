package com.javarush.task.task17.task1711;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        switch (args[0]){
            case "-c":
                synchronized (allPeople) {
                    try {
                        Create(args);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    try {
                        Update(args);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    Delete(args);
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    Info(args);
                }
                break;

        }

    }

    static void Create(String[] arg) throws ParseException {
        DateFormat format=new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 1; i <arg.length ; i+=3) {
            String name=arg[i];
            Date db=format.parse(arg[i+2]);
            if (arg[i+1].equals("м")) {
                allPeople.add(Person.createMale(name,db));
            }else if (arg[i+1].equals("ж")) {
                allPeople.add(Person.createFemale(name,db));
            }
            int id=allPeople.size()-1;
            System.out.println(id);
        }
    }
    static void Update(String[] arg) throws ParseException {
        DateFormat format=new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 1; i <arg.length ; i+=4) {
            int id = Integer.parseInt(arg[i]);
            String name=arg[i+1];
            Date db = format.parse(arg[i+3]);
            Person person=allPeople.get(id);
            person.setName(name);
            person.setBirthDay(db);
            if (arg[i+2].equals("м")) {
                person.setSex(Sex.MALE);
            }else if (arg[i+2].equals("ж")) {
                person.setSex(Sex.FEMALE);
            }
        }
    }
    static void Delete(String[] arg){
        for (int i = 1; i <arg.length ; i++) {
            int id = Integer.parseInt(arg[i]);
            Person person=allPeople.get(id);
            person.setName(null);
            person.setBirthDay(null);
            person.setSex(null);
        }
    }
    static void Info(String[] arg){
        DateFormat format=new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        for (int i = 1; i <arg.length ; i++) {
            int id = Integer.parseInt(arg[i]);
            Person person=allPeople.get(id);
            Date db = person.getBirthDay();
            if (person.getSex() == Sex.MALE) {
                System.out.println(person.getName()+" м "+format.format(db));
            }else if (person.getSex() == Sex.FEMALE) {
                System.out.println(person.getName()+" ж "+format.format(db));
            }
        }
    }

}

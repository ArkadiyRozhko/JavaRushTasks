package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Externalizable {
    public static void main(String[] args)
    {
        System.out.println(new Solution(4));
        try(FileOutputStream fos=new FileOutputStream("D:\\1\\2.txt");FileInputStream fis=new FileInputStream("D:\\1\\2.txt")) {
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            Solution savedObject=new Solution(10);
            oos.writeObject(savedObject);
            oos.close();


            ObjectInputStream ois=new ObjectInputStream(fis);
            Solution loadedObject=new Solution(5);
            loadedObject=(Solution)ois.readObject();
            System.out.println(savedObject.string.equals(loadedObject.string));
            ois.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Solution(){};

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(string);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        string=(String)in.readObject();
    }
}

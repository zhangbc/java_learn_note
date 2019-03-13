package com.runoob;

import java.io.*;

/**
 * Employee类实现Serializable接口
 * @author 张伯成
 * @date 2019/3/7 12:30
 */
public class Employee implements Serializable {
    public String name;
    public String address;
    public transient int SSN;
    public int number;

    public void mailCheck() {
        System.out.println("Mailing a check to " + name + " " + address);
    }
}


/**
 * SerializeDemo类，序列化对象
 */
class SerializeDemo {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.name = "Reyan Ali";
        employee.address = "Phonkka kuan, Ambehta Peer.";
        employee.SSN = 11122333;
        employee.number = 101;

        try {
            FileOutputStream fileOut = new
                    FileOutputStream("employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(employee);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in employee.ser.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}


/**
 * DeserializeDemo类，反序列化对象
 */
class DeserializeDemo {
    public static void main(String[] args) {
        Employee employee;
        try {
            FileInputStream fileIn = new FileInputStream("employee.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            employee = (Employee) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            return;
        } catch (ClassNotFoundException ex) {
            System.out.println("Employee class not found.");
            ex.printStackTrace();
            return;
        }
        System.out.println("Deserialize Employee...");
        System.out.println("Name: " + employee.name);
        System.out.println("Address: " + employee.address);
        System.out.println("SSN: " + employee.SSN);
        System.out.println("Number: " + employee.number);
    }
}
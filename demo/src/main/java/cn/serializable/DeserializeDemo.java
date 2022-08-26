package cn.serializable;

import java.io.*;

public class DeserializeDemo {
    public static void main(String[] args) throws IOException {
        Employee e = null;

        FileInputStream fileIn = null;
        try {
            fileIn = new FileInputStream("/tmp/employee.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            e = (Employee) in.readObject();
            in.close();
            fileIn.close();
        } catch (FileNotFoundException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        System.out.println("Deserialized class not found");
        System.out.println("Name:" + e.name);
        System.out.println("Address:" + e.address);
        System.out.println("SSN:" + e.SSN);
        System.out.println("Number:" + e.number);
    }
}

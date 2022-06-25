package oop.inheritance.transaction;

import java.io.*;

public class Serializer {
    public static byte[] serialize(Object obj)  {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        ObjectOutputStream o = null;
        try {
            o = new ObjectOutputStream(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            o.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b.toByteArray();
    }

    public static Object deserialize(byte[] bytes) {
        ByteArrayInputStream b = new ByteArrayInputStream(bytes);
        ObjectInputStream o = null;
        try {
            o = new ObjectInputStream(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return o.readObject();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}

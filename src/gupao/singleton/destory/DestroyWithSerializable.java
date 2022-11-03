package gupao.singleton.destory;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import gupao.singleton.hungry.Singleton;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 如何利用序列化 & 反序列化来破坏单例，以及应该如何解决这个问题？
 */
public class DestroyWithSerializable {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteOutputStream byteOutputStream = new ByteOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteOutputStream);
        objectOutputStream.writeObject(Singleton.getInstance());

        ByteInputStream byteInputStream = new ByteInputStream(byteOutputStream.getBytes(), byteOutputStream.getBytes().length);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteInputStream);
        Singleton singleton = (Singleton)objectInputStream.readObject();
        System.out.println("序列化反序列后的对象是"+singleton);
        System.out.println("直接调用类的方法获得的实例是"+Singleton.getInstance());

    }

}

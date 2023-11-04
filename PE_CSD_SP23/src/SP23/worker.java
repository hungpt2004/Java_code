/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SP23;

/**
 *
 * @author Acer
 */
public class worker {
    private int key;
    private String name;
    private int age;

    worker(int key, String name, int age) {
        this.key = key;
        this.name = name;
        this.age = age;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "worker{" + "key=" + key + ", name=" + name + ", age=" + age + '}';
    }
    
    
}

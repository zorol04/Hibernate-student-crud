package org.hibernate;

import javax.persistence.*;

@Entity
@Table(name ="Student")
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) /// auto incremnt in db
    private  int id;/// primary id
    @Column(name="name",nullable = false,length=50
    )
    private String name;
    @Column(name="age",nullable=false)
    private int age;
    @Column(name="city",nullable=false,length=50)
    private String city;

    // getter setter mtd
    public void setName(String name){
        this.name=name;
    }
    public void setAge(int age){
        this.age=age;
    }
    public void setCity(String city){
        this.city=city;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getCity(){
        return city;
    }
public Student(){}

    public Student(String name,int age,String city){
        this.name=name;
        this.age=age;
        this.city=city;
    }
    @Override
    public String toString(){
        return "student{"+"id :"+id +" |"+" "+"name :"+name+" |"+"age :"+age+" |" +"city :"+city;

    }
}
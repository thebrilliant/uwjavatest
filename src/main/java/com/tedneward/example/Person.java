package com.tedneward.example;

import java.beans.*;
import java.util.*;

public class Person implements Comparable<Person> {
  private int age;
  private String name;
  private double salary;
  private String ssn;
  private boolean propertyChangeFired = false;
  
  public Person() {
    this("", 0, 0.0d);
  }
  
  public Person(String n, int a, double s) {
    name = n;
    age = a;
    salary = s;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    if(age < 0) {
      throw new IllegalArgumentException();
    }
    this.age = age;
  }

  public static class AgeComparator implements Comparator<Person> {
    public int compare(Person p1, Person p2) {
      return p1.age - p2.age;
    }
  }
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    if (name == null) {
      throw new IllegalArgumentException();
    }
    this.name = name;
  }
  
  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }
  
  public String getSSN() {
    return ssn;
  }

  public void setSSN(String value) {
    String old = ssn;
    ssn = value;
    
    this.pcs.firePropertyChange("ssn", old, value);
    propertyChangeFired = true;
  }

  public int count() {
    return 0;
  }

  public static ArrayList<Person> getNewardFamily() {
    ArrayList<Person> temp = new ArrayList<Person>();
    temp.add(new Person("Ted", 41, 250000));
    temp.add(new Person("Charlotte", 43, 150000));
    temp.add(new Person("Michael", 22, 10000));
    temp.add(new Person("Matthew", 15, 0));
    return temp;
  }

  public boolean getPropertyChangeFired() {
    return propertyChangeFired;
  }

  public double calculateBonus() {
    return salary * 1.10;
  }
  
  public String becomeJudge() {
    return "The Honorable " + name;
  }
  
  public int timeWarp() {
    return age + 10;
  }
  
  public boolean equals(Person other) {
    return (this.name.equals(other.name) && this.age == other.age);
  }

  public String tostring() {
    return "[Person name:" + name + " age:" + age + " salary:" + salary + "]";
  }

  // PropertyChangeListener support; you shouldn't need to change any of
  // these two methods or the field
  //
  private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
  public void addPropertyChangeListener(PropertyChangeListener listener) {
      this.pcs.addPropertyChangeListener(listener);
  }
  public void removePropertyChangeListener(PropertyChangeListener listener) {
      this.pcs.removePropertyChangeListener(listener);
  }

  public int compareTo(Person other) {
    if (other.salary > this.salary) {
      return -1;
    } else if (other.salary == this.salary) {
      return 0;
    } else {
      return 1;
    }
  }
}

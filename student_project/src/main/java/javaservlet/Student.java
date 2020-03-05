package javaservlet;

public class Student  {
    String rollnumber;
    String name;
    String university;

    public Student(String rollnumber,String name, String university) {
        super();
        this.rollnumber=rollnumber;
        this.name=name;
        this.university=university;
    }

    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", university='" + university + '\'' + ", rollnumber=" + rollnumber + '}';
    }
  }

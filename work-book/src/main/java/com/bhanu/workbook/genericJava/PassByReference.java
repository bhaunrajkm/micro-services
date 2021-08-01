package com.bhanu.workbook.genericJava;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import lombok.Getter;
import lombok.Setter;

public class PassByReference {

  public static void main(String[] argsF) {
    Student student = new Student();
    student.setAge(25);
    abc(student);
    //System.out.println(student.getAge());

    int age = 25;
    abc(age);
//        System.out.println(age);
  }

  static void abc(Student s) {
    s.setAge(30);
  }

  static void abc(int s) {
    s = 30;
  }

  @Getter
  @Setter
  static
  class Student {

    private int age;
  }
}

package com.bhanu.workbook.genericJava;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class TreeHM {

    public static void main(String[] args) {
        Map<Student, String> map = new TreeMap<>(Collections.reverseOrder());
        map.put(new Student(2, 4), "bhanu");
        map.put(new Student(3, 5), "abcd");

        for (Map.Entry<Student, String> entry : map.entrySet()) {
            System.out.println(entry.getKey().getId());
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Student implements Comparable<Student> {
        private int id;
        private int age;

        @Override
        public int compareTo(Student o) {
            return this.getId() - o.getId();
        }
    }
}


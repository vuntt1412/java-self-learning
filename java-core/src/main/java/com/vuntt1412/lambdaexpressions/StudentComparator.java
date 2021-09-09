package com.vuntt1412.lambdaexpressions;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getScore().compareTo(s2.getScore());
    }
}

import javax.swing.*;
import javax.xml.parsers.FactoryConfigurationError;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Faculty{
    String name;
    int id;
    int n;

    Faculty(String n, int i, int num){
        name = n;
        id = i;
        this.n = num;
    }

}

class Course{
    String name;
    Faculty fac1, fac2, fac3;

    Course(String n, Faculty f1, Faculty f2, Faculty f3){
        name = n;
        fac1 = f1;
        fac2 = f2;
        fac3 = f3;
    }
}

class Student{
    String name;
    int regNo;
    String elect1;
    String elect2;
    String facult1;
    String facult2;

    Student(String n, int r, String e1, String e2, String f1, String f2){
        name = n;
        regNo = r;
        elect1 = e1;
        elect2 = e2;
        facult1 = f1;
        facult2 = f2;
    }
}


class ElectiveGUI extends JFrame{
    JList eleList1, eleList2;
    JTextArea res;
    JButton submit, showResult, display;
    JTextField studName, studReg;
    ArrayList<Course> courses;

    int cy;
    int cx;

    ElectiveGUI(){
        setTitle("SLELECT ELECTIVES");
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        cy = 0;

        String facultyNames[] = {"AAA", "BBB", "CCC", "DDD", "EEE", "FFF"};
        String courseNames[] = {"JAVA", "PYTHON"};

        //creating objects for each course and storing them in arraylist
        Faculty elec1F1 = new Faculty(facultyNames[0], 1, 10);
        Faculty elec1F2 = new Faculty(facultyNames[1], 2, 10);
        Faculty elec1F3 = new Faculty(facultyNames[2], 3, 10);
        Faculty elec2F1 = new Faculty(facultyNames[3], 4, 10);
        Faculty elec2F2 = new Faculty(facultyNames[4], 5, 10);
        Faculty elec2F3 = new Faculty(facultyNames[5], 6, 10);

        Course course1 = new Course(courseNames[0], elec1F1, elec1F2, elec1F3);
        Course course2 = new Course(courseNames[1], elec2F1, elec2F2, elec2F3);

        courses = new ArrayList<>();

        courses.add(course1);
        courses.add(course2);

        JLabel heading = new JLabel("Select two Electives");
        heading.setBounds(20, (cy+=30), 100, 30);
        heading.setFont(new Font("Roboto", Font.BOLD, 20));
        add(heading);

        String list1Values[] = {"JAVA AAA", "JAVA BBB", "JAVA CCC"};
        String list2Values[] = {"JAVA DDD", "JAVA EEE", "JAVA FFF"};

        eleList1 = new JList(list1Values);
        eleList1.setBounds(20, (cy+=30), 60, 60);
        eleList2 = new JList(list2Values);
        eleList2.setBounds(70, (cy), 60, 60);
        add(eleList1);
        add(eleList2);

        JLabel namLab = new JLabel("Student name: ");
        namLab.setBounds(20, (cy+=30), 100, 30);
        add(namLab);

        studName = new JTextField();
        studName.setBounds(120, cy, 200, 30);
        add(studName);

        JLabel regLab = new JLabel("RegNo: ");
        regLab.setBounds(20, (cy+=30), 100, 30);
        add(regLab);

        studReg = new JTextField();
        studReg.setBounds(120, cy, 200, 30);
        add(studReg);

        res = new JTextArea();
        res.setBounds(400, 30, 40, 80);
        res.setEditable(false);
        add(res);

        showResult = new JButton("Show result");
        showResult.setBounds(20, (cy+=40), 100, 30);
        add(showResult);

        submit = new JButton("Submit");
        submit.setBounds(130, (cy), 100, 30);
        add(submit);

        display = new JButton("Display");
        display.setBounds(240, (cy), 100, 30);
        add(display);

    }
}



public class Elective{
    public static void main(String args[]){
        ElectiveGUI e = new ElectiveGUI();
        e.setVisible(true);
    }
}
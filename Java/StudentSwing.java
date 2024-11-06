import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Student{
    String name;
    String regId;
    String depart;
    String cgpa;
    
    Student(String n, String r, String d, String c){
        name = n;
        regId = r;
        depart = d;
        cgpa = c;
    }

    public String toString(){
        return("Name: " + name +"\nRegNo: " + regId + "\nDepartment: " + depart + "\nCGPA: " + cgpa);
    }
}

class idComparator implements Comparator<Student>{
    public int compare(Student s1, Student s2){
        return s1.regId.compareTo(s2.regId);
    }
}

class StudentManagement extends JFrame{
    
    int cx,cy;
    JTextField sn, srgn, sd, sc, sergn;
    JTextArea res;
    JButton submit, display, search;
    ArrayList<Student> sl;

    StudentManagement(int w, int h){
        setLayout(null);
        setSize(w, h);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        cx = 0;
        cy = 0;
        sl = new ArrayList<Student>();

        sn = new JTextField();
        srgn = new JTextField();
        sd = new JTextField();
        sc = new JTextField();

        
        addL("Student Name: ", (cx+=20), (cy+=50), 100, 30);
        sn.setBounds((cx + 200), cy, 200, 30);

        addL("RegNo: ", (cx), (cy+=50), 100, 30);
        srgn.setBounds((cx + 200), cy, 200, 30);
        
        addL("Department: ", (cx), (cy+=50), 100, 30);
        sd.setBounds((cx + 200), cy, 200, 30);
        
        addL("CGPA: ", (cx), (cy+=50), 100, 30);
        sc.setBounds((cx + 200), cy, 200, 30);

        add(sn);
        add(srgn);
        add(sd);
        add(sc);

        res = new JTextArea();
        res.setBounds(cx+500, 50, 400, 600);
        add(res);

        submit = new JButton("Submit");
        submit.setBounds(250, (cy+=50), 100, 30);
        add(submit);

        display = new JButton("Display");
        display.setBounds(100, cy, 100, 30);
        add(display);

        search = new JButton("Search");
        search.setBounds(150, (cy+=50), 100, 30);
        add(search);

        
        sergn = new JTextField();
        
        JLabel sel = addL("Enter RegNo: ", (cx), (cy+=50), 100, 30);
        sergn.setBounds((cx + 200), cy, 200, 30);
        
        add(sergn);
        sergn.setVisible(false);
        sel.setVisible(false);

        // submit.addActionListener(new ActionLis);

        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(sn.getText() != null && srgn.getText() != null && sd.getText() != null && sc.getText() != null){
                    sl.add(new Student(sn.getText(), srgn.getText(), sd.getText(), sc.getText()));
                }

                res.setText("Added successfully");
            }
        });

        display.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Collections.sort(sl, new idComparator());

                for(Student s : sl){
                    res.append(s.toString());
                    res.append("\n");
                }
            }
        });

        search.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(sergn.isVisible() == false){
                    sergn.setVisible(true);
                    sel.setVisible(true);
                }

                if(!sel.getText().isEmpty()){
                    String id = sel.getText();

                    for(Student s : sl){
                        if(s.regId.equals(id)){
                            res.append("FOUND\n\n");
                            res.append(s.toString());
                            return;
                        }
                    }

                    res.append("Student not FOUND");
                }
            }
        });
    }

    public JLabel addL(String title, int x, int y, int w, int h){
        JLabel l = new JLabel(title);
        l.setBounds(x, y, w, h);
        add(l);
        return l;
    }
}

public class StudentSwing{
    public static void main(String args[]){
        new StudentManagement(1000, 1000);
    }
}
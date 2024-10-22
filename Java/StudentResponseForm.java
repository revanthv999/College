import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.*;

class Form {
    public JFrame frame;
    int cy;

    Form(String title, int w, int h){
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(w, h);
        frame.setVisible(true);

        cy = 0;

        JLabel ht = addL("Registration Form", 100, (cy+=20), 400, 40, JLabel.CENTER);
        ht.setFont(new Font("Roboto", Font.BOLD, 30));
        
        addL("Register No: ", 20, (cy+=70), 100, 30);
        addTF(200, (cy), 200, 30);

        addL("Name: ", 20, (cy+=50), 100, 30);
        addTF(200, (cy), 200, 30);

        addL("Father's Name: ", 20, (cy+=50), 100, 30);
        addTF(200, (cy), 200, 30);

        addL("Mobile: ", 20, (cy+=50), 100, 30);
        addTF(200, (cy), 200, 30);

        addL("DOB: ", 20, (cy+=50), 100, 30);
        addTF(200, (cy), 200, 30);

        addL("Gender: ", 20, (cy+=50), 100, 30);
        JRadioButton male = new JRadioButton("Male");
        male.setBounds(200, cy, 100, 30);
        JRadioButton female = new JRadioButton("Female");
        female.setBounds(300, cy, 100, 30);
        frame.add(male);
        frame.add(female);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        addL("Branch: ", 20, (cy+=50), 100, 30);
        String branches[] = {"CSE", "ECE"};
        JComboBox br = new JComboBox(branches);
        br.setBounds(200, cy, 100, 30);
        frame.add(br);

        addL("Address", 20, (cy+=50), 100,20);
        JTextArea ad = new JTextArea(10, 100);
        ad.setBounds(200, cy, 200, 60);
        frame.add(ad);
        
        addL("Electives: ", 20, (cy+=70), 100,20);
        JCheckBox py = new JCheckBox("Python");
        py.setBounds(200, cy, 100, 30);
        JCheckBox ma = new JCheckBox("Machine Learning");
        ma.setBounds(300, cy, 150, 30);
        JCheckBox iot = new JCheckBox("IoT");
        iot.setBounds(450, cy, 100, 30);

        frame.add(py);
        frame.add(ma);
        frame.add(iot);

        JButton su = new JButton("Submit");
        su.setBounds(250, (cy+=60), 100, 30);
        frame.add(su);
    }

    public JTextField addTF(int x, int y, int w, int h){
        JTextField t = new JTextField();
        t.setBounds(x, y, w, h);
        frame.add(t);
        return t;
    }

    public JLabel addL(String t, int x, int y, int w, int h){
        JLabel l = new JLabel(t);
        l.setBounds(x, y, w, h);
        frame.add(l);
        return l;
    }

    public JLabel addL(String t, int x, int y, int w, int h, int a){
        JLabel l = new JLabel(t, a);
        l.setBounds(x, y, w, h);
        frame.add(l);
        return l;
    }
}

public class StudentResponseForm{
    public static void main(String args[]){
        new Form("Student Response Form", 600, 800);
    }
}
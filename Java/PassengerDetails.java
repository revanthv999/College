import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

// name, dob, gender, berth preference

class InvalidAgeException extends Exception{
    InvalidAgeException(String msg){
        super(msg);
    }
}

class PassengerBookingGUI extends JFrame implements Runnable{
    JTextField name, dob, age;
    JRadioButton male, female;
    JComboBox berthPre;
    Thread moveThread;
    JLabel movingLabel;
    JButton submit;
    JTextArea res;
    int cy;
    int cx;

    PassengerBookingGUI(){
        setTitle("Passenger Ticket Booking System");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        cy = 0;
        cx = 0;

        movingLabel = new JLabel("BOOKING TRAIN TICKETS");
        movingLabel.setFont(new Font("Roboto", Font.BOLD, 30));
        // setBounds(200, (cy+=20), 300, 50);
        add(movingLabel);
        moveThread = new Thread(this);
        moveThread.start();

        add(new JLabel("Name: "));
        name = new JTextField(30);
        add(name);

        add(new JLabel("DOB: "));
        dob= new JTextField(30);
        add(dob);

        add(new JLabel("Gender: "));
        male = new JRadioButton("male");
        female = new JRadioButton("female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        add(male);
        add(female);

        add(new JLabel("Berth preference"));
        String preferences[] = {"LOWER", "MIDDLE", "UPPER"};
        berthPre = new JComboBox(preferences);
        add(berthPre);

        add(new JLabel("Age: "));
        age = new JTextField(30);
        age.setEditable(false);
        add(age);

        submit = new JButton("SUBMIT");
        add(submit);
        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                validateConditions();
            }
        });

        res = new JTextArea(10, 50);
        res.setEditable(false);
        add(new JScrollPane(res));

    }

    public void run(){
        try{
            int xpos = getWidth();
            while(true){
                xpos -= 5;
                if(xpos < 0){
                    xpos = getWidth();
                }
                movingLabel.setLocation(xpos, movingLabel.getY());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void validateConditions(){
        // Boolean allFields = true;
        String na = name.getText().trim();
        String db = dob.getText().trim();
        String ber = new String(berthPre.getSelectedItem());

        if(na.isEmpty() || na.isEmpty()){
            res.setText("Enter name and dob fields");
            return;
        }

        if(!male.isSelected() && !female.isSelected()){
            res.setText("Choose gender");
            return;
        }

        String gen = male.isSelected() ? "MALE" : "FEMALE";

        if(ber.isEmpty()){
            res.setText("Choose berth preference");
            return;
        }
        


        // String dbArray[] = db.split("/");
        // int date = Integer.parseInt(dbArray[0]);
        // int month = Integer.parseInt(dbArray[1]);
        // int year = Integer.parseInt(dbArray[2]);

        res.setText("Name: " + na + "\nDOB: " + db + "\nGender: " + gen + "\nBerthPreference: " + ber + "\n");

    }


}




 
public class PassengerDetails{
    public static void main(String args[]){
        System.out.println("Hello world!");
        PassengerBookingGUI p = new PassengerBookingGUI();
        p.setVisible(true);
    }
}
import javax.swing.*;
import java.awt.Font;


class LoginPage{
    JFrame frame;
    int cy;

    LoginPage(int w, int h){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(w, h);
        frame.setVisible(true);

        JLabel ht = addL("Welcome back!", 100, (cy+=20), 400, 40);
        ht.setFont(new Font("Roboto", Font.BOLD, 30));

        addL("Username: ", 70, (cy+=70), 100, 30);
        addTF(170, (cy), 140, 30);

        addL("Password: ", 70, (cy+=50), 100, 30);
        JPasswordField p = new JPasswordField();
        p.setBounds(170, (cy), 140, 30);
        frame.add(p);

        JButton su = new JButton("Submit");
        su.setBounds(150, (cy+=60), 100, 30);
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
}

public class StudentLogin {
    public static void main(String args[]){
        new LoginPage(400, 400);
    }
}

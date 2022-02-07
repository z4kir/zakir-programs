import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.StyleConstants.FontConstants;
import java.awt.event.*;


public class RegistrationForm extends JFrame {
    JLabel Name, Mobile, gender, DOB, heading, address, result;
    JTextField name, mobile;
    JRadioButton male, female;
    JCheckBox accept;
    JComboBox DD, MM, YYYY;
    JTextArea userinput, Address;
    JButton submit;


    RegistrationForm() {
        setSize(700, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        heading = new JLabel("Registration Form");
        heading.setBounds(170, 10, 200, 50);
        // Font f=new Font(Font.BOLD);
        // heading.setFont(f);;
        heading.setFont(new Font("Italic", Font.BOLD, 18));
        add(heading);


        Name = new JLabel("Name :");
        Name.setBounds(10, 70, 50, 20);
        add(Name);

        Mobile = new JLabel("Mobile :");
        Mobile.setBounds(10, 100, 50, 20);
        add(Mobile);

        gender = new JLabel("Gender :");
        gender.setBounds(10, 130, 50, 20);
        add(gender);

        DOB = new JLabel("DOB :");
        DOB.setBounds(10, 160, 50, 20);
        add(DOB);

        address = new JLabel("Address :");
        address.setBounds(10, 190, 70, 20);
        add(address);

        name = new JTextField();
        name.setBounds(90, 70, 200, 20);
        add(name);

        mobile = new JTextField();
        mobile.setBounds(90, 100, 200, 20);
        add(mobile);

        male = new JRadioButton("Male");
        male.setBounds(90, 130, 80, 20);
        add(male);
        male.setSelected(true);

        female = new JRadioButton("Female");
        female.setBounds(170, 130, 90, 20);
        add(female);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        Address = new JTextArea();
        Address.setBounds(90, 190, 200, 80);
        Address.setLineWrap(true);
        add(Address);

        String[] date = {"1", "2", "3", "4"};
        DD = new JComboBox<String>(date);
        DD.setBounds(90, 160, 40, 20);

        DD.setEditable(false);


        String month[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "Octuber", "November", "December"};
        MM = new JComboBox<String>(month);
        MM.setBounds(140, 160, 80, 20);

        String[] year = {"1995", "1996", "1997", "1998", "1999", "2000"};

        YYYY = new JComboBox<String>(year);
        YYYY.setBounds(230, 160, 60, 20);

        add(DD);
        add(MM);
        add(YYYY);

        accept = new JCheckBox("Please accept terms and conditions");
        accept.setBounds(70, 280, 240, 20);
        add(accept);

        submit = new JButton("Submit");
        submit.setBounds(150, 310, 80, 30);
        add(submit);

        userinput = new JTextArea();
        userinput.setBounds(310, 70, 290, 300);
        add(userinput);


        result = new JLabel();
        result.setBounds(20, 350, 300, 20);
        add(result);

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (accept.isSelected()) {
                    if (e.getActionCommand().equalsIgnoreCase("submit")) {
                        String t = "Name :" + name.getText() + "\n";
                        String t2 = t + "Mobile :" + mobile.getText() + "\n";
                        String t3 = t2 + "Gender :male\n";
                        if (female.isSelected()) {
                            t3 = t2 + "Gender :female\n";

                        }

                        String t4 = t3 + "DOB :" + DD.getSelectedItem().toString() + "-" + MM.getSelectedItem().toString() + "-" + YYYY.getSelectedItem().toString() + "\n";
                        String t5 = t4 + "Address :" + Address.getText();
                        userinput.setText(t5);
                        result.setText("Form submitted");
                    }

                } else {
                    result.setText("please accept the terms and conditions First");
                }
            }
        });

        setVisible(true);
    }


    /*     public void actionPerformed(ActionEvent e){

            if (accept.isSelected()) {
                if(e.getActionCommand().equalsIgnoreCase("submit")){
                    String t="Name :"+name.getText()+"\n";
                    String t2=t+"Mobile :"+mobile.getText()+"\n";
                    String t3=t2+"Gender :male\n";
                    if(female.isSelected()){
                        t3=t2+"Gender :female\n";

                    }

                    String t4=t3+"DOB :"+DD.getSelectedItem().toString()+"-"+MM.getSelectedItem().toString()+"-"+YYYY.getSelectedItem().toString()+"\n";
                    String t5=t4+"Address :"+address.getText();
                    userinput.setText(t);
                }

            }
            else{
                result.setText("please accept the terms and conditions First");
            }
        } */
    public static void main(String[] args) {
        new RegistrationForm();
    }

}

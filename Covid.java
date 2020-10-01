/*
    > AP Assignment 0 (Refresher Module)
    > Name: Dhairya Chaudhary
    > Roll No.: 2019035
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Covid {

    static class date {
        /*
        The constructor accepts the date in the string format.
        This class has 3 attributes, the full date in string format (stdate: String) and the integer value of date and month (dd, mm: Integers).
        It contains 2 methods:
        1. addtwentyone- Takes a date as an argument and returns the date twenty one days later (when a patient will recover.)
        2. isgreater- Takes two dates and arguments and returns true if the first is greater and false otherwise.
         */

        String stdate;
        int dd;
        int mm;

        public date(String stdate) {
            //constructor
            this.stdate = stdate;
            char d1 = this.stdate.charAt(0);
            int d11 = d1 - 48;
            char d2 = this.stdate.charAt(1);
            int d22 = d2 - 48;
            char m1 = this.stdate.charAt(3);
            int m11 = m1 - 48;
            char m2 = this.stdate.charAt(4);
            int m22 = m2 - 48;
            this.dd = (d11 * 10) + d22;
            this.mm = (m11 * 10) + m22;
        }

        public date addtwentyone(date bruv) {
            //returns date 21 days later
            date bruh = new date(bruv.stdate);
            if (bruh.mm == 4 || bruh.mm == 6) {
                if (bruh.dd + 21 > 30) {
                    bruh.dd = bruh.dd + 21 - 30;
                    bruh.mm = bruh.mm + 1;
                } else {
                    bruh.dd = bruh.dd + 21;
                }
            } else {
                if (bruh.dd + 21 > 31) {
                    bruh.dd = bruh.dd + 21 - 31;
                    bruh.mm = bruh.mm + 1;
                } else {
                    bruh.dd = bruh.dd + 21;
                }
            }

            bruh.stdate = bruh.dd + "/" + bruh.mm + "/" + "2020";
            return bruh;
        }

        static boolean isgreater(date dat1, date dat2) {
            //Returns true of first date is greater, false otherwise (given they are both in the same year)
            if (dat1.mm > dat2.mm || (dat1.mm == dat2.mm && dat1.dd >= dat2.dd)) {
                return true;
            }
            return false;
        }

    }

    static class patient {
        /*
        The constructor accepts the name, age, tower of residence and date of falling ill for a patient.
        An arraylist (patList) is maintained that contains all the patients entered.
        The constructor calculates the recovery date for every patient using addtwentyone(date) function of the date class. This is stored in recovery date.
        The total number of patients (numPatients) and number of patients in each tower (nta, ntb, ntc, ntd) is also maintained.
         */

        String name;
        int age;
        char tower;
        date illday;

        date recoverydate;

        static ArrayList<patient> patList = new ArrayList<>();

        static int numPatients;
        static int nta;
        static int ntb;
        static int ntc;
        static int ntd;

        public patient(String name, int age, char tower, date illday) {
            //constructor
            this.name = name;
            this.age = age;
            this.tower = tower;
            if (tower == 'A') {
                nta++;
            } else if (tower == 'B') {
                ntb++;
            } else if (tower == 'C') {
                ntc++;
            } else {
                ntd++;
            }
            this.illday = illday;
            this.recoverydate = illday.addtwentyone(illday);
            patList.add(this);
            numPatients++;
        }
    }

    public static void main(String[] args) {
        //Given database
        patient p1 = new patient("Flora", 6, 'A', new date("01/04/2020"));
        patient p2 = new patient("Denys", 24, 'B', new date("01/04/2020"));
        patient p3 = new patient("Jim", 42, 'C', new date("18/05/2020"));
        patient p4 = new patient("Hazel", 87, 'D', new date("23/06/2020"));
        patient p5 = new patient("Caery", 72, 'A', new date("01/06/2020"));
        patient p6 = new patient("David", 7, 'B', new date("14/06/2020"));
        patient p7 = new patient("Kevim", 37, 'D', new date("05/06/2020"));
        patient p8 = new patient("Tom", 67, 'A', new date("20/06/2020"));
        patient p9 = new patient("Bob", 74, 'A', new date("04/07/2020"));
        patient p10 = new patient("Rachel", 48, 'C', new date("24/07/2020"));
        patient p11 = new patient("Thomas", 21, 'C', new date("11/06/2020"));
        patient p12 = new patient("Mary", 17, 'D', new date("21/06/2020"));
        patient p13 = new patient("Smith", 89, 'A', new date("07/08/2020"));
        patient p14 = new patient("Pearson", 47, 'B', new date("04/06/2020"));
        patient p15 = new patient("Anderson", 62, 'B', new date("27/07/2020"));
        patient p16 = new patient("Johnson", 10, 'D', new date("01/08/2020"));
        patient p17 = new patient("Robertz", 50, 'A', new date("09/08/2020"));
        patient p18 = new patient("Julie", 86, 'B', new date("02/05/2020"));
        patient p19 = new patient("Edith", 42, 'D', new date("07/06/2020"));
        patient p20 = new patient("John", 95, 'D', new date("01/06/2020"));

        //First frame
        Swingg obj = new Swingg();
    }

    static class Swingg extends JFrame {
        /*
        Frame contains a text field for inputting date, 4 checkboxes to determine the towers for which information is needed amd a button that leads to the result frame.
        The information entered in the 4 checkboxes is stored in boolean variables sel1, sel2, sel3, and sel4.
        Text from text field is saved in variable p of the date type.
        Shows appropriate labels.
         */

        JTextField jTextField1;
        JButton b;
        JCheckBox cb1, cb2, cb3, cb4;
        static boolean sel1, sel2, sel3, sel4;
        static date p;

        Swingg() {
            JLabel l1 = new JLabel();
            l1.setBounds(120, 25, 300, 40);
            //l1.setFont(l1.getFont().getName(),100, 64);
            l1.setText("COVID-19 Updates");

            cb1 = new JCheckBox("Tower A");
            cb1.setBackground(Color.gray);
            cb1.setBounds(125, 100, 100, 20);
            sel1=false;

            cb2 = new JCheckBox("Tower B");
            cb2.setBackground(Color.gray);
            cb2.setBounds(125, 150, 100, 20);
            sel2=false;

            cb3 = new JCheckBox("Tower C");
            cb3.setBackground(Color.gray);
            cb3.setBounds(125, 200, 100, 20);
            sel3=false;

            cb4 = new JCheckBox("Tower D");
            cb4.setBackground(Color.gray);
            cb4.setBounds(125, 250, 100, 20);
            sel4=false;

            b = new JButton("Get Info");
            b.setBounds(135, 400, 80, 30);

            JLabel l2 = new JLabel();
            l2.setBounds(103, 295, 300, 40);
            l2.setText("Enter Date:");

            jTextField1 = new JTextField(20);
            jTextField1.setBounds(175, 300, 70, 30);

            //l3 = new JTextField(20);
            //l3.setBounds(100, 350, 30, 40);

            //JLabel l4 = new JLabel();
            //l4.setBounds(150, 350, 300, 40);
            //l4.setText("Recovered cases");

            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    p=new date((jTextField1.getText()));
                    //l3.setText((patient.countRecovered(p,'A')+""));
                    if (cb1.isSelected()){
                        sel1=true;
                    }
                    if (cb2.isSelected()){
                        sel2=true;
                    }
                    if (cb3.isSelected()){
                        sel3=true;
                    }
                    if (cb4.isSelected()){
                        sel4=true;
                    }
                    setVisible(false);
                    Swingg1 obj1 = new Swingg1();
                }
            });

            add(l1);
            add(cb1);
            add(cb2);
            add(cb3);
            add(cb4);
            add(l2);
            add(jTextField1);
            add(b);

            setLayout(null);

            setTitle("Neighborhood COVID-19 Status");
            setSize(380, 500);
            getContentPane().setBackground(Color.PINK);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }


    static class Swingg1 extends JFrame {
        /*
        Contains a table and 2 text fields to display the result.
        Shows appropriate labels.
         */

        JTable jt;
        JTextField j1;
        JTextField j2;

        int nt=0;

        Swingg1() {

            JLabel l1=new JLabel();
            l1.setBounds(265, 10, 300, 40);
            l1.setText("Status on "+Swingg.p.stdate);

            if (Swingg.sel1==true){
                nt+=patient.nta;
            } if (Swingg.sel2==true){
                nt+=patient.ntb;
            } if (Swingg.sel3==true){
                nt+=patient.ntc;
            } if (Swingg.sel4==true){
                nt+=patient.ntd;
            }

            int recnuma=0;
            int acnuma=0;
            int recnumb=0;
            int acnumb=0;
            int recnumc=0;
            int acnumc=0;
            int recnumd=0;
            int acnumd=0;

            JLabel l2=new JLabel();
            l2.setBounds(10, 400, 300, 30);
            l2.setText("Recovered: ");

            j1=new JTextField(20);
            j1.setBounds(80, 400, 600, 30);

            JLabel l3=new JLabel();
            l3.setBounds(10, 450, 400, 30);
            l3.setText("Active: ");

            j2=new JTextField(20);
            j2.setBounds(80, 450, 600, 30);


            String data[][]=new String[nt][5];

            int i=0;
            int j=0;
            while (i!=20){
                //System.out.println(i);
                if ((patient.patList.get(i).tower=='A' && Swingg.sel1==true) || (patient.patList.get(i).tower=='B' && Swingg.sel2==true) || (patient.patList.get(i).tower=='C' && Swingg.sel3==true) || (patient.patList.get(i).tower=='D' && Swingg.sel4==true)) {
                    data[j][0] = patient.patList.get(i).name;
                    data[j][1] = patient.patList.get(i).age + "";
                    if (date.isgreater(Swingg.p, patient.patList.get(i).recoverydate)) {
                        data[j][2] = "Recovered";
                        if (patient.patList.get(i).tower=='A'){
                            recnuma++;
                        } else if (patient.patList.get(i).tower=='B'){
                            recnumb++;
                        } else if (patient.patList.get(i).tower=='C'){
                            recnumc++;
                        } else {
                            recnumd++;
                        }
                    } else {
                        data[j][2] = "Active";
                        if (patient.patList.get(i).tower=='A'){
                            acnuma++;
                        } else if (patient.patList.get(i).tower=='B'){
                            acnumb++;
                        } else if (patient.patList.get(i).tower=='C'){
                            acnumc++;
                        } else {
                            acnumd++;
                        }
                    }
                    data[j][3] = patient.patList.get(i).tower + "";
                    data[j][4] = patient.patList.get(i).recoverydate.stdate;
                    j++;
                }
                i++;
            }

            String column[] = {"Name", "Age", "Status", "Tower", "Recovery Date"};

            jt = new JTable(data, column);
            jt.setBounds(140, 50, 400, 325);
            //JScrollPane sp = new JScrollPane(jt);

            String f1, f2, f3, f4;
            String t1, t2, t3, t4;

            if (Swingg.sel1==true){
                f1=recnuma+"";
            } else {
                f1="Not Selected";
            } if (Swingg.sel2==true){
                f2=recnumb+"";
            } else {
                f2="Not Selected";
            } if (Swingg.sel3==true){
                f3=recnumc+"";
            } else {
                f3="Not Selected";
            } if (Swingg.sel4==true){
                f4=recnumd+"";
            } else {
                f4="Not Selected";
            }

            if (Swingg.sel1==true){
                t1=acnuma+"";
            } else {
                t1="Not Selected";
            } if (Swingg.sel2==true){
                t2=acnumb+"";
            } else {
                t2="Not Selected";
            } if (Swingg.sel3==true){
                t3=acnumc+"";
            } else {
                t3="Not Selected";
            } if (Swingg.sel4==true){
                t4=acnumd+"";
            } else {
                t4="Not Selected";
            }

            j1.setText("A: "+f1+" ;\tB: "+f2+" ;\tC: "+f3+" ;\tD: "+f4);
            j2.setText(("A: "+t1+" ;\tB: "+t2+" ;\tC: "+t3+" ;\tD: "+t4));

            add(l1);
            add(jt);
            add(j1);
            add(j2);
            add(l2);
            add(l3);

            setLayout(null);

            setTitle("Results");
            setSize(700, 600);
            getContentPane().setBackground(Color.PINK);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
}




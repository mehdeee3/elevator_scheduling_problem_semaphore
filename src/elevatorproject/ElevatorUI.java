package elevatorproject;

/**
 *
 * @author ---------
 */

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ElevatorUI extends JFrame {

    public JPanel main;
    public JPanel floor1,floor2,floor3,floor4,floor5,floor6,floor7,floor8,floor9,floor10;
    public JPanel elevator_floor1,elevator_floor2,elevator_floor3,elevator_floor4,elevator_floor5,
            elevator_floor6,elevator_floor7,elevator_floor8,elevator_floor9,elevator_floor10;
    public ArrayList<JLabel> persons;
    //public JLabel p1,p2,p3,p4,p5;
    public int num_floor1,num_floor2,num_floor3,num_floor4,num_floor5,num_floor6,num_floor7,num_floor8,num_floor9,num_floor10;
    public JButton start;
    public int num_person;
    public JTextArea textArea;
    public JScrollPane jScrollPane;
    public static BufferedImage myPicture = null;
    public ElevatorUI(int number_person) {
        num_person=0;
        persons= new ArrayList<JLabel>();
        
        try {
            myPicture = ImageIO.read(new File("man.png"));
        } catch (IOException e) {
            System.out.println("error on file reading...!");
        }
        for(int i=0; i< number_person;i++){
           persons.add(new JLabel(new ImageIcon(myPicture)));
         }
       
             
        num_floor1=0;
        num_floor2=0;
        num_floor3=0;
        num_floor4=0;
        num_floor5=0;
        num_floor6=0;
        num_floor7=0;
        num_floor8=0;
        num_floor9=0;
        num_floor10=0;
        initUI();

    }

    private void initUI()  {

        setTitle("Elevator project");
        setSize(1000, 730);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        floor1 = new JPanel();
        floor1.setBackground(Color.MAGENTA);
        floor2 = new JPanel();
        floor2.setBackground(Color.MAGENTA);
        floor3 = new JPanel();
        floor3.setBackground(Color.MAGENTA);
        floor4 = new JPanel();
        floor4.setBackground(Color.MAGENTA);
        floor5 = new JPanel();
        floor5.setBackground(Color.MAGENTA);
        floor6 = new JPanel();
        floor6.setBackground(Color.MAGENTA);
        floor7 = new JPanel();
        floor7.setBackground(Color.MAGENTA);
        floor8 = new JPanel();
        floor8.setBackground(Color.MAGENTA);
        floor9 = new JPanel();
        floor9.setBackground(Color.MAGENTA);
        floor10 = new JPanel();
        floor10.setBackground(Color.MAGENTA);

        elevator_floor1 = new JPanel();
        elevator_floor2 = new JPanel();
        elevator_floor3 = new JPanel();
        elevator_floor4 = new JPanel();
        elevator_floor5 = new JPanel();
        elevator_floor6 = new JPanel();
        elevator_floor7 = new JPanel();
        elevator_floor8 = new JPanel();
        elevator_floor9 = new JPanel();
        elevator_floor10 = new JPanel();
        setElevatorColor();

       /* BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("man.png"));
        } catch (IOException e) {
            System.out.println("error on file reading...!");
        }
        p1 = new JLabel(new ImageIcon(myPicture));
        p2 = new JLabel(new ImageIcon(myPicture));
        p3 = new JLabel(new ImageIcon(myPicture));
        p4 = new JLabel(new ImageIcon(myPicture));
        p5 = new JLabel(new ImageIcon(myPicture));*/

        textArea = new JTextArea(10,50);

        jScrollPane =new JScrollPane(textArea);
        jScrollPane.setMaximumSize(new Dimension(50,13));
        this.add(jScrollPane,BorderLayout.SOUTH);

        main= new JPanel(new GridLayout(10,2,3,3));
        main.setBackground(Color.blue);
        main.setPreferredSize(new Dimension(700,600));

        main.add(floor1);
        main.add(elevator_floor1);
        main.add(floor2);
        main.add(elevator_floor2);
        main.add(floor3);
        main.add(elevator_floor3);
        main.add(floor4);
        main.add(elevator_floor4);
        main.add(floor5);
        main.add(elevator_floor5);
        main.add(floor6);
        main.add(elevator_floor6);
        main.add(floor7);
        main.add(elevator_floor7);
        main.add(floor8);
        main.add(elevator_floor8);
        main.add(floor9);
        main.add(elevator_floor9);
        main.add(floor10);
        main.add(elevator_floor10);

        this.add(main,BorderLayout.EAST);

        //start = new JButton("start");
        //start.setSize(new Dimension(50,30));
        //this.add(start);
    }

    public void setElevatorColor(){
        elevator_floor1.setBackground(Color.YELLOW);
        elevator_floor2.setBackground(Color.YELLOW);
        elevator_floor3.setBackground(Color.YELLOW);
        elevator_floor4.setBackground(Color.YELLOW);
        elevator_floor5.setBackground(Color.YELLOW);
        elevator_floor6.setBackground(Color.YELLOW);
        elevator_floor7.setBackground(Color.YELLOW);
        elevator_floor8.setBackground(Color.YELLOW);
        elevator_floor9.setBackground(Color.YELLOW);
        elevator_floor10.setBackground(Color.YELLOW);
    }
    public void remove_floors(){
        elevator_floor1.removeAll();
        elevator_floor2.removeAll();
        elevator_floor3.removeAll();
        elevator_floor4.removeAll();
        elevator_floor5.removeAll();
        elevator_floor6.removeAll();
        elevator_floor7.removeAll();
        elevator_floor8.removeAll();
        elevator_floor9.removeAll();
        elevator_floor10.removeAll();
    }

    public void addlog(String text){this.textArea.append(text+"\n");}

    public void movePersonsToFloor(int position){
        remove_floors();
        ArrayList<JLabel> persons= new ArrayList<JLabel>();

        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("man.png"));
        } catch (IOException e) {
            System.out.println("error on file reading...!");
        }

        for(int i=0; i< num_person;i++){
            persons.add(new JLabel(new ImageIcon(myPicture)));
        }

        switch (position){
            case 1:
                for(int i =0 ; i<persons.size();i++){
                    elevator_floor10.add(persons.get(i));
                }
                break;
            case 2:
                for(int i =0 ; i<persons.size();i++){
                    elevator_floor9.add(persons.get(i));
                }
                break;
            case 3:
                for(int i =0 ; i<persons.size();i++){
                    elevator_floor8.add(persons.get(i));
                }
                break;
            case 4:
                for(int i =0 ; i<persons.size();i++){
                    elevator_floor7.add(persons.get(i));
                }
                break;
            case 5:
                for(int i =0 ; i<persons.size();i++){
                    elevator_floor6.add(persons.get(i));
                }
                break;
            case 6:
                for(int i =0 ; i<persons.size();i++){
                    elevator_floor5.add(persons.get(i));
                }
                break;
            case 7:
                for(int i =0 ; i<persons.size();i++){
                    elevator_floor4.add(persons.get(i));
                }
                break;
            case 8:
                for(int i =0 ; i<persons.size();i++){
                    elevator_floor3.add(persons.get(i));
                }
                break;
            case 9:
                for(int i =0 ; i<persons.size();i++){
                    elevator_floor2.add(persons.get(i));
                }
                break;
            case 10:
                for(int i =0 ; i<persons.size();i++){
                    elevator_floor1.add(persons.get(i));
                }
                break;
            default:
                return;
        }



    }

    public void addPersonToElevator(){
        num_person ++;
    }
    public void removePersonFromElevator(){
        num_person --;
    }
    public void addPersonToFloor(int floor){
       

        switch (floor){
            case(1):
                num_floor1++;
                
                floor10.removeAll();
                for(int i =0 ; i<num_floor1;i++){
                    floor10.add(persons.get(i));
                }
                break;
            case(2):
                num_floor2++;
                
                floor9.removeAll();
                for(int i =0 ; i<num_floor2;i++){
                    floor9.add(persons.get(i));
                }
                break;
            case(3):
                num_floor3++;
               
                floor8.removeAll();
                for(int i =0 ; i<num_floor3;i++){
                    floor8.add(persons.get(i));
                }
                break;
            case(4):
                num_floor4++;
                
                floor7.removeAll();
                for(int i =0 ; i<num_floor4;i++){
                    floor7.add(persons.get(i));
                }
                break;
            case(5):
                num_floor5++;
               
                floor6.removeAll();
                for(int i =0 ; i<num_floor5;i++){
                    floor6.add(persons.get(i));
                }
                break;
            case(6):
                num_floor6++;
                
                floor5.removeAll();
                for(int i =0 ; i<num_floor6;i++){
                    floor5.add(persons.get(i));
                }
                break;
            case(7):
                num_floor7++;
                
                floor4.removeAll();
                for(int i =0 ; i<num_floor7;i++){
                    floor4.add(persons.get(i));
                }
                break;
            case(8):
                num_floor8++;
               
                floor3.removeAll();
                for(int i =0 ; i<num_floor8;i++){
                    floor3.add(persons.get(i));
                }
                break;
            case(9):
                num_floor9++;
                
                floor2.removeAll();
                for(int i =0 ; i<num_floor9;i++){
                    floor2.add(persons.get(i));
                }
                break;
            case(10):
                num_floor10++;
               
                floor1.removeAll();
                for(int i =0 ; i<num_floor10;i++){
                    floor1.add(persons.get(i));
                }
                break;
            default:
                return;
        }
    }
    public void removePersonFromFloor(int floor){
        ArrayList<JLabel> persons= new ArrayList<JLabel>();

        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("man.png"));
        } catch (IOException e) {
            System.out.println("error on file reading...!");
        }

        switch (floor){
            case(1):
                num_floor1--;
                for(int i=0; i< num_floor1;i++){
                    persons.add(new JLabel(new ImageIcon(myPicture)));
                }
                floor10.removeAll();
                for(int i =0 ; i<persons.size();i++){
                    floor10.add(persons.get(i));
                }
                break;
            case(2):
                num_floor2--;
                for(int i=0; i< num_floor2;i++){
                    persons.add(new JLabel(new ImageIcon(myPicture)));
                }
                floor9.removeAll();
                for(int i =0 ; i<persons.size();i++){
                    floor9.add(persons.get(i));
                }
                break;
            case(3):
                num_floor3--;
                for(int i=0; i< num_floor3;i++){
                    persons.add(new JLabel(new ImageIcon(myPicture)));
                }
                floor8.removeAll();
                for(int i =0 ; i<persons.size();i++){
                    floor8.add(persons.get(i));
                }
                break;
            case(4):
                num_floor4--;
                for(int i=0; i< num_floor4;i++){
                    persons.add(new JLabel(new ImageIcon(myPicture)));
                }
                floor7.removeAll();
                for(int i =0 ; i<persons.size();i++){
                    floor7.add(persons.get(i));
                }
                break;
            case(5):
                num_floor5--;
                for(int i=0; i< num_floor5;i++){
                    persons.add(new JLabel(new ImageIcon(myPicture)));
                }
                floor6.removeAll();
                for(int i =0 ; i<persons.size();i++){
                    floor6.add(persons.get(i));
                }
                break;
            case(6):
                num_floor6--;
                for(int i=0; i< num_floor6;i++){
                    persons.add(new JLabel(new ImageIcon(myPicture)));
                }
                floor5.removeAll();
                for(int i =0 ; i<persons.size();i++){
                    floor5.add(persons.get(i));
                }
                break;
            case(7):
                num_floor7--;
                for(int i=0; i< num_floor7;i++){
                    persons.add(new JLabel(new ImageIcon(myPicture)));
                }
                floor4.removeAll();
                for(int i =0 ; i<persons.size();i++){
                    floor4.add(persons.get(i));
                }
                break;
            case(8):
                num_floor8--;
                for(int i=0; i< num_floor8;i++){
                    persons.add(new JLabel(new ImageIcon(myPicture)));
                }
                floor3.removeAll();
                for(int i =0 ; i<persons.size();i++){
                    floor3.add(persons.get(i));
                }
                break;
            case(9):
                num_floor9--;
                for(int i=0; i< num_floor9;i++){
                    persons.add(new JLabel(new ImageIcon(myPicture)));
                }
                floor2.removeAll();
                for(int i =0 ; i<persons.size();i++){
                    floor2.add(persons.get(i));
                }
                break;
            case(10):
                num_floor10--;
                for(int i=0; i< num_floor10;i++){
                    persons.add(new JLabel(new ImageIcon(myPicture)));
                }
                floor1.removeAll();
                for(int i =0 ; i<persons.size();i++){
                    floor1.add(persons.get(i));
                }
                break;
            default:
                return;
        }
    }
    public void setElevatorPosition(int position){
        switch (position){
            case 1:
                setElevatorColor();
                movePersonsToFloor(1);
                elevator_floor10.setBackground(Color.red);
                break;
            case 2:
                setElevatorColor();
                movePersonsToFloor(2);
                elevator_floor9.setBackground(Color.red);
                break;
            case 3:
                setElevatorColor();
                movePersonsToFloor(3);
                elevator_floor8.setBackground(Color.red);
                break;
            case 4:
                setElevatorColor();
                movePersonsToFloor(4);
                elevator_floor7.setBackground(Color.red);
                break;
            case 5:
                setElevatorColor();
                movePersonsToFloor(5);
                elevator_floor6.setBackground(Color.red);
                break;
            case 6:
                setElevatorColor();
                movePersonsToFloor(6);
                elevator_floor5.setBackground(Color.red);
                break;
            case 7:
                setElevatorColor();
                movePersonsToFloor(7);
                elevator_floor4.setBackground(Color.red);
                break;
            case 8:
                setElevatorColor();
                movePersonsToFloor(8);
                elevator_floor3.setBackground(Color.red);
                break;
            case 9:
                setElevatorColor();
                movePersonsToFloor(9);
                elevator_floor2.setBackground(Color.red);
                break;
            case 10:
                setElevatorColor();
                movePersonsToFloor(10);
                elevator_floor1.setBackground(Color.red);
                break;
            default:
                return;
        }
    }

//    public static void main(String[] args) {
//
//        EventQueue.invokeLater(new Runnable() {
//
//            @Override
//            public void run() {
//                ElevatorUI ex = new ElevatorUI();
//                ex.setVisible(true);
//                ex.addlog("saeid");
//                ex.addlog("aslami");
//                ex.removePersonFromElevator();
//                ex.setElevatorPosition(3);
//              
//                ex.addPersonToElevator();
//                ex.setElevatorPosition(5);
//                ex.addPersonToFloor(3);
//                ex.addPersonToFloor(5);
//                ex.addPersonToFloor(5);
//                ex.addPersonToFloor(5);
//
//                ex.removePersonFromFloor(5);
//
//
//
//            }
//        });
//    }
}

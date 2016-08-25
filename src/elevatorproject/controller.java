package elevatorproject;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author ---------
 */
public class controller {
    public static int PassengersCount = 10;
    public static Semaphore sleepMutex = new Semaphore(1,false);
    public static Semaphore moveMutex = new Semaphore(1,false);
    public static int[] reqFloors = new int[10]; 
    public static int[] pushFloors = new int[10];
    public static boolean sleepFlag = true; 
    public static int currentFloor = 0 ; 
    public static int slowFactor = 10 ; 
    static passenger[] pList = new passenger[10];
    static Random rand = new Random();
    
//    public static void addPersonToFloor(int floor){
//       
//
//        switch (floor){
//            case(1):
//                UI.num_floor1++;
//                
//                UI.floor10.removeAll();
//                for(int i =0 ; i<UI.num_floor1;i++){
//                    UI.floor10.add(UI.persons.get(i));
//                }
//                break;
//            case(2):
//                UI.num_floor2++;
//                
//                UI.floor9.removeAll();
//                for(int i =0 ; i<UI.num_floor2;i++){
//                    UI.floor9.add(UI.persons.get(i));
//                }
//                break;
//            case(3):
//                UI.num_floor3++;
//               
//                UI.floor8.removeAll();
//                for(int i =0 ; i<UI.num_floor3;i++){
//                    UI.floor8.add(UI.persons.get(i));
//                }
//                break;
//            case(4):
//                UI.num_floor4++;
//                
//                UI.floor7.removeAll();
//                for(int i =0 ; i<UI.num_floor4;i++){
//                    UI.floor7.add(UI.persons.get(i));
//                }
//                break;
//            case(5):
//                UI.num_floor5++;
//               
//                UI.floor6.removeAll();
//                for(int i =0 ; i<UI.num_floor5;i++){
//                    UI.floor6.add(UI.persons.get(i));
//                }
//                break;
//            case(6):
//                UI.num_floor6++;
//                
//                UI.floor5.removeAll();
//                for(int i =0 ; i<UI.num_floor6;i++){
//                    UI.floor5.add(UI.persons.get(i));
//                }
//                break;
//            case(7):
//                UI.num_floor7++;
//                
//                UI.floor4.removeAll();
//                for(int i =0 ; i<UI.num_floor7;i++){
//                    UI.floor4.add(UI.persons.get(i));
//                }
//                break;
//            case(8):
//                UI.num_floor8++;
//               
//                UI.floor3.removeAll();
//                for(int i =0 ; i<UI.num_floor8;i++){
//                    UI.floor3.add(UI.persons.get(i));
//                }
//                break;
//            case(9):
//                UI.num_floor9++;
//                
//                UI.floor2.removeAll();
//                for(int i =0 ; i<UI.num_floor9;i++){
//                    UI.floor2.add(UI.persons.get(i));
//                }
//                break;
//            case(10):
//                UI.num_floor10++;
//               
//                UI.floor1.removeAll();
//                for(int i =0 ; i<UI.num_floor10;i++){
//                    UI.floor1.add(UI.persons.get(i));
//                }
//                break;
//            default:
//                return;
//        }
//    }

    // UI
    public static ElevatorUI UI; 
    
    
    public static void main(String[] args){
        UI = new ElevatorUI(PassengersCount);
        UI.setVisible(true);
        UI.addPersonToElevator();
        UI.setElevatorPosition(1);
//        addPersonToFloor(8);
        //addPersonToFloor(5);
        elevator e = new elevator();
        int initial; 
	for(int i = 0; i < PassengersCount; i++){
            initial=rand.nextInt(10);
            pList[i]=new passenger(initial,i);
            pList[i].start();
            
	}

	e.start();
	
	}

    
}

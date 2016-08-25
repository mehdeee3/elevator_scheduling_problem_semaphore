package elevatorproject;

import java.util.Random;

/**
 *
 * @author ---------
 */
public class passenger extends Thread{
    private Random rand = new Random();
    private int callFloor;
    private int passengerID;
    private int reqFloor;
    private boolean insideFlag;
    private boolean doneFlag;

    public passenger(int currentFloor ,int passengerId){
        passengerID=passengerId;
        callFloor=currentFloor;
        insideFlag=false;
        doneFlag=true;
        reqFloor=0; 
    }
    
    
    
    public void run()
    {
        do{
            try{controller.sleepMutex.acquire();}catch(InterruptedException e){};
            //System.out.println("SLEEP MUTEX dast passenger= "+passengerID);
            if(controller.sleepFlag==true)
            {
                //try{controller.sleepMutex.acquire();}catch(InterruptedException e){};
                    //System.out.println(controller.sleepFlag);
                    controller.sleepFlag=false;
                    //System.out.println(controller.sleepFlag);
                    /////////////////////////////////////////////////////////////////////////////////
                    try{Thread.sleep(2000);}catch(InterruptedException e){};
                    System.out.println("wake up controller!");
                    controller.UI.addlog("wake up controller!");
                    controller.UI.removePersonFromElevator();
                /////////////////////////////////////////////////////////////////////////////////
                    //controller.sleepMutex.release();
            }
            controller.sleepMutex.release();
            
            try{controller.moveMutex.acquire();}catch(InterruptedException e){};
            //System.out.println("MOVE MUTEX dast passenger= "+passengerID);
            if(doneFlag==true)
            {
                //try{controller.moveMutex.acquire();}catch(InterruptedException e){};
                    controller.reqFloors[callFloor]++;
                    if(controller.currentFloor!=callFloor)
                    {
                    /////////////////////////////////////////////////////////////////////////////////
                    try{Thread.sleep(2000);}catch(InterruptedException e){};
                    System.out.println("Passenger "+ passengerID + " is calling from floor "+ (callFloor+1));
//                    controller.addPersonToFloor((callFloor+1));
                    controller.UI.addlog("Passenger "+ passengerID + " is calling from floor "+ (callFloor+1));
                    /////////////////////////////////////////////////////////////////////////////////
                                                
                    //addPassenger(callFloor);
                    }
                    doneFlag=false; 
                //controller.moveMutex.release();
            }
            controller.moveMutex.release();
            
            //while(controller.currentFloor!=callFloor); 
            try{controller.moveMutex.acquire();}catch(InterruptedException e){};
            //System.out.println("MOVE MUTEX dast passenger= "+passengerID);
            //System.out.println("curFloor= "+(controller.currentFloor+1)+"-----"+(1+callFloor)+" =callFloor"+passengerID);
            if(insideFlag==false)
            {                    
                if(controller.currentFloor==callFloor)
                {
                //try{controller.moveMutex.acquire();}catch(InterruptedException e){};
                    controller.reqFloors[callFloor]--;
                //    System.out.println("current floor= "+(controller.currentFloor+1));
                    /////////////////////////////////////////////////////////////////////////////////
                    try{Thread.sleep(2000);}catch(InterruptedException e){};
                    System.out.println("Passenger "+ passengerID + " is getting in floor"+ (callFloor+1));
                    controller.UI.addPersonToElevator();
                    controller.UI.addlog("Passenger "+ passengerID + " is getting in floor"+ (callFloor+1));
                    controller.UI.removePersonFromFloor(callFloor+1);
                    /////////////////////////////////////////////////////////////////////////////////
                    //addPassengerToElevator()
                    reqFloor = rand.nextInt(10);
                    while(reqFloor==callFloor){reqFloor = rand.nextInt(10);}
                    controller.pushFloors[reqFloor]++;
                    /////////////////////////////////////////////////////////////////////////////////
                    try{Thread.sleep(2000);}catch(InterruptedException e){};
                    System.out.println("Passenger "+ passengerID + " pushing floor "+ (reqFloor+1));
                    insideFlag=true;
                //controller.moveMutex.release();
                }
            }
            controller.moveMutex.release();
           
            //while(controller.currentFloor!=reqFloor);
            try{controller.moveMutex.acquire();}catch(InterruptedException e){};
            //System.out.println("MOVE MUTEX dast passenger= "+passengerID);
            //System.out.println("curFloor= "+(controller.currentFloor+1)+"-----"+(callFloor+1)+" =reqFloor"+passengerID);
            
            if(controller.currentFloor==reqFloor)
            {
                if(insideFlag==true)
                {
            //        System.out.println("get out part");
                    //try{controller.moveMutex.acquire();}catch(InterruptedException e){};
                        controller.pushFloors[reqFloor]--;
                        /////////////////////////////////////////////////////////////////////////////////
                        try{Thread.sleep(2000);}catch(InterruptedException e){};
                        System.out.println("Passenger "+ passengerID + " is getting out floor"+ (reqFloor+1));
                        controller.UI.removePersonFromElevator();
                        controller.UI.addlog("Passenger "+ passengerID + " is getting in floor"+ (callFloor+1));
                        /////////////////////////////////////////////////////////////////////////////////
                    
                        //addPassengerTofloor();
                        insideFlag=false; 
                        doneFlag=true; 
                        callFloor=reqFloor; 
                    //controller.moveMutex.release();
                }
            }
            controller.moveMutex.release();
                
            try{Thread.sleep(controller.slowFactor*rand.nextInt(100));
                controller.UI.removePersonFromFloor(reqFloor+1);
                //passengerRemove(req)
            }catch(InterruptedException e){}
            
        }while(true);
    }
    
}

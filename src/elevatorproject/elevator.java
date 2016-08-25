package elevatorproject;

/**
 *
 * @author ---------
 */
public class elevator extends Thread{
    public boolean halt;
    public boolean upDirection; 

    public elevator() 
    {
        halt=false; 
        upDirection=true;
    }
    
    
    public void run(){
        boolean repeat;
        do{
            
            try{controller.sleepMutex.acquire();}catch(InterruptedException e){};
            //System.out.println("run method");
            //System.out.println("SLEEP MUTEX dast ELEVATOR");
            
            if(controller.sleepFlag==false)
            {
                //try{controller.sleepMutex.acquire();}catch(InterruptedException e){};
                    controller.sleepFlag=true;
                    for(int f=0;f<10;f++){
                        if(controller.reqFloors[f]!=0) controller.sleepFlag=false;
                        if(controller.pushFloors[f]!=0) controller.sleepFlag=false;
                    }
                    halt=controller.sleepFlag;
                    //System.out.println("Elevator set sleepFlag "+halt);
                    if(halt)
                    {
                        try{Thread.sleep(2000);}catch(InterruptedException e){};
                        System.out.println("Elevator changes into halt mode");
                        controller.UI.addlog("Elevator changes into halt mode");
                    }
            }
                //controller.sleepMutex.release();
            controller.sleepMutex.release();
                    
//                while(halt);
//                while(controller.pushFloors[controller.currentFloor]!=0);
//                while(controller.reqFloors[controller.currentFloor]!=0);
//              
                try{controller.moveMutex.acquire();}catch(InterruptedException e){};
            //    System.out.println("MOVE MUTEX dast ELEVATRO");
                //System.out.println("current position= "+(controller.currentFloor+1));
                if(halt==false)
                {
                    if(controller.reqFloors[controller.currentFloor]==0)
                    {
                        if(controller.pushFloors[controller.currentFloor]==0)
                        {
                        
                            //try{controller.moveMutex.acquire();}catch(InterruptedException e){};
                                repeat=true;
                                //System.out.println("update position!");
                                while(repeat==true)
                                {
                                    if(upDirection==true)
                                    {
                                        controller.currentFloor++;
                                        if(controller.pushFloors[controller.currentFloor]!=0||
                                                controller.reqFloors[controller.currentFloor]!=0){
                                            {
                                                try{Thread.sleep(2000);}catch(InterruptedException e){};
                                                System.out.println("elevator is moving to floor "+ (controller.currentFloor+1));
                                                controller.UI.addlog("elevator is moving to floor "+ (controller.currentFloor+1));
                                                controller.UI.setElevatorPosition(controller.currentFloor+1);
                                                repeat=false; 
                                                try{Thread.sleep(controller.slowFactor*controller.rand.nextInt(100));}catch(InterruptedException e){};
            
                                            }
                                        }
                                    }
                                    if(upDirection==false)
                                    {
                                        controller.currentFloor--;
                                        if(controller.pushFloors[controller.currentFloor]!=0||
                                                controller.reqFloors[controller.currentFloor]!=0){
                                            {
                                                try{Thread.sleep(2000);}catch(InterruptedException e){};
                                                System.out.println("elevator is moving to floor "+ (controller.currentFloor+1));
                                                controller.UI.addlog("elevator is moving to floor "+ (controller.currentFloor+1));
                                                controller.UI.setElevatorPosition((controller.currentFloor+1));
                                                //moveElevatorto(con.cure); 
                                            repeat=false;
                                            try{Thread.sleep(controller.slowFactor*controller.rand.nextInt(100));}catch(InterruptedException e){};
            
                                            }
                                        }
                                    }
                                    if(controller.currentFloor==0||controller.currentFloor==9){upDirection=!upDirection;}
                                    //controller.moveMutex.release();
                                }
                        }

                    }
                }
                controller.moveMutex.release();
                try{Thread.sleep(controller.slowFactor*controller.rand.nextInt(100));}catch(InterruptedException e){};
            
                                
            
            
            
            
        }while(true);
    }
}

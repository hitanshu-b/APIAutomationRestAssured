package org.example.ListenerDemo;

import org.testng.IExecutionListener;

public class CustomListener implements IExecutionListener {

    @Override
    public void onExecutionFinish(){
        long endTime = System.currentTimeMillis();
        System.out.println("Finished Execution at: " +endTime);
    }

    @Override
    public void onExecutionStart(){
        long startTime = System.currentTimeMillis();
        System.out.println("Started Execution at: " +startTime);
    }
}

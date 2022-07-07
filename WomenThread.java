package com.company;

class WomenThread extends Thread {
    private int id;

    public WomenThread(int id) {
        this.id = id;
    }

    public void run() {
        spendTime();
        if(UnisexBathroom.womenSemaphore.availablePermits()==0){
            useBathroom();
        }
        else{
            try{
                UnisexBathroom.bathroomSemaphore.acquire();
                UnisexBathroom.womenSemaphore.acquire();
            }catch(InterruptedException e){
                System.out.println(e);
                System.exit(-1);
            }
            try{
                useBathroom();
            }finally{
                UnisexBathroom.womenSemaphore.release();
                UnisexBathroom.bathroomSemaphore.release();
            }//else
            System.out.print("Sıra boş!\n");
            spendTime();
        }
    }//run

    private void spendTime() {
        System.out.println("Kadın " + id);
        RandomOperations.RandomSleep(2000);
    }

    private void useBathroom() {
        System.out.println("\t\t\t\tKadın " + id );
        RandomOperations.RandomSleep(1000);
        System.out.println("\t\t\t\t\t\t\t\tKadın " + id );
        RandomOperations.RandomSleep(1000);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tKadın " + id );
        RandomOperations.RandomSleep(1000);
    }
}

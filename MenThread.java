package com.company;



class MenThread extends Thread {
    private int id;

    public MenThread(int id) {
        this.id = id;
    }

    public void run() {
        spendTime();
        if(UnisexBathroom.menSemaphore.availablePermits()==0){
            useBathroom();
        }
        else{
            try{
                UnisexBathroom.bathroomSemaphore.acquire();
                UnisexBathroom.menSemaphore.acquire();
            }catch(InterruptedException e){
                System.out.println(e);
                System.exit(-1);
            }
            try{
                useBathroom();
            }finally{
                UnisexBathroom.menSemaphore.release();
                UnisexBathroom.bathroomSemaphore.release();
            }//else
            System.out.print("Sıra boş!\n");
            spendTime();
        }
    }

    private void spendTime() {
        System.out.println("Erkek " + id);
        RandomOperations.RandomSleep(2000);
    }

    private void useBathroom() {
        System.out.println("\t\t\t\tErkek " + id );
        RandomOperations.RandomSleep(1000);
        System.out.println("\t\t\t\t\t\t\t\tErkek " + id );
        RandomOperations.RandomSleep(1000);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tErkek " + id );
        RandomOperations.RandomSleep(1000);
    }
}
package com.company;

import java.util.concurrent.Semaphore;
import java.util.Scanner;


class UnisexBathroom {
        static Semaphore bathroomSemaphore;
        static Semaphore menSemaphore;
        static Semaphore womenSemaphore;

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int menCount = 0;
            int womenCount = 0;
            String inLine;
            System.out.print("Erkek sayısı: ");
            menCount = scanner.nextInt();
            System.out.print("Kadın sayısı: ");
            womenCount = scanner.nextInt();
            inLine = RandomOperations.randomDecission(menCount, womenCount);

            bathroomSemaphore = new Semaphore(1);
            menSemaphore = new Semaphore(1);
            womenSemaphore = new Semaphore(1);

            System.out.println("Boşta\t\t\tBekliyor\t\tTuvalette\t\tÇıktı");
            System.out.println("----------------------------------------------------------");

            Thread[] menThread = new Thread[inLine.length()];
            Thread[] womenThread = new Thread[inLine.length()];
            for (int i = 0; i < inLine.length(); i++) {
                if (inLine.charAt(i) == 'M') {
                    menThread[i] = new MenThread(i);
                    menThread[i].start();
                }
                if (inLine.charAt(i) == 'F') {
                    womenThread[i] = new WomenThread(i);
                    womenThread[i].start();
                }
            }

            for (int i = 1; i < inLine.length(); i++) {
                if (inLine.charAt(i) != inLine.charAt(i - 1)) {
                    if (inLine.charAt(i) == 'M') {
                        try {
                            menThread[i].join();
                        } catch (InterruptedException ex) {
                            System.out.println(ex);
                        }

                    } else {
                        try {
                            womenThread[i].join();
                        } catch (InterruptedException ex) {
                            System.out.println(ex);
                        }
                    }
                } else {

                }
            }
            System.exit(0);
        }




    }





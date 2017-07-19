package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {

	 System.out.println("+++++Início+++++");

	 Scanner in = new Scanner(System.in);

	 System.out.print("Quantas salas devem ser geradas? R.: ");
	 int numsalas = Integer.parseInt(in.nextLine());

	 AulasTeoricas reservasat = new AulasTeoricas();
	 reservasat.geraSalas(numsalas);

	 ReservaThread t1 = new ReservaThread(reservasat);
     ReservaThread t2 = new ReservaThread(reservasat);
     ReservaThread t3 = new ReservaThread(reservasat);
     ReservaThread t4 = new ReservaThread(reservasat);

     for(int i = 0; i != 4; i++)
     {
         t1.run();
         t2.run();
         t3.run();
         t4.run();
     }
    }
}

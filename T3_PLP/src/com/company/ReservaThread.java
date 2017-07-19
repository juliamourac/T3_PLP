package com.company;

import java.util.Random;

/**
 * Created by juliamourac on 7/10/17.
 */

public class ReservaThread extends Thread
{
    /*Declaração do objeto ats, que é uma instância de AulasTeoricas e deve
     * ser enviado do método main */
    private AulasTeoricas ats;

    //Construtor
    public ReservaThread (AulasTeoricas _ats)
    {
        ats = _ats;
    }

    public void run()
    {
        System.out.println("Thread "+this.getName()+" iniciada");

            try {
                Random n = new Random();
                int n1 = n.nextInt(5);

                boolean proj;

                if (n1 % 2 == 0)
                    proj = true;
                else
                    proj = false;

                Sala s = ats.reservar(this.getName(), proj, n.nextInt(61));
                this.sleep(n.nextInt(1000));
                ats.liberar(s);
            }
            catch(InterruptedException e)
            {
                System.out.print("Ocorreu algum erro :(");
            }
    }
}

package com.company;

import java.util.ArrayList;
import java.util.Random;


/**
 * Created by juliamourac on 7/10/17.
 */
public class AulasTeoricas
{
    ArrayList<Sala> salas = new ArrayList<Sala>(5);

    public void geraSalas(int _num)
    {
        for(int K = 0; K != _num; K++)
        {
            Random n = new Random();

            boolean proj;
            if (n.nextInt() % 2 == 0)
                proj = true;
            else
                proj = false;

            Sala s = new Sala("" + n.nextInt(200), "UFSCar", n.nextInt(61), proj, true);
            salas.add(s);
        }

    }

    /*Este método verifica se há alguma sala s livre no ArrayList salas
    * Se há, o objeto é retornado
    * Senão, nada é retornado*/
    public Sala verificaSalaLivre(boolean _proj, int _cap)
    {
        for(Sala s: salas)
        {
            if(s.temProjetor() == _proj && _cap <= s.getCapacidade())
            {
                if (s.getEstado())
                    return s;
            }
        }
        return null;
    }

    public synchronized void liberar (Sala s) throws InterruptedException
    {
        s.libera();
        System.out.println("Sala "+s.getId()+" liberada!");
        notify();
    }

    /*Verifica o arrayLista em busca de uma sala livre
    * Se não encontrar, espera e repete o procedimendo
    * Se encontrar, reserva a sala*/
    public synchronized Sala reservar(String pdacesso, boolean _proj, int _cap)
            throws InterruptedException
    {
        Sala s;
        //Random t = new Random();
        while((s = verificaSalaLivre(_proj,_cap)) == null)
            wait();
        s.reserva();
        System.out.println("Sala "+s.getId()+" reservada para "+pdacesso);
        notify();
        return s;
    }
    
}

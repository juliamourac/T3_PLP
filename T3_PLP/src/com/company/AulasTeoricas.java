package com.company;

import java.util.ArrayList;

/**
 * Created by juliamourac on 7/10/17.
 */
public class AulasTeoricas
{
    ArrayList<Sala> salas = new ArrayList<Sala>();

    public boolean liberar(String _id)
    {
        int tam = salas.size();

        for (int i = 0; i < tam; i++)
        {
            if (salas.get(i).getId().compareTo(_id))
            {
                salas.get(i).libera();
                return true;
            }
        }
        System.out.println("Sala "+_id+" não existe!");
        return false;
    }

    public boolean reservar(String _id)
    {
        int tam = salas.size();

        for (int i = 0; i < tam; i++)
        {
            if (salas.get(i).getId().compareTo(_id))
            {
                salas.get(i).reserva();
                return true;
            }
        }
        return false;
    }
    
}

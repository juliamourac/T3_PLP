package com.company;

/**
 * Created by juliamourac on 7/10/17.
 */
public class Sala
{
    private String id, localreserva;
    private int capacidade;
    private boolean projetor, livre;

    Sala(String _id, String _localreserva, int _capacidade, boolean _proj, boolean _livre)
    {
        id = _id;
        localreserva = _localreserva;
        capacidade = _capacidade;
        projetor = _proj;
        livre = _livre;
    }

    public String getId(){return id;}

    public void libera(){livre = true;}
    public void reserva(){livre = false;}


}

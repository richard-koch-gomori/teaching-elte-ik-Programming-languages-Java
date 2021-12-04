package game;

import game.Participant;

public class Player extends Participant
{
    private final String ip;

    public String getIpAddress()
    {
        return ip;
    }

    public Player(String name, String ip) 
    {
        this.name = name;
        this.ip = ip;
    }
}


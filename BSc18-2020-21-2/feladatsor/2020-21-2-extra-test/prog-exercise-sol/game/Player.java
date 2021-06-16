package game;

import game.Participant;

public class Player extends Participant // 0.5 pont
{
    private final String ip;

    public String getIpAddress()
    {
        return ip;
    }

    public Player(String name, String ip) // 0.5 pont
    {
        this.name = name;
        this.ip = ip;
    }
}


package game;

import game.Participant;
import game.Animation;

public class NPC extends Participant // 0.5 pont
{
    private final Animation animation;

    public NPC(String name, Animation animation) // 0.5 pont
    {
        this.name = name;
        this.animation = animation;
    }
}


package game;

import game.Participant;
import game.Animation;

public class NPC extends Participant
{
    private final Animation animation;

    public NPC(String name, Animation animation)
    {
        this.name = name;
        this.animation = animation;
    }
}


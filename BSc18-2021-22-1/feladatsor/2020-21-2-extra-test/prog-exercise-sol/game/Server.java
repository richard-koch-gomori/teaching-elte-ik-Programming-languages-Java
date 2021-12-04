package game;

import java.util.HashMap;
import game.Participant;
import util.ServerException;

public class Server
{
    private HashMap<Integer, Participant> participants;
    private int currentMaximumID;

    public Server()
    {
        participants = new HashMap<Integer, Participant>();
    }

    public Participant getParticipantFromName(String name)
    {
        for (int i = 0; i <= currentMaximumID; ++i)
        {
            Participant item = participants.get(i);
            if (item == null)
            {
                continue;
            }
            if (name.equals(item.getName()))
            {
                return item;
            }
        }
        return null;
    }

    public int addParticipant(Participant participant) throws ServerException
    {
        if (participant == null)
        {
            throw new IllegalArgumentException("addParticipant(): participant is null");
        }
        if (participants.entrySet().contains(participant))
        {
            throw new ServerException("addParticipant(): Participant " + participant.getName() + " is already on the server.");
        }
        Participant item = getParticipantFromName(participant.getName());
        if (item != null)
        {
            throw new ServerException("addParticipant(): Participant name: " + participant.getName() + " is already used by other participant.");
        }
        Integer new_idx = currentMaximumID + 1;
        for (int i = 0; i <= currentMaximumID; ++i)
        {
            item = participants.get(i);
            if (item == null)
            {
                new_idx = i;
                break;
            }
        }
        participants.put(new_idx, participant);
        ++currentMaximumID;
        return new_idx;
    }

    public void removeParticipant(int id) throws ServerException
    {
        Participant participant = participants.get(id);
        if (participant == null)
        {
            throw new ServerException("removeParticipant(): Participant with ID: " + id + " is not present on the server.");
        }
        participants.remove(id, participant);
        if (id == currentMaximumID)
        {
            for (int idx = currentMaximumID; idx >= 0; --idx)
            {
                if (participants.get(idx) != null)
                {
                    currentMaximumID = idx;
                    break;
                }
            }
        }
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= currentMaximumID; ++i)
        {
            Participant item = participants.get(i);
            if (item != null)
            {
                sb.append(i);
                sb.append(": ");
                sb.append(item.getName());
                sb.append(" ");
            }
        }
        
        // nem volt tananyag, bármi más is elfogadható (pl. eredmény sztring hosszának ellenőrzése, és pozitív esetben az utolsó karakter levágása)
        if (sb.length() > 0)
        {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
}


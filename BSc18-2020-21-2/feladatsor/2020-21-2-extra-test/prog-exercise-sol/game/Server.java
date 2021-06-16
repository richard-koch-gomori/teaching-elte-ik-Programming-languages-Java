package game;

import java.util.HashMap;
import game.Participant;
import util.ServerException;

public class Server
{
    // 0.5 pont
    private HashMap<Integer, Participant> participants;
    private int currentMaximumID;

    public Server()
    {
        participants = new HashMap<Integer, Participant>(); // 0.5 pont
    }

    public Participant getParticipantFromName(String name)
    {
        for (int i = 0; i <= currentMaximumID; ++i) // 0.5 pont
        {
            Participant item = participants.get(i);
            if (item == null)
            {
                continue; // 0.5 pont
            }
            if (name.equals(item.getName())) // 0.5 pont
            {
                return item; // 0.5 pont
            }
        }
        return null;
    }

    public int addParticipant(Participant participant) throws ServerException // 0.5 pont
    {
        if (participant == null) // 0.5 pont
        {
            throw new IllegalArgumentException("addParticipant(): participant is null");
        }
        if (participants.entrySet().contains(participant)) // 0.5 pont
        {
            throw new ServerException("addParticipant(): Participant " + participant.getName() + " is already on the server.");
        }
        Participant item = getParticipantFromName(participant.getName());
        if (item != null) // 0.5 pont
        {
            throw new ServerException("addParticipant(): Participant name: " + participant.getName() + " is already used by other participant.");
        }
        Integer new_idx = currentMaximumID + 1;
        for (int i = 0; i <= currentMaximumID; ++i) // 0.5 pont
        {
            item = participants.get(i);
            if (item == null)
            {
                new_idx = i;
                break; // 0.5 pont
            }
        }
        participants.put(new_idx, participant); // 0.5 pont
        ++currentMaximumID; // 0.5 pont
        return new_idx; // 0.5 pont
    }

    public void removeParticipant(int id) throws ServerException
    {
        Participant participant = participants.get(id);
        if (participant == null) // 0.5 pont
        {
            throw new ServerException("removeParticipant(): Participant with ID: " + id + " is not present on the server.");
        }
        participants.remove(id, participant); // 0.5 pont
        if (id == currentMaximumID)
        {
            for (int idx = currentMaximumID; idx >= 0; --idx) // 0.5 pont
            {
                if (participants.get(idx) != null)
                {
                    currentMaximumID = idx; // 0.5 pont
                    break;
                }
            }
        }
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder(); // 0.5 pont
        for (int i = 0; i <= currentMaximumID; ++i) // 0.5 pont
        {
            Participant item = participants.get(i);
            if (item != null)
            {
                sb.append(i);
                sb.append(": ");
                sb.append(item.getName()); // 0.5 pont
                sb.append(" ");
            }
        }
         // 0.5 pont
        // nem volt tananyag, bármi más is elfogadható (pl. eredmény sztring hosszának ellenőrzése, és pozitív esetben az utolsó karakter levágása)
        if (sb.length() > 0)
        {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
}


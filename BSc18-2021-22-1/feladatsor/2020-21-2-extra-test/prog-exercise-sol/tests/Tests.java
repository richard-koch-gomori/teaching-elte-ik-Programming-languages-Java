package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

import util.Cipher;
import util.ServerException;
import game.Server;
import game.Player;
import game.NPC;
import game.Animation;

public class Tests
{
    @Test(expected = IllegalArgumentException.class)
    public void Encrypt_test_neg_shift()
    {
        Cipher.encrypt("password", -1);
    }

    @Test
    public void Encrypt_test_pos_shift()
    {
        assertEquals("qbttxpse", Cipher.encrypt("password", 1));
    }

    @Test
    public void Decrypt_test_positive_shift()
    {
        assertEquals("password", Cipher.decrypt("qbttxpse", 1));
    }

    @Test
    public void Server_test_id() throws ServerException
    {
        Server server = new Server();
       
        assertEquals(0, server.addParticipant(new Player("name0", "127.0.0.1")));
        assertEquals(1, server.addParticipant(new Player("name1", "127.0.0.2")));
        assertEquals(2, server.addParticipant(new Player("name2", "127.0.0.3")));
        assertEquals(3, server.addParticipant(new Player("name3", "127.0.0.4")));
        assertEquals(4, server.addParticipant(new NPC("name4", Animation.ATTACK)));
        server.removeParticipant(3);
        server.removeParticipant(4);
       
        assertEquals(3, server.addParticipant(new Player("name5", "127.0.0.3")));
        assertEquals(4, server.addParticipant(new Player("name6", "127.0.0.3")));
    }

    @Test(expected = ServerException.class)
    public void Server_test_addParticipant_name_is_already_present() throws ServerException
    {
        Server server = new Server();
        server.addParticipant(new Player("name1", "127.0.0.1"));
        server.addParticipant(new Player("name2", "127.0.0.2"));
        server.addParticipant(new Player("name1", "127.0.0.3"));
    }

    @Test
    public void Server_test_toString() throws ServerException
    {
        Server server = new Server();
        server.addParticipant(new Player("name0", "127.0.0.1"));
        server.addParticipant(new Player("name1", "127.0.0.2"));
        server.addParticipant(new Player("name2", "127.0.0.3"));
        server.addParticipant(new Player("name3", "127.0.0.4"));
       
        assertEquals("0: name0 1: name1 2: name2 3: name3", server.toString());
        server.removeParticipant(2);
       
        assertEquals("0: name0 1: name1 3: name3", server.toString());
    }

    @Test
    public void Server_test_empty_toString() throws ServerException
    {
        Server server = new Server();
        server.addParticipant(new Player("name0", "127.0.0.1"));
        server.addParticipant(new Player("name1", "127.0.0.2"));
        server.addParticipant(new Player("name2", "127.0.0.3"));
        server.addParticipant(new Player("name3", "127.0.0.4"));
       
        assertEquals("0: name0 1: name1 2: name2 3: name3", server.toString());
        server.removeParticipant(0);
        server.removeParticipant(1);
        server.removeParticipant(2);
        server.removeParticipant(3);
       
        assertEquals("", server.toString());
    }
}


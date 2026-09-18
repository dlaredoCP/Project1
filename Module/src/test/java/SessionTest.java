import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SessionTest {
    @Test
    void Session(){
        assertThrows(IllegalArgumentException.class, ()->{new Session(111423, "Math Tutoring", "John", "2026-ch-19", "Kennedy Library", 2, 2);});
    }

    @Test
    void listSession(){
        Session example1 = new Session(999, "Peer Tutoring #1", "Riley", "2025-09-10","Kennedy Library", 3,2);
        assertEquals("\nId Number: 999\nSession Title: Peer Tutoring #1\nMentor: Riley\nDate: 2025-09-10\nLocation: Kennedy Library\nMaximum Number of Participants: 2", Session.listSession(example1));
    }
}
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SessionListTest {
    @Test
    void listLength(){
        SessionList exList = new SessionList(new Session(1, "", "", "2025-09-17","", 1,2), new SessionList(new Session(1, "", "", "2026-09-17","", 1,2), null));
        assertEquals(2, SessionList.listLength(exList));
    }

    @Test
    void listSessions(){
        Session example1 = new Session(999, "Peer Tutoring #1", "Riley", "2025-09-10","Kennedy Library", 3,2);
        Session example2 = new Session(609, "Peer Tutoring #2", "Diego", "2025-09-17","Kennedy Library", 3,2);
        Session example3 = new Session(773, "Peer Tutoring #3", "Brian", "2025-09-24","Honors Commons", 3,3);
        SessionList example = new SessionList(example1,new SessionList(example2, new SessionList(example3, null) ));
        assertEquals(
                "\nId Number: 999\nSession Title: Peer Tutoring #1\nMentor: Riley\nDate: 2025-09-10\nLocation: Kennedy Library\nMaximum Number of Participants: 2\n--------------------\nId Number: 609\nSession Title: Peer Tutoring #2\nMentor: Diego\nDate: 2025-09-17\nLocation: Kennedy Library\nMaximum Number of Participants: 2\n--------------------\nId Number: 773\nSession Title: Peer Tutoring #3\nMentor: Brian\nDate: 2025-09-24\nLocation: Honors Commons\nMaximum Number of Participants: 3\n--------------------\n", SessionList.listSessions(example));
    }
}
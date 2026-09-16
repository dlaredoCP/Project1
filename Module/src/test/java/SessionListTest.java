import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SessionListTest {
    @Test
    void listLength(){
        SessionList exList = new SessionList(new Session(1, "", "", "2025-09-17","", 1,2), new SessionList(new Session(1, "", "", "2026-09-17","", 1,2), null));
        assertEquals(2, SessionList.listLength(exList));
    }
}
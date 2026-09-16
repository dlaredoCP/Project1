import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SessionTest {
    @Test
    void Session(){
        assertThrows(IllegalArgumentException.class, ()->{new Session(111423, "Math Tutoring", "John", "2026-ch-19", "Kennedy Library", 2, 2);});
    }
}
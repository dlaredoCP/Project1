public record SessionList (Session sesh, SessionList seshlist){
    /** Accepts a SessionList and return the number of sessions in that list */
    public static int listLength(SessionList lst){
        switch (lst){
            case null:
                return 0;
            case SessionList(Session s, SessionList r):
                return listLength(r)+1;
        }
    }

    /** Accepts Session and SessionList objects and adds the Session to the aforementioned SessionList object */
    public static SessionList addToSesh(Session sesh, SessionList lst){
        switch (lst) {
            case null:
                return new SessionList(sesh, null);
            case SessionList(Session s, SessionList r):
                return new SessionList(s, addToSesh(sesh, r));
        }
    }

    /** Accepts a SsessionList and returns a string that lists all the Session objects and their contents in that SessionList */
    public static String listSessions(SessionList sList){
        switch (sList) {
            case null:
                return "";
            case SessionList(Session s, SessionList r):
                return Session.listSession(s) + "\n--------------------" + listSessions(r);
        }
    }
}

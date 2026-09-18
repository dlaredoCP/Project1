import org.w3c.dom.Node;

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

    public Session getSession(){
        return this.sesh;
    }

    public SessionList getSessionList(){
        return this.seshlist;
    }

    /** Accepts Session and SessionList objects and inserts the Session to the aforementioned SessionList object in chronological order*/
    public static SessionList insert(SessionList lst, Session session) {

        if (lst== null) {
            return new SessionList(session, null);
        } else
        if (session.getDate().compareToIgnoreCase(lst.getSession().getDate()) <= 0) {
            return new SessionList(session, lst);
        }
        else {
            return new SessionList(lst.getSession(), insert(lst.getSessionList(), session));
        }
    }

    /** Accepts a SessionList and returns a string that lists all the Session objects and their contents in that SessionList */
    public static String listSessions(SessionList sList){
        switch (sList) {
            case null:
                return "";
            case SessionList(Session s, SessionList r):
                return Session.listSession(s) + "\n--------------------" + listSessions(r);
        }
    }
}

import org.w3c.dom.Node;

import java.util.Objects;

public record SessionList (Session sesh, SessionList seshList){
    /** Accepts a SessionList and return the number of sessions in that list */
    public static int listLength(SessionList lst){
        switch (lst){
            case null:
                return 0;
            case SessionList(Session s, SessionList r):
                return listLength(r)+1;
        }
    }

    /** Returns SessionList's sesh variable */
    public Session getSession(){
        return this.sesh;
    }

    /** Returns SessionList's seshlist variable */
    public SessionList getSessionList(){
        return this.seshList;
    }

    /** Accepts Session and SessionList objects and inserts the Session to the aforementioned SessionList object in chronological order */
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
    public static Session searchByID(int id, SessionList sList){
        switch(sList) {
            case null:
                return null;
            case SessionList(Session s, SessionList r):
                if (s.getID() == id){
                    return s;
                }
                else {
                    return searchByID(id, r);
                }

        }
    }
    public static SessionList searchByMentor(String mentor, SessionList sList){
        switch(sList) {
            case null:
                return null;
            case SessionList(Session s, SessionList r):
                if (Objects.equals(s.getMentor(), mentor)){
                    return new SessionList(s, searchByMentor(mentor, r));
                }
                else {
                    return searchByMentor(mentor, r);
                }

        }
    }
    public static SessionList remove(Session session, SessionList sList){
        if (session == null){
            return null;
        }
        switch(sList) {
            case null:
                return null;
            case SessionList(Session s, SessionList r):
                if (session == s){
                    return r;
                }
                else {
                    return new SessionList(s, remove(session, r));
                }

        }
    }
}

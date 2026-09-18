public record SessionList (Session sesh, SessionList seshlist){
    public static int listLength(SessionList lst){
        switch (lst){
            case null:
                return 0;
            case SessionList(Session s, SessionList r):
                return listLength(r)+1;
        }
    }

    public Session getSesh(){
        return this.sesh;
    }

    public SessionList getSeshList(){
        return this.seshlist;
    }


    public static SessionList addToSesh(SessionList addedList, SessionList lst){
        switch (lst) {
            case null:
                return addedList;
            case SessionList(Session s, SessionList r):
                return new SessionList(s, addToSesh(addedList, r));
        }
    }

    public static String listSessions(SessionList sList){
        switch (sList) {
            case null:
                return "";
            case SessionList(Session s, SessionList r):
                return Session.listSession(s) + "\n--------------------" + listSessions(r);
        }
    }
}

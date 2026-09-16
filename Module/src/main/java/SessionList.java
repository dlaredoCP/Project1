public record SessionList (Session sesh, SessionList seshlist){
    public static int listLength(SessionList lst){
        switch (lst){
            case null:
                return 0;
            case SessionList(Session s, SessionList r):
                return listLength(r)+1;
        }
    }

    public static void addToSesh(SessionList addedList, SessionList lst){
        switch (lst){
            case null:
                throw new IllegalArgumentException("The list that you want to add to is null");
            case SessionList(Session s, SessionList r):
                if (r==null){
                    r=addedList;
                }
        }
    }
}

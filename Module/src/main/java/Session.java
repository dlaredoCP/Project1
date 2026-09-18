public class Session{
    private int idNum;
    private String title;
    private String mentor;
    private String date;
    private String location;
    private int currCount;
    private int maxNum;

    /** Session constructor that throws an IllegalArgumentException when the date is in the wrong format*/
    public Session(int idNum, String title, String mentor, String date, String location, int currCount, int maxNum){
        for (int x=0; x<date.length(); x++){
            if (((x<4) || (x>=5 && x<7) || (x>=8 && x<10)) && !Character.isDigit(date.charAt(x))){
                throw new IllegalArgumentException("Date is not in ISO 8601 format");
            }
            if ((x==4 || x==7) && Character.isDigit(date.charAt(x))){
                throw new IllegalArgumentException("Date is not in ISO 8601 format");
            }
        }
        this.idNum = idNum;
        this.title = title;
        this.mentor = mentor;
        this.date = date;
        this.location = location;
        this.currCount = currCount;
        this.maxNum = maxNum;
    }

    public int getID(){
        return this.idNum;
    }

    public String getTitle(){
        return this.title;
    }

    public String getDate(){
        return this.date;
    }

    public String getLocation(){
        return this.location;
    }

    public String getMentor(){
        return this.mentor;
    }

    public int getCurrCount(){
        return this.currCount;
    }

    public int getMaxNum(){
        return this.maxNum;
    }

    /** Accepts a Session object and return a String of the instance variables in a custom format*/
    public static String listSession(Session sesh){
        if (sesh==null){
            return "";
        } else {
            return "\n" + "Id Number: " + sesh.getID() + "\n" + "Session Title: " + sesh.getTitle() + "\n" + "Mentor: " + sesh.getMentor() + "\n" + "Date: " + sesh.getDate() + "\n" + "Location: " + sesh.getLocation() + "\n" + "Maximum Number of Participants: " + sesh.getMaxNum();
        }
    }

    /** Adds one to the number of current participants in the given Session object */
    public static void addCurrCount(Session s){
        s.currCount++;
    }

}

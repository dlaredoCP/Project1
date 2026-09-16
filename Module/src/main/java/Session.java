public record Session (int idNum, String title, String mentor, String date, String location, int currCount, int maxNum) {
    public Session{
        for (int x=0; x<date.length(); x++){
            if (((x<4) || (x>=5 && x<7) || (x>=8 && x<10)) && !Character.isDigit(date.charAt(x))){
                throw new IllegalArgumentException("Date is not in ISO 8601 format");
            }
            if ((x==4 || x==7) && Character.isDigit(date.charAt(x))){
                throw new IllegalArgumentException("Date is not in ISO 8601 format");
            }
        }
    }
}

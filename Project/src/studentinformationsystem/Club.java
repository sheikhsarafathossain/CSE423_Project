package studentinformationsystem;


public class Club {

    private String clubName, clubPosition;

    public Club() {
    }

    public Club(String clubName, String clubPosition) {
        this.clubName = clubName;
        this.clubPosition = clubPosition;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {

        this.clubName = clubName;
    }

    public String getClubPosition() {
        return clubPosition;
    }

    public void setClubPosition(String clubPosition) {

        this.clubPosition = clubPosition;
    }

    public void display() {
        System.out.println("Club Name: " + clubName);
        System.out.println("Club Position: " + clubPosition);
    }

}

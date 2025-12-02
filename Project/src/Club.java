public class Club {

    private String clubName;
    private String memberRole;

    public Club() {
    }

    public Club(String clubName, String memberRole)
  {
        this.clubName = clubName;
        this.memberRole = memberRole;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(String memberRole) {
        this.memberRole = memberRole;
    }
}

public class ClubView { 
    
    public void printClubDetails(Club club) {
        System.out.println("--- Club Details ---");
        System.out.println("Club Name: " + club.getClubName());
        System.out.println("Club Position: " + club.getClubPosition());
    }
}
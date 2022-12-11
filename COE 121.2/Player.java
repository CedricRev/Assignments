public class Player {

    private PlayList playlist;

    public void setPlaylist(PlayList playlist) {
        this.playlist = playlist;
    }

    public void next() {
        System.out.println(playlist.moveToNext().getSongName());
    }

    public void previous() {
        System.out.println(playlist.moveToPrevious().getSongName());
    }

    public static void main(String[] args) {

        // Create a playlist with the list of Sir Earl's songs
        PlayList playlist = new PlayList("Sir Earl's Playlist");
        playlist.addSong(new Song("As Long as You Love Me"));
        playlist.addSong(new Song("All or Nothing"));
        playlist.addSong(new Song("If I Let You Go"));
        playlist.addSong(new Song("I Want It That Way"));
        playlist.addSong(new Song("When You Say Nothing at All"));
        playlist.addSong(new Song("Swear It Again"));
        playlist.addSong(new Song("If You Come Back"));
        playlist.addSong(new Song("Truly Madly Deeply"));
        playlist.addSong(new Song("Tearing Up My Heart"));
        playlist.addSong(new Song("Love Me for a Reason"));


        // Load player then select playlist
        Player player = new Player();
        player.setPlaylist(playlist);

        // Prev-Next Buttons
        player.next(); // All or Nothing
        player.next(); // If I Let You Go
        player.previous(); // All or Nothing
        player.previous(); // As Long as You Love Me
        player.previous(); // Love Me for a Reason
        player.previous(); // Tearing Up My Heart
    }

}

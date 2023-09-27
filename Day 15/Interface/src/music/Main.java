package music;

public class Main {
    public static void main(String[] args) {
        MyMusicPlayer player = new MyMusicPlayer();
        player.play();
        player.playNext();
        player.pause();
        player.stop();
        player.removeSong("asd");

        System.out.println("---------------------------------------");
        player.addSong("Without you - David Guetta ft. Usher");
        player.play();
        player.playNext();
        player.removeSong("Without you - David Guetta ft. Usher");

        System.out.println("---------------------------------------");
        player.addSong("Without you - David Guetta ft. Usher");
        player.addSong("Firework - Katy Perry");
        player.addSong("Paradise - Coldplay");
        player.addSong("Call Me Maybe - Carly Rae Jepsen");
        player.addSong("We Found Love - Rihanna ft Calvin Harris");
        player.play();
        player.playNext();
        player.playNext();
        player.playNext();
        player.playNext();
        player.playNext();
        player.pause();
        player.pause();
        player.stop();
        player.stop();
        player.playNext();
        player.printPlaylist();

        System.out.println("-------------------------");
        player.shuffle();
        player.printPlaylist();
    }
}

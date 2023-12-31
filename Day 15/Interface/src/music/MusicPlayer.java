package music;

public interface MusicPlayer {

    void play();
    void pause();
    void stop();
    void addSong(String song);
    void removeSong(String song);
    void playNext();
}

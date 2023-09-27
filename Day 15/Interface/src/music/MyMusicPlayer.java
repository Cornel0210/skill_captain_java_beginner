package music;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyMusicPlayer implements MusicPlayer{

    private final List<String> songs;
    private String currentSong;
    private Status status;

    public MyMusicPlayer() {
        songs = new ArrayList<>();
        status = Status.STOP;
    }

    @Override
    public void play() {
        if (songs.isEmpty()){
            System.out.println("Playlist is empty. Add some songs.");
        } else {
            if (currentSong == null){
                currentSong = songs.get(0);
            }
            System.out.println("playing " + currentSong + ".");
            status = Status.PLAY;
        }
    }

    @Override
    public void pause() {
        if (songs.isEmpty()){
            System.out.println("Playlist is empty. Add some songs.");
        } else {
            if (status == Status.PLAY){
                System.out.println(currentSong + " has been paused.");
                status = Status.PAUSE;
            } else {
                System.out.println("No song played.");
            }
        }
    }

    @Override
    public void stop() {
        if (songs.isEmpty()){
            System.out.println("Playlist is empty. Add some songs.");
        } else {
            if (status == Status.PLAY || status == Status.PAUSE){
                System.out.println(currentSong + " has been stopped.");
                status = Status.STOP;
            } else {
                System.out.println("Player is already stopped.");
            }
        }
    }

    @Override
    public void addSong(String song) {
        if (!songs.contains(song)){
            songs.add(song);
            System.out.println(song + " has been added to your playlist.");
        } else {
            System.out.println(song + " is already in your playlist.");
        }
    }

    @Override
    public void removeSong(String song) {
        if (songs.remove(song)){
            System.out.println(song + " has been removed from your playlist.");
            if (song.equals(currentSong)){
                playNext();
            }

        } else {
            System.out.println("There is no such song in your playlist.");
        }
    }

    @Override
    public void playNext() {
        if (songs.isEmpty()){
            System.out.println("Playlist is empty. Add some songs.");
            return;
        }

        int currentSongIndex = getIndexForCurrentSong();
        if (currentSongIndex+1 < songs.size()){
            currentSong = songs.get(currentSongIndex+1);
            play();
        } else {
            currentSong = songs.get(0);
            play();
        }
    }

    public void shuffle(){
        if (songs.size() > 1){
            Collections.shuffle(songs);
        }
    }

    public void printPlaylist(){
        for (int i = 0; i < songs.size(); i++) {
            System.out.println((i+1) + " - " + songs.get(i));
        }
    }

    private int getIndexForCurrentSong(){
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).equals(currentSong)){
                return i;
            }
        }
        return -1;
    }
}

package JavaOOp.L04Inheritance.Exercises.p10OnlineRadioDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SongDatabase {
    private List<Song> songs;

    public SongDatabase() {
        this.songs = new ArrayList<>();
    }

    public void addSong (Song song){

        this.songs.add(song);
    }

    public String getTotalLengthOfSongs (){
        int totalLenghtSeconds = 0;
        for (Song song : songs) {
            String[] lengthData = song.getLength().split(":");
            int seconds = Integer.parseInt(lengthData[0])*60+Integer.parseInt(lengthData[1]);
            totalLenghtSeconds+=seconds;
        }
        int hour = totalLenghtSeconds/3600;
        totalLenghtSeconds%=3600;
        int minute = totalLenghtSeconds/60;
        totalLenghtSeconds%=60;
        int seconds = totalLenghtSeconds;
        return String.format("%dh %dm %ds",hour,minute,seconds);
    }

    public List<Song> getSongs() {
        return Collections.unmodifiableList(this.songs);
    }
}

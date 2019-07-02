package JavaOOp.L04Inheritance.Exercises.p10OnlineRadioDatabase;

import JavaOOp.L04Inheritance.Exercises.p10OnlineRadioDatabase.Exceptions.*;

public class Song {
    private String artistName;
    private String songName;
    private String length;

    public Song(String artistName, String songName, String length) {
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setLength(length);
    }

    public void setArtistName(String artistName) throws InvalidArtistNameException {
        if (artistName.length()<3||artistName.length()>20){
            throw new InvalidArtistNameException("Artist name should be between 3 and 20 symbols.");
        }

        this.artistName = artistName;
    }

    public void setSongName(String songName) throws InvalidSongNameException {
        if (songName.length()<3||songName.length()>30){
            throw new InvalidSongNameException("Song name should be between 3 and 30 symbols.");
        }
        this.songName = songName;
    }

    public void setLength(String length)throws InvalidSongLengthException, InvalidSongMinutesException, InvalidSongSecondsException {
        String[] songData = length.split(":");
        int minutes = Integer.parseInt(songData[0]);
        int seconds = Integer.parseInt(songData[1]);
        int songSecondsSum = (minutes*60)+seconds;
        final int maxLengthSong = 899;

        if (seconds<0||seconds>59){
            throw new InvalidSongSecondsException("Song seconds should be between 0 and 59.");
        }
        if (minutes<0||minutes>14){
            throw new InvalidSongMinutesException("Song minutes should be between 0 and 14.");
        }
        if (songSecondsSum<0||songSecondsSum>maxLengthSong){
            throw new InvalidSongLengthException("Invalid song length.");
        }
        this.length = length;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getSongName() {
        return songName;
    }

    public String getLength() {
        return length;
    }



}

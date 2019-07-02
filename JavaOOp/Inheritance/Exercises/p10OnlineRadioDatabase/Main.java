package JavaOOp.L04Inheritance.Exercises.p10OnlineRadioDatabase;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfSongs = Integer.parseInt(reader.readLine());

        SongDatabase songDatabase = new SongDatabase();

        while (numberOfSongs-- > 0) {
            String[] songData = reader.readLine().split(";");
            try {
                String artistName = songData[0];
                String songName = songData[1];
                String length = songData[2];
                Song song = new Song(artistName, songName, length);
                songDatabase.addSong(song);
                System.out.println("Song added.");
            } catch (RuntimeException error) {
                System.out.println(error.getMessage());
            }


        }
        System.out.println("Songs added: " + songDatabase.getSongs().size());
        System.out.println("Playlist length: " + songDatabase.getTotalLengthOfSongs());


    }
   //4
   //ABBA;Mamma Mia;3:35
   //Nasko Mentata;Shopskata salata;4:123
   //Nasko Mentata;Shopskata salata;4:12Song added.
    //null
    //as;asd asd ;3:35
    //For input string: "12as"
    //
    //Index 1 out of bounds for length 1
    //Songs added: 1
    //Playlist length: 0h 3m 35s
}

package Playlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    public String albumName;
    public String artistName;
    public List<Song> songList;

    public Album(String albumName, String artistName) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.songList = new ArrayList<>();
    }

    public boolean findSongInAlbum(String title){
        //Iterate over the arrayList and check the song if its present using title
        for(Song song : songList){
            if((song.title).equals(title)){
                return true;
            }
        }
        return false;
    }

    public String addSongToAlbum(String title, double duration){

        //check if song is already present or not. If present we will not add
        //otherwise create new song and add to album

        if(findSongInAlbum(title) == true){
            return "Song Already Exists";
        }
        else{
            //create object of song and then add to songList;
            Song newSong = new Song(title, duration);
            songList.add(newSong);
            return "Song added Successfully";
        } 
    }

    //find and add song using track number
    public String addSongToPlayList(int trackNo, LinkedList<Song> playList){

        int index = trackNo - 1;

        if(index >= 0 && index < this.songList.size()){

            Song song = this.songList.get(index);
            playList.add(song);

            return "Song Added Successfully";
        }
        return "Invalid Track Number";
    }
    //find and add song using title
    public String addSongToPlayList(String title, LinkedList<Song> playList){


        for(Song song : songList){
            if(song.title == title){
                playList.add(song);
                return "Song has been added Successfully";
            }
        }
        return "Song does not exist";
    }

}

package Playlist;

import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static List<Album> albums = new ArrayList<>();
    public static void main(String[] args){
        System.out.println("Hello world");

        Album album = new Album("Evergreen", "KK");

        album.addSongToAlbum("Alvida", 4.5);
        album.addSongToAlbum("Beete LamHein", 5.65);
        album.addSongToAlbum("Zindagi do pal ki", 3.5);

        albums.add(album);

        album = new Album("All Time Hit","Arijit Singh");

        album.addSongToAlbum("Pathan", 4.5);
        album.addSongToAlbum("Channa mereya", 3.5);
        album.addSongToAlbum("Naina", 3.5);

        albums.add(album);

        LinkedList<Song> playList_1 = new LinkedList<>();

        albums.get(0).addSongToPlayList("Alvida", playList_1);
        albums.get(0).addSongToPlayList("Zindagi do pal ki", playList_1);
        albums.get(1).addSongToPlayList("Pathan", playList_1);
        albums.get(1).addSongToPlayList("Naina",playList_1);

        play(playList_1);
    }

    static Scanner sc = new Scanner(System.in);



    public static void play(LinkedList<Song> playList){
        ListIterator<Song> listIterator = playList.listIterator();

        if(playList.size() == 0){
            return;
        }
        printMenu();
        System.out.println("Now Playing"+listIterator.next());

        boolean forward = true;

        boolean quit = false;

        while(quit == false){
            int choice = sc.nextInt();

            switch(choice){
                case 0:
                    quit = true;
                    break;
                case 1:
                    if(forward == false){
                        listIterator.next();
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println(listIterator.next().toString());
                    }
                    else{
                        System.out.println("You are at the last Song");
                    }

                    break;
                case 2:
                    if(forward == true){//iterator already at the right of the printed value
                        listIterator.previous();
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println(listIterator.previous().toString());
                    }
                    else{
                        System.out.println("You are at the first song");
                    }
                    break;
                case 3:
                    if(forward == true){// we are on right side of the printed value
                        System.out.println(listIterator.previous().toString());
                        forward = false;
                    }
                    else{//we are on the left side of printed value
                        System.out.println((listIterator.next().toString()));
                        forward = true;
                    }
                    break;
                case 4:
                    printAllSongs(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size() > 0){
                        System.out.println(listIterator.previous().toString());
                        listIterator.remove();
                        if(playList.size() > 0 && listIterator.hasPrevious()){
                            System.out.println("Now Playing" + listIterator.next().toString());
                        }
                        else if(playList.size() > 0 && listIterator.hasNext()){
                            System.out.println("Now Playing" + listIterator.previous().toString());
                        }
                    }
                    else{
                        System.out.println("The playList is already Empty");
                    }
                    break;
            }
        }
    }
    private static void printAllSongs(LinkedList<Song> songs){
        ListIterator<Song> listIterator = songs.listIterator();

        while(listIterator.hasNext()){
            System.out.println(listIterator.next().toString());
        }
    }
    private static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println("0 - to quit\n"+
                "1 - to play next song\n"+
                "2 - to play previous song\n"+
                "3 - to replay the current song\n"+
                "4 - list of all songs\n"+
                "5 - print all available options\n"+
                "6 - delete current song");

    }
}

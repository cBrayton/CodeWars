public class Dubstep {
  public static String SongDecoder (String song)  {
/*
This takes a remixxed Dubstep song as a string and produces the original song.
The original song is produced by removing all of the "WUB"s added to it arbitrarily, and
the original song without any "WUB"s is returned.
*/
     String[] oldSongArray = song.split("WUB");
     StringBuilder oldSong = new StringBuilder(oldSongArray.length);
     for(String s : oldSongArray) {
       if (!s.isEmpty()){
         oldSong.append(s);
         oldSong.append(" ");
       }
     }
     return oldSong.toString().trim();
   }
}
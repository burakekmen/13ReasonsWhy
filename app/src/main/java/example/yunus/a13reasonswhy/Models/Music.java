package example.yunus.a13reasonswhy.Models;

import android.graphics.Bitmap;

/**
 * Created by yunus on 23.08.2017.
 */

public class Music
{
    private String singer;
    private String song;
    private String songURL;
    private String albumCover;

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getSongURL() {
        return songURL;
    }

    public void setSongURL(String songURL) {
        this.songURL = songURL;
    }

    public String getAlbumCover() {
        return albumCover;
    }

    public void setAlbumCover(String albumCover) {
        this.albumCover = albumCover;
    }
}

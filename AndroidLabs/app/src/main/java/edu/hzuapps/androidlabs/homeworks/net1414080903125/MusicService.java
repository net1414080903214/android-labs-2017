package edu.hzuapps.androidlabs.homeworks.net1414080903125;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by Administrator on 2017/5/3.
 */

public class MusicService extends Service{

    public final IBinder binder = new MyBinder();
    public class MyBinder extends Binder{
        MusicService getService() {
            return MusicService.this;
        }
    }


    private String[] musicDir = new String[]{
            "mnt/sdcard/Music/也罢.mp3",
            "mnt/sdcard/Music/恋爱的犀牛.mp3",
            "mnt/sdcard/Music/对号入座.mp3",
            "mnt/sdcard/Music/春风十里不及你.mp3"
    };


    /*private String[] musicDir = new String[]{
            Environment.getExternalStorageDirectory().getAbsolutePath()+"mnt/sdcard/也罢.mp3",
            Environment.getExternalStorageDirectory().getAbsolutePath()+"mnt/sdcard/对号入座.mp3",
            Environment.getExternalStorageDirectory().getAbsolutePath()+"mnt/sdcard/春风十里不及你.mp3",
            Environment.getExternalStorageDirectory().getAbsolutePath()+"mnt/sdcard/恋爱的犀牛.mp3"

    };*/
    private int musicNumber = 1;

    public int MusicNumberGet(){
        return musicNumber;
    }

    public MediaPlayer mp = new MediaPlayer();

    public MusicService() {
        try {
            mp.setDataSource("mnt/sdcard/Music/也罢.mp3");
            mp.prepare();
            musicNumber = 1;
        } catch (Exception e) {
            Log.d("hint","can't get to the song");
            e.printStackTrace();
        }
    }

    /*public MusicService(){
        try {
            musicNumber = 1;
            mp.setDataSource(musicDir[musicNumber]);
            mp.prepare();
        }catch (Exception e){}


    }*/


    public void playOrPause() {
        if(mp != null && mp.isPlaying()){
            mp.pause();
        } else {
            mp.start();
        }
    }

    public void nextMusic() {
        if(mp != null && musicNumber < 3) {
            mp.stop();
            try {
                mp.reset();
                mp.setDataSource(musicDir[musicNumber+1]);
                musicNumber++;
                mp.prepare();
                mp.seekTo(0);
                mp.start();
            } catch (Exception e) {}
        }
    }


    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }


}

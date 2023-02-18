package com.kyle.sample0218

import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class MusicService : android.app.Service() {
    lateinit var mp : MediaPlayer
    override fun onBind(intent: Intent?): IBinder? { // ctrl + i or o // override 설정하게 해준다.
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        android.util.Log.i("음악 서비스 테스트", "onStartCommand()") // Logcat에서 확인
        mp = MediaPlayer.create(this, R.raw.song1)
        mp.isLooping = true
        mp.start()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onCreate() {
        android.util.Log.i("음악 서비스 테스트", "onCreate()")
        super.onCreate()
    }

    override fun onDestroy() {
        android.util.Log.i("음악 서비스 테스트", "onDestroy()")
        mp.stop()
        super.onDestroy()
    }
}
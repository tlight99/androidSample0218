package com.kyle.sample0218

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var soundIntent: Intent
    lateinit var btnStart:Button
    lateinit var btnStop: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title= "음악 서비스 테스트"

        // 사용자가 만든 MusicService 클래스를 Intent로 생성
        soundIntent = Intent(this, MusicService::class.java)
        btnStart = findViewById<Button>(R.id.btnStart)
        btnStop = findViewById<Button>(R.id.btnStop)

        btnStart.setOnClickListener {
            startService(soundIntent)
            android.util.Log.i("서비스 시작 테스트", "startService()")
            Toast.makeText(this, "음악 플레이 시작", Toast.LENGTH_SHORT).show()
        }

        btnStop.setOnClickListener {
            stopService(soundIntent)
            android.util.Log.i("서비스 중지 테스트", "stopService()")
            Toast.makeText(this, "음악 플레이 중지", Toast.LENGTH_SHORT).show()
        }
    }
}
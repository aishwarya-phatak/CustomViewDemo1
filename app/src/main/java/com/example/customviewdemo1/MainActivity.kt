package com.example.customviewdemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.widget.CheckBox
import android.widget.CompoundButton

class MainActivity : AppCompatActivity() {

    lateinit var exitButton: ExitButton
    lateinit var chkExit : CheckBox

    private var backPressedTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        chkExit.setOnCheckedChangeListener(
            object : CompoundButton.OnCheckedChangeListener{
                override fun onCheckedChanged(checkBox: CompoundButton?, isChecked: Boolean) {
                    exitButton.exitable = isChecked
                    /*if(isChecked){
                        exitButton.exitable = true
                    } else {
                        exitButton.exitable = false
                    }*/
                }
            }
        )
        /*exitButton = ExitButton(this)
        exitButton.text = "Exit Application"
        setContentView(exitButton)*/
    }

    private fun initViews(){
        chkExit = findViewById(R.id.chkExit)
        exitButton = findViewById(R.id.btnExit)
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            if(((System.currentTimeMillis() - backPressedTime) / 1000) < 1){
                Log.e("tag","${System.currentTimeMillis()} -- ${backPressedTime}")
                System.exit(0)
                return true
            } else {
                backPressedTime = System.currentTimeMillis()
            }
        }
        return false
    }
}
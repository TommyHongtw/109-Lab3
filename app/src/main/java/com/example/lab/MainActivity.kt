package com.example.lab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var ed_name:EditText //宣告
    private lateinit var tv_text:TextView //宣告
    private lateinit var tv_name:TextView //宣告
    private lateinit var tv_winner:TextView //宣告
    private lateinit var tv_mmora:TextView //宣告
    private lateinit var tv_cmora:TextView //宣告
    private lateinit var btn_scissor:RadioButton //宣告
    private lateinit var btn_stone:RadioButton //宣告
    private lateinit var btn_paper:RadioButton //宣告
    private lateinit var btn_mora:Button //宣告

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //將xml連結到kt
        ed_name=findViewById(R.id.ed_name) //連結元件
        tv_text=findViewById(R.id.tv_text) //連結元件
        tv_name=findViewById(R.id.tv_name) //連結元件
        tv_cmora=findViewById(R.id.tv_cmora) //連結元件
        tv_mmora=findViewById(R.id.tv_mmora) //連結元件
        tv_winner=findViewById(R.id.tv_winner) //連結元件
        btn_stone=findViewById(R.id.btn_stone) //連結元件
        btn_paper=findViewById(R.id.btn_paper) //連結元件
        btn_scissor=findViewById(R.id.btn_scissor) //連結元件
        btn_mora=findViewById(R.id.btn_mora) //連結元件
    }
    //onclocklinsntner function
    fun moraclick(view:View){
        //確定有輸入名字
        if (ed_name.length()<1)
        {
            tv_text.setText("Please enter your name")
        }
        else
        {
            tv_name.setText("name\n${ed_name.text.toString()}"); //玩家名稱
            if(btn_scissor.isChecked())
            {
                tv_mmora.setText("you are\nscissor")
            }
            else if(btn_stone.isChecked())
            {
                tv_mmora.setText("you are\nstone")
            }
            else
            {
                tv_mmora.setText("you are\npaper")
            }
            val computer =(1..3).random() //generate random number from 1 to 3
            if(computer==1)
            {
                tv_cmora.setText("computer is\nscissor")
            }
            else if(computer==2)
            {
                tv_cmora.setText("computer is\nstone")
            }
            else
            {
                tv_cmora.setText("computer is\npaper")
            }
            //Player win
            if((btn_scissor.isChecked && computer==3)||(btn_stone.isChecked && computer==1)
                ||(btn_paper.isChecked && computer==2))
            {
                tv_winner.setText("Winner is\n${ed_name.text.toString()}");
                tv_text.setText("Congradulation you are winner")
            }
            //Computer win
            else if((computer==1 && btn_paper.isChecked)||(computer==2 && btn_scissor.isChecked)
                ||(computer==3 && btn_stone.isChecked))
            {
                tv_winner.setText("Winner is\ncomputer");
                tv_text.setText("Sorry, you lose")
            }
            //draw
            else
            {
                tv_winner.setText("Is draw!!");
                tv_text.setText("Again!!")
            }

        }

    }
}
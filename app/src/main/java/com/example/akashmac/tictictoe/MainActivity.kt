package com.example.akashmac.tictictoe

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

   protected fun bClick(view: View) {
       val bSelect = view as Button
       var sButton = 0
       when(bSelect.id){
           R.id.B1 -> sButton=1
           R.id.B2 -> sButton=2
           R.id.B3 -> sButton=3
           R.id.B4 -> sButton=4
           R.id.B5 -> sButton=5
           R.id.B6 -> sButton=6
           R.id.B7 -> sButton=7
           R.id.B8 -> sButton=8
           R.id.B9 -> sButton=9


       }
       //Toast.makeText(this,"ID:"+sButton,Toast.LENGTH_LONG).show()

        game(sButton,bSelect)
       winnerCheck()
    }
    var player1= ArrayList<Int>()
    var player2= ArrayList<Int>()
    var activePlayer=1



    fun game(sButton:Int,bSelect:Button) {
        if(activePlayer==1){
       bSelect.text="X"
        bSelect.setBackgroundResource(R.color.blue)
        player1.add(sButton)
         activePlayer=2
            autoPlay()

        }
        else{
            bSelect.text="O"
            bSelect.setBackgroundResource(R.color.darkgreen)
            player2.add(sButton)
            activePlayer=1
        }

      bSelect.isEnabled=false


    }
    fun winnerCheck(){

        var winner=-1
        //row wise

        if(player1.contains(1) && player1.contains(2) && player1.contains(3) ){
            winner=1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3) ){
            winner=2
        }

        //row wise
        if(player1.contains(4) && player1.contains(5) && player1.contains(6) ){
            winner=1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6) ){
            winner=2
        }

        //row wise
        if(player1.contains(7) && player1.contains(8) && player1.contains(9) ){
            winner=1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9) ){
            winner=2
        }


        //column wise

        if(player1.contains(1) && player1.contains(4) && player1.contains(7) ){
            winner=1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7) ){
            winner=2
        }


        if(player1.contains(2) && player1.contains(5) && player1.contains(8) ){
            winner=1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8) ){
            winner=2
        }


        if(player1.contains(3) && player1.contains(6) && player1.contains(9) ){
            winner=1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9) ){
            winner=2
        }

        //diagonal wise

        if(player1.contains(1) && player1.contains(5) && player1.contains(9) ){
            winner=1
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9) ){
            winner=2
        }


        if(player1.contains(3) && player1.contains(5) && player1.contains(7) ){
            winner=1
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7) ){
            winner=2
        }


        //winner anounsed

        if(winner != -1){
            if(winner ==1){
                Toast.makeText(this,"Player 1 is win the game",Toast.LENGTH_LONG).show()

            }
            else{
                Toast.makeText(this,"Player 2 is win the game",Toast.LENGTH_LONG).show()
            }
        }


    }
 fun autoPlay(){
     var emptyB= ArrayList<Int>()
     for( sButton in 1..9){

         if(!(player1.contains(sButton) || player2.contains(sButton) )){
             emptyB.add(sButton)
         }
     }
     val r=Random()
     val randomIndex=r.nextInt(emptyB.size-0)+0
     val sButton=emptyB[randomIndex]

     var bSelect:Button?
     when(sButton){
         1 -> bSelect=B1
         2 -> bSelect=B2
         3 -> bSelect=B3
         4 -> bSelect=B4
         5 -> bSelect=B5
         6 -> bSelect=B6
         7 -> bSelect=B7
         8 -> bSelect=B8
         9 -> bSelect=B9
         else->{
             bSelect=B1
         }
     }
     game(sButton,bSelect)

 }

}

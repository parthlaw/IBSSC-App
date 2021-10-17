package com.psr.ibssc_2021.activities

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.transition.AutoTransition
import androidx.transition.TransitionManager
import com.google.firebase.firestore.FirebaseFirestore
import com.psr.ibssc_2021.R
import com.psr.ibssc_2021.models.Tracks
import com.psr.ibssc_2021.utils.Constants


class LiveConference : BaseActivity() {
    private val Firestore= FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_conference)
        dropbuttons()
        setUpActionBar()
        setDates()
        buttons()
    }

    private fun buttons() {
        val join1= findViewById<TextView>(R.id.join1)
        join1.setOnClickListener {
            if(isConnected()){
                Firestore.collection(Constants.TRACKS)
                    .document("track1")
                    .get()
                    .addOnSuccessListener { document->
                        val track=document.toObject(Tracks::class.java)
                        val link= track?.link
                        startActivity(Intent(Intent.ACTION_VIEW,Uri.parse(link)))

                    }}
            else
                showErrorSnackBar("NO INTERNET")
        }
        val join2= findViewById<TextView>(R.id.join2)
        join2.setOnClickListener {

            if(isConnected()){
                Firestore.collection(Constants.TRACKS)
                    .document("track2")
                    .get()
                    .addOnSuccessListener { document->
                        val track=document.toObject(Tracks::class.java)
                        val link= track?.link
                        startActivity(Intent(Intent.ACTION_VIEW,Uri.parse(link)))

                    }}
            else
                showErrorSnackBar("NO INTERNET")
        }
        val join3= findViewById<TextView>(R.id.join3)
        join3.setOnClickListener {

            if(isConnected()){
                Firestore.collection(Constants.TRACKS)
                    .document("track3")
                    .get()
                    .addOnSuccessListener { document->
                        val track=document.toObject(Tracks::class.java)
                        val link= track?.link
                        startActivity(Intent(Intent.ACTION_VIEW,Uri.parse(link)))

                    }}
            else
                showErrorSnackBar("NO INTERNET")
        }
        val join4= findViewById<TextView>(R.id.join4)
        join4.setOnClickListener {

            if(isConnected()){
                Firestore.collection(Constants.TRACKS)
                    .document("track4")
                    .get()
                    .addOnSuccessListener { document->
                        val track=document.toObject(Tracks::class.java)
                        val link= track?.link
                        startActivity(Intent(Intent.ACTION_VIEW,Uri.parse(link)))

                    }}
            else
                showErrorSnackBar("NO INTERNET")
        }
    }

    private fun dropbuttons() {
        val track1= findViewById<TextView>(R.id.track1)
        track1.setOnClickListener {
            val expand=findViewById<LinearLayout>(R.id.expandable)
            val card= findViewById<CardView>(R.id.track1_card)
            if(expand.visibility== View.GONE)
            {
                TransitionManager.beginDelayedTransition(card as ViewGroup, AutoTransition())
                card.setCardBackgroundColor(Color.parseColor("#9fff80"))
                expand.visibility= View.VISIBLE
                track1.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.up,0)

            }
            else{
                card.setCardBackgroundColor(Color.parseColor("#4dc3ff"))
                expand.visibility= View.GONE
                track1.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.down,0)
                TransitionManager.beginDelayedTransition(card as ViewGroup, AutoTransition())

            }
        }
        val track2= findViewById<TextView>(R.id.track2)
        track2.setOnClickListener {
            val expand=findViewById<LinearLayout>(R.id.expandable2)
            val card= findViewById<CardView>(R.id.track2_card)
            if(expand.visibility== View.GONE)
            {
                TransitionManager.beginDelayedTransition(card as ViewGroup, AutoTransition())
                card.setCardBackgroundColor(Color.parseColor("#9fff80"))
                expand.visibility= View.VISIBLE
                track2.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.up,0)

            }
            else{
                card.setCardBackgroundColor(Color.parseColor("#4dc3ff"))
                expand.visibility= View.GONE
                track2.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.down,0)
                TransitionManager.beginDelayedTransition(card as ViewGroup, AutoTransition())

            }
        }
        val track3= findViewById<TextView>(R.id.track3)
        track3.setOnClickListener {
            val expand=findViewById<LinearLayout>(R.id.expandable3)
            val card= findViewById<CardView>(R.id.track3_card)
            if(expand.visibility== View.GONE)
            {
                TransitionManager.beginDelayedTransition(card as ViewGroup, AutoTransition())
                card.setCardBackgroundColor(Color.parseColor("#9fff80"))
                expand.visibility= View.VISIBLE
                track3.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.up,0)

            }
            else{
                card.setCardBackgroundColor(Color.parseColor("#4dc3ff"))
                expand.visibility= View.GONE
                track3.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.down,0)
                TransitionManager.beginDelayedTransition(card as ViewGroup, AutoTransition())

            }
        }
        val track4= findViewById<TextView>(R.id.track4)
        track4.setOnClickListener {
            val expand=findViewById<LinearLayout>(R.id.expandable4)
            val card= findViewById<CardView>(R.id.track4_card)
            if(expand.visibility== View.GONE)
            {
                TransitionManager.beginDelayedTransition(card as ViewGroup, AutoTransition())
                card.setCardBackgroundColor(Color.parseColor("#9fff80"))
                expand.visibility= View.VISIBLE
                track4.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.up,0)

            }
            else{
                card.setCardBackgroundColor(Color.parseColor("#4dc3ff"))
                expand.visibility= View.GONE
                track4.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.down,0)
                TransitionManager.beginDelayedTransition(card as ViewGroup, AutoTransition())

            }
        }
    }

    private fun setDates(){
        Firestore.collection(Constants.TRACKS)
            .document("track1")
            .get()
            .addOnSuccessListener { document->
                val track=document.toObject(Tracks::class.java)
                val tv= findViewById<TextView>(R.id.track1_d)
                if (track != null) {
                    tv.text= track.dt
                }
            }
        Firestore.collection(Constants.TRACKS)
            .document("track2")
            .get()
            .addOnSuccessListener { document->
                val track=document.toObject(Tracks::class.java)
                val tv= findViewById<TextView>(R.id.track2_d)
                if (track != null) {
                    tv.text= track.dt
                }
            }
        Firestore.collection(Constants.TRACKS)
            .document("track3")
            .get()
            .addOnSuccessListener { document->
                val track=document.toObject(Tracks::class.java)
                val tv= findViewById<TextView>(R.id.track3_d)
                if (track != null) {
                    tv.text= track.dt
                }
            }
        Firestore.collection(Constants.TRACKS)
            .document("track4")
            .get()
            .addOnSuccessListener { document->
                val track=document.toObject(Tracks::class.java)
                val tv= findViewById<TextView>(R.id.track4_d)
                if (track != null) {
                    tv.text= track.dt
                }
            }
    }
    private fun setUpActionBar(){
        val toolbar= findViewById<Toolbar>(R.id.toolbar_live_c)
        setSupportActionBar(toolbar)
        val actionbar= supportActionBar
        if(actionbar!=null)
        {
            actionbar.setDisplayHomeAsUpEnabled(true)
            actionbar.setHomeAsUpIndicator(R.drawable.back_arrow)
            resources.getString(R.string.live_c).also { actionbar.title = it }
        }
        toolbar.setNavigationOnClickListener(){
            onBackPressed()
        }
    }
}
package com.prayosof.gutenbergassignment

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*Some SVGs sources seem to not be fully supported, vector support for less then API 21*/
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        cvFiction.setOnClickListener{
            goToBookList("fiction")
        }
        cvDrama.setOnClickListener{
            goToBookList("drama")
        }
        humor.setOnClickListener{
            goToBookList("humor")
        }
        politics.setOnClickListener{
            goToBookList("politics")
        }
        philosophy.setOnClickListener{
            goToBookList("philosophy")
        }
        cv_history.setOnClickListener{
            goToBookList("history")
        }
        cv_adventure.setOnClickListener{
            goToBookList("adventure")
        }

    }

    fun goToBookList(topic: String) {
        val intent = Intent(this, BooksListActivity::class.java).apply {
            putExtra("topic", topic)
        }
        startActivity(intent)
    }

}
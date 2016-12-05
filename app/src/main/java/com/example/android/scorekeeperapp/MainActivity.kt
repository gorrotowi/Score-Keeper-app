package com.example.android.scorekeeperapp

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var goalsLocal = 0
    var goalVisit = 0

    var foulsLocal = 0
    var foulsVisit = 0

    var yCardLocal = 0
    var yCardVisit = 0

    var rCardLocal = 0
    var rCardVisit = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        displayLocalGoals(goalsLocal)
        displayVisitGoals(goalsLocal)
        displayFoulsLocal(foulsLocal)
        displayFoulsVisit(foulsVisit)
        displayYCardLocal(yCardLocal)
        displayYCardVisit(yCardVisit)
        displayRCardLocal(rCardLocal)
        displayRCardVisit(rCardVisit)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.resetScore -> {
                resetGoals()
            }
            R.id.resetAll -> {
                resetGoals()
                resetFouls()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun localGoal(v: View) {
        goalsLocal++
        displayLocalGoals(goalsLocal)
    }

    fun visitGoal(v: View) {
        goalVisit++
        displayVisitGoals(goalVisit)
    }

    fun localFoul(v: View) {
        foulsLocal++
        displayFoulsLocal(foulsLocal)
    }

    fun visitFoul(v: View) {
        foulsVisit++
        displayFoulsVisit(foulsVisit)
    }

    fun yCardLocal(v: View) {
        yCardLocal++
        displayYCardLocal(yCardLocal)
    }

    fun yCardVisit(v: View) {
        yCardVisit++
        displayYCardVisit(yCardVisit)
    }

    fun rCardLocal(v: View) {
        rCardLocal++
        if (rCardLocal > 4) {
            AlertDialog.Builder(this)
                    .setTitle("Game Over")
                    .setMessage("Local Team Lose, Does not have enough players")
                    .setPositiveButton("Ok", { dialogInterface, i ->
                        resetGoals()
                        resetFouls()
                    })
                    .create()
                    .show()
        } else {
            displayRCardLocal(rCardLocal)
        }
    }

    fun rCardVisit(v: View) {
        rCardVisit++
        if (rCardVisit > 4) {
            AlertDialog.Builder(this)
                    .setTitle("Game Over")
                    .setMessage("Visit Team Lose, Does not have enough players")
                    .setPositiveButton("Ok", { dialogInterface, i ->
                        resetGoals()
                        resetFouls()
                    })
                    .create()
                    .show()
        } else {
            displayRCardVisit(rCardVisit)
        }
    }

    fun displayLocalGoals(goals: Int) {
        txtGoalLocal.text = "$goals"
    }

    fun displayVisitGoals(goals: Int) {
        txtGoalVisit.text = "$goals"
    }

    fun displayFoulsLocal(faul: Int) {
        txtLocalFouls.text = "$faul"
    }

    fun displayFoulsVisit(faul: Int) {
        txtVisitFouls.text = "$faul"
    }

    fun displayYCardLocal(ycard: Int) {
        txtLocalYCard.text = "$ycard"
    }

    fun displayYCardVisit(ycard: Int) {
        txtVisitYCard.text = "$ycard"
    }

    fun displayRCardLocal(rcard: Int) {
        txtLocalRCard.text = "$rcard"
    }

    fun displayRCardVisit(rcard: Int) {
        txtVisitRCard.text = "$rcard"
    }

    fun resetGoals() {
        goalsLocal = 0
        goalVisit = 0
        displayLocalGoals(goalsLocal)
        displayVisitGoals(goalsLocal)
    }

    fun resetFouls() {
        foulsLocal = 0
        foulsVisit = 0
        yCardLocal = 0
        yCardVisit = 0
        rCardLocal = 0
        rCardVisit = 0
        displayLocalGoals(goalsLocal)
        displayVisitGoals(goalsLocal)
        displayFoulsLocal(foulsLocal)
        displayFoulsVisit(foulsVisit)
        displayYCardLocal(yCardLocal)
        displayYCardVisit(yCardVisit)
        displayRCardLocal(rCardLocal)
        displayRCardVisit(rCardVisit)
    }

}

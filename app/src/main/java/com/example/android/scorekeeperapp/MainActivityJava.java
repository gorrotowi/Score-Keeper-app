package com.example.android.scorekeeperapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Gorro on 05/12/16.
 */

public class MainActivityJava extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.txtGoalLocal)
    TextView txtGoalLocal;
    @BindView(R.id.txtGoalVisit)
    TextView txtGoalVisit;
    @BindView(R.id.txtLocalFouls)
    TextView txtLocalFouls;
    @BindView(R.id.txtLocalYCard)
    TextView txtLocalYCard;
    @BindView(R.id.txtLocalRCard)
    TextView txtLocalRCard;
    @BindView(R.id.txtVisitFouls)
    TextView txtVisitFouls;
    @BindView(R.id.txtVisitYCard)
    TextView txtVisitYCard;
    @BindView(R.id.txtVisitRCard)
    TextView txtVisitRCard;

    int goalsLocal = 0;
    int goalVisit = 0;

    int foulsLocal = 0;
    int foulsVisit = 0;

    int yCardLocal = 0;
    int yCardVisit = 0;

    int rCardLocal = 0;
    int rCardVisit = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

    }

    @Override
    protected void onResume() {
        super.onResume();
        displayLocalGoals(goalsLocal);
        displayVisitGoals(goalsLocal);
        displayFoulsLocal(foulsLocal);
        displayFoulsVisit(foulsVisit);
        displayYCardLocal(yCardLocal);
        displayYCardVisit(yCardVisit);
        displayRCardLocal(rCardLocal);
        displayRCardVisit(rCardVisit);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.resetScore:
                resetGoals();
                break;
            case R.id.resetAll:
                resetGoals();
                resetFouls();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void localGoal(View v) {
        goalsLocal++;
        displayLocalGoals(goalsLocal);
    }

    public void visitGoal(View v) {
        goalVisit++;
        displayVisitGoals(goalVisit);
    }

    public void localFoul(View v) {
        foulsLocal++;
        displayFoulsLocal(foulsLocal);
    }

    public void visitFoul(View v) {
        foulsVisit++;
        displayFoulsVisit(foulsVisit);
    }

    public void yCardLocal(View v) {
        yCardLocal++;
        displayYCardLocal(yCardLocal);
    }

    public void yCardVisit(View v) {
        yCardVisit++;
        displayYCardVisit(yCardVisit);
    }

    public void rCardLocal(View v) {
        rCardLocal++;
        if (rCardLocal > 4) {
            new AlertDialog.Builder(this)
                    .setTitle("Game Over")
                    .setMessage("Local Team Lose, Does not have enough players")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            resetGoals();
                            resetFouls();
                        }
                    })
                    .create()
                    .show();
        } else {
            displayRCardLocal(rCardLocal);
        }
    }

    public void rCardVisit(View v) {
        rCardVisit++;
        if (rCardVisit > 4) {
            new AlertDialog.Builder(this)
                    .setTitle("Game Over")
                    .setMessage("Visit Team Lose, Does not have enough players")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            resetGoals();
                            resetFouls();
                        }
                    })
                    .create()
                    .show();
        } else {
            displayRCardVisit(rCardVisit);
        }
    }

    private void displayLocalGoals(int goals) {
        txtGoalLocal.setText(String.format("%d", goals));
    }

    private void displayVisitGoals(int goals) {
        txtGoalVisit.setText(String.format("%d", goals));
    }

    private void displayFoulsLocal(int faul) {
        txtLocalFouls.setText(String.format("%d", faul));
    }

    private void displayFoulsVisit(int faul) {
        txtVisitFouls.setText(String.format("%d", faul));
    }

    private void displayYCardLocal(int ycard) {
        txtLocalYCard.setText(String.format("%d", ycard));
    }

    private void displayYCardVisit(int ycard) {
        txtVisitYCard.setText(String.format("%d", ycard));
    }

    private void displayRCardLocal(int rcard) {
        txtLocalRCard.setText(String.format("%d", rcard));
    }

    private void displayRCardVisit(int rcard) {
        txtVisitRCard.setText(String.format("%d", rcard));
    }

    private void resetGoals() {
        goalsLocal = 0;
        goalVisit = 0;
        displayLocalGoals(goalsLocal);
        displayVisitGoals(goalsLocal);
    }

    private void resetFouls() {
        foulsLocal = 0;
        foulsVisit = 0;
        yCardLocal = 0;
        yCardVisit = 0;
        rCardLocal = 0;
        rCardVisit = 0;
        displayLocalGoals(goalsLocal);
        displayVisitGoals(goalsLocal);
        displayFoulsLocal(foulsLocal);
        displayFoulsVisit(foulsVisit);
        displayYCardLocal(yCardLocal);
        displayYCardVisit(yCardVisit);
        displayRCardLocal(rCardLocal);
        displayRCardVisit(rCardVisit);
    }

}

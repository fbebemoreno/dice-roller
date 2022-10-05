package com.example.diceroller;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rollButton = findViewById(R.id.button);
        rollButton.setOnClickListener(view -> rollDice());
    }

    protected void rollDice() {
        // Membuat dua object class Dice
        Dice firstDice = new Dice(6);
        Dice secondDice = new Dice(6);

        // Membuat variable hasil roll dadu
        int firstDiceRoll = firstDice.roll();
        int secondDiceRoll = secondDice.roll();

        // Set variable gamba
        ImageView firstDiceImage = findViewById(R.id.imgFirstDice);
        ImageView secondDiceImage = findViewById(R.id.imgSecondDice);

        // Initialize dua variable resource image
        int firstDrawableResource;
        int secondDrawableResource;

        // Logic menentukan gambar sesuai hasli roll dadu
        switch (firstDiceRoll) {
            case 1:
                firstDrawableResource = R.drawable.dice_1;
                break;
            case 2:
                firstDrawableResource = R.drawable.dice_2;
                break;
            case 3:
                firstDrawableResource = R.drawable.dice_3;
                break;
            case 4:
                firstDrawableResource = R.drawable.dice_4;
                break;
            case 5:
                firstDrawableResource = R.drawable.dice_5;
                break;
            default:
                firstDrawableResource = R.drawable.dice_6;
                break;
        }

        switch (secondDiceRoll) {
            case 1:
                secondDrawableResource = R.drawable.dice_1;
                break;
            case 2:
                secondDrawableResource = R.drawable.dice_2;
                break;
            case 3:
                secondDrawableResource = R.drawable.dice_3;
                break;
            case 4:
                secondDrawableResource = R.drawable.dice_4;
                break;
            case 5:
                secondDrawableResource = R.drawable.dice_5;
                break;
            default:
                secondDrawableResource = R.drawable.dice_6;
                break;
        }

        // Mengganti gambar dan content description
        firstDiceImage.setImageResource(firstDrawableResource);
        secondDiceImage.setImageResource(secondDrawableResource);
        firstDiceImage.setContentDescription(Integer.toString(firstDiceRoll));
        secondDiceImage.setContentDescription(Integer.toString(secondDiceRoll));
    }
}

class Dice {
    int numSides;
    Random rn = new Random();

    Dice(int newNumSides) {
        numSides = newNumSides;
    }

    int roll() {
        return rn.nextInt(numSides) + 1;
    }
}
package com.example.mudrakpatel_comp304_lab3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class Exercise1Activity extends AppCompatActivity {

    //Objects required to draw
    private Bitmap bitmap;
    private Canvas canvas;
    private Paint paint;
    //Declare a the ImageView
    private ImageView drawingImageView;
    //Coordinates associated with the line
    private int startX = 5;
    private int startY = 5;
    private int endX = 50;
    private int endY = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise1);

        //Get a reference to the drawingImageView
        drawingImageView = (ImageView) findViewById(R.id.drawingImageView);
        //Create a Bitmap object
        bitmap = Bitmap.createBitmap((int) getWindowManager().getDefaultDisplay().getWidth(),
                (int) getWindowManager().getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);
        //Create a Canvas object
        canvas = new Canvas(bitmap);
        //Set the image bitmap for the drawingImageView object
        drawingImageView.setImageBitmap(bitmap);

        //Draw a sample line to test the canvas functionality
        paint = new Paint();
        paint.setStrokeWidth(10);
        paint.setColor(Color.BLACK);
        canvas.drawLine(startX, startY, endX, endY, paint);
    }

    /*
    * getColor() : int
    * */
    public int getColor(){
        //Get a reference to the RadioGroup
        RadioGroup lineColorRadioGroup = (RadioGroup) findViewById(R.id.lineColorRadioGroup);
        //This variable will hold the integer value of the color
        int colorToReturn = 0;
        if(lineColorRadioGroup.getCheckedRadioButtonId() == R.id.lineColorRedRadioButton){
            colorToReturn = Color.RED;
        } else if(lineColorRadioGroup.getCheckedRadioButtonId() == R.id.lineColorYellowRadioButton){
            colorToReturn = Color.YELLOW;
        } else if(lineColorRadioGroup.getCheckedRadioButtonId() == R.id.lineColorCyanRadioButton){
            colorToReturn = Color.CYAN;
        }
        return colorToReturn;
    }
}

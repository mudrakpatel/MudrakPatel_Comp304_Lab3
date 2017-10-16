package com.example.mudrakpatel_comp304_lab3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Exercise1Activity extends AppCompatActivity {
    //View components
    RadioGroup lineColorRadioGroup;
    EditText editTextExercise1Activity;

    //Objects required to draw
    private Bitmap bitmap;
    private Canvas canvas;
    private Paint paint;
    //Declare a the ImageView
    private ImageView drawingImageView;
    //Coordinates associated with the line
    private int startX = 5;
    private int startY = 0;
    private int endX = 10;
    private int endY = 10;

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
    }
    /*
    * arrowButtonClicked() : void
    * */
    public void arrowButtonClicked(View view){
        int viewID = view.getId();
        //Get references to proper view components
        lineColorRadioGroup = (RadioGroup) findViewById(R.id.lineColorRadioGroup);
        int radioButtonID = lineColorRadioGroup.getCheckedRadioButtonId();
        EditText lineThicknessEditText = (EditText) findViewById(R.id.editTextExercise1Activity);
        //Validate all the input fields
        if( radioButtonID == 0 || lineThicknessEditText.getText().toString().isEmpty() ||
                Integer.parseInt(lineThicknessEditText.getText().toString().trim()) == 0){
            Toast.makeText(getApplicationContext(), "PLEASE SELECT PROPER VALUES", Toast.LENGTH_SHORT).show();
        } else{
                switch(viewID){
                    case R.id.upArrowImageView:
                        //Handle for up down click
                        paint.setColor(getColor());
                        paint.setStrokeWidth(getLineThickness());
                        canvas.drawLine(startX, startY, endX, endY, paint);
                        startY = endY;
                        endY = endY - 5;
                        break;
                    case R.id.downArrowImageView:
                        //Handle for down click
                        paint.setColor(getColor());
                        paint.setStrokeWidth(getLineThickness());
                        canvas.drawLine(startX, startY, endX, endY, paint);
                        startY = endY;
                        endY = endY + 5;
                        break;
                    case R.id.rightArrowImageView:
                        //Handle for right click
                        paint.setColor(getColor());
                        paint.setStrokeWidth(getLineThickness());
                        canvas.drawLine(startX, startY, endX, endY, paint);
                        startX = endX;
                        endX = endX + 5;
                        break;
                    case R.id.leftArrowImageView:
                        //Handle for left click
                        paint.setColor(getColor());
                        paint.setStrokeWidth(getLineThickness());
                        canvas.drawLine(startX, startY, endX, endY, paint);
                        startX = endX;
                        endX = endX - 5;
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "SOME ERROR OCCURRED", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }
    /*
    * getColor() : int
    * */
    public int getColor(){
        //Get a reference to the RadioGroup
        lineColorRadioGroup = (RadioGroup) findViewById(R.id.lineColorRadioGroup);
        //This variable will hold the integer value of the color
        int colorToReturn;
        switch(lineColorRadioGroup.getCheckedRadioButtonId()){
            case R.id.lineColorRedRadioButton:
                colorToReturn = Color.RED;
                break;
            case R.id.lineColorYellowRadioButton:
                colorToReturn = Color.YELLOW;
                break;
            case R.id.lineColorCyanRadioButton:
                colorToReturn = Color.CYAN;
                break;
            default:
                return 0;
        }
        return colorToReturn;
    }
    /*
    * getLineThickness() : int
    * */
    public int getLineThickness(){
        //Get a reference to the NumberPicker
        editTextExercise1Activity = (EditText) findViewById(R.id.editTextExercise1Activity);
        return Integer.parseInt(editTextExercise1Activity.getText().toString());
    }
}

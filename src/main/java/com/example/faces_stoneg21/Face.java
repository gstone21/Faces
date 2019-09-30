package com.example.faces_stoneg21;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

/**
 * --- Face Class ---
 * This class draws it's face
 *
 * @author Grant Stone
 */

public class Face extends SurfaceView
{
    protected int skinColor;
    protected int eyeColor;
    protected int hairColor;
    protected int hairStyle;
    protected int colorOp;  //holds selection hair/eyes/skin for changing color
    protected int red;  //rgb value changed by respected seekbar
    protected int green;  //rgb value changed by respected seekbar
    protected int blue;  //rgb value changed by respected seekbar

    Paint paintWhite = new Paint();  //white paint
    Paint paintBlack = new Paint();  //black paint
    Paint paintFace = new Paint();  //skin paint
    Paint paintEyes = new Paint();  //eye paint
    Paint paintHair = new Paint();  //hair paint

    Random rand = new Random();





    public Face(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        setWillNotDraw(false);

        colorOp = R.id.hairRadioButton;

        this.randomize();

        setBackgroundColor(Color.WHITE);

        paintWhite.setColor(Color.WHITE);
        paintWhite.setStyle(Paint.Style.FILL);
        paintBlack.setColor(Color.BLACK);




    }


    public void colorUpdate()
    {
        int partToColor;
        if(colorOp == R.id.hairRadioButton)
        {
            partToColor = hairColor;
        }
        else if(colorOp == R.id.eyesRadioButton)
        {
            partToColor = eyeColor;
        }
        else
        {
            partToColor = skinColor;
        }
        red = Color.red(partToColor);
        green = Color.green(partToColor);
        blue = Color.blue(partToColor);
    }

    public void colorChange(int seekBarId, int rgb)
    {
        int partToColor;
        if(colorOp == R.id.hairRadioButton)
        {
            partToColor = hairColor;
        }
        else if(colorOp == R.id.eyesRadioButton)
        {
            partToColor = eyeColor;
        }
        else
        {
            partToColor = skinColor;
        }
        red = Color.red(partToColor);
        green = Color.green(partToColor);
        blue = Color.blue(partToColor);

        if(seekBarId == R.id.redSeekBar)
        {
            red = rgb;
        }
        else if(seekBarId == R.id.greenSeekBar)
        {
            green = rgb;
        }
        else
        {
            blue = rgb;
        }

        if(colorOp == R.id.hairRadioButton)
        {
            hairColor = Color.rgb(red, green, blue);
        }
        else if(colorOp == R.id.eyesRadioButton)
        {
            eyeColor = Color.rgb(red, green, blue);
        }
        else
        {
            skinColor = Color.rgb(red, green, blue);
        }




    }

    public void randomize()
    {
        hairStyle = rand.nextInt(3);

        int r = rand.nextInt(255);
        int g = rand.nextInt(255);
        int b = rand.nextInt(255);
        skinColor = Color.rgb(r, g, b);
        if(colorOp == R.id.skinRadioButton){
            red = r;
            green = g;
            blue = b;
        }


        r = rand.nextInt(255);
        g = rand.nextInt(255);
        b = rand.nextInt(255);
        eyeColor = Color.rgb(r, g, b);
        if(colorOp == R.id.eyesRadioButton){
            red = r;
            green = g;
            blue = b;
        }

        r = rand.nextInt(255);
        g = rand.nextInt(255);
        b = rand.nextInt(255);
        hairColor = Color.rgb(r, g, b);
        if(colorOp == R.id.hairRadioButton){
            red = r;
            green = g;
            blue = b;
        }




    }

    public void drawEyes(Canvas canvas)
    {

        canvas.drawCircle(400.0f, 600.0f, 75, paintWhite);
        canvas.drawCircle(800.0f, 600.0f, 75, paintWhite);

        canvas.drawCircle(400.0f, 600.0f, 50, paintEyes);
        canvas.drawCircle(800.0f, 600.0f, 50, paintEyes);

        canvas.drawCircle(400.0f, 600.0f, 25, paintBlack);
        canvas.drawCircle(800.0f, 600.0f, 25, paintBlack);
    }

    public void drawHair(Canvas canvas)
    {

        if(hairStyle == 0){
            canvas.drawOval(200, 200, 1000, 500, paintHair);
            canvas.drawRect(225, 350, 300, 600, paintHair);
            canvas.drawRect(900, 350, 975, 600, paintHair);
        } else if(hairStyle == 1)
        {

        } else {
            canvas.drawOval(300, 200, 900, 400, paintHair);
            canvas.drawCircle(600, 150, 150, paintHair);
        }


    }

    @Override
    public void onDraw(Canvas canvas)
    {
        paintFace.setColor(skinColor);
        paintEyes.setColor(eyeColor);
        paintHair.setColor(hairColor);


        canvas.drawOval(200.0f, 200.0f, 1000.0f, 1200.0f, paintFace);
        drawEyes(canvas);
        drawHair(canvas);




    }


}

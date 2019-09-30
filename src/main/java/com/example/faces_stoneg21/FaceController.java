package com.example.faces_stoneg21;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

/**
 * --- FaceController Class ---
 * This is the controller class for making changes
 * to it's face.
 *
 * @author Grant Stone
 */

public class FaceController implements AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener,
        SeekBar.OnSeekBarChangeListener, View.OnClickListener
{
    private Face face_v;  //face that is controlled


    public FaceController(Face f)
    {
        face_v = f;
    }


    /**
     External Citation
     Date:     29 September 2019
     Problem:  I did not know how to use a spinner.
     Resource:
     https://www.youtube.com/watch?v=on_OrrX7Nw4
     Solution: I used the example code from this video.
     */
    //spinner
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        face_v.hairStyle = position;
        face_v.invalidate();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) { }


    /**
     External Citation
     Date:     29 September 2019
     Problem:  I did not know how to use a radio button group.
     Resource:
     https://developer.android.com/reference/android/widget/RadioGroup.OnCheckedChangeListener
     Solution: I learned what listener and methods to use for a radio group.
     */
    //radio group
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId)
    {
        face_v.colorOp = checkedId;
        face_v.colorUpdate();


        face_v.invalidate();

    }

    //seekbar
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
    {
        face_v.colorChange(seekBar.getId(), progress);
        face_v.invalidate();

    }
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) { }
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) { }

    //Random face button
    @Override
    public void onClick(View v)
    {
        face_v.randomize();
        face_v.invalidate();
    }

}

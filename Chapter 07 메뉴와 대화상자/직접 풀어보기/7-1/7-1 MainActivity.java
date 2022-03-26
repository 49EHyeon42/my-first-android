package com.cookandroid.trytosolve7_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    EditText editAngle;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("제주도 풍경");

        editAngle = (EditText) findViewById(R.id.editAngle);
        imageView = (ImageView) findViewById(R.id.imgView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemRotate:
                imageView.setRotation(Float.parseFloat(editAngle.getText().toString()));
                return true;
            case R.id.item1:
                imageView.setImageResource(R.drawable.jeju2);
                return true;
            case R.id.item2:
                imageView.setImageResource(R.drawable.jeju14);
                return true;
            case R.id.item3:
                imageView.setImageResource(R.drawable.jeju6);
                return true;
        }
        return false;
    }
}
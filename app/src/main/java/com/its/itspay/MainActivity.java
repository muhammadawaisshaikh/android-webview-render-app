package com.its.itspay;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onItsPayClick(View view) {
        openWebUrl();
    }

    private void openWebUrl() {
        Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
        startActivityForResult(intent , 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
           Bundle bundle = data.getExtras();
            String tdata = bundle.getString("name" , "");
            Toast.makeText(MainActivity.this, tdata, Toast.LENGTH_SHORT).show();

        }
    }
}

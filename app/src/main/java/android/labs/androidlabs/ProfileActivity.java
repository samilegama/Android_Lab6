package android.labs.androidlabs;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.content.SharedPreferences;


public class ProfileActivity extends Activity {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final String ACTIVITY_NAME="ProfileActivity";
    private ImageButton mImageButton;

    private Button chatButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.d(ACTIVITY_NAME,"onCreate");

        mImageButton = findViewById(R.id.pictureButton);
        EditText editText = findViewById(R.id.emailEdit);
        SharedPreferences prefs= getSharedPreferences("FileName", MODE_PRIVATE);
        String email = prefs.getString("Email", "");
        editText.setText(email);
        mImageButton.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });


        Log.e(ACTIVITY_NAME, "in function: onCreate()");

        chatButton = (Button) findViewById(R.id.chatButton);

        chatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent itLab4 = new Intent(ProfileActivity.this, ChatRoomActivity.class);
                startActivityForResult(itLab4, 345);
            }
        });


        Button goToWeatherBtn = (Button)findViewById(R.id.WeatherBtn);
        goToWeatherBtn.setOnClickListener(c -> {
            Intent goToMenuPage = new Intent(ProfileActivity.this, WeatherForecast.class);

            startActivityForResult(goToMenuPage, 234);

        });

        Log.d(ACTIVITY_NAME, "In function: onCreate()");
    }


    private void dispatchTakePictureIntent() {
        Log.d(ACTIVITY_NAME,"dispatchTakePictureIntent");
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(ACTIVITY_NAME,"onActivityResult");

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImageButton.setImageBitmap(imageBitmap);
        }
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(ACTIVITY_NAME,"onPause");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(ACTIVITY_NAME,"onStart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(ACTIVITY_NAME,"onResume");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(ACTIVITY_NAME,"onStop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(ACTIVITY_NAME,"onDestroy");
    }



}

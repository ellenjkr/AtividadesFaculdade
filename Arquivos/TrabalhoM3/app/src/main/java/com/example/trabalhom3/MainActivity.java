package com.example.trabalhom3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.CookieHandler;
import java.util.ArrayList;

import static android.content.Intent.createChooser;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ImageView> images = new ArrayList<>();
    private ArrayList<Button> buttons = new ArrayList<>();
    private int imageIterator;

    private static final int PICK_IMAGE=1;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.images.add((ImageView) findViewById(R.id.FirstImage));
        this.images.add((ImageView) findViewById(R.id.SecondImage));
        this.images.add((ImageView) findViewById(R.id.ThirdImage));

        this.buttons.add((Button) findViewById(R.id.FirstButton));
        this.buttons.add((Button) findViewById(R.id.SecondButton));
        this.buttons.add((Button) findViewById(R.id.ThirdButton));

        for(int i=0; i < this.images.size(); i++){
            int finalI = i;
            this.images.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imageIterator = finalI;
                    Intent gallery = new Intent();
                    gallery.setType("image/*");
                    gallery.setAction(Intent.ACTION_GET_CONTENT);

                    startActivityForResult(Intent.createChooser(gallery, "Selecione uma Imagem"), PICK_IMAGE);
                }
            });
        }

        if(ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{
                            Manifest.permission.CAMERA
                    },
                    100);
        }


        for(int j=0; j < this.buttons.size(); j++){
            int finalJ = j;
            this.buttons.get(j).setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    imageIterator = finalJ;
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, 100);
                }
            });
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK){
            imageUri = data.getData();
            try{
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                this.images.get(imageIterator).setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (requestCode == 100){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            this.images.get(imageIterator).setImageBitmap(bitmap);
        }
    }
}
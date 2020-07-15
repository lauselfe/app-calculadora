package com.example.ejerciciointerfacesandroid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PerfilActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nombre, mail;
    ImageView btncamara, photo;
    TextView nombreview, mailview;
    Uri image_uri;
    private static final int PERMISSION_CODE = 1000;
    private static final int IMAGE_CAPTURE_CODE = 1001;
    public static int CAMERA_REQUEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_perfil);

        ///actionbar edit
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.calculadorapequenya);
        getSupportActionBar().setTitle("");


        nombre = (EditText) findViewById(R.id.nombre);
        mail = (EditText) findViewById(R.id.mail);
        btncamara = (ImageView) findViewById(R.id.btncamara);
        /////imageview que recogerá la imagen de la camara
        photo = (ImageView) findViewById(R.id.photo);
        nombreview = (TextView) findViewById(R.id.nombreview);
        mailview = (TextView) findViewById(R.id.mailview);
    ///Boton para activar la cámara
        btncamara.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        ///editar los TextView cuando se haga click



        ///si el sistema es >= a marshmallow, haz el request de los permisos
     if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
         if(checkSelfPermission(Manifest.permission.CAMERA) ==
                 PackageManager.PERMISSION_DENIED ||
                 checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
         PackageManager.PERMISSION_DENIED){
             ///el permiso no está, se pide
             String[] permission = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
             ///que aparezca el popup
             requestPermissions(permission, PERMISSION_CODE);
         }
         else{
             ///los permisos ya habían sido dados
             openCamera();
         }
     }
     else{
         ///el sistema operativo es inferior a marshmallow
         openCamera();
     }
        String contenidoNombre = nombre.getText().toString();
        String contenidoEmail = mail.getText().toString();

        nombreview.setText(contenidoNombre);
        mailview.setText(contenidoEmail);

    }

    private void openCamera(){
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, "Perfil");
        values.put(MediaStore.Images.Media.DESCRIPTION, "Desde la cámara");
        image_uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        ////camara intent
        Intent camaraIntent = new Intent (MediaStore.ACTION_IMAGE_CAPTURE);
        camaraIntent.putExtra(MediaStore.EXTRA_OUTPUT, image_uri);
        startActivityForResult(camaraIntent, IMAGE_CAPTURE_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        ///este metodo se usa cuando el usuario permite o niega el popup de los permisos
        switch (requestCode){
            case PERMISSION_CODE:{
                if (grantResults.length > 0 && grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED){
                    ///se da el permiso
                    openCamera();
                }else{
                    ////se niega el permiso
                    Toast.makeText(this, "Permiso denegado...", Toast.LENGTH_LONG).show();
                }
            }

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        ////llamar cuándo la imagen sea capturada
        if(resultCode == RESULT_OK){
            photo.setImageURI(image_uri);
        }
    }
}



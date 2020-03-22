package com.eiadmreh.tutsplusupload;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    private Button btnchoose, btnUpload;
    private EditText itemName, itemPrice, itemInfo, Link1, Link2, Link3;
    private ImageView imageView;

    private Uri filePath;
    //Firebase
    private FirebaseStorage storage;
    private StorageReference storageReference;
    private DatabaseReference databaseReference;

    private final int PICK_IMAGE_REQUEST = 71;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initialize Views
        btnchoose = (Button) findViewById(R.id.btnChos);
        btnUpload = (Button) findViewById(R.id.btnUplod);
        imageView = (ImageView) findViewById(R.id.imgView);
        //Firebase
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        itemName=findViewById(R.id.editname);
        itemPrice=findViewById(R.id.editprice);
        itemInfo=findViewById(R.id.editinfo);
        Link1=findViewById(R.id.editlink1);
        Link2=findViewById(R.id.editlink2);
        Link3=findViewById(R.id.editlink3);
        databaseReference= FirebaseDatabase.getInstance().getReference("items");


        Initialize();


}



    private void Initialize() {
        btnchoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImage();
            }
        });

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadImage();
            }
        });
    }

    private void uploadImage() {
        if(filePath != null)
        {
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();
            final String imgName = itemName.getText().toString() +"." + getFileExtension( filePath );
            UploadImage uploadImage=new UploadImage(itemName.getText().toString(),itemPrice.getText().toString(),
                    itemInfo.getText().toString(),Link1.getText().toString(),Link2.getText().toString(),Link3.getText().toString(),imgName
                    );
            databaseReference.push().setValue(uploadImage);
            StorageReference ref = storageReference.child(imgName);
            ref.putFile(filePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressDialog.dismiss();
                            Toast.makeText(MainActivity.this, "Uploaded", Toast.LENGTH_SHORT).show();


                          /*  UploadImage uploadImage=new UploadImage(itemName.getText().toString(),itemPrice.getText().toString(),
                                    itemInfo.getText().toString(),Link1.getText().toString(),Link2.getText().toString(),Link3.getText().toString(),
                                    taskSnapshot.getUploadSessionUri().toString());
                            String UploadId=databaseReference.push().getKey();
                            databaseReference.child(UploadId).setValue(uploadImage);

                           */
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(MainActivity.this, "Failed "+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                   /* .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot
                                    .getTotalByteCount());
                            progressDialog.setMessage("Uploaded "+(int)progress+"%");
                        }
                    });

                    */
        }
        if(filePath== null)
        Toast.makeText(MainActivity.this, "select an image...", Toast.LENGTH_SHORT).show();

    }

    private String getFileExtension(Uri uri){
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType( cR.getType( uri ) );
    }
    private void chooseImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }
    @Override
   /* protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null )
        {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                imageView.setImageBitmap(bitmap);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    */
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE_REQUEST){
            filePath = data.getData();
            imageView.setImageURI( filePath );
        }
    }
    private String getImageType(String name){
        String [] type = name.split( "\\." );
        return type[1];
        }
}

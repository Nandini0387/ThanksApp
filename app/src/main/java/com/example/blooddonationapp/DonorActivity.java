package com.example.blooddonationapp;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;
//import com.journeyapps.barcodescanner.BarcodeFormat;

public class DonorActivity extends AppCompatActivity {

    private EditText donorNameEditText;
    private EditText donorMobileEditText;
    private Button generateQrButton;
    private ImageView qrCodeImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor);

        donorNameEditText = findViewById(R.id.donor_name);
        donorMobileEditText = findViewById(R.id.donor_mobile);
        generateQrButton = findViewById(R.id.generate_qr_button);
        qrCodeImageView = findViewById(R.id.qr_code_image);
        // Inside onCreate() method of DonorActivity.java
        Button downloadButton = findViewById(R.id.download_button);

        generateQrButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = donorNameEditText.getText().toString();
                String mobile = donorMobileEditText.getText().toString();

                if (name.isEmpty() || mobile.isEmpty()) {
                    Toast.makeText(DonorActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                String qrData = name + ":" + mobile;

                try {
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.encodeBitmap(qrData, BarcodeFormat.QR_CODE, 400, 400);
                    qrCodeImageView.setImageBitmap(bitmap);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                generateQrButton.setVisibility(View.INVISIBLE);
                downloadButton.setVisibility(View.VISIBLE); // Show the download button
            }
        });

        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveImageToGallery();
            }
        });

    }

    private void saveImageToGallery(){
        // Get the bitmap from the ImageView
        BitmapDrawable drawable = (BitmapDrawable) qrCodeImageView.getDrawable();
        Bitmap bitmap = drawable.getBitmap();

        // Save the bitmap to the device gallery
        String savedImageURL = MediaStore.Images.Media.insertImage(
                getContentResolver(),
                bitmap,
                "QR_Code",
                "QR Code generated by Blood Donation App"
        );

        // Show a toast message indicating whether the image was saved successfully
        if (savedImageURL != null) {
            Toast.makeText(this, "QR Code saved to Gallery", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Failed to save QR Code", Toast.LENGTH_SHORT).show();
        }
    }
}

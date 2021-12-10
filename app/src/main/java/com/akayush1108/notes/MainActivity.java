package com.akayush1108.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button button1;
    DatabaseReference database;
    String message;
    Button button2;
    DatabaseReference database2;
    String message2;
    Button button3;
    DatabaseReference database3;
    String message3;
    Button button4;
    DatabaseReference database4;
    String message4;

//    Button button1;
//    Button button2;
//    Button button3;
//    Button button4;
    String url1 = "https://raw.githubusercontent.com/akayush1108/Notes-HandWrittenNotesApp/master/screenshots/slider1.png";
    String url2 = "https://raw.githubusercontent.com/akayush1108/Notes-HandWrittenNotesApp/master/screenshots/slider2.jpg";
    String url3 = "https://raw.githubusercontent.com/akayush1108/Notes-HandWrittenNotesApp/master/screenshots/slider3.png";
    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout);


        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();

        SliderView sliderView = findViewById(R.id.slider);


        sliderDataArrayList.add(new SliderData(url1));
        sliderDataArrayList.add(new SliderData(url2));
        sliderDataArrayList.add(new SliderData(url3));

        SliderAdapter adapter = new SliderAdapter(this, sliderDataArrayList);
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        sliderView.setSliderAdapter(adapter);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();



        button1 = findViewById(R.id.btn);

        // Initialising the reference to database
        database = FirebaseDatabase.getInstance().getReference().child("pdf1");
        database.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // getting a DataSnapshot for the location at the specified
                // relative path and getting in the link variable
                message = dataSnapshot.getValue(String.class);
            }

            // this will called when any problem
            // occurs in getting data
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // we are showing that error message in toast
                Toast.makeText(MainActivity.this, "Error Loading Pdf", Toast.LENGTH_SHORT).show();
            }
        });
        // After clicking here alert box will come
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                CharSequence options[] = new CharSequence[]{
                        "Download",
                        "View",
                        "Cancel"
                };
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Choose One");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // we will be downloading the pdf
                        if (which == 0) {
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(message));
                            startActivity(intent);
                        }
                        // We will view the pdf
                        if (which == 1) {
                            Intent intent = new Intent(v.getContext(), PdfActivity1.class);
                            intent.putExtra("url", message);
                            startActivity(intent);
                        }
                    }
                });
                builder.show();
            }
        });


        button2 = findViewById(R.id.btn2);

        // Initialising the reference to database
        database2 = FirebaseDatabase.getInstance().getReference().child("pdf2");
        database2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // getting a DataSnapshot for the location at the specified
                // relative path and getting in the link variable
                message2 = dataSnapshot.getValue(String.class);
            }

            // this will called when any problem
            // occurs in getting data
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // we are showing that error message in toast
                Toast.makeText(MainActivity.this, "Error Loading Pdf", Toast.LENGTH_SHORT).show();
            }
        });
        // After clicking here alert box will come
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                CharSequence options[] = new CharSequence[]{
                        "Download",
                        "View",
                        "Cancel"
                };
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Choose One");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // we will be downloading the pdf
                        if (which == 0) {
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(message2));
                            startActivity(intent);
                        }
                        // We will view the pdf
                        if (which == 1) {
                            Intent intent = new Intent(v.getContext(), PdfActivity2.class);
                            intent.putExtra("url", message2);
                            startActivity(intent);
                        }
                    }
                });
                builder.show();
            }
        });


        button3 = findViewById(R.id.btn3);

        // Initialising the reference to database
        database3 = FirebaseDatabase.getInstance().getReference().child("pdf3");
        database3.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // getting a DataSnapshot for the location at the specified
                // relative path and getting in the link variable
                message3 = dataSnapshot.getValue(String.class);
            }

            // this will called when any problem
            // occurs in getting data
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // we are showing that error message in toast
                Toast.makeText(MainActivity.this, "Error Loading Pdf", Toast.LENGTH_SHORT).show();
            }
        });
        // After clicking here alert box will come
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                CharSequence options[] = new CharSequence[]{
                        "Download",
                        "View",
                        "Cancel"
                };
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Choose One");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // we will be downloading the pdf
                        if (which == 0) {
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(message3));
                            startActivity(intent);
                        }
                        // We will view the pdf
                        if (which == 1) {
                            Intent intent = new Intent(v.getContext(), PdfActivity3.class);
                            intent.putExtra("url", message3);
                            startActivity(intent);
                        }
                    }
                });
                builder.show();
            }
        });

        button4 = findViewById(R.id.btn4);

        // Initialising the reference to database
        database4 = FirebaseDatabase.getInstance().getReference().child("pdf4");
        database4.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // getting a DataSnapshot for the location at the specified
                // relative path and getting in the link variable
                message4 = dataSnapshot.getValue(String.class);
            }

            // this will called when any problem
            // occurs in getting data
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // we are showing that error message in toast
                Toast.makeText(MainActivity.this, "Error Loading Pdf", Toast.LENGTH_SHORT).show();
            }
        });
        // After clicking here alert box will come
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                CharSequence options[] = new CharSequence[]{
                        "Download",
                        "View",
                        "Cancel"
                };
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Choose One");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // we will be downloading the pdf
                        if (which == 0) {
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(message4));
                            startActivity(intent);
                        }
                        // We will view the pdf
                        if (which == 1) {
                            Intent intent = new Intent(v.getContext(), PdfActivity4.class);
                            intent.putExtra("url", message4);
                            startActivity(intent);
                        }
                    }
                });
                builder.show();
            }
        });






        // //Button button1 = findViewById(R.id.btn);

//        button1 = (Button) findViewById(R.id.btn);
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, PdfActivity1.class);
//                startActivity(intent);
//            }
//        });

//        button2 = (Button) findViewById(R.id.btn2);
//
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, PdfActivity2.class);
//                startActivity(intent);
//            }
//        });

//        button3 = (Button) findViewById(R.id.btn3);
//
//        button3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, PdfActivity3.class);
//                startActivity(intent);
//            }
//        });

//        button4 = (Button) findViewById(R.id.btn4);
//
//        button4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, PdfActivity4.class);
//                startActivity(intent);
//            }
//        });

    }

    @Override
    public void onBackPressed()
    {
        AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("Alert")
                .setMessage("Do you want to close this application?")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("Cancel",null);
        AlertDialog alert = builder.create();
        alert.show();
    }
}
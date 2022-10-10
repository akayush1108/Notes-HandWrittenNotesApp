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
    DatabaseReference database31,database32,database33,database34,database35,database36,database37,database38,database39,database310,database311;
    String message31,message32,message33,message34,message35,message36,message37,message38,message39,message310,message311;
    Button button4;
    DatabaseReference database4;
    String message4;
    Button button5;
    DatabaseReference database5;
    String message5;
    Button button6;
    DatabaseReference database6;
    String message6;
    Button button7;
    DatabaseReference database7;
    String message7;
    Button button8;
    DatabaseReference database8;
    String message8;
    Button button9;
    DatabaseReference database9;
    String message9;
    Button button10;

//    Button button1;
//    Button button2;
//    Button button3;
//    Button button4;
    String url1 = "https://github.com/akayush1108/Notes-HandWrittenNotesApp/blob/master/screenshots/slider4.png?raw=true";
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
        database31 = FirebaseDatabase.getInstance().getReference().child("pdf31");
        database31.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // getting a DataSnapshot for the location at the specified
                // relative path and getting in the link variable
                message31 = dataSnapshot.getValue(String.class);
            }

            // this will called when any problem
            // occurs in getting data
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // we are showing that error message in toast
                Toast.makeText(MainActivity.this, "Error Loading Pdf", Toast.LENGTH_SHORT).show();
            }
        });

        database32 = FirebaseDatabase.getInstance().getReference().child("pdf32");
        database32.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // getting a DataSnapshot for the location at the specified
                // relative path and getting in the link variable
                message32 = dataSnapshot.getValue(String.class);
            }

            // this will called when any problem
            // occurs in getting data
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // we are showing that error message in toast
                Toast.makeText(MainActivity.this, "Error Loading Pdf", Toast.LENGTH_SHORT).show();
            }
        });

        database33 = FirebaseDatabase.getInstance().getReference().child("pdf33");
        database33.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // getting a DataSnapshot for the location at the specified
                // relative path and getting in the link variable
                message33 = dataSnapshot.getValue(String.class);
            }

            // this will called when any problem
            // occurs in getting data
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // we are showing that error message in toast
                Toast.makeText(MainActivity.this, "Error Loading Pdf", Toast.LENGTH_SHORT).show();
            }
        });

        database34 = FirebaseDatabase.getInstance().getReference().child("pdf34");
        database34.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // getting a DataSnapshot for the location at the specified
                // relative path and getting in the link variable
                message34 = dataSnapshot.getValue(String.class);
            }

            // this will called when any problem
            // occurs in getting data
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // we are showing that error message in toast
                Toast.makeText(MainActivity.this, "Error Loading Pdf", Toast.LENGTH_SHORT).show();
            }
        });

        database35 = FirebaseDatabase.getInstance().getReference().child("pdf35");
        database35.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // getting a DataSnapshot for the location at the specified
                // relative path and getting in the link variable
                message35 = dataSnapshot.getValue(String.class);
            }

            // this will called when any problem
            // occurs in getting data
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // we are showing that error message in toast
                Toast.makeText(MainActivity.this, "Error Loading Pdf", Toast.LENGTH_SHORT).show();
            }
        });

        database36 = FirebaseDatabase.getInstance().getReference().child("pdf36");
        database36.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // getting a DataSnapshot for the location at the specified
                // relative path and getting in the link variable
                message36 = dataSnapshot.getValue(String.class);
            }

            // this will called when any problem
            // occurs in getting data
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // we are showing that error message in toast
                Toast.makeText(MainActivity.this, "Error Loading Pdf", Toast.LENGTH_SHORT).show();
            }
        });

        database37 = FirebaseDatabase.getInstance().getReference().child("pdf37");
        database37.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // getting a DataSnapshot for the location at the specified
                // relative path and getting in the link variable
                message37 = dataSnapshot.getValue(String.class);
            }

            // this will called when any problem
            // occurs in getting data
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // we are showing that error message in toast
                Toast.makeText(MainActivity.this, "Error Loading Pdf", Toast.LENGTH_SHORT).show();
            }
        });

        database38 = FirebaseDatabase.getInstance().getReference().child("pdf38");
        database38.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // getting a DataSnapshot for the location at the specified
                // relative path and getting in the link variable
                message38 = dataSnapshot.getValue(String.class);
            }

            // this will called when any problem
            // occurs in getting data
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // we are showing that error message in toast
                Toast.makeText(MainActivity.this, "Error Loading Pdf", Toast.LENGTH_SHORT).show();
            }
        });

        database39 = FirebaseDatabase.getInstance().getReference().child("pdf39");
        database39.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // getting a DataSnapshot for the location at the specified
                // relative path and getting in the link variable
                message39 = dataSnapshot.getValue(String.class);
            }

            // this will called when any problem
            // occurs in getting data
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // we are showing that error message in toast
                Toast.makeText(MainActivity.this, "Error Loading Pdf", Toast.LENGTH_SHORT).show();
            }
        });

        database310 = FirebaseDatabase.getInstance().getReference().child("pdf310");
        database310.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // getting a DataSnapshot for the location at the specified
                // relative path and getting in the link variable
                message310 = dataSnapshot.getValue(String.class);
            }

            // this will called when any problem
            // occurs in getting data
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // we are showing that error message in toast
                Toast.makeText(MainActivity.this, "Error Loading Pdf", Toast.LENGTH_SHORT).show();
            }
        });

        database311 = FirebaseDatabase.getInstance().getReference().child("pdf311");
        database311.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // getting a DataSnapshot for the location at the specified
                // relative path and getting in the link variable
                message311 = dataSnapshot.getValue(String.class);
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
                        "Linked List",
                        "Stack and Queue",
                        "Binary Tree",
                        "Binary Search Tree",
                        "Generic Tree",
                        "Tries",
                        "Graph",
                        "HashMap and Heap",
                        "Recursion",
                        "Dynamic Programming",
                        "Time and Space"

                };
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Topics");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // we will be downloading the pdf

                        if(which == 0){
                            CharSequence options1[] = new CharSequence[]{
                                    "Download",
                                    "View",
                                    "Cancel"
                            };
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(v.getContext());
                            builder1.setTitle("Choose One");
                            builder1.setItems(options1, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // we will be downloading the pdf
                                    if (which == 0) {
                                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(message31));
                                        startActivity(intent);
                                    }
                                    // We will view the pdf
                                    if (which == 1) {
                                        Intent intent = new Intent(v.getContext(), PdfActivity3.class);
                                        intent.putExtra("url", message31);
                                        startActivity(intent);
                                    }
                                }
                            });
                            builder1.show();
                        }

                        if(which == 1){
                            CharSequence options2[] = new CharSequence[]{
                                    "Download",
                                    "View",
                                    "Cancel"
                            };
                            AlertDialog.Builder builder2 = new AlertDialog.Builder(v.getContext());
                            builder2.setTitle("Choose One");
                            builder2.setItems(options2, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // we will be downloading the pdf
                                    if (which == 0) {
                                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(message32));
                                        startActivity(intent);
                                    }
                                    // We will view the pdf
                                    if (which == 1) {
                                        Intent intent = new Intent(v.getContext(), PdfActivity3.class);
                                        intent.putExtra("url", message32);
                                        startActivity(intent);
                                    }
                                }
                            });
                            builder2.show();
                        }

                        if(which == 2){
                            CharSequence options3[] = new CharSequence[]{
                                    "Download",
                                    "View",
                                    "Cancel"
                            };
                            AlertDialog.Builder builder3 = new AlertDialog.Builder(v.getContext());
                            builder3.setTitle("Choose One");
                            builder3.setItems(options3, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // we will be downloading the pdf
                                    if (which == 0) {
                                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(message33));
                                        startActivity(intent);
                                    }
                                    // We will view the pdf
                                    if (which == 1) {
                                        Intent intent = new Intent(v.getContext(), PdfActivity3.class);
                                        intent.putExtra("url", message33);
                                        startActivity(intent);
                                    }
                                }
                            });
                            builder3.show();
                        }

                        if(which == 3){
                            CharSequence options4[] = new CharSequence[]{
                                    "Download",
                                    "View",
                                    "Cancel"
                            };
                            AlertDialog.Builder builder4 = new AlertDialog.Builder(v.getContext());
                            builder4.setTitle("Choose One");
                            builder4.setItems(options4, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // we will be downloading the pdf
                                    if (which == 0) {
                                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(message34));
                                        startActivity(intent);
                                    }
                                    // We will view the pdf
                                    if (which == 1) {
                                        Intent intent = new Intent(v.getContext(), PdfActivity3.class);
                                        intent.putExtra("url", message34);
                                        startActivity(intent);
                                    }
                                }
                            });
                            builder4.show();
                        }

                        if(which == 4){
                            CharSequence options5[] = new CharSequence[]{
                                    "Download",
                                    "View",
                                    "Cancel"
                            };
                            AlertDialog.Builder builder5 = new AlertDialog.Builder(v.getContext());
                            builder5.setTitle("Choose One");
                            builder5.setItems(options5, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // we will be downloading the pdf
                                    if (which == 0) {
                                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(message35));
                                        startActivity(intent);
                                    }
                                    // We will view the pdf
                                    if (which == 1) {
                                        Intent intent = new Intent(v.getContext(), PdfActivity3.class);
                                        intent.putExtra("url", message35);
                                        startActivity(intent);
                                    }
                                }
                            });
                            builder5.show();
                        }

                        if(which == 5){
                            CharSequence options6[] = new CharSequence[]{
                                    "Download",
                                    "View",
                                    "Cancel"
                            };
                            AlertDialog.Builder builder6 = new AlertDialog.Builder(v.getContext());
                            builder6.setTitle("Choose One");
                            builder6.setItems(options6, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // we will be downloading the pdf
                                    if (which == 0) {
                                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(message36));
                                        startActivity(intent);
                                    }
                                    // We will view the pdf
                                    if (which == 1) {
                                        Intent intent = new Intent(v.getContext(), PdfActivity3.class);
                                        intent.putExtra("url", message36);
                                        startActivity(intent);
                                    }
                                }
                            });
                            builder6.show();
                        }

                        if(which == 6){
                            CharSequence options7[] = new CharSequence[]{
                                    "Download",
                                    "View",
                                    "Cancel"
                            };
                            AlertDialog.Builder builder7 = new AlertDialog.Builder(v.getContext());
                            builder7.setTitle("Choose One");
                            builder7.setItems(options7, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // we will be downloading the pdf
                                    if (which == 0) {
                                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(message37));
                                        startActivity(intent);
                                    }
                                    // We will view the pdf
                                    if (which == 1) {
                                        Intent intent = new Intent(v.getContext(), PdfActivity3.class);
                                        intent.putExtra("url", message37);
                                        startActivity(intent);
                                    }
                                }
                            });
                            builder7.show();
                        }

                        if(which == 7){
                            CharSequence options8[] = new CharSequence[]{
                                    "Download",
                                    "View",
                                    "Cancel"
                            };
                            AlertDialog.Builder builder8 = new AlertDialog.Builder(v.getContext());
                            builder8.setTitle("Choose One");
                            builder8.setItems(options8, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // we will be downloading the pdf
                                    if (which == 0) {
                                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(message38));
                                        startActivity(intent);
                                    }
                                    // We will view the pdf
                                    if (which == 1) {
                                        Intent intent = new Intent(v.getContext(), PdfActivity3.class);
                                        intent.putExtra("url", message38);
                                        startActivity(intent);
                                    }
                                }
                            });
                            builder8.show();
                        }

                        if(which == 8){
                            CharSequence options9[] = new CharSequence[]{
                                    "Download",
                                    "View",
                                    "Cancel"
                            };
                            AlertDialog.Builder builder9 = new AlertDialog.Builder(v.getContext());
                            builder9.setTitle("Choose One");
                            builder9.setItems(options9, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // we will be downloading the pdf
                                    if (which == 0) {
                                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(message39));
                                        startActivity(intent);
                                    }
                                    // We will view the pdf
                                    if (which == 1) {
                                        Intent intent = new Intent(v.getContext(), PdfActivity3.class);
                                        intent.putExtra("url", message39);
                                        startActivity(intent);
                                    }
                                }
                            });
                            builder9.show();
                        }

                        if(which == 9){
                            CharSequence options10[] = new CharSequence[]{
                                    "Download",
                                    "View",
                                    "Cancel"
                            };
                            AlertDialog.Builder builder10 = new AlertDialog.Builder(v.getContext());
                            builder10.setTitle("Choose One");
                            builder10.setItems(options10, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // we will be downloading the pdf
                                    if (which == 0) {
                                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(message310));
                                        startActivity(intent);
                                    }
                                    // We will view the pdf
                                    if (which == 1) {
                                        Intent intent = new Intent(v.getContext(), PdfActivity3.class);
                                        intent.putExtra("url", message310);
                                        startActivity(intent);
                                    }
                                }
                            });
                            builder10.show();
                        }

                        if(which == 10){
                            CharSequence options11[] = new CharSequence[]{
                                    "Download",
                                    "View",
                                    "Cancel"
                            };
                            AlertDialog.Builder builder11 = new AlertDialog.Builder(v.getContext());
                            builder11.setTitle("Choose One");
                            builder11.setItems(options11, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // we will be downloading the pdf
                                    if (which == 0) {
                                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(message311));
                                        startActivity(intent);
                                    }
                                    // We will view the pdf
                                    if (which == 1) {
                                        Intent intent = new Intent(v.getContext(), PdfActivity3.class);
                                        intent.putExtra("url", message311);
                                        startActivity(intent);
                                    }
                                }
                            });
                            builder11.show();
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


        button5 = findViewById(R.id.btn5);

        // Initialising the reference to database
        database5 = FirebaseDatabase.getInstance().getReference().child("pdf5");
        database5.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // getting a DataSnapshot for the location at the specified
                // relative path and getting in the link variable
                message5 = dataSnapshot.getValue(String.class);
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
        button5.setOnClickListener(new View.OnClickListener() {
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
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(message5));
                            startActivity(intent);
                        }
                        // We will view the pdf
                        if (which == 1) {
                            Intent intent = new Intent(v.getContext(), PdfActivity5.class);
                            intent.putExtra("url", message5);
                            startActivity(intent);
                        }
                    }
                });
                builder.show();
            }
        });

        button6 = findViewById(R.id.btn6);

        // Initialising the reference to database
        database6 = FirebaseDatabase.getInstance().getReference().child("pdf6");
        database6.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // getting a DataSnapshot for the location at the specified
                // relative path and getting in the link variable
                message6 = dataSnapshot.getValue(String.class);
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
        button6.setOnClickListener(new View.OnClickListener() {
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
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(message6));
                            startActivity(intent);
                        }
                        // We will view the pdf
                        if (which == 1) {
                            Intent intent = new Intent(v.getContext(), PdfActivity6.class);
                            intent.putExtra("url", message6);
                            startActivity(intent);
                        }
                    }
                });
                builder.show();
            }
        });


        button7 = findViewById(R.id.btn7);

        // Initialising the reference to database
        database7 = FirebaseDatabase.getInstance().getReference().child("pdf7");
        database7.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // getting a DataSnapshot for the location at the specified
                // relative path and getting in the link variable
                message7 = dataSnapshot.getValue(String.class);
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
        button7.setOnClickListener(new View.OnClickListener() {
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
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(message7));
                            startActivity(intent);
                        }
                        // We will view the pdf
                        if (which == 1) {
                            Intent intent = new Intent(v.getContext(), PdfActivity7.class);
                            intent.putExtra("url", message7);
                            startActivity(intent);
                        }
                    }
                });
                builder.show();
            }
        });

        button8 = findViewById(R.id.btn8);

        // Initialising the reference to database
        database8 = FirebaseDatabase.getInstance().getReference().child("pdf8");
        database8.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // getting a DataSnapshot for the location at the specified
                // relative path and getting in the link variable
                message8 = dataSnapshot.getValue(String.class);
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
        button8.setOnClickListener(new View.OnClickListener() {
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
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(message8));
                            startActivity(intent);
                        }
                        // We will view the pdf
                        if (which == 1) {
                            Intent intent = new Intent(v.getContext(), PdfActivity8.class);
                            intent.putExtra("url", message8);
                            startActivity(intent);
                        }
                    }
                });
                builder.show();
            }
        });

        button9 = findViewById(R.id.btn9);

        // Initialising the reference to database
        database9 = FirebaseDatabase.getInstance().getReference().child("pdf9");
        database9.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // getting a DataSnapshot for the location at the specified
                // relative path and getting in the link variable
                message9 = dataSnapshot.getValue(String.class);
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
        button9.setOnClickListener(new View.OnClickListener() {
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
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(message9));
                            startActivity(intent);
                        }
                        // We will view the pdf
                        if (which == 1) {
                            Intent intent = new Intent(v.getContext(), PdfActivity9.class);
                            intent.putExtra("url", message9);
                            startActivity(intent);
                        }
                    }
                });
                builder.show();
            }
        });

        button10=findViewById(R.id.btn10);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String appPackageName = "com.akayush1108.freshnews";

                Intent intent = getPackageManager().getLaunchIntentForPackage(appPackageName);
                if (intent != null) {

                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);

                } else {

                    onGoToAnotherInAppStore(intent, appPackageName);

                }

            }

            public void onGoToAnotherInAppStore(Intent intent, String appPackageName) {

                try {

                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setData(Uri.parse("market://details?id=" + appPackageName));
                    startActivity(intent);

                } catch (android.content.ActivityNotFoundException anfe) {

                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setData(Uri.parse("http://play.google.com/store/apps/details?id=" + appPackageName));
                    startActivity(intent);

                }

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
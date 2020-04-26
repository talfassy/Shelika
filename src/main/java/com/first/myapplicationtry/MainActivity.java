package com.first.myapplicationtry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button aboutUsBtn;
    private Button addOfferBtn;
    private Button howBtn;
    private Button watchBtn;

    private TextView instaBtn;
    private TextView emailBtn;
    private TextView whatsupBtn;
    private ImageView facebookBtn;

    private long mLastClickTime_about = 0;
    private long mLastClickTime_how = 0;
    private long mLastClickTime_watch = 0;
    private long mLastClickTime_add = 0;
    private long mLastClickTime_face = 0;
    private long mLastClickTime_insta = 0;
    private long mLastClickTime_what = 0;
    private long mLastClickTime_mail = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aboutUsBtn = (Button) findViewById(R.id.aboutUsButton);
        addOfferBtn =(Button) findViewById(R.id.addOffer);
        howBtn = ( Button) findViewById(R.id.howItsWork) ;
        watchBtn = (Button) findViewById(R.id.watch);

        instaBtn = (TextView) findViewById(R.id.insta);
        emailBtn = (TextView) findViewById(R.id.mail) ;
        facebookBtn = (ImageView) findViewById(R.id.facebook);
        whatsupBtn =(TextView) findViewById(R.id.whatsupp);


        //about us page
        aboutUsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (SystemClock.elapsedRealtime() - mLastClickTime_about < 4000) {
                    return;
                }
                else {
                    mLastClickTime_about = SystemClock.elapsedRealtime();
                    openAboutUsPage();
                }


            }
        });


        // how it work page
        howBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (SystemClock.elapsedRealtime() - mLastClickTime_how< 4000) {
                    return;
                }
                else {
                    mLastClickTime_how = SystemClock.elapsedRealtime();
                    openHowPage();
                }
            }
        });

        // addOffer page
        addOfferBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mLastClickTime_add < 4000) {
                    return;
                }
                else {
                    mLastClickTime_add = SystemClock.elapsedRealtime();
                    openNewNote();
                }

            }
        });


        // watch offer page

        watchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (SystemClock.elapsedRealtime() - mLastClickTime_watch < 4000) {
                    return;
                }
                else {
                    mLastClickTime_watch = SystemClock.elapsedRealtime();
                    openListOfOfferPage();
                }


            }
        });

        // handle the line of social buttons
        {

            instaBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    if (SystemClock.elapsedRealtime() - mLastClickTime_insta < 4000) {
                        return;
                    }
                    else {
                        mLastClickTime_insta = SystemClock.elapsedRealtime();
                        Uri uri = Uri.parse("https://www.instagram.com/shelika_happiness/");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }



                /*
                String url = "https://api.whatsapp.com/send?phone="+ "+972 523480837";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);*/
                }
            });

            whatsupBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (SystemClock.elapsedRealtime() - mLastClickTime_what < 4000) {
                        return;
                    }
                    else {
                        mLastClickTime_what = SystemClock.elapsedRealtime();
                        String url = "https://api.whatsapp.com/send?phone=" + "+972 522796717";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                    }


                }
            });


            emailBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    if (SystemClock.elapsedRealtime() - mLastClickTime_mail < 4000) {
                        return;
                    }
                    else {
                        mLastClickTime_mail = SystemClock.elapsedRealtime();
                        Intent email = new Intent(Intent.ACTION_SENDTO);
                        email.setData(Uri.parse("mailto:meitalba4@gmail.com"));
                        email.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                        email.putExtra(Intent.EXTRA_TEXT, "My Email message");
                        startActivity(email);
                    }


                }
            });

            facebookBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {



                    if (SystemClock.elapsedRealtime() - mLastClickTime_face < 4000) {
                        return;
                    }
                    else {
                        mLastClickTime_face = SystemClock.elapsedRealtime();
                          Intent facebookIntenet = getOpenFacebookIntent(MainActivity.this);
                        startActivity(facebookIntenet);
                    }

                }
            });
        }
    }


    public static Intent getOpenFacebookIntent(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/100713978122151"));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/<שֶׁלִיקֶה - המרכז הישראלי לאושר וטוב לב>"));
        }
    }


    private void openNewNote() {
        Intent in = new Intent(this, new_Note_Activity.class);
        startActivity(in);
    }

    private void openHowPage() {
        Intent in = new Intent(this, How_it_work.class);
        startActivity(in);

    }

    private void openAboutUsPage() {
        Intent in = new Intent(this, About_us.class);
        startActivity(in);
    }

    private void openListOfOfferPage() {

        Intent in = new Intent(this, ListOfOffer_page.class);
        startActivity(in);
    }
}

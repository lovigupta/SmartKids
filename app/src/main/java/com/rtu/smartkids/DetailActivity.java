package com.rtu.smartkids;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class DetailActivity extends AppCompatActivity {
    String textarray[];
    String textarray1[];
    String textdescvals[];
    int images[];
    private TextToSpeech textToSpeech;
    String type;
    int count = 0;
    TextView msg, textdesc;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        setContentView(R.layout.activity_detail);
        type = getIntent().getExtras().getString("Type");
        msg = (TextView)findViewById(R.id.text);
        textdesc = (TextView)findViewById(R.id.textdesc);
        img = (ImageView)findViewById(R.id.img);
        Typeface custom_font;
        if(type.equals("E")){
            custom_font = Typeface.createFromAsset(getAssets(), "GoodUnicornRegular-Rxev.ttf");
            textarray = new String[]{"Aa","Bb","Cc","Dd","Ee","Ff","Gg","Hh","Ii","Jj","Kk","Ll","Mm","Nn","Oo",
                    "Pp","Qq","Rr","Ss","Tt","Uu","Vv","Ww","Xx","Yy","Zz" };
            textarray1 = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O",
                    "P","Q","R","S","T","U","V","W","X","Y","Z" };

            textdescvals = new String[]{"Apple","Banana","Cat","Dog","Elephant","Fish","Girl","Hut","Inkpot","Jug","Kite","Lion","Monkey",
                    "Nest","Orange", "Peacock","Queen","Rose","Ship","Tiger","Umbrella","Volcano","Well","X-mas tree","Yak","Zebra" };
            images = new int[]{R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,
                    R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j,R.drawable.k,
                    R.drawable.l,R.drawable.m,R.drawable.n,R.drawable.o,R.drawable.p,R.drawable.q,
                    R.drawable.r,R.drawable.s,R.drawable.t,R.drawable.u,R.drawable.v,R.drawable.w,
                    R.drawable.x,R.drawable.y,R.drawable.z};
        }
        else {
            textarray = new String[]{ "अ","आ","इ","ई","उ","ऊ","ए","ऐ","ऒ","औ","ऋ","अं","अः","क","ख","ग","घ",
                    "ङ","च","छ","ज","झ","ञ","ट","ठ","ड","ढ","ण","त","थ","द","ध","न","प","फ","ब","भ","म","य",
                    "र","ल","व","श","ष","स","ह","क्ष","त्र","ज्ञ","श्र" };
            textarray1 = new String[]{ "अ","आ","इ","ई","उ","ऊ","ए","ऐ","ऒ","औ","ऋ","अं","अः","क","ख","ग","घ",
                    "ङ","च","छ","ज","झ","ञ","ट","ठ","ड","ढ","ण","त","थ","द","ध","न","प","फ","ब","भ","म","य",
                    "र","ल","व","श","ष","स","ह","क्ष","त्र","ज्ञ","श्र" };

            textdescvals = new String[]{ "अनार","आम","इमली","ईनाम","उल्लू","ऊन","एड़ी","ऐनक","ओस","औरत","ऋतू","अंगूर","अः","कबूतर","खरगोश","गमला","घर",
                    "ङ खाली","चाय","छाता","जग","झंडा","ञ खाली","टमाटर","ठेला","डाकिया","ढक्कन","ण खाली","तरबूज","थलसेना","दवात","धन",
                    "नल","पतंग","फल","बकरी","भ","मछली","यमुना",
                    "रात","लड़की","वकील","शरीफा","षट्कोण","सपना","हरा", "क्षत्रिय","त्रिकोण","ज्ञान","श्रमिक" };
            custom_font = Typeface.createFromAsset(getAssets(), "Devnew.ttf");
            images = new int[]{R.drawable.a,R.drawable.b,R.drawable.b,R.drawable.b,R.drawable.b,
                    R.drawable.b,R.drawable.b,R.drawable.b,R.drawable.b,R.drawable.b,R.drawable.b,
                    R.drawable.b,R.drawable.b,R.drawable.b,R.drawable.b,R.drawable.b,R.drawable.b,
                    R.drawable.b,R.drawable.b,R.drawable.b,R.drawable.b,R.drawable.b,R.drawable.b,
                    R.drawable.b,R.drawable.b,R.drawable.b,R.drawable.b,R.drawable.b,R.drawable.b,R.drawable.b,
                    R.drawable.b,R.drawable.b,R.drawable.b,R.drawable.b,R.drawable.b,R.drawable.b,
                    R.drawable.b,R.drawable.b,R.drawable.b,R.drawable.b,R.drawable.b,R.drawable.b,R.drawable.b,
                    R.drawable.b,R.drawable.b,R.drawable.b,R.drawable.b,R.drawable.b,R.drawable.b,
                    R.drawable.b,R.drawable.b,R.drawable.b};
        }
        msg.setTypeface(custom_font);
        msg.setText(textarray[count]);
        textdesc.setTypeface(custom_font);
        textdesc.setText(textdescvals[count]);
        img.setImageResource(images[count]);
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int ttsLang = textToSpeech.setLanguage(Locale.US);

                    if (ttsLang == TextToSpeech.LANG_MISSING_DATA
                            || ttsLang == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "The Language is not supported!");
                    } else {
                        Log.i("TTS", "Language Supported.");
                    }
                    Log.i("TTS", "Initialization success.");
                } else {
                    Log.e("TTS", "TTS Initialization failed!");
                    Toast.makeText(getApplicationContext(), "TTS Initialization failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        img.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                String data = textarray1[count] + " For "+textdescvals[count];
                int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                if (speechStatus == TextToSpeech.ERROR) {
                    Log.e("TTS", "Error in converting Text to Speech!");
                }
            }
        });
    }

    public void prevClick(View v){
        if(count>0) {
            count--;
            msg.setText(textarray[count]);
            textdesc.setText(textdescvals[count]);
            img.setImageResource(images[count]);
        }
    }

    public void nextClick(View v){
        if(count < textarray.length-1) {
            count++;
            msg.setText(textarray[count]);
            textdesc.setText(textdescvals[count]);
            img.setImageResource(images[count]);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
    }

}
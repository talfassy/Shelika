package com.first.myapplicationtry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class How_it_work extends AppCompatActivity {

    private TextView part7;
    private TextView part8;
    private TextView rule_textView;
    private Button watchBotton;

    private long mLastClickTime_watch = 0;
    private long mLastClickTime_rule = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_it_work);

        part7 = findViewById(R.id.prat7_how);
        part8 = findViewById(R.id.prat8_how);
        rule_textView = findViewById(R.id.rules);
        watchBotton = findViewById(R.id.watch_btn_how);

        part7.setText("אנחנו מציגים לפניך רשימה דינמית של הצעות ( חלקם של משתמשי האפליקציה וחלקם שלנו).\n" +
                "הפעילויות ממוינות לפי סדר יורד כך שיהיה לך קל לבחור לדפדף ברשימה.\n" +
                "לכל פעילות יש כותרת שמגדירה אותה ויש הסבר שמציג בצורה כללית מה היא דורשת. בנוסף מופיע האזור שבו הפעילות מתבצעת וכמובן מספר הטלפון של אותו אדם שיזם או מפעיל את הפעילות. במידה ואתם רוצים לקחת חלק בפעילות זו פשוט מאוד שולחים הודעה או אפילו מתקשרים לאותו אדם בשביל פרטים נוספים וקידום התהליך.\n");

        part8.setText("במידה ואתם רוצים להוסיף הצעה חדשה לרשימה הדינמית שתהיה מוצגת לכלל המשתמשים באפליקציה כל מה שעליכם לעשות זה להיכנס לחלון \" הוספת הצעות חדשות\" למלא את הפרטים הנדרשים ( כותרת, מידע על הפעילות , אזור פעולה וטלפון) ולאשר את הוספת הפעילות.\n" +
                "שימו לב – ברגע שההצעה נוספה אין דרך לבצע שינוי או מחיקה ידנית ( רק באמצעות שיחה איתנו) ולכן יש לשים לב שהפרטים שאתם מעלים נכונים.\n");

        rule_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (SystemClock.elapsedRealtime() - mLastClickTime_rule < 4000) {
                    return;
                }
                else {
                    mLastClickTime_rule = SystemClock.elapsedRealtime();
                    openRulesPage();
                }

            }
        });


        watchBotton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mLastClickTime_rule < 4000) {
                    return;
                }
                else {
                    mLastClickTime_rule = SystemClock.elapsedRealtime();
                    openListOfOfeer();
                }

            }
        });
    }

    private void openListOfOfeer() {
        Intent in = new Intent(this, ListOfOffer_page.class);
        startActivity(in);
    }

    private void openRulesPage() {
        Intent in = new Intent(this, Rules.class);
        startActivity(in);
    }
}

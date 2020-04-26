package com.first.myapplicationtry;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.regex.Pattern;

public class new_Note_Activity extends AppCompatActivity {

    private EditText editText_title;
    private EditText editText_description;
    private EditText editText_address;
    private EditText editText_phone;
    private TextView textView_date;
    private Button saveBtn;
    private RadioButton radioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new__note_);

        editText_title = findViewById(R.id.add_title);
        editText_description = findViewById(R.id.add_description);
        editText_address = findViewById(R.id.add_address);
        editText_phone = findViewById(R.id.add_phone);
        textView_date = findViewById(R.id.add_date);
        saveBtn = findViewById(R.id.save);
        radioButton = findViewById(R.id.radioBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNewNote();
            }
        });

    }

    private void saveNewNote() {

        final String title = editText_title.getText().toString();
        final String description = editText_description.getText().toString();
        final String address = editText_address.getText().toString();
        final String phone = editText_phone.getText().toString();
        final String date ;


        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance().format(calendar.getTime());
       textView_date.setText(currentDate);
        date =  textView_date.getText().toString();

        if (title.trim().isEmpty() || description.trim().isEmpty() || phone.trim().isEmpty() || address.trim().isEmpty() ) {
            Toast.makeText(new_Note_Activity.this, "אחד מהפרטים חסר", Toast.LENGTH_SHORT).show();
            return;
        } // if is empty



     else{

            if (!(isValidPhoneNumber(phone))) {
                Toast.makeText(new_Note_Activity.this, "הזנת מספר לא תקין", Toast.LENGTH_SHORT).show();
                return;
            } // end if phone validation

            if (!(isValidAddress(address))) {
                Toast.makeText(new_Note_Activity.this, "הזנת אזור לא תקין", Toast.LENGTH_SHORT).show();
                return;
            } // end if address validation

            if (radioButton.isChecked()){

                AlertDialog.Builder builder = new AlertDialog.Builder(new_Note_Activity.this);
                builder.setTitle("העלת הצעה חדשה");
                builder.setMessage("האם אתה בטוח שאתה רוצה להעלות הצעה זו? ");
                builder.setPositiveButton("כן", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Toast.makeText(newNoteActivity.this, "yes yes yes", Toast.LENGTH_SHORT).show();
                        CollectionReference notebookRef = FirebaseFirestore.getInstance().collection("Notebook");
                        notebookRef.add(new Note(title,date, description, address, phone));
                        Toast.makeText(new_Note_Activity.this, "המודעה נוספה", Toast.LENGTH_SHORT).show();
                        finish(); // return to main page

                    }
                });

                builder.setNegativeButton("צפייה בתקנון", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //  Toast.makeText(newNoteActivity.this, "no no no", Toast.LENGTH_SHORT).show();
                        Intent in = new Intent(new_Note_Activity.this, Rules.class);
                        startActivity(in);
                    }
                });
                builder.show();




            }// end if radio button

            else{ // else radio button
                Toast.makeText(new_Note_Activity.this, "חייב לאשר פרסום פרטים אלו", Toast.LENGTH_SHORT).show();
            }// end else radio button


        } // else if is empty

    }



    //check the length of the phone number and force to include only numbers
    public static final boolean isValidPhoneNumber(CharSequence target) {
        if ((target.length()!=11) &&  (!Pattern.matches("[a-zA-Z]+", target))) {
            return false;
        } else {
            return android.util.Patterns.PHONE.matcher(target).matches();
        }
    }
    //check the validation of the address
    public boolean isValidAddress (String add){

        if( add.trim().equals("צפון") || add.trim().equals("דרום") || add.trim().equals("מרכז") ||
                add.trim().equals("חיפה") || add.trim().equals("ירושלים")  || add.trim().equals("אילת") || add.trim().equals("f"))
            return true;
        else
            return false;
    }

}

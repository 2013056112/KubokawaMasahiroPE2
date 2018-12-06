package masahiro.kubokawa.com.kubokawamasahirope2;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class KubokawaMasahiroPE2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kubokawa_masahiro_pe2);

        SQLiteDatabase mydatabase = openOrCreateDatabase("personinfo",MODE_PRIVATE,null);
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS PersonTable(FullName VARCHAR, Age INTEGER, Gender VARCHAR)");
    }

    public void addRecord(View v){
        EditText Fname = findViewById(R.id.NAMEINPUT);
        EditText Age1 = findViewById(R.id.AGEINPUT);
        EditText Gender1 = findViewById(R.id.GENDERINPUT);

        String EFname = Fname.getText().toString();
        String EAge1 = Age1.getText().toString();
        String EGender1 = Gender1.getText().toString();


    }


}

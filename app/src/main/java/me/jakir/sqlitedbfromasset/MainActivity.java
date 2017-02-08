package me.jakir.sqlitedbfromasset;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MyDatabase myDB;
    TextView tvData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvData = (TextView) findViewById(R.id.tvData);
        myDB = new MyDatabase(this);

        Cursor res = myDB.getAllData();

        if(res.getCount() == 0){
            Toast.makeText(MainActivity.this, "No data found", Toast.LENGTH_LONG).show();
            return;
        }else {
            StringBuffer buffer = new StringBuffer();

            while (res.moveToNext()){
                buffer.append("Id: " + res.getString(0) + " - ");
                buffer.append("Name: " + res.getString(1) + "\n");
            }

            tvData.setText(buffer.toString());
        }
    }

}

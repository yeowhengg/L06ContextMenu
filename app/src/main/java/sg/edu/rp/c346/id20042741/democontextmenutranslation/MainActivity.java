package sg.edu.rp.c346.id20042741.democontextmenutranslation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvTranslatedText;
    TextView tvTranslatedText2;
    String wordClicked = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTranslatedText = findViewById(R.id.textViewTranslatedText);
        tvTranslatedText2 = findViewById(R.id.textViewTranslatedText2);
        registerForContextMenu(tvTranslatedText);
        registerForContextMenu(tvTranslatedText2);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        menu.add(0,0,0,"English");
        menu.add(0,1,1,"Italian");

        if (v == tvTranslatedText) {
            wordClicked = "Hello";

        }
        else if (v == tvTranslatedText2){
            wordClicked = "Bye";
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item){

        if(wordClicked.equalsIgnoreCase("Hello")){
            if (item.getItemId() == 0) {
                Toast.makeText(MainActivity.this, "English is chosen",Toast.LENGTH_SHORT).show();
                tvTranslatedText.setText("Hello");
                return true;
            }

            else if (item.getItemId() == 1){
                Toast.makeText(MainActivity.this, "Italian is chosen", Toast.LENGTH_SHORT).show();
                tvTranslatedText.setText("Ciao");
                return true;
            }
        }
        else{
            if (item.getItemId() == 0) {
                tvTranslatedText2.setText("Ciao");
                return true;
            }

            else if (item.getItemId() == 1){
                tvTranslatedText2.setText("Adios");
                return true;
            }
        }



        return super.onContextItemSelected(item);
    }
}
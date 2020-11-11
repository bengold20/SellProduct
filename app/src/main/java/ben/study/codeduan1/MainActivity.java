package ben.study.codeduan1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"bền mặt lisosfu " , Toast.LENGTH_LONG).show();


        Toast.makeText(this,"bền mặt lờ" , Toast.LENGTH_LONG).show();

        Toast.makeText(this,"ninh đb" , Toast.LENGTH_LONG).show();


        Toast.makeText(this,"mẹt áuhsauif" , Toast.LENGTH_LONG).show();
    }
}
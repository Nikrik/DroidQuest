package krikun.rksi.droidquest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Deceit extends AppCompatActivity {
    private Button Nikita;
    private TextView question;
    private static String rksi="RU.RKSI.ANDROID.ANSWER_IS_TRUE";
    public static Intent NewIntent(Context packageContent, Boolean answerIsTrue)
    {
        Intent ha=new Intent(packageContent,Deceit.class);
        ha.putExtra(rksi,answerIsTrue);
        return ha;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deceit);
        question=(TextView)findViewById(R.id.textView2);
        Nikita=(Button)findViewById(R.id.button);
        Nikita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getIntent().getBooleanExtra(rksi,false))
                {
                    question.setText(R.string.Yes);
                }
                else
                {
                    question.setText(R.string.No);
                }
                Toast.makeText(Deceit.this, R.string.cant_be_fooled,Toast.LENGTH_SHORT).show();
            }
        });
    }
}

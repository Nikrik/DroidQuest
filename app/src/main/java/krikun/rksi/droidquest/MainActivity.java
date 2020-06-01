package krikun.rksi.droidquest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    private static String TAG ="MainActivity";
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mDeceiveButton;
    private ImageButton mNextButton;
    private  ImageButton mPreviousButton;
    private TextView QuestionTextView;
    private String KEY_INDEX="index";
    int i=0;
    private Questions[] questions =new Questions[]
            {
                    new Questions(R.string.quests0,true),
                    new Questions(R.string.quests1,true),
                    new Questions(R.string.quests2,true),
                    new Questions(R.string.quests3,true),
                    new Questions(R.string.quests4,false),
                    new Questions(R.string.quests5,true),
                    new Questions(R.string.quests6,true),
                    new Questions(R.string.quests7,true),
                    new Questions(R.string.quests8,false),
                    new Questions(R.string.quests9,true),
            };

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart вызван");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart вызван");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy вызван");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause вызван");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume вызван");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop вызван");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        Log.i(TAG,"onSaveInstanceState");
        outState.putInt(KEY_INDEX,i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        if (savedInstanceState!=null)
        {
            i=savedInstanceState.getInt(KEY_INDEX,0);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTrueButton=(Button) findViewById(R.id.true_button);
        mFalseButton=(Button) findViewById(R.id.false_button);
        mNextButton =(ImageButton) findViewById(R.id.next_button);
        QuestionTextView=(TextView)findViewById(R.id.question_text_view);
        mPreviousButton=(ImageButton)findViewById(R.id.prev_button);
        QuestionTextView.setText(questions[i].getTextResId());

        mDeceiveButton=(Button) findViewById((R.id.deceive));
        mDeceiveButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Toast.makeText(MainActivity.this,"hello",Toast.LENGTH_SHORT).show();
                Intent intent=Deceit.NewIntent(MainActivity.this,questions[i].ismAnswerTrue());
                startActivity(intent);
            }
        });
        mPreviousButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (0<i)
                {
                    i--;
                    QuestionTextView.setText(questions[i].getTextResId());
                }
            }
        }));
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this,R.string.app_name,Toast.LENGTH_SHORT).show();
                if (questions.length>i+1)
                {
                    i++;
                    QuestionTextView.setText(questions[i].getTextResId());
                }
                else
                {
                    QuestionTextView.setText(R.string.Questions_end);
                }
            }
        });

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if (questions[i].ismAnswerTrue()==true)
                {
                    Toast.makeText(MainActivity.this,R.string.toast_true,Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, R.string.toast_false, Toast.LENGTH_SHORT).show();
                }
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questions[i].ismAnswerTrue()==false)
                {
                    Toast.makeText(MainActivity.this,R.string.toast_true,Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, R.string.toast_false, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

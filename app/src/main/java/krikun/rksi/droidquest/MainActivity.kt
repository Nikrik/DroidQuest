package krikun.rksi.droidquest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import krikun.rksi.droidquest.Deceit.Companion.NewIntent
import krikun.rksi.droidquest.MainActivity

class MainActivity : AppCompatActivity() {
    private var mTrueButton: Button? = null
    private var mFalseButton: Button? = null
    private var mDeceiveButton: Button? = null
    private var mNextButton: ImageButton? = null
    private var mPreviousButton: ImageButton? = null
    private var QuestionTextView: TextView? = null
    private val KEY_INDEX = "index"
    private var ispressed = booleanArrayOf(false, false, false, false, false, false, false, false, false, false)

    var i = 0
    private val questions = arrayOf(
            Questions(R.string.quests0, true),
            Questions(R.string.quests1, true),
            Questions(R.string.quests2, true),
            Questions(R.string.quests3, true),
            Questions(R.string.quests4, false),
            Questions(R.string.quests5, true),
            Questions(R.string.quests6, true),
            Questions(R.string.quests7, true),
            Questions(R.string.quests8, false),
            Questions(R.string.quests9, true))

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart вызван")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart вызван")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy вызван")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause вызван")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK && data != null) {
            ispressed[i] = data.getBooleanExtra("ispressed", false)
        }
        return
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume вызван")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop вызван")
    }

    public override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i(TAG, "onSaveInstanceState вызван")
        outState.putInt(KEY_INDEX, i)
        outState.putBooleanArray("ispressed",ispressed)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            i = savedInstanceState.getInt(KEY_INDEX, 0)
            ispressed= savedInstanceState.getBooleanArray("ispressed")!!
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mTrueButton = findViewById<View>(R.id.true_button) as Button
        mFalseButton = findViewById<View>(R.id.false_button) as Button
        mNextButton = findViewById<View>(R.id.next_button) as ImageButton
        QuestionTextView = findViewById<View>(R.id.question_text_view) as TextView
        mPreviousButton = findViewById<View>(R.id.prev_button) as ImageButton
        QuestionTextView!!.setText(questions[i].textResId)
        mDeceiveButton = findViewById<View>(R.id.deceive) as Button
        mDeceiveButton!!.setOnClickListener { //Toast.makeText(MainActivity.this,"hello",Toast.LENGTH_SHORT).show();
            val intent = NewIntent(this@MainActivity, questions[i].ismAnswerTrue())
            startActivityForResult(intent, 1)
        }
        mPreviousButton!!.setOnClickListener {
            if (0 < i) {
                i--
                QuestionTextView!!.setText(questions[i].textResId)
            }
        }
        mNextButton!!.setOnClickListener { //Toast.makeText(MainActivity.this,R.string.app_name,Toast.LENGTH_SHORT).show();
            if (questions.size > i + 1) {
                i++
                QuestionTextView!!.setText(questions[i].textResId)
            } else {
                QuestionTextView!!.setText(R.string.Questions_end)
            }
        }
        mTrueButton!!.setOnClickListener {
            if (ispressed[i]) {
                Toast.makeText(this@MainActivity, R.string.cant_be_fooled, Toast.LENGTH_SHORT).show()
            } else if (questions[i].ismAnswerTrue()) {
                Toast.makeText(this@MainActivity, R.string.toast_true, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@MainActivity, R.string.toast_false, Toast.LENGTH_SHORT).show()
            }
        }
        mFalseButton!!.setOnClickListener {
            if (ispressed[i]) {
                Toast.makeText(this@MainActivity, R.string.cant_be_fooled, Toast.LENGTH_SHORT).show()
            } else if (questions[i].ismAnswerTrue()) {
                Toast.makeText(this@MainActivity, R.string.toast_true, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@MainActivity, R.string.toast_false, Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}
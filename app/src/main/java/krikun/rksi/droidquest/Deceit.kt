package krikun.rksi.droidquest

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Deceit : AppCompatActivity() {
    private var Nikita: Button? = null
    private var question: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deceit)
        question = findViewById<View>(R.id.textView2) as TextView
        Nikita = findViewById<View>(R.id.button) as Button
        Nikita!!.setOnClickListener {
            setResult(Activity.RESULT_OK, Intent().putExtra("ispressed", true))
            if (intent.getBooleanExtra(rksi, false)) {
                question!!.setText(R.string.Yes)
            } else {
                question!!.setText(R.string.No)
            }

            //Toast.makeText(Deceit.this, R.string.cant_be_fooled,Toast.LENGTH_SHORT).show();
        }
    }

    companion object {
        private const val rksi = "RU.RKSI.ANDROID.ANSWER_IS_TRUE"
        @JvmStatic
        fun NewIntent(packageContent: Context?, answerIsTrue: Boolean?): Intent {
            val ha = Intent(packageContent, Deceit::class.java)
            ha.putExtra(rksi, answerIsTrue)
            return ha
        }
    }
}
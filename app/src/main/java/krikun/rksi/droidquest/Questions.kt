package krikun.rksi.droidquest

class Questions(val textResId: Int, private val mAnswerTrue: Boolean) {

    fun ismAnswerTrue(): Boolean {
        return mAnswerTrue
    }

}
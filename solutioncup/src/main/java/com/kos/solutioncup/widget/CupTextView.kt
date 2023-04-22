package com.kos.solutioncup.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView

open class CupTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : TextView(context, attrs) {

    init {
        ellipsize = android.text.TextUtils.TruncateAt.END
        maxLines = 1
    }
}
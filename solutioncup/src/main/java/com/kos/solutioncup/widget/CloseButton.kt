package com.kos.solutioncup.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import com.kos.solutioncup.R
import com.kos.solutioncup.utils.px

class CloseButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ImageView(context, attrs) {

    init {
        setBackgroundResource(R.drawable.close_bg)
        setImageResource(R.drawable.ic_cup_close)
        setPadding(px(R.dimen.closePadding),
            px(R.dimen.closePadding),
            px(R.dimen.closePadding),
            px(R.dimen.closePadding))
    }
}
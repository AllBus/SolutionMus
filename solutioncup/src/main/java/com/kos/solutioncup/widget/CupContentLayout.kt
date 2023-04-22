package com.kos.solutioncup.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.core.view.updatePadding
import com.kos.solutioncup.utils.ResourceManager
import com.kos.solutioncup.utils.px

class CupContentLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    private var contentData: List<CupContentData> = emptyList()
    private var currentOrientation = ContentOrientation.HORIZONTAL

    init {

        setContentOrientation(ContentOrientation.VERTICAL)
    }

    fun setContentOrientation(orientation: ContentOrientation) {
        if (orientation == currentOrientation)
            return

        currentOrientation = orientation
        when (orientation) {
            ContentOrientation.HORIZONTAL -> {
                this.orientation = HORIZONTAL
                updatePadding(
                    px(ResourceManager.CELL_HORIZONTAL_OFFSET), 0,
                    px(ResourceManager.CELL_HORIZONTAL_OFFSET), 0
                )
                invalidateList()
            }
            ContentOrientation.VERTICAL -> {
                this.orientation = VERTICAL
                updatePadding(
                    0, 0,
                    0, px(ResourceManager.CELL_VERTICAL_PADDING)
                )
                invalidateList()
            }
        }
    }

    fun setContent(list: List<CupContentData>) {
        if (list != contentData) {
            contentData = list
            invalidateList()
        }
    }

    private fun invalidateList() {
        removeAllViews()
        contentData.map { data ->
            val item = CupContentItem(this.context, null)
            item.setData(data)
            item
        }.forEach { item ->
            addView(item)
            item.setOrientation(currentOrientation)
        }
    }

}
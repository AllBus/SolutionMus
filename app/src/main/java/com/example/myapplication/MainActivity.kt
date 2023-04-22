package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import com.kos.solutioncup.utils.margin
import com.kos.solutioncup.utils.matchParent_WrapContent
import com.kos.solutioncup.widget.CupCell
import com.kos.solutioncup.widget.CupHeader
import com.kos.solutioncup.widget.CupStyle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val linearLayout = findViewById<LinearLayout>(R.id.testLayout)

        linearLayout.apply {
            val ctx = this.context
            val attrs = null

            listOf(
                CupHeader(ctx,attrs).apply{
                    setTitle("Header")

                    setButton("Edit")
                    setButtonListener({ v -> Toast.makeText(ctx, "Button click", Toast.LENGTH_SHORT).show()})
                    setEditButton("Edit")
                    setEditButtonListener({ v -> Toast.makeText(ctx, "EditButton click", Toast.LENGTH_SHORT).show()})


                    setStyle(CupStyle.NORMAL)
                },
                CupHeader(ctx,attrs).apply{
                    setTitle("Header")
                    setDescription("Description")
                    setButton("Edit")
                    setButtonListener({ v -> Toast.makeText(ctx, "Button click", Toast.LENGTH_SHORT).show()})
                    setStyle(CupStyle.NORMAL)
                },
                CupHeader(ctx,attrs).apply{
                    setTitle("Header")

                    setEditButton("Edit")
                    setEditButtonListener({ v -> Toast.makeText(ctx, "EditButton click", Toast.LENGTH_SHORT).show()})
                    setStyle(CupStyle.FLAT)
                },
                CupHeader(ctx, attrs).apply{

                setTitle("Header")
                setDescription("Description")
                setImage(getDrawable(R.drawable.tui_avatar))
                setStyle(CupStyle.NORMAL)
            },
           CupCell(ctx,attrs).apply{

                setTitle("Title")
                setDescription("Description")
                setImage(getDrawable(R.drawable.tui_avatar))
                setStyle(CupStyle.NORMAL)
            },CupCell(ctx,attrs).apply{

                setTitle("Title")
                setDescription("Description")
                setImage(getDrawable(R.drawable.tui_avatar))
                setStyle(CupStyle.FLAT)
            }
            ).forEach{ item ->
                this.addView(item)
                item.matchParent_WrapContent()
                item.margin(com.kos.solutioncup.R.dimen.cellPadding)
            }
        }

    }
}
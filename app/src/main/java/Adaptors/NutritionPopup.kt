package Adaptors

import android.app.Dialog
import android.content.Context
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.ProiectSI.R
import androidx.core.graphics.drawable.toDrawable

class NutritionPopupDialog(
    context: Context,
    private val nutritionInfo: String
) : Dialog(context) {

    init {
        // Set transparent background
        window?.setBackgroundDrawable(context.getColor(R.color.transparent).toDrawable())
        setContentView(R.layout.dialog_nutrition)

        // Set dialog size (90% width, wrap height)
        window?.setLayout(
            (context.resources.displayMetrics.widthPixels * 0.9).toInt(),
            WindowManager.LayoutParams.WRAP_CONTENT
        )

        // Set click listeners
        findViewById<TextView>(R.id.tv_nutrition_info).text = nutritionInfo
        findViewById<ImageView>(R.id.btn_close).setOnClickListener { dismiss() }

        // Make dialog cancelable when touching outside
        setCanceledOnTouchOutside(true)
    }
}
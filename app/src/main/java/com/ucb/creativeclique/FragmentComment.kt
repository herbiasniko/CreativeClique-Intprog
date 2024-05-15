package com.ucb.creativeclique

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class FragmentComment : BottomSheetDialogFragment() {
    private var lastX: Int = 0
    private var lastY: Int = 0
    private lateinit var editText: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_comment, container, false)
        dialog?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        editText = view.findViewById(R.id.editText)
        setUpResizeListeners(view)
        return view
    }

    override fun onStart() {
        super.onStart()
        val bottomSheet = dialog?.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
        val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet as View)

        // Ensure the bottom sheet starts expanded
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED

        // Set minimum height to ensure the layout is not too small
        bottomSheet.layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT

        // Ensure the bottom sheet expands when the EditText gains focus
        editText.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            }
        }

        // Expand bottom sheet when EditText is clicked
        editText.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }
    }

    private fun setUpResizeListeners(view: View) {
        view.setOnTouchListener { _, event ->
            val x = event.rawX.toInt()
            val y = event.rawY.toInt()
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    lastX = x
                    lastY = y
                }
                MotionEvent.ACTION_MOVE -> {
                    val deltaX = x - lastX
                    val deltaY = y - lastY
                    val layoutParams = view.layoutParams
                    layoutParams.width += deltaX
                    layoutParams.height += deltaY
                    view.layoutParams = layoutParams
                }
            }
            lastX = x
            lastY = y
            true
        }
    }

    override fun getTheme(): Int {
        return R.style.FullScreenDialog
    }
}

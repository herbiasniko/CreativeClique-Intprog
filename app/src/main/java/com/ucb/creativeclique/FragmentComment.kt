package com.ucb.creativeclique

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class FragmentComment : BottomSheetDialogFragment() {
    private lateinit var editText: EditText
    private lateinit var commentAdapter: CommentAdapter
    private lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_comment, container, false)
        dialog?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        editText = view.findViewById(R.id.editText)
        var commentAdd: ImageButton = view.findViewById(R.id.commentAdd)

        recyclerView = view.findViewById<RecyclerView>(R.id.list_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        var item = ArrayList<CommentItem>()
        item.add(CommentItem(R.drawable.profile_pic, "Ramon Alejandro", "chuya ba ana oy"))
        item.add(CommentItem(R.drawable.profile_pic, "Ramon Alejandro", "chuya ba a asd sfdsfoy"))
        item.add(CommentItem(R.drawable.profile_pic, "Ramon Alejandro", "chuya ba a asd sfdsfoy"))


        commentAdapter = CommentAdapter(item)
        recyclerView.adapter = commentAdapter

        commentAdd.setOnClickListener{
            val comment = editText.text.toString()
            val newItem = CommentItem(R.drawable.profile_pic, "Ramon Alejandro", comment)
            item.add(newItem)
            commentAdapter.notifyDataSetChanged()
         }
        return view


    }

    override fun onStart() {
        super.onStart()
        val bottomSheet = dialog?.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
        val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet as View)

        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        bottomSheet.layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT

        editText.post {
            editText.requestFocus()
            val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT)
        }
    }
}

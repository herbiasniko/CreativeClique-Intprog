package com.ucb.creativeclique

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentPrivateMessage: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_private_message, container, false)
        val backBtn: ImageButton = view.findViewById(R.id.back_btn)

        val messages = listOf(
            PrivateMessageSealed.SenderMessage("Bai, pasar kas INTPROG?"),
            PrivateMessageSealed.ReceiverMessage("Nah, ambot lang pud ani bai murag hagbong man"),
            PrivateMessageSealed.SenderMessage("Same:))"),
            PrivateMessageSealed.ReceiverMessage("Mayntag malooy si Sir Joem nato, papasaron ta"),
            PrivateMessageSealed.SenderMessage("Lage bai, maynta jud oy")
        )

        val recyclerView: RecyclerView = view.findViewById(R.id.messageRecyclerView)
        val adapter = PrivateMessageAdapter(messages)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        backBtn.setOnClickListener {
            (activity as MainActivity).showBottomNavigationBar()
            requireActivity().supportFragmentManager.popBackStack()
        }

        return view
    }

    fun handleBackPressed() {
        requireActivity().supportFragmentManager.popBackStack()
    }
}
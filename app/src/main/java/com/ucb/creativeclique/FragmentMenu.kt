package com.ucb.creativeclique

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment

class FragmentMenu: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_menu, container, false)
        var ArrowBack: ImageButton = view.findViewById(R.id.ArrowBack)

        //ayaw lng ni tangtanga kay mao ni code para mo balik sa previous fragment
        //ang layout ug ang image lng ang ilisi adtos xml
        ArrowBack.setOnClickListener {

            (activity as MainActivity).showBottomNavigationBar()
            requireActivity().supportFragmentManager.popBackStack()
        }

        return view

    }
     fun handleBackPressed() {
        requireActivity().supportFragmentManager.popBackStack()
    }


}
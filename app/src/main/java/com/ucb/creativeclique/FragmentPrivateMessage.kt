package com.ucb.creativeclique

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment

class FragmentPrivateMessage: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view =  inflater.inflate(R.layout.fragment_private_message, container, false)
        var sampleArrowBack: ImageButton = view.findViewById(R.id.sampleArrowBack)
        sampleArrowBack.setOnClickListener {

            //ayaw lng ni tangtanga code ni para mo balik sa message fragment
            //ilisi lng ang layout ug asa ibutang ang arrow back
            (activity as MainActivity).showBottomNavigationBar()
            requireActivity().supportFragmentManager.popBackStack()
        }

        return view
    }
    fun handleBackPressed() {

        requireActivity().supportFragmentManager.popBackStack()
    }
}
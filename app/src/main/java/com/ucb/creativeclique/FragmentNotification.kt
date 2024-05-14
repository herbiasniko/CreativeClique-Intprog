package com.ucb.creativeclique

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentNotification: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       var view =  inflater.inflate(R.layout.fragment_notification, container, false)

        //ayaw lng ni tangtanga ibutang lng imong code babaw ani nga line
        (activity as MainActivity).showBottomNavigationBar()
        requireActivity().supportFragmentManager.popBackStack()

        return view
    }

}
package com.ucb.creativeclique

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment

class FragmentProfile: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_profile, container, false)
        var menuButton: ImageButton = view.findViewById(R.id.menuButton)

        //mao nani ang code para ig pislit sa menu mo adto sa menu nga fragment
        //ilisi lng sa layout ug unsa ang image sa menu
        menuButton.setOnClickListener {
             val fragmentMenu = FragmentMenu()

            (activity as MainActivity).showBottomNavigationBar()
             requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragmentMenu)
                .addToBackStack(null)
                .commit()
        }
        (activity as MainActivity).showBottomNavigationBar()
        requireActivity().supportFragmentManager.popBackStack()

      
        return view;
    }

}
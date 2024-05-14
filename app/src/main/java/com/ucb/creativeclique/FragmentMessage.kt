package com.ucb.creativeclique

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentMessage: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         var view = inflater.inflate(R.layout.fragment_message, container, false)

        // sample rani siya para mo adto sa private message nga screen once pisliton ang item sulod sa recycler
        //mostly approach ani is sa adapter nimo i code
        var buttonSample: Button = view.findViewById(R.id.buttonSample)
        buttonSample.setOnClickListener {
            val privateMessageFragment = FragmentPrivateMessage()

            (activity as MainActivity).hideBottomNavigationBar()

            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, privateMessageFragment)
                .addToBackStack(null)
                .commit()
        }
        (activity as MainActivity).showBottomNavigationBar()
        requireActivity().supportFragmentManager.popBackStack()


        return view
    }
}
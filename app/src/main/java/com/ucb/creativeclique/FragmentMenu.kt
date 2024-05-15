package com.ucb.creativeclique

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

import com.ucb.creativeclique.MainActivity
import com.ucb.creativeclique.R


class FragmentMenu : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_menu, container, false)
        (activity as MainActivity).showBottomNavigationBar()
        requireActivity().supportFragmentManager.popBackStack()

        val builder = AlertDialog.Builder(requireActivity())
        val inflater = requireActivity().layoutInflater

        val btnBack = view.findViewById<ImageButton>(R.id.btnBackToMain)
        // Find buttons
        val btnProfileSettings = view.findViewById<ImageButton>(R.id.btnProfileSettings)
        val btnSettings = view.findViewById<ImageButton>(R.id.btnSettings)
        val btnSubs = view.findViewById<ImageButton>(R.id.btnSubs)
        //val btnHome = view.findViewById<Button>(R.id.btnHome)
        val btnLogButt = view.findViewById<ImageButton>(R.id.btnLogButt)

        btnBack.setOnClickListener {
            // Dismiss the dialog
            dismiss()
        }

        // Set click listeners
        btnProfileSettings.setOnClickListener {
            val intent = Intent(activity, ProfileSettings::class.java)
            startActivity(intent)
        }

        btnSettings.setOnClickListener {
            val intent = Intent(activity, Settings::class.java)
            startActivity(intent)
        }

        btnSubs.setOnClickListener {
            val intent = Intent(activity, Subscription::class.java)
            startActivity(intent)
        }

        btnLogButt.setOnClickListener {
            val intent = Intent(activity, Signin::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            dismiss()
        }
        builder.setView(view)

        return view
    }

}

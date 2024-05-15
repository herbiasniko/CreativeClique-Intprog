package com.ucb.creativeclique

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentNotification: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       var view =  inflater.inflate(R.layout.fragment_notification, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.notificationRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        var notificationButton: ImageButton = view.findViewById(R.id.notificationButton)

        val notifications = listOf(
            NotificationItem.Header("Recent"),
            NotificationItem.Notification(R.drawable.profile_pic, "Niko Herbias and 298 others followed you, follow them back"),
            NotificationItem.Notification(R.drawable.profile_pic, "Niko Herbias and 298 others followed you, follow them back"),
            NotificationItem.Notification(R.drawable.profile_pic, "Niko Herbias and 298 others followed you, follow them back"),
            NotificationItem.Header("Last 7 days"),
            NotificationItem.Notification(R.drawable.profile_pic, "Niko Herbias and 298 others followed you, follow them back"),
            NotificationItem.Notification(R.drawable.profile_pic, "Niko Herbias and 298 others followed you, follow them back"),
            NotificationItem.Notification(R.drawable.profile_pic, "Niko Herbias and 298 others followed you, follow them back"),
            NotificationItem.Header("Last 30 days"),
            NotificationItem.Notification(R.drawable.profile_pic, "Niko Herbias and 298 others followed you, follow them back"),
            NotificationItem.Notification(R.drawable.profile_pic, "Niko Herbias and 298 others followed you, follow them back"),
            NotificationItem.Notification(R.drawable.profile_pic, "Niko Herbias and 298 others followed you, follow them back")

        )

        val adapter = NotificationAdapter(notifications)
        recyclerView.adapter = adapter
        //ayaw lng ni tangtanga ibutang lng imong code babaw ani nga line
        notificationButton.setOnClickListener {
            var backFragment = FragmentFeed()

            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, backFragment)
                .commit()
        }
        (activity as MainActivity).showBottomNavigationBar()
        requireActivity().supportFragmentManager.popBackStack()

        return view
    }

}
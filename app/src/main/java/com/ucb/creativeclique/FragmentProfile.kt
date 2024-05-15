package com.ucb.creativeclique

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment


class FragmentProfile : Fragment() {

    private lateinit var nameTextView: TextView
    private lateinit var followButton: Button
    private lateinit var messageButton: Button
    private lateinit var imageOne: ImageView
    private lateinit var imageTwo: ImageView
    private lateinit var imageThree: ImageView
    private lateinit var imageFour: ImageView
    private lateinit var imageFive: ImageView
    private lateinit var imageLong: ImageView
    private var isFollowing = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        nameTextView = view.findViewById(R.id.txtname)
        followButton = view.findViewById(R.id.followBUTTON)
        messageButton = view.findViewById(R.id.messageBUTTON)
        imageOne = view.findViewById(R.id.imageone)
        imageTwo = view.findViewById(R.id.imagetwo)
        imageThree = view.findViewById(R.id.imagethree)
        imageFour = view.findViewById(R.id.imageFour)
        imageFive = view.findViewById(R.id.imageFive)
        imageLong = view.findViewById(R.id.imagelong)

        followButton.setOnClickListener {
            isFollowing = !isFollowing // Toggle the following state

            if (isFollowing) {
                followButton.text = "Following"
                val message = "You are now following ${nameTextView.text}"
                Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
            } else {
                followButton.text = "Follow"
                Toast.makeText(requireContext(), "You unfollowed ${nameTextView.text}", Toast.LENGTH_SHORT).show()
            }
        }
    //menu button ni diri
        val btnShowMenu = view.findViewById<ImageButton>(R.id.btnShowMenu)
        btnShowMenu.setOnClickListener {
            val dialogFragment = FragmentMenu()
            dialogFragment.show(childFragmentManager, "menu_dialog")
        }

        messageButton.setOnClickListener {
            val intent = Intent(requireContext(), FragmentPrivateMessage::class.java)
            startActivity(intent)
        }

        setImageClickListener(imageOne, R.drawable.imageone)
        setImageClickListener(imageTwo, R.drawable.imagethree)
        setImageClickListener(imageThree, R.drawable.imagetwo)
        setImageClickListener(imageFour, R.drawable.imagefive)
        setImageClickListener(imageFive, R.drawable.imagefour)
        setImageClickListener(imageLong, R.drawable.landscape)

        return view
    }

    private fun setImageClickListener(imageView: ImageView, drawableRes: Int) {
        imageView.setOnClickListener {
            showImageDialog(requireContext(), drawableRes)
        }
    }

    private fun showImageDialog(context: Context, drawableRes: Int) {
        val dialog = Dialog(context)
        dialog.setContentView(R.layout.dialog_image_view)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        val imageView = dialog.findViewById<ImageView>(R.id.imageView)
        imageView.setImageResource(drawableRes)

        dialog.show()
    }
}
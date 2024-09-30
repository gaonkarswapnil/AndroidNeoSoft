package com.example.finalapplication.data.fragment2activity

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.finalapplication.R
import com.example.finalapplication.databinding.ActivityDataRecievingBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DataSendingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DataSendingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_data_sending, container, false)


        val btn = view.findViewById<Button>(R.id.btnFragmentDataSend)

        val myInterface: MyInterface = activity as MyInterface

        btn.setOnClickListener {
            val msg = view.findViewById<EditText>(R.id.etEditText).text.toString()
            myInterface.transferredMsg(msg)
        }

        return view;
    }
}
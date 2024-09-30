package com.example.finalapplication.data.fragment2fragment

import android.os.Bundle
import android.provider.ContactsContract.RawContacts.Data
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.finalapplication.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DataSendFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DataSendFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_data_send, container, false)

        val DataRevieveFragment = DataRevieveFragment()
        view.findViewById<Button>(R.id.btnMsgSend).setOnClickListener {
            val msg = view.findViewById<EditText>(R.id.etMsg).text.toString()
            val bundle = Bundle().apply {
                putString("EXTRA_MSG", msg)
            }

            DataRevieveFragment.arguments = bundle

            parentFragmentManager.beginTransaction().apply {
                replace(R.id.flFragmentDataSendingRecieving, DataRevieveFragment)
                addToBackStack(null)
                commit()
            }
        }

        return view
    }

}
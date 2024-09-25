package com.example.finalapplication.fragmentlifecycle

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.finalapplication.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondLifeCycleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondLifeCycleFragment : Fragment(R.layout.fragment_second_life_cycle) {
    // TODO: Rename and change types of parameters
//    private var param1: String? = null
//    private var param2: String? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Toast.makeText(requireContext(), "Second Fragment onAttach() state", Toast.LENGTH_SHORT).show()
        Log.d("FragmentLifeCycle","Second Fragment onAttach() state")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(requireContext(), "Second Fragment onCreate() state", Toast.LENGTH_SHORT).show()
        Log.d("FragmentLifeCycle","Second Fragment onCreate() state")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Toast.makeText(requireContext(), "Second Fragment onCreateView() state", Toast.LENGTH_SHORT).show()
        Log.d("FragmentLifeCycle","Second Fragment onCreateView() state")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(requireContext(), "Second Fragment onViewCreated() state", Toast.LENGTH_SHORT).show()
        Log.d("FragmentLifeCycle","Second Fragment onViewCreated() state")
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(requireContext(), "Second Fragment onStart() state", Toast.LENGTH_SHORT).show()
        Log.d("FragmentLifeCycle","Second Fragment onStart() state")
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(requireContext(), "Second Fragment onResume() state", Toast.LENGTH_SHORT).show()
        Log.d("FragmentLifeCycle","Second Fragment onResume() state")
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(requireContext(), "Second Fragment onPause() state", Toast.LENGTH_SHORT).show()
        Log.d("FragmentLifeCycle","Second Fragment onPause() state")
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(requireContext(), "Second Fragment onStop() state", Toast.LENGTH_SHORT).show()
        Log.d("FragmentLifeCycle","Second Fragment onStop() state")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Toast.makeText(requireContext(), "Second Fragment onDestroyView() state", Toast.LENGTH_SHORT).show()
        Log.d("FragmentLifeCycle","Second Fragment onDestroyView() state")
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(requireContext(), "Second Fragment onDestroy() state", Toast.LENGTH_SHORT).show()
        Log.d("FragmentLifeCycle","Second Fragment onDestroy() state")
    }

    override fun onDetach() {
        super.onDetach()
        Toast.makeText(requireContext(), "Second Fragment onDetach() state", Toast.LENGTH_SHORT).show()
        Log.d("FragmentLifeCycle","Second Fragment onDetach() state")
    }
}
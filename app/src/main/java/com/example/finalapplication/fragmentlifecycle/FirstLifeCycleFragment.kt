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
 * Use the [FirstLifeCycleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstLifeCycleFragment : Fragment(R.layout.fragment_first_life_cycle) {
    // TODO: Rename and change types of parameters
//    private var param1: String? = null
//    private var param2: String? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Toast.makeText(requireContext(), "First Fragment onAttach() state", Toast.LENGTH_SHORT).show()
        Log.d("FragmentLifeCycle","First Fragment onAttach() state")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(requireContext(), "First Fragment onCreate() state", Toast.LENGTH_SHORT).show()
        Log.d("FragmentLifeCycle","First Fragment onCreate() state")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Toast.makeText(requireContext(), "First Fragment onCreateView() state", Toast.LENGTH_SHORT).show()
        Log.d("FragmentLifeCycle","First Fragment onCreateView() state")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(requireContext(), "First Fragment onViewCreated() state", Toast.LENGTH_SHORT).show()
        Log.d("FragmentLifeCycle","First Fragment onViewCreated() state")
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(requireContext(), "First Fragment onStart() state", Toast.LENGTH_SHORT).show()
        Log.d("FragmentLifeCycle","First Fragment onStart() state")
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(requireContext(), "First Fragment onResume() state", Toast.LENGTH_SHORT).show()
        Log.d("FragmentLifeCycle","First Fragment onResume() state")
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(requireContext(), "First Fragment onPause() state", Toast.LENGTH_SHORT).show()
        Log.d("FragmentLifeCycle","First Fragment onPause() state")
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(requireContext(), "First Fragment onStop() state", Toast.LENGTH_SHORT).show()
        Log.d("FragmentLifeCycle","First Fragment onStop() state")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Toast.makeText(requireContext(), "First Fragment onDestroyView() state", Toast.LENGTH_SHORT).show()
        Log.d("FragmentLifeCycle","First Fragment onDestroyView() state")
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(requireContext(), "First Fragment onDestroy() state", Toast.LENGTH_SHORT).show()
        Log.d("FragmentLifeCycle","First Fragment onDestroy() state")
    }

    override fun onDetach() {
        super.onDetach()
        Toast.makeText(requireContext(), "First Fragment onDetach() state", Toast.LENGTH_SHORT).show()
        Log.d("FragmentLifeCycle","First Fragment onDetach() state")
    }
}
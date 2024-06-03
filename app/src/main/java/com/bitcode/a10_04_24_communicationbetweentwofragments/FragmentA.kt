package com.bitcode.a10_04_24_communicationbetweentwofragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bitcode.a10_04_24_communicationbetweentwofragments.databinding.FragmentABinding

class FragmentA : Fragment() {
    private lateinit var fragmentABinding: FragmentABinding
        var text = ""
        set(value) {
            field = value
            fragmentABinding.edtName.setText(value)
        }

    interface OnNameSetListener{
        fun onNameSet(name : String)
    }

    var onNameSetListener : OnNameSetListener? = null           //reference of interface

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentABinding = FragmentABinding.inflate(inflater)

        fragmentABinding.btnSend.setOnClickListener {
            //way 1
//            (parentFragmentManager.findFragmentById(R.id.fragmentB) as FragmentB).text1 =
//                fragmentABinding.edtName.text.toString()

            //way 2
//            (requireActivity() as MainActivity).setDataToFragmentB(fragmentABinding.edtName.text.toString())

//            onNameSetListener?.onNameSet(fragmentABinding.edtName.text.toString())
        }
        return fragmentABinding.root
    }
}
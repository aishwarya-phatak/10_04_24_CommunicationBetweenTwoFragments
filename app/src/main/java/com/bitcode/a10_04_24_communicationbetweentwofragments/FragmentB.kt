package com.bitcode.a10_04_24_communicationbetweentwofragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bitcode.a10_04_24_communicationbetweentwofragments.databinding.FragmentBBinding

class FragmentB : Fragment(){
    private lateinit var fragmentBBinding: FragmentBBinding
    var text1 = ""
    set(value) {
        field = value
        fragmentBBinding.edtCity.setText(value)
    }

    interface OnCitySetListener{
        fun onCitySet(city : String)
    }

    var onCitySetListener : OnCitySetListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentBBinding = FragmentBBinding.inflate(inflater)

        fragmentBBinding.btnSendCity.setOnClickListener {
            //way 2
//            (requireActivity() as MainActivity).setDataToFragmentA(fragmentBBinding.edtCity.text.toString())

            //way 3 -- creates cyclic dependency if we implement interface at Fragment level
//            onCitySetListener?.onCitySet(fragmentBBinding.edtCity.text.toString())
        }
        return fragmentBBinding.root
    }
}
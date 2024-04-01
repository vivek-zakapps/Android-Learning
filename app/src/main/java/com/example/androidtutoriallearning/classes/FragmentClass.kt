package com.example.androidtutoriallearning.classes

import SecondFragment
import android.os.Bundle
import com.example.androidtutoriallearning.fragments.FirstFragment
import java.io.Serializable

class FirstFragmentClass: FirstFragment() {
    companion object{
        fun newInstance(key: String,data: Int?):FirstFragmentClass{
            val fragment = FirstFragmentClass();
            val argument = Bundle();
            argument.putInt(key, data!!)
            fragment.arguments= argument;
            return  fragment;
        }
    }
}


class SecondFragmentClass: SecondFragment() {
    companion object{
        fun newInstance(key: String, data: Int?):SecondFragmentClass{
            val fragment = SecondFragmentClass();
            val argument = Bundle();
            argument.putInt(key, data!!)
            fragment.arguments= argument;
            return  fragment;
        }
    }
}
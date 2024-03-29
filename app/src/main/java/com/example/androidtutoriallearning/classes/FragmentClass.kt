package com.example.androidtutoriallearning.classes

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.androidtutoriallearning.fragments.FirstFragment
import com.example.androidtutoriallearning.fragments.SecondFragment

class FirstFragmentClass: FirstFragment() {
    companion object{
        fun newInstance(key: String,data: String):FirstFragmentClass{
            val fragment = FirstFragmentClass();
            val argument = Bundle();
            argument.putString(key, data)
            fragment.arguments= argument;
            return  fragment;
        }
    }
}


class SecondFragmentClass: SecondFragment() {
    companion object{
        fun newInstance(key: String,data: String):SecondFragmentClass{
            val fragment = SecondFragmentClass();
            val argument = Bundle();
            argument.putString(key, data)
            fragment.arguments= argument;
            return  fragment;
        }
    }
}
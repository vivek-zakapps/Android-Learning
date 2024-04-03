package com.example.androidtutoriallearning.interfaces

interface RecyclerviewInterface  {
    fun onEvent(event: String)
    fun onDeleteButtonClick(id: Int)

    fun onCardTilePress(position :Int)
}
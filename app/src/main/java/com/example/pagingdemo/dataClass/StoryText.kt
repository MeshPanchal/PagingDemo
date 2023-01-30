package com.example.pagingdemo.dataClass

data class StoryText(
    val fullyHighlighted: Boolean,
    val matchLevel: String,
    val matchedWords: List<String>,
    val value: String
)
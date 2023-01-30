package com.example.pagingdemo.dataClass

data class ProcessingTimingsMS(
    val afterFetch: AfterFetch,
    val fetch: Fetch,
    val request: Request,
    val total: Int
)
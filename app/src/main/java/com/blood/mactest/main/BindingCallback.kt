package com.blood.mactest.main

interface BindingCallback<T> {
    fun onItemClick(t: T)
}
package com.nishan.auth.domain

interface PatternValidator{
    fun matches(value: String): Boolean
}
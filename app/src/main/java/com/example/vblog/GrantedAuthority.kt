package com.example.vblog

import java.io.Serializable


interface GrantedAuthority : Serializable {
    val authority: String?
}

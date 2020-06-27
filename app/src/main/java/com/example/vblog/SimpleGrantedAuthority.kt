package com.example.vblog

class SimpleGrantedAuthority(role: String) : GrantedAuthority {
    override val authority: String

    override fun equals(obj: Any?): Boolean {
        return if (this === obj) {
            true
        } else {
            if (obj is SimpleGrantedAuthority) authority == obj.authority else false
        }
    }

    override fun hashCode(): Int {
        return authority.hashCode()
    }

    override fun toString(): String {
        return authority
    }

    companion object {
        private const val serialVersionUID = 520L
    }

    init {
//        Assert.hasText(role, "A granted authority textual representation is required")
        authority = role
    }
}

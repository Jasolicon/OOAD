package com.example.vblog


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection
import java.util.List;


class User : UserDetails {
    var id: Long? = null
    override var username: String? = null
    override var password: String? = null
    var nickname: String? = null
    override var isEnabled = false
    private var roles: List<Role>? = null
    var email: String? = null
    var userface: String? = null
    var regTime: Timestamp? = null

    fun getRoles(): List<Role>? {
        return roles
    }

    fun setRoles(roles: List<Role>?) {
        this.roles = roles
    }

//    @get:JsonIgnore
    override val isAccountNonExpired: Boolean
        get() = true

//    @get:JsonIgnore
    override val isAccountNonLocked: Boolean
        get() = true

//    @get:JsonIgnore
    override val isCredentialsNonExpired: Boolean
        get() = true

//    @get:JsonIgnore
    override val authorities: MutableList<GrantedAuthority>
        get() {
            val authorities: MutableList<GrantedAuthority> = ArrayList()
            for (role in roles!!) {
                authorities.add(SimpleGrantedAuthority("ROLE_" + role.name))
            }
            return authorities
        }

}
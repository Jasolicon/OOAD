package com.example.vblog
import java.io.Serializable;
import java.util.Collection;
//import org.springframework.security.core.GrantedAuthority;
interface UserDetails : Serializable {
    val authorities: MutableList<GrantedAuthority>
    val password: String?
    val username: String?
    val isAccountNonExpired: Boolean
    val isAccountNonLocked: Boolean
    val isCredentialsNonExpired: Boolean
    val isEnabled: Boolean
}

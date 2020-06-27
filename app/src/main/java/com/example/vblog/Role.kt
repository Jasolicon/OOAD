package com.example.vblog

class Role {
    var id: Long? = null
    var name: String? = null

    constructor() {}

    constructor(id: Long?, name: String?) {
        this.id = id
        this.name = name
    }
}

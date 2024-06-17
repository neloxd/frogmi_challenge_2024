package com.jesusvilla.core.network.data

object Session {
    var session: String? = null
    var nextUrl: String = "https://neo.frogmi.com/"
    var companyUUID = ""
    var authenticationListener: AuthenticationListener? = null


    fun invalidate() {
        // sending logged out event to it's listener
        // i.e: Activity, Fragment, Service
        session = null
        authenticationListener?.onUserLoggedOut()
    }

    fun hasSession() = !session.isNullOrEmpty()
}

interface AuthenticationListener {
    fun onUserLoggedOut()
}
package com.ucb.creativeclique

import android.accounts.Account

object AccountManager {
    private val registeredAccount = mutableListOf<AccountDetails>()

    fun register(account: AccountDetails){
        registeredAccount.add(account)
    }

    fun logIn(userName: String, password: String): Boolean {
        val account = registeredAccount.find { it.userName == userName && it.password == password }
        return account != null
    }

    fun Search(fullName: String): Boolean {
        val search = registeredAccount.find { it.fullName.equals(fullName, ignoreCase = true) }
        return search != null
    }
    fun isEmailRegistered(email: String): Boolean {
        val account = registeredAccount.find { it.userName == email }
        return account != null
    }

}
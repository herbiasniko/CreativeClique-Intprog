package com.ucb.creativeclique

sealed class NotificationItem {
    data class Header(val title: String) : NotificationItem()
    data class Notification(val profileImageRes: Int, val message: String) : NotificationItem()
}
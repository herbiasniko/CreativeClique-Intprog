package com.ucb.creativeclique

sealed class PrivateMessageSealed(val text: String) {
    abstract fun getViewType(): Int

    class SenderMessage(text: String) : PrivateMessageSealed(text) {
        override fun getViewType(): Int {
            return VIEW_TYPE_SENDER
        }
    }

    class ReceiverMessage(text: String) : PrivateMessageSealed(text) {
        override fun getViewType(): Int {
            return VIEW_TYPE_RECEIVER
        }
    }

    companion object {
        const val VIEW_TYPE_SENDER = 1
        const val VIEW_TYPE_RECEIVER = 2
    }
}
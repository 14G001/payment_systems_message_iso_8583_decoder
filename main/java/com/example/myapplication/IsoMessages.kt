package com.example.myapplication

class IsoMessages private constructor() {
    companion object {
        @Volatile
        private var instance: IsoMessages? = null
        private var value = ArrayList<String>()

        fun getInstance(): IsoMessages {
            if (instance == null) {
                synchronized(this) {
                    if (instance == null) {
                        instance = IsoMessages()
                    }
                }
            }
            return instance!!
        }
    }

    fun get(): ArrayList<String> {
        return value
    }
    fun add(isoMsg: String) {
        value.add(isoMsg)
    }
}
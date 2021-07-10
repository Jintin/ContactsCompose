package com.jintin.contactscompose.data

import kotlinx.coroutines.delay
import javax.inject.Inject

class ContactRepo @Inject constructor() {

    suspend fun getList(): List<ContactData> {
        delay(1000)
        return listOf(
            ContactData("Alex", "0967467847"),
            ContactData("Peter", "0947385797"),
            ContactData("Tim", "0954389279"),
            ContactData("Apple", "0954385793"),
            ContactData("Lance", "0954852589"),
            ContactData("Jane", "0954789275"),
            ContactData("Tiger", "0954832798"),
            ContactData("Irene", "0954789777"),
            ContactData("Chris", "0951909089"),
            ContactData("Edwin", "0913859107"),

            ContactData("Billy", "0967467847"),
            ContactData("Nick", "0947385797"),
            ContactData("Eric", "0954389279"),
            ContactData("Adam", "0954385793"),
            ContactData("Andrew", "0954852589"),
            ContactData("Jake", "0954789275"),
            ContactData("James", "0954832798"),
            ContactData("Mike", "0954789777"),
            ContactData("Rick", "0951909089"),
            ContactData("Thomas", "0913859107"),

            ContactData("Rebecca", "0967467847"),
            ContactData("Jenny", "0947385797"),
            ContactData("Sam", "0954385793"),
            ContactData("Kim", "0954852589"),
            ContactData("Allen", "0954789275"),
            ContactData("Ben", "0954832798"),
            ContactData("Steven", "0954789777"),
            ContactData("Fiona", "0951909089"),
            ContactData("Jason", "0913859107"),
            ContactData("Ray", "0953891789"),

            ContactData("Sean", "0953891789"),
            ContactData("Zac", "0953891789"),
            ContactData("Ryan", "0954389279"),
        ).sortedBy { it.name }
    }
}
package com.example.finalapplication.jsondata.jsondataquiz

import android.os.Parcel
import android.os.Parcelable

data class QuizData (
    val question: String,
    val optionSelected: String?,
    val isCorrect: Boolean
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(question)
        parcel.writeString(optionSelected)
        parcel.writeByte(if (isCorrect) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<QuizData> {
        override fun createFromParcel(parcel: Parcel): QuizData {
            return QuizData(parcel)
        }

        override fun newArray(size: Int): Array<QuizData?> {
            return arrayOfNulls(size)
        }
    }
}
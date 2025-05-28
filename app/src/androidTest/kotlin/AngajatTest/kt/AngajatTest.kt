package AngajatTest.kt

import DataClasses.Angajat
import android.os.Parcel
import org.junit.Assert.*
import org.junit.Test

class AngajatTest {
    @Test
    fun testConstructor_ValidValues() {
        val angajat = Angajat("user123", "pass123")
        assertEquals("user123", angajat.username)
        assertEquals("pass123", angajat.password)
    }

    @Test
    fun testConstructor_InvalidValues_BlankOrNull() {
        val angajat1 = Angajat("   ", "   ")
        val angajat2 = Angajat(null, null)

        assertNull(angajat1.username)
        assertNull(angajat1.password)

        assertNull(angajat2.username)
        assertNull(angajat2.password)
    }

    @Test
    fun testParcelable_WriteRead() {
        val original = Angajat("parcelUser", "parcelPass")
        val parcel = Parcel.obtain()
        original.writeToParcel(parcel, 0)
        parcel.setDataPosition(0)
        val recreated = Angajat.CREATOR.createFromParcel(parcel)

        assertEquals(original.username, recreated.username)
        assertEquals(original.password, recreated.password)

        parcel.recycle()
    }

    @Test
    fun testDescribeContents() {
        val angajat = Angajat("abc", "123")
        assertEquals(0, angajat.describeContents())
    }

    @Test
    fun testNewArray() {
        val array = Angajat.CREATOR.newArray(2)
        assertEquals(2, array.size)
        assertNull(array[0])
    }
}

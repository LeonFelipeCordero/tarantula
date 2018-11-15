package com.ph.tarantula

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class UrlUtilsKtTest {

    @Test
    fun testValidateUrl() {
        assertTrue("http://testDomain.com/".regexUrl("testDomain.com"))
        assertTrue("https://TestDomain.com/test".regexUrl("TestDomain.com"))
        assertTrue("https://test.com/test/test2".regexUrl("test.com"))
        assertFalse("https://Test.com/".regexUrl("domain"))
        assertFalse("test.com".regexUrl("test.com"))
    }
}

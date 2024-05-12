package br.com.yessr.utilty;

import org.junit.jupiter.api.Test;

import static br.com.yessr.utilty.ValidationUtils.*;
import static org.junit.jupiter.api.Assertions.*;

class ValidationUtilsTest {

    @Test
    void testConstructor() {
        assertThrows(IllegalStateException.class, ValidationUtils::new);
    }

    @Test
    void testIsValidCPF_NullOrEmptyDocument() {
        assertFalse(isValidCPF(null));
        assertFalse(isValidCPF(""));
        assertFalse(isValidCPF(" "));
        assertFalse(isValidCPF("0"));
    }

    @Test
    void testIsValidCPF_ValidDocument() {
        assertTrue(isValidCPF("529.982.247-25"));
    }

    @Test
    void testIsValidCPF_InvalidDocument() {
        assertFalse(isValidCPF("123.456.789-00"));
    }

    @Test
    void testIsValidCPF_InputMismatchException() {
        assertFalse(isValidCPF("111.111.111-11"));
    }

    @Test
    void testIsValidEmail_ValidEmail() {
        assertTrue(isValidEmail("test@example.com"));
    }

    @Test
    void testIsValidEmail_InvalidEmail() {
        assertFalse(isValidEmail("testexample.com"));
    }

    @Test
    void testIsValidPhone_ValidPhone() {
        assertTrue(isValidPhone("(11) 1234-5678"));
    }

    @Test
    void testIsValidPhone_InvalidPhone() {
        assertFalse(isValidPhone("12345"));
    }

    @Test
    void testIsValidCPF_Dig11Equals0() {
        assertTrue(isValidCPF("529.982.247-25"));
    }

    @Test
    void testIsValidCPF_Dig11NotEquals0() {
        assertFalse(isValidCPF("52998224700"));
    }

}

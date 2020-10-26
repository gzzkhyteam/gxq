//package com.hengyunsoft.utils;
//
//import com.hengyunsoft.exception.BaseUncheckedException;
//
//import java.util.Collection;
//
///**
// * @author tyh
// * @createTime 2017-12-15 15:19
// */
//public class UncheckedAssert {
//    private UncheckedAssert() {
//    }
//
//    /**
//     * Asserts that a condition is true. If it isn't it throws an
//     * {@link BaseUncheckedException} with the given message.
//     *
//     * @param message   the identifying message for the {@link BaseUncheckedException} (<code>null</code>
//     *                  okay)
//     * @param condition condition to be checked
//     * @throws BaseUncheckedException
//     */
//    public static void assertTrue(String message, boolean condition) throws BaseUncheckedException {
//        if (!condition) {
//            fail(message);
//        }
//    }
//    public static void assertTrue(int code, String message, boolean condition) throws BaseUncheckedException {
//        if (!condition) {
//            fail(code, message);
//        }
//    }
//
//    /**
//     * Asserts that a condition is true. If it isn't it throws an
//     * {@link BaseUncheckedException} without a message.
//     *
//     * @param condition condition to be checked
//     * @throws BaseUncheckedException
//     */
//    public static void assertTrue(boolean condition) throws BaseUncheckedException {
//        assertTrue(null, condition);
//    }
//
//    /**
//     * Asserts that a condition is false. If it isn't it throws an
//     * {@link BaseUncheckedException} with the given message.
//     *
//     * @param message   the identifying message for the {@link BaseUncheckedException} (<code>null</code>
//     *                  okay)
//     * @param condition condition to be checked
//     * @throws BaseUncheckedException
//     */
//    public static void assertFalse(String message, boolean condition) throws BaseUncheckedException {
//        assertTrue(message, !condition);
//    }
//
//    /**
//     * Asserts that a condition is false. If it isn't it throws an
//     * {@link BaseUncheckedException} without a message.
//     *
//     * @param condition condition to be checked
//     * @throws BaseUncheckedException
//     */
//    static public void assertFalse(boolean condition) throws BaseUncheckedException {
//        assertFalse(null, condition);
//    }
//
//    /**
//     * Fails a test with the given message.
//     *
//     * @param message the identifying message for the {@link BaseUncheckedException} (<code>null</code>
//     *                okay)
//     * @throws BaseUncheckedException
//     * @see BaseUncheckedException
//     */
//    public static void fail(int code, String message) throws BaseUncheckedException {
//        if (message == null) {
//            throw new BaseUncheckedException(code, message);
//        }
//        throw new BaseUncheckedException(code, message);
//    }
//
//    /**
//     * Fails a test with no message.
//     *
//     * @throws BaseUncheckedException
//     */
//    public static void fail() throws BaseUncheckedException {
//        fail(-1, null);
//    }
//
//    private static boolean equalsRegardingNull(Object expected, Object actual) {
//        if (expected == null) {
//            return actual == null;
//        }
//
//        return isEquals(expected, actual);
//    }
//
//    private static boolean isEquals(Object expected, Object actual) {
//        return expected.equals(actual);
//    }
//
//
//    /**
//     * Asserts that two objects are <b>not</b> equals. If they are, an
//     * {@link BaseUncheckedException} is thrown with the given message. If
//     * <code>unexpected</code> and <code>actual</code> are <code>null</code>,
//     * they are considered equal.
//     *
//     * @param message    the identifying message for the {@link BaseUncheckedException} (<code>null</code>
//     *                   okay)
//     * @param unexpected unexpected value to check
//     * @param actual     the value to check against <code>unexpected</code>
//     * @throws BaseUncheckedException
//     */
//    public static void assertNotEquals(String message, Object unexpected,
//                                       Object actual) throws BaseUncheckedException {
//        if (equalsRegardingNull(unexpected, actual)) {
//            failEquals(message, actual);
//        }
//    }
//
//    /**
//     * Asserts that two objects are <b>not</b> equals. If they are, an
//     * {@link BaseUncheckedException} without a message is thrown. If
//     * <code>unexpected</code> and <code>actual</code> are <code>null</code>,
//     * they are considered equal.
//     *
//     * @param unexpected unexpected value to check
//     * @param actual     the value to check against <code>unexpected</code>
//     * @throws BaseUncheckedException
//     */
//    public static void assertNotEquals(Object unexpected, Object actual) throws BaseUncheckedException {
//        assertNotEquals(null, unexpected, actual);
//    }
//
//    private static void failEquals(String message, Object actual) throws BaseUncheckedException {
//        String formatted = "Values should be different. ";
//        if (message != null) {
//            formatted = message + ". ";
//        }
//
//        formatted += "Actual: " + actual;
//        fail(formatted);
//    }
//
//    /**
//     * Asserts that two longs are <b>not</b> equals. If they are, an
//     * {@link BaseUncheckedException} is thrown with the given message.
//     *
//     * @param message    the identifying message for the {@link BaseUncheckedException} (<code>null</code>
//     *                   okay)
//     * @param unexpected unexpected value to check
//     * @param actual     the value to check against <code>unexpected</code>
//     * @throws BaseUncheckedException
//     */
//    public static void assertNotEquals(String message, long unexpected, long actual) throws BaseUncheckedException {
//        if (unexpected == actual) {
//            failEquals(message, Long.valueOf(actual));
//        }
//    }
//
//    /**
//     * Asserts that two longs are <b>not</b> equals. If they are, an
//     * {@link BaseUncheckedException} without a message is thrown.
//     *
//     * @param unexpected unexpected value to check
//     * @param actual     the value to check against <code>unexpected</code>
//     * @throws BaseUncheckedException
//     */
//    public static void assertNotEquals(long unexpected, long actual) throws BaseUncheckedException {
//        assertNotEquals(null, unexpected, actual);
//    }
//
//    /**
//     * Asserts that two doubles are <b>not</b> equal to within a positive delta.
//     * If they are, an {@link BaseUncheckedException} is thrown with the given
//     * message. If the unexpected value is infinity then the delta value is
//     * ignored. NaNs are considered equal:
//     * <code>assertNotEquals(Double.NaN, Double.NaN, *)</code> fails
//     *
//     * @param message    the identifying message for the {@link BaseUncheckedException} (<code>null</code>
//     *                   okay)
//     * @param unexpected unexpected value
//     * @param actual     the value to check against <code>unexpected</code>
//     * @param delta      the maximum delta between <code>unexpected</code> and
//     *                   <code>actual</code> for which both numbers are still
//     *                   considered equal.
//     * @throws BaseUncheckedException
//     */
//    public static void assertNotEquals(String message, double unexpected,
//                                       double actual, double delta) throws BaseUncheckedException {
//        if (!doubleIsDifferent(unexpected, actual, delta)) {
//            failEquals(message, Double.valueOf(actual));
//        }
//    }
//
//    /**
//     * Asserts that two doubles are <b>not</b> equal to within a positive delta.
//     * If they are, an {@link BaseUncheckedException} is thrown. If the unexpected
//     * value is infinity then the delta value is ignored.NaNs are considered
//     * equal: <code>assertNotEquals(Double.NaN, Double.NaN, *)</code> fails
//     *
//     * @param unexpected unexpected value
//     * @param actual     the value to check against <code>unexpected</code>
//     * @param delta      the maximum delta between <code>unexpected</code> and
//     *                   <code>actual</code> for which both numbers are still
//     *                   considered equal.
//     * @throws BaseUncheckedException
//     */
//    public static void assertNotEquals(double unexpected, double actual, double delta) throws BaseUncheckedException {
//        assertNotEquals(null, unexpected, actual, delta);
//    }
//
//    /**
//     * Asserts that two floats are <b>not</b> equal to within a positive delta.
//     * If they are, an {@link BaseUncheckedException} is thrown. If the unexpected
//     * value is infinity then the delta value is ignored.NaNs are considered
//     * equal: <code>assertNotEquals(Float.NaN, Float.NaN, *)</code> fails
//     *
//     * @param unexpected unexpected value
//     * @param actual     the value to check against <code>unexpected</code>
//     * @param delta      the maximum delta between <code>unexpected</code> and
//     *                   <code>actual</code> for which both numbers are still
//     *                   considered equal.
//     * @throws BaseUncheckedException
//     */
//    public static void assertNotEquals(float unexpected, float actual, float delta) throws BaseUncheckedException {
//        assertNotEquals(null, unexpected, actual, delta);
//    }
//
//    /**
//     * Asserts that two doubles are equal to within a positive delta.
//     * If they are not, an {@link BaseUncheckedException} is thrown with the given
//     * message. If the expected value is infinity then the delta value is
//     * ignored. NaNs are considered equal:
//     * <code>assertEquals(Double.NaN, Double.NaN, *)</code> passes
//     *
//     * @param message  the identifying message for the {@link BaseUncheckedException} (<code>null</code>
//     *                 okay)
//     * @param expected expected value
//     * @param actual   the value to check against <code>expected</code>
//     * @param delta    the maximum delta between <code>expected</code> and
//     *                 <code>actual</code> for which both numbers are still
//     *                 considered equal.
//     * @throws BaseUncheckedException
//     */
//    public static void assertEquals(String message, double expected,
//                                    double actual, double delta) throws BaseUncheckedException {
//        if (doubleIsDifferent(expected, actual, delta)) {
//            failNotEquals(message, Double.valueOf(expected), Double.valueOf(actual));
//        }
//    }
//
//    /**
//     * Asserts that two floats are equal to within a positive delta.
//     * If they are not, an {@link BaseUncheckedException} is thrown with the given
//     * message. If the expected value is infinity then the delta value is
//     * ignored. NaNs are considered equal:
//     * <code>assertEquals(Float.NaN, Float.NaN, *)</code> passes
//     *
//     * @param message  the identifying message for the {@link BaseUncheckedException} (<code>null</code>
//     *                 okay)
//     * @param expected expected value
//     * @param actual   the value to check against <code>expected</code>
//     * @param delta    the maximum delta between <code>expected</code> and
//     *                 <code>actual</code> for which both numbers are still
//     *                 considered equal.
//     * @throws BaseUncheckedException
//     */
//    public static void assertEquals(String message, float expected,
//                                    float actual, float delta) throws BaseUncheckedException {
//        if (floatIsDifferent(expected, actual, delta)) {
//            failNotEquals(message, Float.valueOf(expected), Float.valueOf(actual));
//        }
//    }
//
//    /**
//     * Asserts that two floats are <b>not</b> equal to within a positive delta.
//     * If they are, an {@link BaseUncheckedException} is thrown with the given
//     * message. If the unexpected value is infinity then the delta value is
//     * ignored. NaNs are considered equal:
//     * <code>assertNotEquals(Float.NaN, Float.NaN, *)</code> fails
//     *
//     * @param message    the identifying message for the {@link BaseUncheckedException} (<code>null</code>
//     *                   okay)
//     * @param unexpected unexpected value
//     * @param actual     the value to check against <code>unexpected</code>
//     * @param delta      the maximum delta between <code>unexpected</code> and
//     *                   <code>actual</code> for which both numbers are still
//     *                   considered equal.
//     * @throws BaseUncheckedException
//     */
//    public static void assertNotEquals(String message, float unexpected,
//                                       float actual, float delta) throws BaseUncheckedException {
//        if (!floatIsDifferent(unexpected, actual, delta)) {
//            failEquals(message, Float.valueOf(actual));
//        }
//    }
//
//    private static boolean doubleIsDifferent(double d1, double d2, double delta) {
//        if (Double.compare(d1, d2) == 0) {
//            return false;
//        }
//        if ((Math.abs(d1 - d2) <= delta)) {
//            return false;
//        }
//
//        return true;
//    }
//
//    private static boolean floatIsDifferent(float f1, float f2, float delta) {
//        if (Float.compare(f1, f2) == 0) {
//            return false;
//        }
//        if ((Math.abs(f1 - f2) <= delta)) {
//            return false;
//        }
//
//        return true;
//    }
//
//    /**
//     * Asserts that two longs are equal. If they are not, an
//     * {@link BaseUncheckedException} is thrown.
//     *
//     * @param expected expected long value.
//     * @param actual   actual long value
//     * @throws BaseUncheckedException
//     */
//    public static void assertEquals(long expected, long actual) throws BaseUncheckedException {
//        assertEquals(null, expected, actual);
//    }
//
//    /**
//     * Asserts that two longs are equal. If they are not, an
//     * {@link BaseUncheckedException} is thrown with the given message.
//     *
//     * @param message  the identifying message for the {@link BaseUncheckedException} (<code>null</code>
//     *                 okay)
//     * @param expected long expected value.
//     * @param actual   long actual value
//     * @throws BaseUncheckedException
//     */
//    public static void assertEquals(String message, long expected, long actual) throws BaseUncheckedException {
//        if (expected != actual) {
//            failNotEquals(message, Long.valueOf(expected), Long.valueOf(actual));
//        }
//    }
//
//    /**
//     * @throws BaseUncheckedException
//     * @deprecated Use
//     * <code>assertEquals(double expected, double actual, double delta)</code>
//     * instead
//     */
//    @Deprecated
//    public static void assertEquals(double expected, double actual) throws BaseUncheckedException {
//        assertEquals(null, expected, actual);
//    }
//
//    /**
//     * @throws BaseUncheckedException
//     * @deprecated Use
//     * <code>assertEquals(String message, double expected, double actual, double delta)</code>
//     * instead
//     */
//    @Deprecated
//    public static void assertEquals(String message, double expected,
//                                    double actual) throws BaseUncheckedException {
//        fail("Use assertEquals(expected, actual, delta) to compare floating-point numbers");
//    }
//
//    /**
//     * Asserts that two doubles are equal to within a positive delta.
//     * If they are not, an {@link BaseUncheckedException} is thrown. If the expected
//     * value is infinity then the delta value is ignored.NaNs are considered
//     * equal: <code>assertEquals(Double.NaN, Double.NaN, *)</code> passes
//     *
//     * @param expected expected value
//     * @param actual   the value to check against <code>expected</code>
//     * @param delta    the maximum delta between <code>expected</code> and
//     *                 <code>actual</code> for which both numbers are still
//     *                 considered equal.
//     * @throws BaseUncheckedException
//     */
//    public static void assertEquals(double expected, double actual, double delta) throws BaseUncheckedException {
//        assertEquals(null, expected, actual, delta);
//    }
//
//    /**
//     * Asserts that two floats are equal to within a positive delta.
//     * If they are not, an {@link BaseUncheckedException} is thrown. If the expected
//     * value is infinity then the delta value is ignored. NaNs are considered
//     * equal: <code>assertEquals(Float.NaN, Float.NaN, *)</code> passes
//     *
//     * @param expected expected value
//     * @param actual   the value to check against <code>expected</code>
//     * @param delta    the maximum delta between <code>expected</code> and
//     *                 <code>actual</code> for which both numbers are still
//     *                 considered equal.
//     * @throws BaseUncheckedException
//     */
//
//    public static void assertEquals(float expected, float actual, float delta) throws BaseUncheckedException {
//        assertEquals(null, expected, actual, delta);
//    }
//
//    /**
//     * Asserts that an object isn't null. If it is an {@link BaseUncheckedException} is
//     * thrown with the given message.
//     *
//     * @param message the identifying message for the {@link BaseUncheckedException} (<code>null</code>
//     *                okay)
//     * @param object  Object to check or <code>null</code>
//     * @throws BaseUncheckedException
//     */
//    public static void assertNotNull(String message, Object object) throws BaseUncheckedException {
//        assertTrue(message, object != null);
//    }
//
//    /**
//     * Asserts that an object isn't null. If it is an {@link BaseUncheckedException} is
//     * thrown.
//     *
//     * @param object Object to check or <code>null</code>
//     * @throws BaseUncheckedException
//     */
//    static public void assertNotNull(Object object) throws BaseUncheckedException {
//        assertNotNull(null, object);
//    }
//
//    /**
//     * Asserts that an object is null. If it is not, an {@link BaseUncheckedException}
//     * is thrown with the given message.
//     *
//     * @param message the identifying message for the {@link BaseUncheckedException} (<code>null</code>
//     *                okay)
//     * @param object  Object to check or <code>null</code>
//     * @throws BaseUncheckedException
//     */
//    public static void assertNull(String message, Object object) throws BaseUncheckedException {
//        if (object == null) {
//            return;
//        }
//        failNotNull(message, object);
//    }
//
//    /**
//     * Asserts that an object is null. If it isn't an {@link BaseUncheckedException} is
//     * thrown.
//     *
//     * @param object Object to check or <code>null</code>
//     * @throws BaseUncheckedException
//     */
//    public static void assertNull(Object object) throws BaseUncheckedException {
//        assertNull(null, object);
//    }
//
//    private static void failNotNull(String message, Object actual) throws BaseUncheckedException {
//        String formatted = "";
//        if (message != null) {
//            formatted = message + " ";
//        }
//        fail(formatted + "expected null, but was:<" + actual + ">");
//    }
//
//    /**
//     * Asserts that two objects refer to the same object. If they are not, an
//     * {@link BaseUncheckedException} is thrown with the given message.
//     *
//     * @param message  the identifying message for the {@link BaseUncheckedException} (<code>null</code>
//     *                 okay)
//     * @param expected the expected object
//     * @param actual   the object to compare to <code>expected</code>
//     * @throws BaseUncheckedException
//     */
//    public static void assertSame(String message, Object expected, Object actual) throws BaseUncheckedException {
//        if (expected == actual) {
//            return;
//        }
//        failNotSame(message, expected, actual);
//    }
//
//    /**
//     * Asserts that two objects refer to the same object. If they are not the
//     * same, an {@link BaseUncheckedException} without a message is thrown.
//     *
//     * @param expected the expected object
//     * @param actual   the object to compare to <code>expected</code>
//     * @throws BaseUncheckedException
//     */
//    public static void assertSame(Object expected, Object actual) throws BaseUncheckedException {
//        assertSame(null, expected, actual);
//    }
//
//    /**
//     * Asserts that two objects do not refer to the same object. If they do
//     * refer to the same object, an {@link BaseUncheckedException} is thrown with the
//     * given message.
//     *
//     * @param message    the identifying message for the {@link BaseUncheckedException} (<code>null</code>
//     *                   okay)
//     * @param unexpected the object you don't expect
//     * @param actual     the object to compare to <code>unexpected</code>
//     * @throws BaseUncheckedException
//     */
//    public static void assertNotSame(String message, Object unexpected,
//                                     Object actual) throws BaseUncheckedException {
//        if (unexpected == actual) {
//            failSame(message);
//        }
//    }
//
//    /**
//     * Asserts that two objects do not refer to the same object. If they do
//     * refer to the same object, an {@link BaseUncheckedException} without a message is
//     * thrown.
//     *
//     * @param unexpected the object you don't expect
//     * @param actual     the object to compare to <code>unexpected</code>
//     * @throws BaseUncheckedException
//     */
//    public static void assertNotSame(Object unexpected, Object actual) throws BaseUncheckedException {
//        assertNotSame(null, unexpected, actual);
//    }
//
//    private static void failSame(String message) throws BaseUncheckedException {
//        String formatted = "";
//        if (message != null) {
//            formatted = message + " ";
//        }
//        fail(formatted + "expected not same");
//    }
//
//    private static void failNotSame(String message, Object expected,
//                                    Object actual) throws BaseUncheckedException {
//        String formatted = "";
//        if (message != null) {
//            formatted = message + " ";
//        }
//        fail(formatted + "expected same:<" + expected + "> was not:<" + actual
//                + ">");
//    }
//
//    private static void failNotEquals(String message, Object expected,
//                                      Object actual) throws BaseUncheckedException {
//        fail(format(message, expected, actual));
//    }
//
//    private static String format(String message, Object expected, Object actual) {
//        String formatted = "";
//        if (message != null && !message.equals("")) {
//            formatted = message + " ";
//        }
//        String expectedString = String.valueOf(expected);
//        String actualString = String.valueOf(actual);
//        if (expectedString.equals(actualString)) {
//            return formatted + "expected: "
//                    + formatClassAndValue(expected, expectedString)
//                    + " but was: " + formatClassAndValue(actual, actualString);
//        } else {
//            return formatted + "expected:<" + expectedString + "> but was:<"
//                    + actualString + ">";
//        }
//    }
//
//    private static String formatClassAndValue(Object value, String valueString) {
//        String className = value == null ? "null" : value.getClass().getName();
//        return className + "<" + valueString + ">";
//    }
//
//    public static void assertNotEmpty(String message,
//                                      Collection<?> collection) throws BaseUncheckedException {
//        if (collection == null || collection.isEmpty()) {
//            fail(message);
//        }
//    }
//
//    public static void assertNotEmpty(String message, String obj) throws BaseUncheckedException {
//        if (obj == null || obj.isEmpty()) {
//            fail(message);
//        }
//    }
//
//    public static void assertEquals(String message, String str,
//                                    String str2) throws BaseUncheckedException {
//        if (str == str2) {
//            return;
//        }
//        if (str == null || !str.equals(str2)) {
//            fail(message);
//        }
//    }
//}

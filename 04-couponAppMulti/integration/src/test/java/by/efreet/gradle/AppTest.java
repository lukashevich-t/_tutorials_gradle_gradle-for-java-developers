/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package by.efreet.gradle;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test public void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting());

        // JvmInfo jInfo = JvmInfo.current();
        // assertEquals("16", jInfo.getMajor());
    }
}

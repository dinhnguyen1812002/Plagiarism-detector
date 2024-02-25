
package de.jplag.java;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import de.jplag.ParsingException;

/**
 * Test cases regarding the extraction from try vs. try with resource.
 */
class JavaTryTest extends AbstractJavaLanguageTest {
    @Test
    @DisplayName("Test difference between Add block and Cong block.")
    void testJavaClassPair() throws ParsingException {
        assertIterableEquals(parseJavaFile("Add.java"), parseJavaFile("Cong.java"));
    }
}

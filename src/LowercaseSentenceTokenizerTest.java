import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

public class LowercaseSentenceTokenizerTest {

    // Wave 1
    @Test
    public void testTokenizeWithNoCapitalizationOrPeriod() {
         String input = "this is a lowercase sentence without a period";
        LowercaseSentenceTokenizer tokenizer = new LowercaseSentenceTokenizer();
        Scanner scanner = new Scanner(input);
        
        List<String> expected = Arrays.asList("this", "is", "a", "lowercase", "sentence", "without", "a", "period");
        List<String> actual = tokenizer.tokenize(scanner);
        
        assertEquals(expected, actual);
        
    }

    // Wave 2
    @Test
    public void LowercaseSentenceTokenizerTest() {
        LowercaseSentenceTokenizer tokenizer = new LowercaseSentenceTokenizer();
        String input = "hello     hi hi hi    hello hello";
        Scanner scanner = new Scanner(input);
    
        List<String> expected = Arrays.asList("hello", "hi", "hi", "hi", "hello", "hello");
        List<String> actual = tokenizer.tokenize(scanner);
    
        assertEquals(expected, actual);
    }
    

    // Wave 3
    @Test
    void testTokenizeWithCapitalization() {
        LowercaseSentenceTokenizer tokenizer = new LowercaseSentenceTokenizer();
        Scanner scanner = new Scanner("This is a SENTENCE with sTrAnGe capitalization");
        List<String> tokens = tokenizer.tokenize(scanner);

        assertEquals(List.of("this", "is", "a", "sentence", "with", "strange", "capitalization"), tokens);
    }

    // Wave 3
    @Test
    void testTokenizeSentenceWithPeriod() {
        LowercaseSentenceTokenizer tokenizer = new LowercaseSentenceTokenizer();
        Scanner scanner = new Scanner("Hello world. This is an example.");
        List<String> tokens = tokenizer.tokenize(scanner);

        assertEquals(List.of("hello", "world", ".", "this", "is", "an", "example", "."), tokens);
    }

    // Wave 3
    @Test
    void testTokenizeWithInternalPeriod() {
        LowercaseSentenceTokenizer tokenizer = new LowercaseSentenceTokenizer();
        Scanner scanner = new Scanner("Hello world. This is Dr.Smith's example.");
        List<String> tokens = tokenizer.tokenize(scanner);

        assertEquals(List.of("hello", "world", ".", "this", "is", "dr.smith's", "example", "."), tokens);
    }
    
}

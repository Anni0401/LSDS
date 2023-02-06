package edu.upf;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;

import edu.upf.parser.SimplifiedTweet;

/**
 * Unit test for simple App.
 */
public class TwitterFilterTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testParseTweet()
    {
        String jsonString  = "{\"id\":0001,\"text\":\"no me gusta el chocolate\",\"user\":{\"id\":888,\"name\":\"ali\"},\"lang\":\"es\",\"timestamp_ms\":\"10001002\"}";
        SimplifiedTweet test = new SimplifiedTweet(00001, "no me gusta el chocolate", 888, "ali", "es", 10001002);
        Optional<SimplifiedTweet>  compare= SimplifiedTweet.fromJson(jsonString);

        assertEquals( test, compare.get());
    }
    public void testParseInvalidTweet()
    {
        String jsonString  = "{\"id\":0001,\"text\":\"no me gusta el chocolate\",\"user\":{\"id\":888,\"name\":\"ali\",\"lang\":\"es\",\"timestamp_ms\":\"10001002\"}";
        
        Optional<SimplifiedTweet>  compare= SimplifiedTweet.fromJson(jsonString);

        assertEquals( Optional.empty(), compare.get());
    }
    public void testParseIncompleteTweet()
    {
        String jsonString  = "{\"id\":0001,\"user\":{\"id\":888,\"name\":\"ali\",\"lang\":\"es\",\"timestamp_ms\":\"10001002\"}";
        
        Optional<SimplifiedTweet>  compare= SimplifiedTweet.fromJson(jsonString);

        assertEquals(Optional.empty(), compare.get());
    }


    // Place your code here
}

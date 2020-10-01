package twolak.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

/**
 *
 * @author twolak
 */
@Slf4j
@ActiveProfiles("kebab")
@JsonTest
public class BeerDtoKebabTest extends BaseTest {
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @Test
    public void testKebab() throws JsonProcessingException {
        BeerDto beerDto = getBeerDto();
        String jsonString = this.objectMapper.writeValueAsString(beerDto);
        log.info(jsonString);
    }
    
}

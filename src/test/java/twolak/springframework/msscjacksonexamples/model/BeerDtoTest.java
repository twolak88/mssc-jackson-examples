package twolak.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

/**
 *
 * @author twolak
 */
@Slf4j
@JsonTest
public class BeerDtoTest extends BaseTest {
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testSerializeDto() throws JsonProcessingException {
        BeerDto beerDto = getBeerDto();
        String jsonString = this.objectMapper.writeValueAsString(beerDto);
        log.info(jsonString);
    }

    @Test
    public void testDeserialize() throws JsonProcessingException {
        String json = "{\"id\":\"5b700d9e-8da4-4698-ae03-12b5f62b5fb2\",\"beerName\":\"Beer\",\"beerStyle\":\"Porter\",\"upc\":1,\"price\":5.32,\"createdDate\":null,\"lastUpdatedDate\":null}";
        BeerDto beerDto = this.objectMapper.readValue(json, BeerDto.class);
        log.info(beerDto.toString());
        assertEquals("5b700d9e-8da4-4698-ae03-12b5f62b5fb2", beerDto.getId().toString());
        assertEquals("Beer", beerDto.getBeerName());
        assertEquals(BigDecimal.valueOf(5.32), beerDto.getPrice());
    }
}

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
        String json = "{\"beerName\":\"Beer\",\"beerStyle\":\"Porter\",\"upc\":1,\"price\":\"5.32\","
                + "\"createdDate\":\"2020-10-01T22:30:34+0200\",\"lastUpdatedDate\":\"2020-01-10T22:30:34+0200\","
                + "\"localDate\":\"20201001\",\"beerID\":\"c1a7f8a7-727b-4363-ac29-fb0882cfcc6a\"}";
        BeerDto beerDto = this.objectMapper.readValue(json, BeerDto.class);
        log.info(beerDto.toString());
        assertEquals("c1a7f8a7-727b-4363-ac29-fb0882cfcc6a", beerDto.getId().toString());
        assertEquals("Beer", beerDto.getBeerName());
        assertEquals(BigDecimal.valueOf(5.32), beerDto.getPrice());
    }
}

package twolak.springframework.msscjacksonexamples.model;

import java.math.BigDecimal;
import java.util.UUID;

/**
 *
 * @author twolak
 */
public class BaseTest {
    
    BeerDto getBeerDto() {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Beer")
                .beerStyle("Porter")
                .upc(1L)
                .price(BigDecimal.valueOf(5.32))
                .build();
    }
}

package twolak.springframework.msscjacksonexamples.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
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
                .createdDate(OffsetDateTime.now())
                .lastUpdatedDate(OffsetDateTime.now())
                .build();
    }
}

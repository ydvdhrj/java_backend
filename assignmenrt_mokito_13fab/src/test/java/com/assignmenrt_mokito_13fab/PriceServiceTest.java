package com.assignmenrt_mokito_13fab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class PriceServiceTest {

    @Test
    public void calculateFinalPrice() {
        // 1. Create mock object manually
        DiscountRepository repoMock = mock(DiscountRepository.class);
        
        // 2. Define behavior (Stubbing)
        // When repo is asked for "MOB", return 10.0
        when(repoMock.getDiscountPercentage("MOB")).thenReturn(10.0);
        
        // When repo is asked for "LAP", return 20.0
        when(repoMock.getDiscountPercentage("LAP")).thenReturn(20.0);
        
        // 3. Inject mock into the service
        PriceService service = new PriceService(repoMock);
        
        // 4. Test Case 1: Mobile (Price 1000, Discount 10%)
        // Calculation: 1000 - (1000 * 10 / 100) = 900
        double res1 = service.calculateFinalPrice(1000, "MOB");
        assertEquals(900.0, res1);
        
        // 5. Test Case 2: Laptop (Price 2000, Discount 20%)
        // Calculation: 2000 - (2000 * 20 / 100) = 1600
        double res2 = service.calculateFinalPrice(2000, "LAP");
        assertEquals(1600.0, res2);

        // Optional: Verify the mock was actually used
        verify(repoMock).getDiscountPercentage("MOB");
        verify(repoMock).getDiscountPercentage("LAP");
    }
    
    // Bonus Task: Handling Exceptions
    @Test
    public void calculateFinalPriceException() {
        // Create mock
        DiscountRepository repoMock = mock(DiscountRepository.class);
        
        // Stubbing: Throw exception when specific code is used
        when(repoMock.getDiscountPercentage("ERROR_CODE"))
             .thenThrow(new RuntimeException("Database error"));
        
        PriceService service = new PriceService(repoMock);
        
        // Validate that the exception is thrown correctly
        assertThrows(RuntimeException.class, () -> {
            service.calculateFinalPrice(100, "ERROR_CODE");
        });
    }
}
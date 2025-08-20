package housing;

import com.ecor.reach.spring.template.housing.models.Housing;
import com.ecor.reach.spring.template.housing.dao.HousingDao;
import com.ecor.reach.spring.template.housing.HousingService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * SpringBootTest will load the entire application context,
 * allowing us to test HousingService with the actual HousingDao
 * and (optionally) an in-memory DB if configured in application-test.properties.
 */
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HousingServiceIntegrationTest {

    @Autowired
    private HousingService housingService;

    @Autowired
    private HousingDao housingDao;

    @Test
    @Order(1)
    public void testAdd() {
        Housing h = new Housing();
        // Use the entity's method names exactly:
        h.setID(1001);
        h.setCMA("Toronto");

        // You can set other fields if needed
        h.setYear(2023);
        h.setMonth(7);

        String result = housingService.add(h);
        Assertions.assertEquals("Saved", result);

        // Verify the record was actually saved
        Assertions.assertTrue(housingDao.findById(1001).isPresent());
    }

    @Test
    @Order(2)
    public void testGet() {
        Housing retrieved = housingService.get(1001);
        Assertions.assertNotNull(retrieved);

        // The entity's getter is getCMA()
        Assertions.assertEquals("Toronto", retrieved.getCMA());
        Assertions.assertEquals(2023, retrieved.getYear());
        Assertions.assertEquals(7, retrieved.getMonth());
        Assertions.assertEquals(1001, retrieved.getID());
    }

    @Test
    @Order(3)
    public void testUpdate() {
        Housing existing = housingService.get(1001);
        existing.setCMA("Hamilton");  // rename the CMA
        String result = housingService.update(existing);

        Assertions.assertEquals("Updated", result);

        Housing updated = housingService.get(1001);
        Assertions.assertEquals("Hamilton", updated.getCMA());
    }

    @Test
    @Order(4)
    public void testAllAndCount() {
        Iterable<Housing> all = housingService.all();
        int count = 0;
        for (Housing h : all) {
            count++;
        }

        // The service's "count" method might provide the same info directly
        Integer serviceCount = housingService.count();

        // If we only inserted one record so far, these should be 1
        Assertions.assertEquals(1, count);
        Assertions.assertEquals(1, serviceCount);
    }

    @Test
    @Order(5)
    public void testDelete() {
        String result = housingService.delete(1001);
        Assertions.assertEquals("Deleted", result);

        // Confirm it's no longer present
        Assertions.assertFalse(housingDao.findById(1001).isPresent());
    }
}

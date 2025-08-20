package com.ecor.reach.spring.template.housing;

import com.ecor.reach.spring.template.housing.dao.HousingDao;
import com.ecor.reach.spring.template.housing.models.Housing;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class HousingServiceMockTest {

    @Mock
    private HousingDao housingDao; // Mocked repository

    @InjectMocks
    private HousingServiceImpl housingService; // The service under test

    private Housing sampleHousing;

    @BeforeEach
    void setup() {
        // Create a sample Housing object for tests
        sampleHousing = new Housing();
        // If your entity uses setID and setCMA as method names, use them:
        sampleHousing.setID(123);
        sampleHousing.setCMA("Toronto");
    }

    @Test
    void testAdd_Success() {
        // Arrange
        // Mock "save" to not throw any exception
        when(housingDao.save(any(Housing.class))).thenReturn(sampleHousing);

        // Act
        String result = housingService.add(sampleHousing);

        // Assert
        assertEquals("Saved", result);
        verify(housingDao, times(1)).save(sampleHousing);
    }

    @Test
    void testAdd_Failure() {
        // Arrange
        // Simulate a DB error or constraint violation
        when(housingDao.save(any(Housing.class)))
                .thenThrow(new RuntimeException("DB Error"));

        // Act
        String result = housingService.add(sampleHousing);

        // Assert
        assertEquals("DB Error", result);
        verify(housingDao, times(1)).save(sampleHousing);
    }

    @Test
    void testGet() {
        // Arrange
        when(housingDao.findById(123))
                .thenReturn(Optional.of(sampleHousing));

        // Act
        Housing found = housingService.get(123);

        // Assert
        assertNotNull(found);
        assertEquals("Toronto", found.getCMA());
        // etc.
        verify(housingDao, times(1)).findById(123);
    }

    @Test
    void testUpdate_Success() {
        // Arrange
        // Suppose the existing record is present, so "save" is fine
        when(housingDao.save(any(Housing.class))).thenReturn(sampleHousing);

        // Act
        String result = housingService.update(sampleHousing);

        // Assert
        assertEquals("Updated", result);
        verify(housingDao, times(1)).save(sampleHousing);
    }

    @Test
    void testUpdate_Failure() {
        // Arrange
        when(housingDao.save(any(Housing.class)))
                .thenThrow(new RuntimeException("Update Failed"));

        // Act
        String result = housingService.update(sampleHousing);

        // Assert
        assertEquals("Update Failed", result);
        verify(housingDao, times(1)).save(sampleHousing);
    }

    @Test
    void testDelete_Success() {
        // Arrange
        // By default, a mock does nothing on void methods
        doNothing().when(housingDao).deleteById(123);

        // Act
        String result = housingService.delete(123);

        // Assert
        assertEquals("Deleted", result);
        verify(housingDao, times(1)).deleteById(123);
    }

    @Test
    void testDelete_Failure() {
        // Arrange
        doThrow(new RuntimeException("Delete Error"))
                .when(housingDao).deleteById(123);

        // Act
        String result = housingService.delete(123);

        // Assert
        assertEquals("Delete Error", result);
        verify(housingDao, times(1)).deleteById(123);
    }

    @Test
    void testAll() {
        // Act
        housingService.all();

        // Assert
        verify(housingDao, times(1)).findAll();
    }

    @Test
    void testCount() {
        // Arrange
        when(housingDao.getCount()).thenReturn(5);

        // Act
        Integer count = housingService.count();

        // Assert
        assertEquals(5, count);
        verify(housingDao, times(1)).getCount();
    }
}

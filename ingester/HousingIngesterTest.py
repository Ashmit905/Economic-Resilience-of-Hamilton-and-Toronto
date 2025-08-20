import unittest
from unittest.mock import patch, MagicMock
from HousingIngester import HousingIngester 

class TestHousingIngester(unittest.TestCase):

    @patch('HousingIngester.pymysql.connect')
    def setUp(self, mock_connect):
        self.mock_connection = MagicMock()
        self.mock_cursor = MagicMock()
        self.mock_connection.cursor.return_value = self.mock_cursor
        mock_connect.return_value = self.mock_connection
        
        self.ingester = HousingIngester()

    def test_fetch_url(self):
        expected_housing_url = 'https://cis-data-service.socs.uoguelph.ca/data/housing_starts_completions'
        expected_employment_url = 'https://cis-data-service.socs.uoguelph.ca/data/labour_market'
        self.assertEqual(self.ingester.fetch_url(1), expected_housing_url)
        self.assertEqual(self.ingester.fetch_url(2), expected_employment_url)

    @patch('HousingIngester.requests.get')  
    def test_fetch_housing_data(self, mock_get):
        mock_response = MagicMock()
        mock_response.status_code = 200
        mock_response.json.return_value = [{"id": 1, "CMA": "Toronto", "Year": 2023, "Month": "January", "Total_starts": 100, "Total_complete": 80}]
        mock_get.return_value = mock_response
        
        data = self.ingester.fetch_housing_data()
        self.assertIsNotNone(data)
        self.assertEqual(len(data), 1)
        self.assertEqual(data[0]['CMA'], "Toronto")

    @patch('HousingIngester.requests.get')  
    def test_fetch_employment_data(self, mock_get):
        # Mock a successful response for employment data
        mock_response = MagicMock()
        mock_response.status_code = 200
        mock_response.json.return_value = [
            {
                "id": 1,
                "cma": 4,
                "DURUNEMP": 10
            },
            {
                "id": 2,
                "cma": 5,
                "DURUNEMP": 15
            }
        ]
        mock_get.return_value = mock_response
        
        data = self.ingester.fetch_employment_data()
        self.assertIsNotNone(data)
        self.assertEqual(len(data), 2)
        self.assertEqual(data[0]['cma'], 4)
        self.assertEqual(data[1]['DURUNEMP'], 15)

    def test_transform_housing_data(self):
        sample_data = [
            {
                "id": 1, "CMA": "Toronto", "Year": 2023, "Month": "January", "Total_starts": 100, "Total_complete": 80, 
                "Singles_starts": 50, "Semis_starts": 20, "Row_starts": 10, "Apt_Other_starts": 20, "Singles_complete": 40, 
                "Semis_complete": 20, "Row_complete": 10, "Apt_other_complete": 10
            },
            {
                "id": 2, "CMA": "Hamilton", "Year": 2023, "Month": "February", "Total_starts": 150, "Total_complete": 120,
                "Singles_starts": 70, "Semis_starts": 30, "Row_starts": 20, "Apt_Other_starts": 30, "Singles_complete": 60,
                "Semis_complete": 30, "Row_complete": 20, "Apt_other_complete": 10
            },
            {
                "id": 3, "CMA": "Vancouver", "Year": 2023, "Month": "March", "Total_starts": 200, "Total_complete": 180,
                "Singles_starts": 100, "Semis_starts": 50, "Row_starts": 20, "Apt_Other_starts": 30, "Singles_complete": 80,
                "Semis_complete": 50, "Row_complete": 20, "Apt_other_complete": 30
            }
        ]
        transformed = self.ingester.transform_housing_data(sample_data)
        
        # Expect only Hamilton and Toronto in the final transformed data
        self.assertEqual(len(transformed), 2)
        self.assertEqual(transformed[0]['cma'], "Toronto")
        self.assertEqual(transformed[1]['cma'], "Hamilton")

    def test_transform_employment_data(self):
        sample_employment_data = [
            {
                "id": 1,
                "cma": 4,
                "DURUNEMP": 10
            },
            {
                "id": 2,
                "cma": 5,
                "DURUNEMP": 15
            },
            {
                "id": 3,
                "cma": 6,
                "DURUNEMP": 20
            }
        ]
        transformed = self.ingester.transform_employment_data(sample_employment_data)
        
        self.assertEqual(len(transformed), 2)
        self.assertEqual(transformed[0]['cma'], 4)
        self.assertEqual(transformed[0]['duration_unemployment'], 10)
        self.assertEqual(transformed[1]['cma'], 5)
        self.assertEqual(transformed[1]['duration_unemployment'], 15)

    def test_insert_housing_data(self):
        transformed_data = [
            {
                "id": 1, "year": 2023, "month": "January", "cma": "Toronto", "total_starts": 100, 
                "total_complete": 80, "singles_starts": 50, "semis_starts": 20, "row_starts": 10, 
                "apt_other_starts": 20, "singles_complete": 40, "semis_complete": 20, 
                "row_complete": 10, "apt_other_complete": 10
            },
        ]
        
        self.ingester.insert_housing_data(transformed_data)
        self.mock_cursor.execute.assert_called_once()

    def test_insert_employment_data(self):
        transformed_employment_data = [
            {
                "id": 1,
                "cma": 4,
                "duration_unemployment": 10
            }
        ]
        
        self.ingester.insert_employment_data(transformed_employment_data)
        self.mock_cursor.execute.assert_called_once()

if __name__ == '__main__':
    unittest.main()

import os
import pymysql
import requests
import datetime
import json
from enum import Enum

class CMA(Enum):
    HAMILTON = "Hamilton"
    TORONTO = "Toronto"

class CMA_ID(Enum):
    HAMILTON_ID = 4
    TORONTO_ID = 5

class HousingIngester:
    def __init__(self):
        self.api_key = 'VIQlXJvkiLKow7z_mtFcuUHRoxl6Kl_eZAE01gbYvhPRwlcyjLFbSQ'
        self.db_config = {
                "host": os.getenv("DB_HOST", "database"),
                "port": int(os.getenv("DB_PORT", 3306)),
                "user": os.getenv("DB_USER", "root"),
                "password": os.getenv("DB_PASSWORD", "pwd"),
                "database": os.getenv("DB_DATABASE", "template_db")
            }
        self.db = pymysql.connect(**self.db_config).cursor()

    def fetch_url(self, url_type):
        today = datetime.date.today().strftime("%Y-%m-%d")
        return f'https://cis-data-service.socs.uoguelph.ca/data/housing_starts_completions' if url_type == 1 else f'https://cis-data-service.socs.uoguelph.ca/data/labour_market'

    def fetch_housing_data(self):
        headers = {'Apikey': self.api_key}
        url = self.fetch_url(1)
        response = requests.get(url, headers = headers)

        if response.status_code == 200:
            return response.json()
        else:
            print(f"Error fetching data: {response.status_code}")
            return None
    
    def fetch_employment_data(self):
        headers = {'Apikey': self.api_key}
        url = self.fetch_url(2)
        response = requests.get(url, headers = headers)

        if response.status_code == 200:
            return response.json()
        else:
            print(f"Error fetching data: {response.status_code}")
            return None
        
    def safe_int(self, value):
        if not value:
            return 0
        if isinstance(value, int):
            return value

        # Otherwise, treat it like a string
        return int(str(value).replace(",", ""))
        
    def transform_housing_data(self, data):
        transformed = []

        for item in data:
            if item["CMA"] in [CMA.HAMILTON.value, CMA.TORONTO.value]:
                transformed.append({
                    "id": item["id"],
                    "year": self.safe_int(item["Year"]),
                    "month": (item["Month"]),
                    "cma": item["CMA"],
                    "total_starts": self.safe_int(item["Total_starts"]),
                    "total_complete": self.safe_int(item["Total_complete"]),
                    "singles_starts": self.safe_int(item["Singles_starts"]),
                    "semis_starts": self.safe_int(item["Semis_starts"]),
                    "row_starts": self.safe_int(item["Row_starts"]),
                    "apt_other_starts": self.safe_int(item["Apt_Other_starts"]),
                    "singles_complete": self.safe_int(item["Singles_complete"]),
                    "semis_complete": self.safe_int(item["Semis_complete"]),
                    "row_complete": self.safe_int(item["Row_complete"]),
                    "apt_other_complete": self.safe_int(item["Apt_other_complete"])
                })
          
        return transformed
    
    def transform_employment_data(self, data):
        transformed = []

        for item in data:
            if "cma" not in item or not item["cma"]:
                continue
            if item["cma"] in [CMA_ID.TORONTO_ID.value, CMA_ID.HAMILTON_ID.value]:
                transformed.append({
                    "id": item["id"],
                    "cma": item["cma"],
                    "duration_unemployment": self.safe_int(item["DURUNEMP"]),
                })
        
        return transformed

    def insert_housing_data(self, transformed_data):
        try:
            for item in transformed_data:
                self.db.execute(
                    "INSERT INTO housing (id, year, month, cma, total_starts, total_complete, singles_starts, semis_starts, row_starts, apt_other_starts, singles_complete, semis_complete, row_complete, apt_other_complete) VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", 
                    (
                        item["id"], item["year"], item["month"], item["cma"], item["total_starts"], item["total_complete"],
                        item["singles_starts"], item["semis_starts"], item["row_starts"], item["apt_other_starts"],
                        item["singles_complete"], item["semis_complete"], item["row_complete"], item["apt_other_complete"]
                     )
                )
            self.db.commit()
        
        except Exception as e:
            print(f"Error inserting data: {e}")    

    def insert_employment_data(self, transformed_data):
        try:
            for item in transformed_data:
                self.db.execute(
                    "INSERT INTO employment (id, cma, duration_unemployment) VALUES (%s, %s, %s)", 
                    (item["id"], item["cma"], item["duration_unemployment"])
                )
            self.db.commit()
        
        except Exception as e:
            print(f"Error inserting data: {e}")
 
    def run_housing_ingestion(self):
        housing_data = self.fetch_housing_data()
        if housing_data:
            transformed = self.transform_housing_data(housing_data)
            self.insert_housing_data(transformed)
            print(f"Transformed housing data: {json.dumps(transformed, indent=2)}")

    def run_employment_ingestion(self):
        employment_data = self.fetch_employment_data()
        if employment_data:
            transformed = self.transform_employment_data(employment_data)
            self.insert_employment_data(transformed)
            print(f"Transformed employment data: {json.dumps(transformed, indent=2)}")
    
    def run(self):
        self.run_housing_ingestion()
        self.run_employment_ingestion()

        if self.db:
            self.db.close()
        if self.db:
            self.db.close()
        print("Ingestion completion")

if __name__ == "__main__":
    ingester = HousingIngester()
    ingester.run()


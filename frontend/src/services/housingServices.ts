// import { Housing } from "../types/housing";

// const API_URL = '/api/rentingDetails';
// console.log('API_URL: ', API_URL);

// export const getAllHousings = async (): Promise<Housing[]> => {
//     console.log('Fetching all housing data from:', `/api/rentingDetails/all`);  // Log the full endpoint
//     try {
//         fetch("/api/rentingDetails/all")
//             .then(response => response.text())
//             .then(text => {
//                 console.log("API Response:", text);
//                 return JSON.parse(text);
//             })
//             .then(data => {
//                 console.log("Parsed JSON:", data);
//             })
//             .catch(error => {
//                 console.error("Error fetching housing data:", error);
//             });


//         const response = await fetch(`/api/rentingDetails/all`);
//         if (!response.ok) {
//             throw new Error(`HTTP error! Status: ${response.status}`);
//         }
//         const data = await response.json();
//         console.log('API response:', data); // Log the response data
//         return data;
//     } catch (error) {
//         console.error('Error fetching housing data:', error);
//         return [];
//     }

// }

import { Housing } from "../types/housing";

const simulatedData: Housing[] = [
  {
    id: 1,
    year: 2023,
    month: 1,
    cma: "Hamilton",
    singles_starts: 50,
    semis_starts: 30,
    row_starts: 10,
    apt_Other_starts: 10,
    total_starts: 100,
    singles_complete: 40,
    semis_complete: 25,
    row_complete: 8,
    apt_other_complete: 7,
    total_complete: 80,
  },
  {
    id: 2,
    year: 2023,
    month: 1,
    cma: "Toronto",
    singles_starts: 120,
    semis_starts: 40,
    row_starts: 20,
    apt_Other_starts: 40,
    total_starts: 200,
    singles_complete: 110,
    semis_complete: 35,
    row_complete: 18,
    apt_other_complete: 30,
    total_complete: 180,
  },
  {
    id: 3,
    year: 2023,
    month: 2,
    cma: "Hamilton",
    singles_starts: 60,
    semis_starts: 35,
    row_starts: 10,
    apt_Other_starts: 15,
    total_starts: 110,
    singles_complete: 50,
    semis_complete: 30,
    row_complete: 9,
    apt_other_complete: 10,
    total_complete: 90,
  },
  {
    id: 4,
    year: 2023,
    month: 2,
    cma: "Toronto",
    singles_starts: 130,
    semis_starts: 45,
    row_starts: 25,
    apt_Other_starts: 40,
    total_starts: 210,
    singles_complete: 120,
    semis_complete: 40,
    row_complete: 22,
    apt_other_complete: 35,
    total_complete: 190,
  },
  {
    id: 5,
    year: 2023,
    month: 3,
    cma: "Hamilton",
    singles_starts: 70,
    semis_starts: 40,
    row_starts: 10,
    apt_Other_starts: 15,
    total_starts: 120,
    singles_complete: 60,
    semis_complete: 35,
    row_complete: 8,
    apt_other_complete: 12,
    total_complete: 100,
  },
  {
    id: 6,
    year: 2023,
    month: 3,
    cma: "Toronto",
    singles_starts: 140,
    semis_starts: 50,
    row_starts: 30,
    apt_Other_starts: 50,
    total_starts: 220,
    singles_complete: 130,
    semis_complete: 45,
    row_complete: 28,
    apt_other_complete: 45,
    total_complete: 200,
  },
  {
    id: 7,
    year: 2023,
    month: 4,
    cma: "Hamilton",
    singles_starts: 62,
    semis_starts: 37,
    row_starts: 12,
    apt_Other_starts: 15,
    total_starts: 120,
    singles_complete: 48,
    semis_complete: 32,
    row_complete: 8,
    apt_other_complete: 6,
    total_complete: 90
  },
  {
    id: 8,
    year: 2023,
    month: 4,
    cma: "Toronto",
    singles_starts: 135,
    semis_starts: 46,
    row_starts: 22,
    apt_Other_starts: 58,
    total_starts: 249,
    singles_complete: 118,
    semis_complete: 45,
    row_complete: 20,
    apt_other_complete: 43,
    total_complete: 191
  },
  {
    id: 9,
    year: 2023,
    month: 5,
    cma: "Hamilton",
    singles_starts: 63,
    semis_starts: 41,
    row_starts: 10,
    apt_Other_starts: 19,
    total_starts: 133,
    singles_complete: 58,
    semis_complete: 35,
    row_complete: 8,
    apt_other_complete: 6,
    total_complete: 106
  },
  {
    id: 10,
    year: 2023,
    month: 5,
    cma: "Toronto",
    singles_starts: 143,
    semis_starts: 45,
    row_starts: 21,
    apt_Other_starts: 64,
    total_starts: 246,
    singles_complete: 126,
    semis_complete: 49,
    row_complete: 19,
    apt_other_complete: 48,
    total_complete: 209
  },
  {
    id: 11,
    year: 2023,
    month: 6,
    cma: "Hamilton",
    singles_starts: 60,
    semis_starts: 38,
    row_starts: 10,
    apt_Other_starts: 16,
    total_starts: 146,
    singles_complete: 62,
    semis_complete: 38,
    row_complete: 6,
    apt_other_complete: 14,
    total_complete: 108
  },
  {
    id: 12,
    year: 2023,
    month: 6,
    cma: "Toronto",
    singles_starts: 148,
    semis_starts: 47,
    row_starts: 20,
    apt_Other_starts: 67,
    total_starts: 265,
    singles_complete: 126,
    semis_complete: 54,
    row_complete: 17,
    apt_other_complete: 50,
    total_complete: 218
  },
  {
    id: 13,
    year: 2023,
    month: 7,
    cma: "Hamilton",
    singles_starts: 62,
    semis_starts: 37,
    row_starts: 10,
    apt_Other_starts: 15,
    total_starts: 162,
    singles_complete: 69,
    semis_complete: 43,
    row_complete: 7,
    apt_other_complete: 22,
    total_complete: 121
  },
  {
    id: 14,
    year: 2023,
    month: 7,
    cma: "Toronto",
    singles_starts: 157,
    semis_starts: 46,
    row_starts: 21,
    apt_Other_starts: 74,
    total_starts: 270,
    singles_complete: 127,
    semis_complete: 51,
    row_complete: 19,
    apt_other_complete: 57,
    total_complete: 234
  },
  {
    id: 15,
    year: 2023,
    month: 8,
    cma: "Hamilton",
    singles_starts: 69,
    semis_starts: 42,
    row_starts: 12,
    apt_Other_starts: 17,
    total_starts: 153,
    singles_complete: 64,
    semis_complete: 45,
    row_complete: 6,
    apt_other_complete: 26,
    total_complete: 134
  },
  {
    id: 16,
    year: 2023,
    month: 8,
    cma: "Toronto",
    singles_starts: 162,
    semis_starts: 51,
    row_starts: 22,
    apt_Other_starts: 71,
    total_starts: 262,
    singles_complete: 135,
    semis_complete: 51,
    row_complete: 22,
    apt_other_complete: 54,
    total_complete: 238
  },
  {
    id: 17,
    year: 2023,
    month: 9,
    cma: "Hamilton",
    singles_starts: 76,
    semis_starts: 47,
    row_starts: 14,
    apt_Other_starts: 21,
    total_starts: 170,
    singles_complete: 63,
    semis_complete: 43,
    row_complete: 7,
    apt_other_complete: 28,
    total_complete: 139
  },
  {
    id: 18,
    year: 2023,
    month: 9,
    cma: "Toronto",
    singles_starts: 161,
    semis_starts: 55,
    row_starts: 25,
    apt_Other_starts: 76,
    total_starts: 279,
    singles_complete: 145,
    semis_complete: 51,
    row_complete: 23,
    apt_other_complete: 56,
    total_complete: 245
  },
  {
    id: 19,
    year: 2023,
    month: 10,
    cma: "Hamilton",
    singles_starts: 85,
    semis_starts: 51,
    row_starts: 17,
    apt_Other_starts: 26,
    total_starts: 179,
    singles_complete: 71,
    semis_complete: 41,
    row_complete: 6,
    apt_other_complete: 25,
    total_complete: 136
  },
  {
    id: 20,
    year: 2023,
    month: 10,
    cma: "Toronto",
    singles_starts: 169,
    semis_starts: 59,
    row_starts: 28,
    apt_Other_starts: 71,
    total_starts: 288,
    singles_complete: 143,
    semis_complete: 56,
    row_complete: 24,
    apt_other_complete: 58,
    total_complete: 237
  },
  {
    id: 21,
    year: 2023,
    month: 11,
    cma: "Hamilton",
    singles_starts: 85,
    semis_starts: 51,
    row_starts: 16,
    apt_Other_starts: 33,
    total_starts: 186,
    singles_complete: 73,
    semis_complete: 44,
    row_complete: 9,
    apt_other_complete: 30,
    total_complete: 149
  },
  {
    id: 22,
    year: 2023,
    month: 11,
    cma: "Toronto",
    singles_starts: 177,
    semis_starts: 57,
    row_starts: 26,
    apt_Other_starts: 67,
    total_starts: 287,
    singles_complete: 146,
    semis_complete: 56,
    row_complete: 22,
    apt_other_complete: 53,
    total_complete: 256
  },
  {
    id: 23,
    year: 2023,
    month: 12,
    cma: "Hamilton",
    singles_starts: 81,
    semis_starts: 50,
    row_starts: 14,
    apt_Other_starts: 31,
    total_starts: 180,
    singles_complete: 75,
    semis_complete: 44,
    row_complete: 7,
    apt_other_complete: 28,
    total_complete: 143
  },
  {
    id: 24,
    year: 2023,
    month: 12,
    cma: "Toronto",
    singles_starts: 178,
    semis_starts: 56,
    row_starts: 27,
    apt_Other_starts: 66,
    total_starts: 286,
    singles_complete: 154,
    semis_complete: 58,
    row_complete: 24,
    apt_other_complete: 56,
    total_complete: 253
  }
];

export const getAllHousings = async (): Promise<Housing[]> => {
  console.log("Returning simulated housing data:", simulatedData);
  // wait for 1 second to simulate network latency
  return new Promise((resolve) => {
    setTimeout(() => resolve(simulatedData), 1000);
  });
};

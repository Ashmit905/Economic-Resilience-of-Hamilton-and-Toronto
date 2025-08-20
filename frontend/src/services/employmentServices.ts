import { Employment } from "../types/employment";

const simulatedData: Employment[] = [
  {
    id: 1,
    cma: "Toronto",
    duration_unemployment: 10
  },
  {
    id: 2,
    cma: "Toronto",
    duration_unemployment: 15
  },
  {
    id: 3,
    cma: "Toronto",
    duration_unemployment: 12
  },
  {
    id: 4,
    cma: "Toronto",
    duration_unemployment: 25
  },
  {
    id: 5,
    cma: "Toronto",
    duration_unemployment: 5
  },
  {
    id: 6,
    cma: "Hamilton",
    duration_unemployment: 50
  },
  {
    id: 7,
    cma: "Hamilton",
    duration_unemployment: 2
  },
  {
    id: 8,
    cma: "Hamilton",
    duration_unemployment: 1
  },
  {
    id: 9,
    cma: "Hamilton",
    duration_unemployment: 25
  },
  {
    id: 10,
    cma: "Hamilton",
    duration_unemployment: 15
  },
];

export const getAllEmployments = async (): Promise<Employment[]> => {
  console.log("Returning simulated Employment data:", simulatedData);
  // wait for 1 second to simulate network latency
  return new Promise((resolve) => {
    setTimeout(() => resolve(simulatedData), 1000);
  });
};

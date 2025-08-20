import { Students } from "../types/students";

const simulatedData: Students[] = [
  {
    id: 1,
    cma: "Toronto",
    schooln: 10,
    durunemp: 1,
  },
  {
    id: 2,
    cma: "Hamilton",
    schooln: 8,
    durunemp: 2,
  },
  {
    id: 3,
    cma: "Toronto",
    schooln: 10,
    durunemp: 2,
  },
  {
    id: 4,
    cma: "Hamilton",
    schooln: 10,
    durunemp: 3,
  },
  {
    id: 5,
    cma: "Toronto",
    schooln: 10,
    durunemp: 1,
  },
  {
    id: 6,
    cma: "Toronto",
    schooln: 11,
    durunemp: 2,
  },
  {
    id: 7,
    cma: "Hamilton",
    schooln: 11,
    durunemp: 1,
  },
  {
    id: 8,
    cma: "Toronto",
    schooln: 12,
    durunemp: 3,
  },
  {
    id: 9,
    cma: "Hamilton",
    schooln: 12,
    durunemp: 2,
  },
  {
    id: 10,
    cma: "Toronto",
    schooln: 13,
    durunemp: 4,
  },
  {
    id: 11,
    cma: "Hamilton",
    schooln: 13,
    durunemp: 2,
  },
  
];

export const getAllStudents = async (): Promise<Students[]> => {
  console.log("Returning simulated Employment data:", simulatedData);
  // wait for 1 second to simulate network latency
  return new Promise((resolve) => {
    setTimeout(() => resolve(simulatedData), 500);
  });
};

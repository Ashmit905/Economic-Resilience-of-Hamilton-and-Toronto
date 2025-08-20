import React, { useEffect, useState } from "react";
import { Students } from "../types/students";
import { getAllStudents } from "../services/studentServices";
import {
  BarChart,
  Bar,
  XAxis,
  YAxis,
  CartesianGrid,
  Tooltip,
  Legend,
} from "recharts";

const StudentList: React.FC = () => {
  const [students, setStudents] = useState<Students[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    const fetchStudents = async () => {
      try {
        const data = await getAllStudents();
        if (Array.isArray(data)) {
          setStudents(data);
        } else {
          setError("Failed to fetch student data");
        }
      } finally {
        setLoading(false);
      }
    };

    fetchStudents();
  }, []);

  if (loading) return <p>Loading...</p>;
  if (error) return <p>{error}</p>;

  return (
    <div style={{ marginTop: "30px", textAlign: "center" }}>
      <h1>Student Employment Data</h1>

      <div style={{ display: "flex", justifyContent: "center" }}>
        <BarChart width={600} height={400} data={students}>
          <CartesianGrid strokeDasharray="3 3" />
          <XAxis dataKey="schooln" label={{ value: "Status", position: "insideBottom", dy: 10 }} />
          <YAxis label={{ value: "Duration", angle: -90, position: "insideLeft" }} />
          <Tooltip />
          <Legend />
          <Bar dataKey="durunemp" fill="#8884d8" name="Hamilton" />
          <Bar dataKey="durunemp" fill="#82ca9d" name="Toronto" />
        </BarChart>
      </div>
    </div>
  );
};

export default StudentList;

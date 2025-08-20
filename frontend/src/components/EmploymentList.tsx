import React, { useEffect, useState } from "react";
import { Employment } from "../types/employment";
import { getAllEmployments } from "../services/employmentServices";
import {
  LineChart,
  Line,
  XAxis,
  YAxis,
  CartesianGrid,
  Tooltip,
  Legend,
  ScatterChart,
  Scatter,
} from "recharts";

interface ScatterPlotProps {
  hamiltonData: Employment[];
  torontoData: Employment[];
  startKey: keyof Employment;
  completeKey: keyof Employment;
  title: string;
}
const ScatterPlot: React.FC<ScatterPlotProps> = ({ hamiltonData, torontoData, startKey, completeKey, title }) => {
  return (
    <div style={{ textAlign: "center", gridColumn: "span 2" }}>
      <h2>{title}</h2>
      <ScatterChart width={500} height={300}>
        <CartesianGrid strokeDasharray="3 3" />
        <XAxis type="number" dataKey={startKey as string} name={`Duration of Unemployment`} />
        <YAxis type="number" dataKey={completeKey as string} name={`ID`} />
        <Tooltip cursor={{ strokeDasharray: "3 3" }} />
        <Legend />
        <Scatter name="Hamilton" data={hamiltonData} fill="#8884d8" />
        <Scatter name="Toronto" data={torontoData} fill="#82ca9d" />
      </ScatterChart>
    </div>
  );
};

interface TrendChartProps {
  data: Employment[];
  xKey: keyof Employment;
  startKey: keyof Employment;
  title: string;
}
const TrendChart: React.FC<TrendChartProps> = ({ data, xKey, startKey, title }) => {
  return (
    <div style={{ textAlign: "center" }}>
      <h2>{title}</h2>
      <LineChart width={500} height={300} data={data}>
        <CartesianGrid strokeDasharray="3 3" />
        <XAxis dataKey={xKey as string} />
        <YAxis />
        <Tooltip />
        <Legend />
        <Line type="monotone" dataKey={startKey as string} stroke="#8884d8" />
      </LineChart>
    </div>
  );
};

const EmploymentList: React.FC = () => {
  const [employment, setEmployment] = useState<Employment[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  const [selectedLocation, setSelectedLocation] = useState<"Hamilton" | "Toronto" | "Both">("Both");

  useEffect(() => {
    const fetchEmployment = async () => {
      try {
        const data = await getAllEmployments();
        if (Array.isArray(data)) {
          setEmployment(data);
        } else {
          setError("Failed to fetch employment");
        }
      } finally {
        setLoading(false);
      }
    };

    fetchEmployment();
  }, []);

  if (loading) return <p>Loading...</p>;
  if (error) return <p>{error}</p>;

  const hamiltonData = employment.filter((emp) => emp.cma === "Hamilton");
  const torontoData = employment.filter((emp) => emp.cma === "Toronto");

  return (
    <div style={{ marginTop: "30px", textAlign: "center" }}>
      <h1>Employment Data</h1>

      <div style={{ marginBottom: "20px" }}>
        <label>
          Select Location (Only Affects Trend Chart):
          <select
            value={selectedLocation}
            onChange={(e) => setSelectedLocation(e.target.value as "Hamilton" | "Toronto" | "Both")}
            style={{ marginLeft: "10px", padding: "5px" }}
          >
            <option value="Both">Both</option>
            <option value="Hamilton">Hamilton</option>
            <option value="Toronto">Toronto</option>
          </select>
        </label>
      </div>

      <div style={{
        display: "grid",
        gridTemplateColumns: "1fr 1fr",
        gap: "20px",
        justifyContent: "center"
      }}>
        
        <ScatterPlot
          hamiltonData={hamiltonData}
          torontoData={torontoData}
          startKey="duration_unemployment"
          completeKey="id"
          title="Employment Scatter Plot (Hamilton vs Toronto)"
        />

        {(selectedLocation === "Both" || selectedLocation === "Hamilton") && (
          <TrendChart
            data={hamiltonData}
            startKey="duration_unemployment"
            xKey="id"
            title="Hamilton Employment Trends"
          />
        )}

        {(selectedLocation === "Both" || selectedLocation === "Toronto") && (
          <TrendChart
            data={torontoData}
            startKey="duration_unemployment"
            xKey="id"
            title="Toronto Employment Trends"
          />
        )}

      </div>
    </div>
  );
};

export default EmploymentList;

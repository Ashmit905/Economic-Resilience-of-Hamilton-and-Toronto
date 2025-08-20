import React from "react";
import { Housing } from "../types/housing";
import { LineChart, Line, XAxis, YAxis, CartesianGrid, Tooltip, Legend } from "recharts";

interface CategorySectionProps {
  categoryTitle: string;
  startKey: keyof Housing;
  completeKey: keyof Housing;
  housings: Housing[];
}

const CategorySection: React.FC<CategorySectionProps> = ({ categoryTitle, startKey, completeKey, housings }) => {
  return (
    <div style={{ marginBottom: "50px" }}>
      <h1 style={{ textAlign: "center" }}>{categoryTitle} Housing</h1>

      <div style={{ textAlign: "center", overflowX: "auto" }}>
        <h2>Housing Data</h2>
        <table style={{ margin: "0 auto", borderCollapse: "collapse", width: "90%" }}>
          <thead>
            <tr>
              <th>Month</th>
              <th>CMA</th>
              <th>{startKey}</th>
              <th>{completeKey}</th>
            </tr>
          </thead>
          <tbody>
            {housings.map((housing) => (
              <tr key={housing.id}>
                <td>{housing.month}</td>
                <td>{housing.cma}</td>
                <td>{housing[startKey]}</td>
                <td>{housing[completeKey]}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>

      <div style={{ textAlign: "center" }}>
        <h2>{categoryTitle} Trends</h2>
        <LineChart width={500} height={300} data={housings}>
          <CartesianGrid strokeDasharray="3 3" />
          <XAxis dataKey="month" />
          <YAxis />
          <Tooltip />
          <Legend />
          <Line type="monotone" dataKey={startKey} stroke="#8884d8" />
          <Line type="monotone" dataKey={completeKey} stroke="#82ca9d" />
        </LineChart>
      </div>
    </div>
  );
};

export default CategorySection;

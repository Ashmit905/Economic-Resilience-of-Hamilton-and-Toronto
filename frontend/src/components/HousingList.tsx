import React, { useEffect, useState } from "react";
import { Housing } from "../types/housing";
import { getAllHousings } from "../services/housingServices";
import CategorySection from "./CategorySection";

const HousingList: React.FC = () => {
  const [housings, setHousings] = useState<Housing[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  const [selectedLocation, setSelectedLocation] = useState<"Hamilton" | "Toronto" | "Both">("Both");
  const [selectedType, setSelectedType] = useState<"Total" | "Singles" | "Semis" | "Row" | "Apt Other">("Total");

  useEffect(() => {
    const fetchHousings = async () => {
      try {
        const data = await getAllHousings();
        if (Array.isArray(data)) {
          setHousings(data);
        } else {
          setError("Failed to fetch housings");
        }
      } finally {
        setLoading(false);
      }
    };

    fetchHousings();
  }, []);

  if (loading) return <p>Loading...</p>;
  if (error) return <p>{error}</p>;

  const filteredData = housings.filter((housing) => {
    if (selectedLocation === "Both") return true;
    return housing.cma === selectedLocation;
  });

  const housingTypes: Record<string, { startKey: keyof Housing; completeKey: keyof Housing }> = {
    Total: { startKey: "total_starts", completeKey: "total_complete" },
    Singles: { startKey: "singles_starts", completeKey: "singles_complete" },
    Semis: { startKey: "semis_starts", completeKey: "semis_complete" },
    Row: { startKey: "row_starts", completeKey: "row_complete" },
    "Apt Other": { startKey: "apt_Other_starts", completeKey: "apt_other_complete" },
  };

  const { startKey, completeKey } = housingTypes[selectedType];

  return (
    <div style={{ marginTop: "30px", textAlign: "center" }}>
      <h1>Housing Market Trends</h1>

      <div style={{ marginBottom: "20px" }}>
        <label>
          Select Location:
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

        <label style={{ marginLeft: "20px" }}>
          Select Housing Type:
          <select
            value={selectedType}
            onChange={(e) => setSelectedType(e.target.value as "Total" | "Singles" | "Semis" | "Row" | "Apt Other")}
            style={{ marginLeft: "10px", padding: "5px" }}
          >
            <option value="Total">Total</option>
            <option value="Singles">Singles</option>
            <option value="Semis">Semis</option>
            <option value="Row">Row</option>
            <option value="Apt Other">Apt Other</option>
          </select>
        </label>
      </div>

      <div style={{ display: "flex", justifyContent: "center", gap: "30px", flexWrap: "wrap" }}>
        {selectedLocation === "Both" || selectedLocation === "Hamilton" ? (
          <div style={{ flex: "1 1 45%" }}>
            <CategorySection
              categoryTitle={`${selectedType} - Hamilton`}
              startKey={startKey}
              completeKey={completeKey}
              housings={filteredData.filter((housing) => housing.cma === "Hamilton")}
            />
          </div>
        ) : null}

        {selectedLocation === "Both" || selectedLocation === "Toronto" ? (
          <div style={{ flex: "1 1 45%" }}>
            <CategorySection
              categoryTitle={`${selectedType} - Toronto`}
              startKey={startKey}
              completeKey={completeKey}
              housings={filteredData.filter((housing) => housing.cma === "Toronto")}
            />
          </div>
        ) : null}
      </div>
    </div>
  );
};

export default HousingList;

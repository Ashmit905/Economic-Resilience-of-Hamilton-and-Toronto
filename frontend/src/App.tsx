import React from "react";
import { Routes, Route, useNavigate } from "react-router-dom";
import HousingList from "./components/HousingList";
import EmploymentList from "./components/EmploymentList";
import StudentList from "./components/StudentList";

const Home: React.FC = () => {
  const navigate = useNavigate();

  return (
    <div className="App" style={{ textAlign: "center", padding: "50px" }}>
      <h1>Economic Resilience of Hamilton and Toronto</h1>
      <p>Analyzing the relationship between housing starts and completions.</p>

      <nav>
        <button onClick={() => navigate("/housing")} style={{ margin: "10px", padding: "10px", fontSize: "16px" }}>
          Housing Data
        </button>
        <button onClick={() => navigate("/employment")} style={{ margin: "10px", padding: "10px", fontSize: "16px" }}>
          Employment Data
        </button>
        <button onClick={() => navigate("/student")} style={{ margin: "10px", padding: "10px", fontSize: "16px" }}>
          Student Status Data
        </button>
      </nav>

      <p>Select a category above to view data.</p>
    </div>
  );
};

const App: React.FC = () => {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/housing" element={<HousingList />} />
      <Route path="/employment" element={<EmploymentList />} />
      <Route path="/student" element={<StudentList />} />
    </Routes>
  );
};

export default App;

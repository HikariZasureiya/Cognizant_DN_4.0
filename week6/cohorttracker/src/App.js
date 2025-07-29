import logo from "./logo.svg";
import "./App.css";
import { CohortsData } from "./Cohort";
import CohortDetails from "./CohortDetails";

function App() {
  return (
    <div
      style={{
        width: "100vw",
        height: "100vh",
      }}
    >
      <h1>Cohorts Details</h1>
      <div
        style={{
          width: "100%",
          height: "100%",
        }}
      >
        <div>
          {CohortsData.map((cohort) => (
            <CohortDetails cohort={cohort} />
          ))}
        </div>
      </div>
    </div>
  );
}

export default App;

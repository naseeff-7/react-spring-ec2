import React, { useEffect, useState } from "react";

function App() {
  const [data, setData] = useState({ message: "" });

  useEffect(() => {
    fetch("/api/hello")
      .then((res) => res.json())
      .then((data) => setData(data))
      .catch((err) => console.error(err));
  }, []);

  return (
    <div style={{ textAlign: "center", marginTop: "50px" }}>
      <h1>React + Spring Boot</h1>

      <h2 style={{ color: "blue" }}>{data.message || "Waiting for API..."}</h2>
    </div>
  );
}

export default App;

import logo from "./logo.svg";
import "./App.css";
import { ListOfPlayers } from "./components/ListofPlayers";
import { Scorebelow70 } from "./components/Scorebelow70";
import { ListofindianPlayers } from "./components/ListofindianPlayers";
import { useState, useEffect } from "react";

const players = [
  { name: "Jack", score: 50, country: "Foreign" },
  { name: "Michael", score: 70, country: "Foreign" },
  { name: "John", score: 40, country: "Foreign" },
  { name: "Ann", score: 61, country: "Foreign" },
  { name: "Elisabeth", score: 61, country: "Foreign" },
  { name: "Sachin", score: 95, country: "India" },
  { name: "Dhoni", score: 100, country: "India" },
  { name: "Virat", score: 84, country: "India" },
  { name: "Jadeja", score: 64, country: "India" },
  { name: "Raina", score: 75, country: "India" },
  { name: "Rohit", score: 80, country: "India" },
];

const T20Players = ['First Player', 'Second Player', 'Third Player'];
const RanjiTrophyPlayers = ['Fourth Player', 'Fifth Player', 'Sixth Player'];
const IndianPlayers = [...T20Players, ...RanjiTrophyPlayers];


export function oddPlayers([first, , third, , fifth]) {
  return (
    <ul>
      <li>first: {first?.name}</li>
      <li>third: {third?.name}</li>
      <li>fifth: {fifth?.name}</li>
    </ul>
  );
}

export function evenPlayers([, tw, , fr, , si]) {
  return (
    <ul>
      <li>second: {tw?.name}</li>
      <li>fourth: {fr?.name}</li>
      <li>sixth: {si?.name}</li>
    </ul>
  );
}

function App() {
  let flag = false;
  const [indianPlayers, setIndianPlayers] = useState([]);
  useEffect(() => {
    const indpl = players.filter((player) => player.country === "India");
    setIndianPlayers(indpl);
  }, []);

  if (flag === true) {
    return (
      <div>
        <ListOfPlayers players={players} />
        <hr />
        <h1>List of Players having score below 70</h1>
        <Scorebelow70 players={players} />
      </div>
    );
  } else {
    return (
      <div>
        <div>
          <h2>Odd Team Players</h2>
          {oddPlayers(indianPlayers)}
          <hr />
          <h2>Even Team Players</h2>
          {evenPlayers(indianPlayers)}
        </div>
        <hr/>
        <div>
          <h1>List of Indian Players Merged</h1>
          <ListofindianPlayers players={IndianPlayers} />
        </div>
      </div>
    );
  }
}

export default App;

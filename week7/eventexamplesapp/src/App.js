import logo from "./logo.svg";
import "./App.css";
import { useState , useRef } from "react";

function App() {
  const [value, setValue] = useState(0);
  const mon = useRef();
  const curr = useRef();
  return (
    <div>
      <div>{value}</div>

      <button
        onClick={()=>{
          setValue(value+1);
          alert("Hello from website")
        }}    
      >increment</button>
      <button 
        onClick={()=>{
          setValue(value-1);
          alert("Hello from website")
        }}
        >decrement</button>
      <button
        onClick={()=>{
          alert("Welcome from website")
        }}
      >say Welcome</button>
      <button
        onClick={()=>{
          alert("Clicked >.<")
        }}
      >Click on me</button>
      <h1 style={{ color: "green" }}>Currency Convertor!!!</h1>
        <div
          style={{
            display: "flex",
            marginBottom: "10px"
          }}
        >
          <h3>Amount: </h3>
          <textarea ref={mon}></textarea>
        </div>
        <div
          style={{
            display: "flex",
          }}
        >
          <h3>Currency: </h3>
          <textarea ref={curr}></textarea>
        </div>
        <button 
          onClick={()=>{
            var number = 0;
            console.log(mon.current.value , curr.current.value)
            try{
              number = Number(mon.current.value);
              if(curr.current.value !== "Euro"){
                alert("Invalid input")
              }
              else{
                alert(`${number} inr in euros is ${number*0.01}`)
              }
            }

            catch(e){
              alert("Invalid input")
            }
          }}
        >Submit</button>

    </div>
  );
}

export default App;

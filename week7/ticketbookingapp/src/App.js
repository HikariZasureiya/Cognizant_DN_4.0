import { useState , useEffect} from 'react';
import logo from './logo.svg';
import './App.css';



function LoginButton(props){
  return(
    <div>
      <button onClick={()=>{props.loginorout(props.loggedin)}}>Login</button>
    </div>
  );
}

function LogoutButton(props){
  return(
    <div>
      <button onClick={()=>{props.loginorout(props.loggedin)}}>Logout</button>
    </div>
  );
}

function App() {
  const [loggedin , setloggedin] = useState(false);
  const loginorout = (loggedin)=>{
    setloggedin(!loggedin);
  }
  
  return (
    <div
      style={{
        height:"100vh",
        width:"100vw",
        display: "flex",
        alignItems:"center",
        justifyContent:"center",
      }}
    >
      {
        loggedin ? <div>
          <h1>Welcome back</h1>
          <LogoutButton loginorout={loginorout} loggedin={loggedin}/>
        </div>
        :
        <div>
          <h1>Please sign up</h1>
          < LoginButton loginorout={loginorout} loggedin={loggedin}/>
        </div>
      }
    </div>
  );
}

export default App;

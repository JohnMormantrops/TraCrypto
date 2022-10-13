import React from 'react';
import './App.css';
import DisplayCrypto from './components/DisplayCrypto';
import { useEffect, useState } from "react";
import { getAllCryptos } from "./services/getCryptoApi";
import {Portfolio} from './components/Portfolio'
import {Login} from './components/login'


export const UserContext = React.createContext();


function App() {
 
  const [crypto, setCrypto] = useState([]);
  const [myCrypto, setMyCrypto] = useState([]);
  const [jwt, setMyJwt] = useState("");

  useEffect( ()=>{

      const fetchData =async() =>{
          console.log("fetching all")
          const response = await getAllCryptos(jwt)
          setCrypto(response);
      }
      jwt && fetchData();
  }, [jwt])
 
  console.log("heres jwt");
  console.log(jwt);


  return (
    <div className="App">
      <h1>TraCrypto</h1>
      
      <Login setMyCrypto={setMyCrypto} setMyJwt={setMyJwt} />

      
      <div className="mainDisplay">
        <DisplayCrypto crypto={crypto} myCrypto={myCrypto} setMyCrypto={setMyCrypto} jwt={jwt} />
        <Portfolio crypto={crypto} myCrypto={myCrypto} setMyCrypto={setMyCrypto} jwt={jwt} />
      </div>
    
    </div>
  );
}

export default App;

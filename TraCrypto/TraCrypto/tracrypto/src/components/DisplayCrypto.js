
import { useEffect, useState } from "react";
import { getAllCryptos } from "../services/getCryptoApi";
import axios from 'axios';
import { Adjuster } from "./Adjuster";


export default function({crypto, myCrypto ,setMyCrypto, jwt}){
    
    const [rank, setRank] = useState(0)

    return (
        <div>
              <b>Crypto Currencies</b>
            <table>
                <thead>
                    <tr>
                        <th>Rank</th>
                        <th>Name</th>
                        <th>Ticker</th>
                        <th>price</th>
                    </tr>
                </thead>
            {crypto?.map((currCrypto, key) =>( 
                <tbody>
                    <tr >
                        <td>{currCrypto.rank}</td>
                        <td>{currCrypto.name}</td>
                        <td>{currCrypto.ticker}</td>
                        <td>{currCrypto.price}</td>
                        <td><button onClick={()=> setRank(currCrypto.rank)}>Add to Portfolio </button></td>
                        
                    </tr>
                
                    {rank==currCrypto.rank&&
                    <Adjuster myCrypto={myCrypto} setMyCrypto={setMyCrypto} currCrypto={currCrypto} jwt={jwt}/>
                    }
                </tbody>
           ))} 
         </table>
        </div>
    )
}
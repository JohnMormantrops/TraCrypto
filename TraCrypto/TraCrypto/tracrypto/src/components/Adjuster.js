
import { useEffect, useState } from "react";
import {UpdateMyCryptoList} from '../services/UpdateMyCryptoList'

export const Adjuster=({myCrypto, setMyCrypto, currCrypto, jwt})=>{

    console.log("In the adjuster")
    console.log(myCrypto)
    console.log(currCrypto)
    const [amount, setAmount] = useState(0);




    const clickHandler = async()=>{
        console.log("Update crypto Handler")
        console.log(amount)
        const obj = {
            crypto : currCrypto.name,
            amount : Number(amount)
        }
        let crypt = myCrypto.filter(e => e.crypto!==currCrypto.name)


        setMyCrypto(await UpdateMyCryptoList(jwt, [...crypt, obj]))
        
    }

    return (
        <tr>
            <td>Adding..</td>
            <td><input 
                placeholder="Enter amount"
                type="number" 
                onChange={(e)=> {setAmount(e.target.value)}}
                />
            </td>
            <td>{currCrypto.ticker}   </td>
            <td></td>
            <td><button onClick={clickHandler}>confirm</button></td>
        </tr>
    )
}
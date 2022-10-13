import { UpdateMyCryptoList } from "../services/UpdateMyCryptoList";
import { TotalDisplay } from "./TotalDisplay";

export const Portfolio=({crypto, myCrypto, setMyCrypto, jwt})=>{

    const handleRemove =async(cryptName)=>{
       let crypt = myCrypto.filter(e => e.crypto!==cryptName);
       setMyCrypto(await UpdateMyCryptoList(jwt, crypt))
    }

    return (
        <div className="portfolio">
           
            <b>Portfolio</b>
             <TotalDisplay />
            <table>
                <thead>
                    <tr>
                        <th>Rank</th>
                        <th>Name</th>
                        <th>Ticker</th>
                        <th>Price</th>
                        <th>Owned</th>
                        <th>Value</th>
                    </tr>
                </thead>
            {crypto.length > 0 && myCrypto.map((currCrypto, key)=>{              
                let thisCrypto = crypto.filter(c => c.name === currCrypto.crypto)[0]
                return (  
                    <tbody>
                        <tr>
                            <td>#{thisCrypto.rank}</td>
                            <td>{thisCrypto.name}</td>  
                            <td>{thisCrypto.ticker}</td>  
                            <td>{thisCrypto.price}</td>  
                            <td>{currCrypto.amount}</td>  
                            <td>${thisCrypto.price
                                .substring(1)
                                .replace(',','')
                                *currCrypto.amount
                                .toFixed(2)}
                            </td>  
                            <td><button onClick={() =>{handleRemove(thisCrypto.name)}}>remove</button></td>
                        </tr>
                    </tbody>)
                })
            }
            </table>
        </div>
    );

}


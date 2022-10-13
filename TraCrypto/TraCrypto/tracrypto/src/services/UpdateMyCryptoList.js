
import axios from "axios";

export const UpdateMyCryptoList=async(jwt, myCryptoList)=>{
    console.log("Update function")
    console.log(myCryptoList)

    const result = await axios.put("http://localhost:8093/api/crypto/addcrypto", myCryptoList, {
        headers : {
            Authorization: "Bearer " + jwt
        }        
    });
    console.log("result");
    console.log(result.data.myCryptoList);
    return result.data.myCryptoList;
}


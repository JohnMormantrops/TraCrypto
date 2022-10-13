import axios from 'axios';

export const getAllCryptos= async (jwt)=>{
    console.log("getting data")

    const res =  await axios.get("http://localhost:8093/api/crypto/crypto", {
        headers : {
            Authorization: "Bearer " + jwt
        }

    });
    return res.data;
}


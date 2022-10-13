
import axios from "axios";

export const loginRequest=async(user)=>{
    console.log("SIGNING IN: " + user)

    const res = await axios.post("http://localhost:8093/api/auth/signin", user);
    //console.log(res.data.accessToken)
    //console.log(res.data.myCryptoList)
    return ([res.data.myCryptoList, res.data.accessToken])
}
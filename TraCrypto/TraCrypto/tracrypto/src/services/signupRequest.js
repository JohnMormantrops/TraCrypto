
import axios from "axios";

export const signUpRequest=async(user)=>{
    console.log("SIGNING UP: " + user)

    const res = await axios.post("http://localhost:8093/api/auth/signup", user);
    console.log(res)
    return res;
}



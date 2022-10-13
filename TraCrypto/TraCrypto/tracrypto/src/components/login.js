import { useState } from "react";
import { signUpRequest } from "../services/signupRequest";
import { loginRequest } from "../services/loginRequest";

//username: 'Username', email: 'user@gmial.com', password: 'user123'


export const Login =({setMyCrypto, setMyJwt})=>{
    
    const [newUser, setNewUser] = useState({
        username: "",
        email: "",
        password: "",
        roles: ["user", "mod"]
    })

    const [user, setUser] = useState({
        username: "",
        password: ""
    })

    const handleSignup = async(e)=>{
        e.preventDefault();
        signUpRequest(newUser);
    }

    
    const handleLogin = async(e)=>{
        e.preventDefault();
        let [myCrypto, jwt] = await loginRequest(user);
        console.log("retrieved")
        console.log(myCrypto)
        setMyCrypto(myCrypto)
        setMyJwt(jwt);
    }

    return (
        <>SIGNUP

        <form onSubmit={handleSignup}>
            <input 
             type="text"
             value={newUser.username} 
             placeholder="username"
             onChange={(e) => setNewUser(prevState => ({
                ...prevState, username: e.target.value
             }))}
             />
            <input
             type="email"
             value={newUser.email} 
             placeholder="email"
             onChange={(e) => setNewUser(prevState => ({
                ...prevState, email: e.target.value
             }))}
            />
            <input
             type="password"
             value={newUser.password} 
             placeholder="password"
             onChange={(e) => setNewUser(prevState => ({
                ...prevState, password: e.target.value
             }))}
            />
            <button type="submit">submit</button>
        </form>

        LOGIN

        <form onSubmit={handleLogin}>
            <input 
             type="text"
             value={user.username} 
             placeholder="username"
             onChange={(e) => setUser(prevState => ({
                ...prevState, username: e.target.value
             }))}
             
             />
            <input
             type="password"
             value={user.password} 
             placeholder="password"
             onChange={(e) => setUser(prevState => ({
                ...prevState, password: e.target.value
             }))}
            />
            <button type="submit">submit</button>
        </form>
        </>
    )
}
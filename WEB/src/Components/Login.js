import React from 'react';
import './Login.css';
import { useHistory } from "react-router-dom";

const Login = () => {
    let history = useHistory();
    return(
        <>
             <div className="container-L">
             <p>Life is an event. Make it memorable.</p>
      <div className="forms-container ">
        <div className="signin-signup form2">
          <form action="#" className="sign-in-form">
            <h2 className="title-L">Sign in</h2>
            <div className="input-field-l">
              <i className="fas fa-user"></i>
              <input type="text" placeholder="Username" />
            </div>
            <div className="input-field-l">
              <i className="fas fa-lock"></i>
              <input type="password" placeholder="Password" />
            </div>
            <div className="btn-login">
            <input type="submit" value="Login" className="btn solid" onClick={() => { history.push("/Dashboard") }}/>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <input type="submit" value="Signup" className="btn solid" onClick={() => { history.push("/Signup") }}/>
            </div>
          </form>
          </div>
        </div>
        <div className="panels-container">
        <div className="panel left-panel">
          <div className="content">
          <h1 className="font-h1">EVENT BOOKING SYSTEM</h1>
            <h3>Life is an event. Make it memorable.</h3>
          </div>
        </div>
      </div>
      </div>
        </>
    );
}
export default Login;
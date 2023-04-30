import React,{ Component }  from 'react';
import './Signup.css';
export default class Signup extends Component {
    Signuphandler(user) {
        console.log("Login");
        if (user === "Login") { 
          this.props.history.push({
            pathname: "./",
          });
        }
      }
      render() {
    return(
        <>
             <div className="container-L">
             <p>Life is an event. Make it memorable.</p>
      <div className="forms-container">
        <div className="signin-signup">
          <form action="#" className="sign-in-form form1">
            <h2 className="title-L">Sign up</h2>
            <div className="input-field">
              <i className="fas fa-user"></i>
              <input type="text" placeholder="Name" />
            </div>
            <div className="input-field">
              <i className="fas fa-user"></i>
              <input type="number" placeholder="Phone Number" />
            </div>
            <div className="input-field">
              <i className="fas fa-user"></i>
              <input type="text" placeholder="E-mail" />
            </div><div className="input-field">
              <i className="fas fa-user"></i>
              <input type="text" placeholder="Username" />
            </div>
            <div className="input-field">
              <i className="fas fa-lock"></i>
              <input type="password" placeholder="Password" />
            </div>
            <div className="btn-login">
            <input type="submit" value="Submit" className="btn solid" onClick={() => this.Signuphandler("Login")} />
            </div>
          </form>
          </div>
        </div>
        <div className="panels-container">
        <div className="panel left-panel">
          <div className="content">
          <h1 className="font-h1">EVENT MANAGEMENT SYSTEM</h1>
            <h3>Life is an event. Make it memorable.</h3>
          </div>
        </div>
      </div>
      </div>
        </>
    );
}
}

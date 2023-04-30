import "./App.css";
import React, { useState } from 'react';
import { BrowserRouter as Router } from "react-router-dom";
import { Suspense } from "react";
import { BrowserRouter } from "react-router-dom";
import { Route, Link } from "react-router-dom";
import Login from "./Components/Login";
import Signup from "./Components/Signup";
import Footer from "./Components/Footer";
import Sidebar from "./Components/Sidebar";
import Dashboard from "./Components/Dashboard";
import Total_Booking from "./Components/Total_Booking";
import Customer_Details from "./Components/Customer_Details";
import Booking from "./Components/Booking";
import MasterData from "./Components/MasterData";
import ViewcustomerDetails from "./Components/ViewCustomerDetails";
import CalenderPage from "./Components/CalenderPage";
import MyModal from "./Components/ShowModule";

function App() {
  const [login, setLogin] =useState(true);
  if (login===false){
      return (
          <Suspense fallback={null}>
          <Router>
              <div>
             
                  <Route path="/" exact component={Login} />
                  <Route path="/Signup" exact component={Signup} />
  
              </div>
  
          </Router>
          
          </Suspense>
  
      );

  }
  else
  {
      return (
          <Suspense fallback={null}>
          <Router>
              <div>
              
              <Route path="/" exact component={Login} />
              <Route path="/Signup" exact component={Signup} />
              <Sidebar />
              <Route path="/Dashboard" exact component={Dashboard} />
              <Route path="/Total_Booking" exact component={Total_Booking} />
              <Route path="/Customer_Details" exact component={Customer_Details} />
              <Route path="/Booking" exact component={Booking} />
              <Route path="/MasterData" exact component={MasterData} />
              <Route path="/ViewcustomerDetails/:id" exact component ={ViewcustomerDetails}/>
              <Route path="/MyModal/:id" exact component ={MyModal}/>
              <Route path="/CalenderPage" exact component ={CalenderPage}/>
 
              </div>
  
          </Router>
          <Footer />
          </Suspense>
  
      );
  }
 
}



        

       




export default App;

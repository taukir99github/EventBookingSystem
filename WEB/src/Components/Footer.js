import React, { Component } from "react";

export default class Footer extends Component {
  render() {
    return (
      <div className="footer">
        <p
          style={{
            padding: "20px",
            marginLeft:"5rem",
            backgroundColor: "#F3F1F5",
            fontSize: "12px",
            textAlign:"center"
          }}
        >
          All Rights Reserved. EVENT BOOKING SYSTEM © 2022 | SIMPANA © V1.0.0
          <br />
          contact@SIMPANA.com
        </p>
      </div>
    );
  }
}

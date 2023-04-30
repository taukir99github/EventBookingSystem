import React, { useState, useEffect } from "react";
import "./ShowModel.css";
import { Link } from "react-router-dom";
import axios from "axios";
import { useHistory } from "react-router-dom";

const MyModal = (props) => {
    const { idParameter, parameter_Key } = props.location.state.parameter;

    let history = useHistory();

    const [user, setUser] = useState({
        idParameter: idParameter,
        parameter_Key: parameter_Key,
        parameter_Value: "",
    });

    let name, value;

    const handleChange = (e) => {
        name = e.target.name;
        value = e.target.value;

        setUser({ ...user, [name]: value });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log("submit");
        console.log(user);
        axios
            .put("http://127.0.0.1:8081/parameterController/updateParameter", user)
            .then((response) => {
                console.log("response", response);
                if (response.status === 200) {
                    history.push({
                        pathname: "../MasterData",
                    });
                }
            });
    };

    return (
        <>
            <Link to="/MasterData">
                <div className="modal-wrapper" />
            </Link>
            <div className="modal-container">
                <h2 className="h2_Parameter">Parameters</h2>
                <br />
                <div>
                    <div
                        style={{
                            display: "flex",
                            height: "4rem",
                            justifyContent: "space-between",
                        }}
                    >
                        <p className="p_Parameter">Parameter :</p>
                        <p className="p_Parameter" style={{ marginLeft: "0.5rem" }}>
                            {parameter_Key}
                        </p>
                    </div>
                    <div
                        style={{
                            display: "flex",
                            height: "4rem",
                            justifyContent: "space-between",
                        }}
                    >
                        <p className="p_Parameter">Value :</p>
                        <input
                            type="text"
                            style={{ height: "2rem", marginTop: "12px", width: "6rem" }}
                            name="parameter_Value"
                            value={user.parameter_Value}
                            onChange={handleChange}
                        />
                    </div>
                </div>
                <div className="Control_Botton">
                    <button className="Profile_s_btn" onClick={handleSubmit}>
                        Save
                    </button>
                    <Link to="/MasterData">
                        <button className="Profile_s_btn">Cancle</button>
                    </Link>
                </div>
            </div>
        </>
    );
};
export default MyModal;

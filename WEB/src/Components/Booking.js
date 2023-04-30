import React, { useState } from 'react';
import './Booking.css';
import { Button, Form, Label, Input } from "reactstrap";
import { Container, Row, Col, FormGroup } from "reactstrap";
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select, { SelectChangeEvent } from '@mui/material/Select';
import Box from "@material-ui/core/Box";
import TextField from "@material-ui/core/TextField";
import { TextFieldsOutlined } from '@mui/icons-material';
import axios from 'axios';
import { useHistory } from "react-router-dom";
// import MenuItem from '@material-ui/core/MenuItem';

export default function Booking() {

    let history = useHistory();
    const [room, setRoom] = useState(0);
    const [room1, setRoom1] = useState(0);
    const [hall, setHall] = useState(0);
    const [hall1, setHall1] = useState(0);
    const [hide, setHide] = useState(false);
    const [hidehall, setHidehall] = useState(false);
    const [user, setUser] = useState({
        firstName: "", lastName: "", age: "", gender: "", phoneNo: "", addharNo: "", email: "", startDate: "", endDate: "",
        startTime: "", endTime: "", totalGuest: "", veg: "", non_veg: "", idCustomer: "", quantity: "", room: "", room1: "", hall: "",
        hall1: "", roomType: "", room1Type: "", hallType: "", hall1Type: "", eventType: ""
    });
    const [listOfCustomerIdAndRooms, setListOfCustomerIdAndRooms] = useState([]);

    let name, value;

    const handleChange = (e) => {
        name = e.target.name;
        value = e.target.value;

        setUser({ ...user, [name]: value });
    }
    const checkboxHandler = (e) => {
        if (e.target.checked === true) {
            setUser({
                [e.target.value]: 1,
            });
        }
    }


    const handleSubmit = (e) => {
        e.preventDefault();
        console.log("submit")
        console.log("gender", user.gender)
        console.log(user.room_type);
        axios.post('http://127.0.0.1:8081/customerController/createCustomer', user)
            .then((response) => {
                console.log("response", response);
                if (response.status === 200) {
                    history.push({
                        pathname: "./Dashboard",
                    });
                }
            })
    }

    // Getting No of room ,Room Type together with CustomerId
    const customerAndQuantityAndTypeHandler = (props, quantity, type) => {
        const index = listOfCustomerIdAndRooms.findIndex(
            (data) => data.idCustomer === props.idCustomer
        );
        console.log("props", props);
        if (index === -1) {
            const data = {
                idCustomer: props.idCustomer,
                quantity: quantity,
                type: type,
            };
            listOfCustomerIdAndRooms.push(data);
        } else {
            listOfCustomerIdAndRooms[index].quantity = quantity;
            listOfCustomerIdAndRooms[index].type = type;
        }
        console.log("check", listOfCustomerIdAndRooms);
    };




    const handlerSetRoom = (e) => {
        e.preventDefault();
        setHide(true)
    }
    const handlerSetHall = (e) => {
        e.preventDefault();
        setHidehall(true)
    }
    const handlerSetRoomHide = (e) => {
        e.preventDefault();
        setHide(false)
    }
    const handlerSetHallHide = (e) => {
        e.preventDefault();
        setHidehall(false)
    }
    const gender = [
        {
            label: 'Select',
        },
        {
            value: 'Male',
            label: 'Male',
        },
        {
            value: 'Female',
            label: 'Female',
        },
    ];
    const type = [
        {
            label: 'Select',
        },
        {
            value: 'AC',
            label: 'AC',
        },
        {
            value: 'Non-AC',
            label: 'Non-AC',
        },
    ];
    return (
        <>
            <Form className="Booking_main">
                <h2 className="Booking_heading">Customer Details</h2>
                <div className="content1">
                    <Row className="flex">
                        <div className="left">
                            <Label style={{ marginLeft: "2rem" }}>First Name:</Label>&nbsp; &nbsp;&nbsp; &nbsp;
                            <input className="mui_input" name="firstName" value={user.firstName} onChange={handleChange}></input>
                        </div><div className="right">
                            <Label>Last Name:</Label>&nbsp; &nbsp;&nbsp; &nbsp;
                            <input className="mui_input" name="lastName" value={user.lastName} onChange={handleChange}></input>
                        </div>
                    </Row>
                    <br />
                    <Row className="flex">
                        <div className="left">
                            <Label style={{ marginLeft: "5.4rem" }}>Age:</Label>&nbsp; &nbsp;&nbsp; &nbsp;
                            <input className="mui_input" name="age" value={user.age} onChange={handleChange}></input>
                        </div><div className="right">
                            <Label style={{ marginLeft: "1.5rem" }}>Gender:</Label>&nbsp; &nbsp;&nbsp; &nbsp;
                            {/* <input className="mui_input" name="gender" value={user.gender} onChange={handleChange}></input> */}
                            <select className='gender_select' name="gender" value={user.gender} onChange={handleChange} >
                                {gender.map((option) => (
                                    <option key={option.value} value={option.value}>
                                        {option.label}
                                    </option>
                                ))}
                            </select>
                        </div>
                    </Row>
                    <br />
                    <Row className="flex">
                        <div className="left">
                            <Label >Phone Number:</Label>&nbsp; &nbsp;&nbsp; &nbsp;
                            <input className="mui_input" name="phoneNo" value={user.phoneNo} onChange={handleChange}></input>
                        </div><div className="right">
                            <Label >Addhar No:</Label>&nbsp; &nbsp;&nbsp; &nbsp;
                            <input className="mui_input" name="addharNo" value={user.addharNo} onChange={handleChange}></input>
                        </div>
                    </Row>
                    <br />
                    <Row className="flex">
                        <div className="left">
                            <Label style={{ marginLeft: "4.6rem" }}>Email:</Label>&nbsp; &nbsp;&nbsp; &nbsp;
                            <input type="email" className="mui_input" name="email" value={user.email} onChange={handleChange}></input>
                        </div>
                        <div className="right">
                        </div>
                    </Row>
                </div>
                <h2 className="Booking_heading">Booking Details</h2>
                <div className="content1">
                    <Row className="flex">
                        <div className="left">
                            <Label style={{ marginLeft: "2rem" }}>Start Date:</Label>&nbsp; &nbsp;&nbsp; &nbsp;
                            <input type="date" className="mui_input_date" name="startDate" value={user.startDate} onChange={handleChange}></input>
                        </div>
                        <div className="right">
                            <Label style={{ marginLeft: "0.8rem" }}>End Date:</Label>&nbsp; &nbsp;&nbsp; &nbsp;
                            <input type="date" className="mui_input_date" name="endDate" value={user.endDate} onChange={handleChange}></input>
                        </div>
                    </Row>
                    <br />
                    <Row className="flex">
                        <div className="left">
                            <Label style={{ marginLeft: "1.6rem" }}>Start Time:</Label>&nbsp; &nbsp;&nbsp; &nbsp;
                            <input type="time" className="mui_input_time" name="startTime" value={user.startTime} onChange={handleChange}></input>
                        </div>
                        <div className="right">
                            <Label style={{ marginLeft: "0.4rem" }}>End Time:</Label>&nbsp; &nbsp;&nbsp; &nbsp;
                            <input type="time" className="mui_input_time" name="endTime" value={user.endTime} onChange={handleChange}></input>
                        </div>
                    </Row>
                    <br />
                    <Row className="flex">
                        <div className="left">
                            <Label style={{ marginLeft: "0.8rem" }}>Total Guests:</Label>&nbsp; &nbsp;&nbsp; &nbsp;
                            <input className="mui_input" name="totalGuest" value={user.totalGuest} onChange={handleChange}></input>
                        </div>
                        <div className="right">
                            <Label style={{ marginLeft: "0.16rem" }}>Event Type:</Label>&nbsp; &nbsp;&nbsp; &nbsp;
                            <input type="text" className="mui_input" name="eventType" value={user.eventType} onChange={handleChange}></input>
                        </div>
                    </Row>
                    <br />
                    <br />
                    <Row className="flex">
                        <Label style={{ marginLeft: "2.5rem", marginTop: "7px" }}>Rooms:</Label>&nbsp; &nbsp;&nbsp; &nbsp;
                        <select className='Room_select' name="roomType" value={user.roomType} onChange={handleChange}>
                            {type.map((option) => (
                                <option key={option.value} value={option.value}>
                                    {option.label}
                                </option>
                            ))}
                        </select>
                        <div className='flex inc'>
                            <input className="inc_input" name="room" value={user.room} onChange={handleChange} />
                        </div>
                        <button className="Add_btn" onClick={handlerSetRoom}>+</button>
                    </Row>
                    <br />
                    {
                        hide ?
                            <Row className="flex">
                                <select className='Room_select' name="room1Type" value={user.room1Type} style={{ marginLeft: "8.8rem" }} onChange={handleChange}>
                                    {type.map((option) => (
                                        <option key={option.value} value={option.value}>
                                            {option.label}
                                        </option>
                                    ))}
                                </select>
                                <div className='flex inc'>
                                    <input className="inc_input" name="room1" value={user.room1} onChange={handleChange} />
                                </div>
                                <button className="Cross_btn" onClick={handlerSetRoomHide}>x</button>
                            </Row>
                            : null
                    }
                    <br />
                    <Row className="flex">
                        <Label style={{ marginLeft: "2.5rem" }}>Halls:</Label>&nbsp; &nbsp;&nbsp; &nbsp;
                        <select className='Room_select1' name="hallType" value={user.hallType} onChange={handleChange} >
                            {type.map((option) => (
                                <option key={option.value} value={option.value}>
                                    {option.label}
                                </option>
                            ))}
                        </select>
                        <div className='flex inc'>
                            <input className="inc_input" name="hall" value={user.hall} onChange={handleChange} />
                        </div>
                        <button className="Add_btn" onClick={handlerSetHall}>+</button>
                    </Row> <br />
                    {
                        hidehall ?
                            <Row className="flex">
                                <select className='Room_select1' style={{ marginLeft: "8.8rem" }} name="hall1Type" value={user.hall1Type} onChange={handleChange}>
                                    {type.map((option) => (
                                        <option key={option.value} value={option.value}>
                                            {option.label}
                                        </option>
                                    ))}
                                </select>
                                <div className='flex inc'>
                                    <input className="inc_input" value={user.hall1} name="hall1" onChange={handleChange} />
                                </div>
                                <button className="Cross_btn" onClick={handlerSetHallHide}>x</button>
                            </Row>
                            : null
                    }
                    <br /><br /><br />
                    {/* <Row className="flex">
                        <Label style={{ marginLeft: "2.5rem" }}>Food Choice:</Label>&nbsp; &nbsp;&nbsp; &nbsp;
                    </Row>
                    <br /> */}
                    {/* <Row className="flex">
                        <div className="left">
                            <Label style={{ marginLeft: "5rem" }}>Veg</Label>&nbsp; &nbsp;&nbsp;
                            <input type="checkbox" name="veg" value={user.veg} onChange={checkboxHandler} />
                        </div>
                        <div className="right">
                            <Label style={{ marginLeft: "2.5rem" }}>Non-Veg</Label>&nbsp; &nbsp;&nbsp;
                            <input type="checkbox" name="non_veg" value={user.non_veg} onChange={checkboxHandler} />
                        </div>
                    </Row>
                    <br /> */}
                    <Row className="submit_btn" >
                        <input type="submit" className='s_btn' onClick={handleSubmit} />
                    </Row>
                </div>

            </Form>
        </>
    );
}
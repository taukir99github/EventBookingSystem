import React  from 'react';
import './ViewcustomerDetails.css'
import { Row } from "reactstrap";
import { IoIosPerson } from "react-icons/io";

export default function ViewcustomerDetails(props) {
    const {firstName, lastName, startDate, endDate, room, room1, hall, hall1, addharNo, email, phoneNo, eventType, 
        age,gender,startTime,endTime,totalGuest} = props.location.state.customerD;
    return (
        <div className='View_main'>
            <div className='view_head'>
                <IoIosPerson className='view_icon' />&nbsp; &nbsp;&nbsp; &nbsp;
                <div className='view_head_detail'>
                    <div className='view_name'>{firstName}&nbsp;{lastName} </div>
                    <br />
                    <hr />
                </div>
            </div>
            <div className='view_details'>
                <div>
                    <div className='heading'>Presonal Details : </div> <br />
                    <Row className='Row' style={{ gap: "6rem" }}>
                        <div style={{ display: "flex" }}> <div className='label'>Addhar Number :</div>&nbsp; &nbsp;{addharNo}</div>
                        <div style={{ display: "flex" }}><div className='label'>Phone Number :</div>&nbsp; &nbsp; {phoneNo}</div>
                        <div style={{ display: "flex" }}><div className='label'>Email :</div>&nbsp; &nbsp; {email}</div>
                    </Row><br />
                    <Row className='Row' style={{ gap: "19.5rem" }}>
                        <div style={{ display: "flex" }}><div className='label'>Age :</div>&nbsp; &nbsp; {age}</div>
                        <div style={{ display: "flex" }}><div className='label'>Gender :</div>&nbsp; &nbsp; {gender}</div>
                    </Row>
                </div>
                <br /> <hr /><br/>
                <div>
                    <div className='heading'>Booking Details : </div> <br />
                    <Row className='Row' style={{ gap: "5.5rem" }}>
                        <div style={{ display: "flex" }}> <div className='label'>Start Date :</div>&nbsp; &nbsp;{startDate}</div>
                        <div style={{ display: "flex" }}><div className='label'>End Date :</div>&nbsp; &nbsp; {endDate}</div>
                        <div style={{ display: "flex" }}><div className='label'>Start Time :</div>&nbsp; &nbsp; {startTime}</div>
                        <div style={{ display: "flex" }}><div className='label'>End Time :</div>&nbsp; &nbsp; {endTime}</div>
                    </Row><br />
                    <Row className='Row' style={{ gap: "9rem" }}>
                        <div style={{ display: "flex" }}> <div className='label'>AC Rooms :</div>&nbsp; &nbsp;{room}</div>
                        <div style={{ display: "flex" }}><div className='label'>Non-AC Rooms :</div>&nbsp; &nbsp; {room1}</div>
                        <div style={{ display: "flex" }}><div className='label'>AC Halls :</div>&nbsp; &nbsp; {hall}</div>
                        <div style={{ display: "flex" }}><div className='label'>Non-AC Halls :</div>&nbsp; &nbsp; {hall1}</div>
                    </Row><br />
                    <Row className='Row' style={{ gap: "8.5rem" }}>
                        <div style={{ display: "flex" }}><div className='label'>Total guest :</div>&nbsp; &nbsp; {totalGuest}</div>
                        <div style={{ display: "flex" }}><div className='label'>Event type :</div>&nbsp; &nbsp; {eventType}</div>
                    </Row>
                </div>
            </div>

        </div>
    );
}
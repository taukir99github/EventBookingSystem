import React, { useState, useEffect } from 'react';
import './Dashboard.css';
import { Container, Row, Col, Button } from "reactstrap";
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import axios from 'axios';
export default function Dashboard() {

    const [user, setUser] = useState({
        firstName: "", lastName: "", startDate: "", endDate: "", startTime: "", endTime: "", room: "", room1: "", hall: "",
         hall1: "", room_type: "", room1_type: "", hall_type: "", hall1_type: "", eventType: "",Mdate:""
    });

    const [booking, setBooking] = useState([])

    useEffect(() => {
        async function getBooking() {
            const result = await axios.get('http://127.0.0.1:8081/customerController/getListOfCustomer', user)
            console.log(result.data);
            console.log(result.data[0].Mdate);
            setBooking(result.data);
            
        }
        getBooking();
    }, []);

    
    let count,mdate
    function TodayBooking(){
        // {booking.map((booking) => (
        //     mdate = {booking.Mdate}
        // ))}
        if(user.mdate === date){
            count++;
        }
        return count;
    }
    console.log(count);
    
    var currDate2 = new Date();
    var date = currDate2.getDate()+'-'+(currDate2.getMonth()+1)+'-'+currDate2.getFullYear();

    console.log(date);

    return (
        <>
            <div className="flex column-gap-3rem">
                <div className="dashboard-left">
                    <div className="dashboard_main flex column-gap-1rem ">
                        <div className="data_card">
                            <div className="data_card_title1">Today's Booking</div>
                            <div className="data">4</div>
                            <input className='date' value={date}  readOnly="true" disabled="true"/>
                        </div>
                        <div className="data_card">
                            <div className="data_card_title2">Booking This Week</div>
                            <div className="data">8</div>
                            <input className='date' value={date}  readOnly="true" disabled="true"/>
                        </div>
                    </div>
                    &nbsp;&nbsp;
                    <div className="dashboard_main flex column-gap-1rem ">
                        <div className="data_card">
                            <div className="data_card_title3">Booking This Month</div>
                            <div className="data">23</div>
                            <input className='date' value={date}  readOnly="true" disabled="true"/>
                        </div>
                        <div className="data_card">
                            <div className="data_card_title4">Revenue This Week</div>
                            <div className="data">Rs 100,000</div>
                            <input className='date' value={date}  readOnly="true" disabled="true"/>
                        </div>
                    </div>
                </div>
                <div className='dashboard-right'>
                    <div className="table_card">
                        <div className="table_card_title">Current Boooking Detail's</div>
                        <TableContainer className="bg_d" style={{ boxShadow: 'none' }}>
                            <Table aria-label="collapsible table" className="bg_d" >
                                <TableHead>
                                    <TableRow>
                                        <TableCell align="center" style={{ fontWeight: '600', fontSize: '0.97rem', padding: "13px 1px 13px 1px" }}>Client Name</TableCell>
                                        <TableCell align="center" style={{ fontWeight: '600', fontSize: '0.97rem', padding: "13px 1px 13px 1px" }}>Start Date</TableCell>
                                        <TableCell align="center" style={{ fontWeight: '600', fontSize: '0.97rem', padding: "13px 1px 13px 1px" }}>End Date</TableCell>
                                        <TableCell align="center" style={{ fontWeight: '600', fontSize: '0.97rem', padding: "13px 1px 13px 1px" }}>Start Time</TableCell>
                                        <TableCell align="center" style={{ fontWeight: '600', fontSize: '0.97rem', padding: "13px 1px 13px 1px" }}>End Time</TableCell>
                                        <TableCell align="center" style={{ fontWeight: '600', fontSize: '0.97rem', padding: "13px 1px 13px 1px" }}>No of Halls</TableCell>
                                        <TableCell align="center" style={{ fontWeight: '600', fontSize: '0.97rem', padding: "13px 1px 13px 1px" }}>No of Rooms</TableCell>
                                    </TableRow>
                                </TableHead>
                                <TableBody>
                                    {booking.map((booking) => (
                                        <TableRow>
                                            <TableCell align="center" style={{ padding: "6px 0.5px 10px 1px" }}>{booking.firstName}&nbsp;{booking.lastName}</TableCell>
                                            <TableCell align="center" style={{ padding: "6px 0.5px 10px 1px" }}>{booking.startDate}</TableCell>
                                            <TableCell align="center" style={{ padding: "6px 0.5px 10px 1px" }}>{booking.endDate}</TableCell>
                                            <TableCell align="center" style={{ padding: "6px 0.5px 10px 1px" }}>{booking.startTime}</TableCell>
                                            <TableCell align="center" style={{ padding: "6px 0.5px 10px 1px" }}>{booking.endTime}</TableCell>
                                            <TableCell align="center" style={{ padding: "6px 0.5px 10px 1px" }}>{booking.hall + booking.hall1}</TableCell>
                                            <TableCell align="center" style={{ padding: "6px 0.5px 10px 1px" }}>{booking.room + booking.room1}</TableCell>
                                        </TableRow>
                                    ))}
                                </TableBody>
                            </Table>
                        </TableContainer>
                    </div>
                </div>
            </div>
        </>
    );
}


import React, { useState, useEffect } from 'react';
import './Total_Booking.css';
import { Container, Row, Col, Button } from "reactstrap";
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import axios from 'axios';
import ReactDOM from 'react-dom'
import Scheduler from "react-mui-scheduler"

const events = [
    {
        color: "#f28f6a",
        // createdAt: "2023-02-14T21:22:58.556+00:00",
        // createdBy: "Owner",
        date: "2023-02-03",
        endHour: "00:20:00",
        groupLabel: "Marrage",
        // id: 4,
        label: "Maaz Khan",
        startHour: "10:20:00",
        // user: "MaazKhan"
    },
    {
        // id: "event-2",
        label: "Raza Kashif",
        groupLabel: "Marraige",
        // user: "Raza Kashif",
        color: "#099ce5",
        startHour: "01:00 PM",
        endHour: "07:00 PM",
        startDate: "2023-2-20",
        endDate: "2023-2-21",
        // createdAt: new Date(),
        // createdBy: "Owner"
    }
]

export default function Total_Booking() {
    const [user, setUser] = useState({
        label:"", date:"",end:""
    });
    const [newEvent, setNewEvent] = useState({ title: "", start: "", end: "" })
    const [allEvent, setAllEvent] = useState(events)
    useEffect(() => {
        async function getToTalBooking() {
        const result = await axios.get('http://127.0.0.1:8081/customerController/getListOfCustomersEvents',user)
                console.log("response", result.data);
                setAllEvent(result.data)
                console.log(allEvent.title)
                console.log("hr data :",events)
        }
        getToTalBooking();
    }, []);
    



    const [state] = useState({
        options: {
            transitionMode: "zoom", // or fade
            startWeekOn: "sun",     // or sun
            defaultMode: "month",    // or week | day | timeline
            minWidth: 540,
            maxWidth: 540,
            minHeight: 540,
            maxHeight: 540
        },
        // alertProps: {
        //   open: true,
        //   color: "info",          // info | success | warning | error
        //   severity: "info",       // info | success | warning | error
        //   showActionButton: true,
        //   showNotification: true,
        //   delay: 0
        // },
        toolbarProps: {
            // showSearchBar: true,
            // showSwitchModeButtons: true,
            showDatePicker: true
        }
    })
    
    const handleCellClick = (event, row, day) => {
        // Do something...
    }

    const handleEventClick = (event, item) => {
        // Do something...
    }

    const handleEventsChange = (item) => {
        // Do something...
    }

    const handleAlertCloseButtonClicked = (item) => {
        // Do something...
    }
    return (
        <>
            <div className="total-booking-main">
                <div className="tbooking_table_card">
                    <div className="tbooking_table_card_title">Booking Details</div>
                    <Scheduler
                        locale="en"
                        events={allEvent}
                        legacyStyle={false}
                        options={state?.options}
                        // alertProps={state?.alertProps}
                        toolbarProps={state?.toolbarProps}
                        // onEventsChange={handleEventsChange}
                        // onCellClick={handleCellClick}
                        // onTaskClick={handleEventClick}
                        // onAlertCloseButtonClicked={handleAlertCloseButtonClicked}
                    />
                </div>
            </div>

        </>
    );
}


import React, { useState, useEffect } from 'react';
import './Calender.css';
import { Calendar, globalizeLocalizer } from 'react-big-calendar';
import globalize from 'globalize';
// import { Calendar, dateFnsLocalizer } from 'react-big-calendar'
import format from 'date-fns/format'
import parse from 'date-fns/parse'
import startOfWeek from 'date-fns/startOfWeek'
import getDay from 'date-fns/getDay'
import enUS from 'date-fns/locale/en-US'
import "react-big-calendar/lib/css/react-big-calendar.css";
import "react-datepicker/dist/react-datepicker.css";
import DatePicker from "react-datepicker";
import axios from 'axios';

const locales = {
    "en-US": require("date-fns/locale/en-US")
}
// const localizer = dateFnsLocalizer({
//     format,
//     parse,
//     startOfWeek,
//     getDay,
//     locales,
// })



const localizer = globalizeLocalizer(globalize)

const events = [
    {
        title: "Meeting",
        allDay: true,
        start: new Date(2023, 1, 3),
        end: new Date(2023, 1, 4)

    },
    {
        title: "Vacation",
        start: new Date(2023, 1, 5),
        end: new Date(2023, 1, 10)

    },
    {
        title: "Conference",
        start: new Date(2023, 1, 17),
        end: new Date(2023, 1, 17)


    }
]



export default function CalenderPage() {
    const [user, setUser] = useState({
        title: "", start: "", end: ""
    });
    const [newEvent, setNewEvent] = useState({ title: "", start: "", end: "" })
    const [allEvent, setAllEvent] = useState(events)

    function handleAddEvent() {
        console.log(newEvent.title);
        console.log(newEvent.start);
        console.log(newEvent.end);
        setAllEvent([...allEvent, newEvent])
    }


    useEffect(() => {
        async function getToTalBooking() {
            const result = await axios.get('http://127.0.0.1:8081/customerController/getListOfCustomersEvents', user)
            console.log("response", result.data);
            setAllEvent(result.data)
            console.log(allEvent.title)
            console.log("hr data :", events)
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

    return (
        <React.Fragment>
            <div style={{ marginLeft: "7rem" }}>
                <div className="Calendar_title">Booking Details</div>
                <Calendar
                    localizer={localizer}
                    events={allEvent}
                    showAllEvents={false}
                    options={state?.options}
                    // alertProps={state?.alertProps}
                    toolbarProps={state?.toolbarProps}
                    startAccessor="start"
                    endAccessor="end"
                    style={{ height: 500, margin: "50px" }}
                />
            </div>
        </React.Fragment>
    );
}
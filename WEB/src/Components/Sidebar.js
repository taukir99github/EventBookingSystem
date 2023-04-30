import React, { useState, useEffect } from 'react';
import './index.css';
import { Link } from 'react-router-dom';
import { FaBars } from "react-icons/fa";
import { FaUserShield } from "react-icons/fa";
import { FaIdCardAlt, FaTools } from "react-icons/fa";
import { AiOutlineUnorderedList } from "react-icons/ai";
import { GiHazardSign } from "react-icons/gi";
import { MdNotifications, MdLibraryBooks, MdDashboardCustomize } from "react-icons/md";
import { GrPowerShutdown } from "react-icons/gr";
import IconButton from '@mui/material/IconButton';
import { FaUserCircle } from "react-icons/fa";
import { BsPersonFill, BsFillKeyFill } from "react-icons/bs";
import Tooltip from '@mui/material/Tooltip';
import { RiEyeCloseFill, RiProfileFill } from "react-icons/ri";
import { useHistory } from "react-router-dom";




const Sidebar = () => {
    let history = useHistory();
    const [show, setShow] = useState(false)
    const [drop, setDrop] = useState(false)
    const [drop1, setDrop1] = useState(false)

    return (
        <main className={show ? 'space-toggle' : null}>
            <header className={`header ${show ? 'space-toggle' : null}`}>
                <div className='header-toggle' onClick={() => setShow(!show)}>
                    <i ><FaBars /> &nbsp;EVENT BOOKING SYSTEM</i>
                </div>
                <div className='flex' style={{ paddingTop: '10px' }}>
                    <Link to="/MasterData">
                        <Tooltip title=<p>Rooms & Halls</p> arrow>
                            <IconButton className='top-icon'><BsFillKeyFill style={{ fontSize: "1.6rem" }} /></IconButton>
                        </Tooltip>
                    </Link>
                    <Tooltip title=<p>Notification</p> arrow>
                        <IconButton className='top-icon'><MdNotifications /></IconButton>
                    </Tooltip>
                    
                    <Tooltip title=<p>Profile</p> arrow>
                        <IconButton className='top-icon'><FaUserCircle /></IconButton>
                    </Tooltip>
                    <Link to="/">
                        <Tooltip title=<p>Logout</p> arrow>
                            <IconButton className='top-icon' ><GrPowerShutdown /></IconButton>
                        </Tooltip>
                    </Link>
                </div>

            </header>
            <aside className={`sidebar ${show ? 'show' : null}`}>
                <nav className='nav'>
                    <ul>

                        <div className='nav-list'>

                            <li>
                                <Link to="/Dashboard" className='nav-link'>
                                    <Tooltip title=<p>Dashboard</p> arrow>
                                        <IconButton className='new-logo'><MdDashboardCustomize className='new-logo' /></IconButton>
                                    </Tooltip>
                                    <span className='nav-link-name'> <p>Dashboard</p> </span>
                                </Link>
                            </li>
                            <li>
                                <Link to="/Booking" className='nav-link'>
                                    <Tooltip title=<p>Booking</p> arrow>
                                        <IconButton className='new-logo'><MdLibraryBooks className='new-logo' /></IconButton>
                                    </Tooltip>
                                    <span className='nav-link-name'><p>Booking</p></span>
                                </Link>
                            </li>
                            <li>
                                <Link to="/CalenderPage" className='nav-link '>
                                    <Tooltip title=<p>Total Booking</p> arrow>
                                        <IconButton className='new-logo'><AiOutlineUnorderedList className='new-logo' /></IconButton>
                                    </Tooltip>
                                    <span className='nav-link-name'><p>Total Booking</p></span>
                                </Link>
                            </li>
                            <li>
                                <Link to="/Customer_Details" className='nav-link'>
                                    <Tooltip title=<p>Customer Details</p> arrow>
                                        <IconButton className='new-logo'><BsPersonFill className='new-logo' /></IconButton>
                                    </Tooltip>
                                    <span className='nav-link-name'><p>Customer Details</p></span>
                                </Link>
                            </li>
                        </div>


                    </ul>

                </nav>
            </aside>

            {/* <Dashboard/> */}

        </main>
    );


}

export default Sidebar;
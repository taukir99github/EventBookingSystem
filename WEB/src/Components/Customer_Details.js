import React, { useState, useEffect } from 'react';
import './Customer_Details.css';
import { Container, Row, Col, Button } from "reactstrap";
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import axios from 'axios';
import { Link } from "react-router-dom";

export default function Customer_Details() {
    const [user, setUser] = useState({
        firstName: "", lastName: "", startDate: "", endDate: "", room: "", room1: "", hall: "",addharNo:"",email:"",phoneNo:"",
        hall1: "", eventType: "",idCustomer:""
    });
    const [customerD, setCustomerD] = useState([])
    useEffect(() => {
        async function getToTalCustomerDetail() {
            const result = await axios.get('http://127.0.0.1:8081/customerController/getListOfCustomer', user)
            console.log(result.data);
            setCustomerD(result.data);
        }
        getToTalCustomerDetail();
    }, []);
    return (
        <>
            <div className="Customer_Detail-main">
                <div className="Customer_Detail_table_card">
                    <div className="Customer_Detail_table_card_title">Customer Details</div>
                    <TableContainer component={Paper} style={{ boxShadow: 'none' ,marginTop:"2rem", marginBottom:"2rem"}}>
                        <Table aria-label="collapsible table" >
                            <TableHead>
                                <TableRow>
                                    <TableCell style={{ fontWeight: '600', fontSize: '0.97rem' }}>S.No</TableCell>
                                    <TableCell align="center" style={{ fontWeight: '600', fontSize: '0.97rem' }}>Name</TableCell>
                                    <TableCell align="center" style={{ fontWeight: '600', fontSize: '0.97rem' }}>Addhar Card</TableCell>
                                    <TableCell align="center" style={{ fontWeight: '600', fontSize: '0.97rem' }}>Phone No</TableCell>
                                    <TableCell align="center" style={{ fontWeight: '600', fontSize: '0.97rem' }}>Event Type</TableCell>
                                    <TableCell align="center" style={{ fontWeight: '600', fontSize: '0.97rem' }}>Chech-In</TableCell>
                                    <TableCell align="center" style={{ fontWeight: '600', fontSize: '0.97rem' }}>Chech-Out</TableCell>
                                    <TableCell align="center" style={{ fontWeight: '600', fontSize: '0.97rem' }}>E-Mail</TableCell>
                                    <TableCell align="center" style={{ fontWeight: '600', fontSize: '0.97rem' }}>Halls No</TableCell>
                                    <TableCell align="center" style={{ fontWeight: '600', fontSize: '0.97rem' }}>Room No</TableCell>
                                    <TableCell align="center" style={{ fontWeight: '600', fontSize: '0.97rem' }}>View</TableCell>
                                    <TableCell align="center" style={{ fontWeight: '600', fontSize: '0.97rem' }}>Edit</TableCell>

                                </TableRow>
                            </TableHead>
                            <TableBody>
                                {customerD.map((customerD) => (
                                    <TableRow>
                                    <TableCell align="center" style={{ padding: "6px 0.5px 10px 1px" }}>{customerD.idCustomer}</TableCell>
                                        <TableCell align="center" style={{ padding: "6px 0.5px 10px 1px" }}>{customerD.firstName}&nbsp;{customerD.lastName}</TableCell>
                                        <TableCell align="center" style={{ padding: "6px 0.5px 10px 1px" }}>{customerD.addharNo}</TableCell>
                                        <TableCell align="center" style={{ padding: "6px 0.5px 10px 1px" }}>{customerD.phoneNo}</TableCell>
                                        <TableCell align="center" style={{ padding: "6px 0.5px 10px 1px" }}>{customerD.eventType}</TableCell>
                                        <TableCell align="center" style={{ padding: "6px 0.5px 10px 1px" }}>{customerD.startDate}</TableCell>
                                        <TableCell align="center" style={{ padding: "6px 0.5px 10px 1px" }}>{customerD.endDate}</TableCell>
                                        <TableCell align="center" style={{ padding: "6px 0.5px 10px 1px" }}>{customerD.email}</TableCell>
                                            <TableCell align="center" style={{ padding: "6px 0.5px 10px 1px" }}>{customerD.hall + customerD.hall1}</TableCell>
                                            <TableCell align="center" style={{ padding: "6px 0.5px 10px 1px" }}>{customerD.room + customerD.room1}</TableCell>
                                        <TableCell align="center">
                                        <Link to={{pathname:'/ViewcustomerDetails/${customerD.idCustomer}', state:{customerD}}}>
                                        <Button
                                                className="button-design tbooking_btn"
                                                variant="contained"
                                                style={{ background: "green", color: "#fff" }}
                                            >
                                                View
                                            </Button>
                                        </Link>
                                           
                                        </TableCell>
                                        <TableCell align="center">
                                            <Button
                                                className="button-design tbooking_btn "
                                                variant="contained"
                                                style={{ background: "blue", color: "#fff" }}
                                            >
                                                Edit
                                            </Button>
                                        </TableCell>
                                    </TableRow>
                                ))}
                            </TableBody>
                        </Table>
                    </TableContainer>
                </div>
            </div>

        </>
    );
}


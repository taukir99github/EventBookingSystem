import React, { useState, useEffect }  from 'react';
import './MasterData.css'
import { Container, Row, Col, Button } from "reactstrap";
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import { FiEdit3 } from "react-icons/fi";
import { useHistory } from "react-router-dom";
import axios from 'axios';
import MyModal from "./ShowModule";
import { Link } from "react-router-dom";

export default function MasterData() {

    const [user, setUser] = useState({
        idParameter:"", parameter_Key:"",parameter_Value:""
    });
    
    const [skillshide, setSkillshide] = useState(false);
    const handlerSkills = (e) => {
        e.preventDefault();
        setSkillshide(true);
        
    }
    const handlerSetSkillsHide = (e) => {
        e.preventDefault();
        setSkillshide(false)
    }
    const [parameter, setParameter] = useState([])
    useEffect(() => {
        async function getParameter() {
            const result = await axios.get('http://127.0.0.1:8081/parameterController/getListOfParameter', user)
            console.log(result.data);
            setParameter(result.data);
        }
        getParameter();
    }, []);
    let history = useHistory();

    const [showModal, setShowModal] = useState(false);
    const closeModal = () => setShowModal(false);


    return (
        <div className="MasterData-main">
            <div className="MasterData_card">
                <div className='MasterBoader'>
                    <div className="MasterData_card_title">Rooms & Halls</div>
                    <div className="Master_table_card">
                        <TableContainer className="bg_d" style={{ boxShadow: 'none' }}>
                            <Table aria-label="collapsible table" className="bg_d" >
                                <TableBody>
                                    <TableRow >
                                        <TableCell align="center" style={{ fontWeight: '500', fontSize: '0.97rem', padding: "13px 1px 13px 1px", color: "rgb(6 122 107)", width: "30%"  }}>Parameters</TableCell>
                                        <TableCell align="center" style={{ fontWeight: '500', fontSize: '0.97rem', padding: "13px 1px 13px 1px", color: "rgb(6 122 107)" }}>Value</TableCell>
                                        <TableCell align="center" style={{ fontWeight: '500', fontSize: '0.97rem', padding: "13px 1px 13px 1px", color: "rgb(6 122 107)" }}>Edit</TableCell>
                                    </TableRow>
                                {parameter.map((parameter) => ( 
                                    <TableRow>
                                        <TableCell align="center" style={{ fontWeight: '500', fontSize: '0.97rem', padding: "13px 1px 13px 1px", color: "rgb(6 122 107)" }}>{parameter.parameter_Key}</TableCell>
                                        <TableCell align="center" style={{ fontWeight: '500', fontSize: '0.97rem', padding: "13px 1px 13px 1px", color: "rgb(6 122 107)" }}>{parameter.parameter_Value}</TableCell>
                                        <TableCell align="center" style={{ fontWeight: '500', fontSize: '0.97rem', padding: "13px 1px 13px 1px", color: "rgb(6 122 107)" }}><Link to={{pathname:'/MyModal/${parameter.idParameter}', state:{parameter}}}><FiEdit3 /></Link></TableCell>
                                    </TableRow>
                                    ))}
                                    
                                </TableBody>
                            </Table>
                        </TableContainer>
                       
                        {showModal && <MyModal closeModal={closeModal}/>}
                    </div>
                </div>
            </div>
        </div>
    );
}
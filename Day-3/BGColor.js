import React, { useState } from "react";
import Select from 'react-select';

const BGColor = () => {
    var colors = [
        {
            value: 1,
            label: "red"
        },
        {
            value: 2,
            label: "green"
        },
        {
            value: 3,
            label: "yellow"
        },
        {
            value: 4,
            label: "blue"
        },
        {
            value: 5,
            label: "cyan"
        },
        {
            value: 6,
            label: "violet"
        },
        {
            value: 7,
            label: "orange"
        },
        {
            value: 8,
            label: "skyblue"
        },
        {
            value: 9,
            label: "pink"
        },
        {
            value: 9,
            label: "brown"
        },
    ]



    var [bgcolor, setbgcolor] = useState("");
    const eventChange = (event) => {
        setbgcolor(event.label);
    }

    return (
        <div>
            <style>
                {
                    '.aaa {background-color:' + bgcolor + ';'
                }
            </style>
            <Select options={colors} onChange={eventChange}></Select>
            <center>
                <h1>BG COLOR is {bgcolor}</h1>
            </center>
            <div style={{border:"1px solid black", height:"300px",width:"300px", position:'absolute',left:'40%',top:"20%"}} className="aaa"> 
            
            </div>
        </div>
    )
}

export default BGColor;
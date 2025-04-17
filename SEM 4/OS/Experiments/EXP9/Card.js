import React from "react";
import "./Card.css";

const Card = ({ title, description, image }) => {
    return (
        <div className="card">
            <img src={image} alt={title} />
            <h2>{title}</h2>
            <p>{description}</p>
        </div>
    );
};

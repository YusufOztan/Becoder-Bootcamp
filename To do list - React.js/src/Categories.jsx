import React, { useState } from "react";

const Categories = (props) => {
  const [input, setInput] = useState("");
  return (
    <div className="base">
      <span className="header">Add Categories{" "}</span>
      <input value={input} onChange={(e) => setInput(e.target.value)} />
      <button
        onClick={() => {
          props.onCategoryAddClick(input);
        }}
      >
        Add
      </button>
      <ul>
        {props.categories.map((item, idx) => (
          <li>
            <button onClick={() => props.onCategoryEditClick(idx)}>
              {item.name} 
            </button>
            <button className="del-button" onClick={() => props.onCategoryDelClick(idx)}>Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Categories;

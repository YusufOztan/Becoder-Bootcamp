import React,{useState} from "react";

const StatusList = (props) => {
  const [input, setInput] = useState("");
  return (
    <div className="base">
      <span className="header">Statuslist of {""+props.categoryName+" "}</span>
      <input value={input} onChange={(e) => setInput(e.target.value)} />
      <button
        onClick={() => {
          props.onStatusAddClick(input);
        }}
      > Add
       </button>
      <ul>
        {props.statusList.map((status, statusIdx) => (
          <li 
          key={statusIdx}>{status}
          <button className="del-button" onClick={() => props.onStatusDelClick(statusIdx)}>Delete</button>
          </li>
          
        ))}
      </ul>
    </div>
  );
};

export default StatusList;

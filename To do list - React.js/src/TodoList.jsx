import React,{ useState , appData } from "react";


const TodoList = (props) => {
  const [input, setInput] = useState("");
  const [selectedCategory, setSelectedCategory] = useState("");
  const [selectedFCategory, setSelectedFCategory] = useState("");
  const [selectedNewStatus, setSelectedNewStatus] = useState("");
  const [filteredTodoList, setFilteredTodoList] = useState([]);


  const handleCategoryCombo = (e) => {
    setSelectedCategory(e.target.value);
  }
  
  const handleNewStatusCombo = (e) => {
    setSelectedNewStatus(e.target.value);
    
  };

  const handleFilterCombo = (e) => {
    setSelectedFCategory(e.target.value);
  }

  const handleFilterClick = () => {
    const selectedCategory = selectedFCategory;
    const filteredTodoList = props.todoList.filter(
      (item) => item.categories === selectedCategory
    );
    setFilteredTodoList(filteredTodoList);
  };

  
  return (
    <div className="base">
      <span className="header">Add To-Do{" "}</span>
      <input value={input} onChange={(e) => setInput(e.target.value)} />
      <select value={selectedCategory} onChange={handleCategoryCombo}>
        <option value="">Select a category</option>
        {props.categories &&
          props.categories.map((category, idx) => (
            <option key={idx} value={category.name}>
              {category.name}
            </option>
          ))}
      </select>
      
      <select value={selectedNewStatus} onChange={handleNewStatusCombo}>
        <option value="">Select a status</option>
        {selectedCategory &&
          props.categories
            .find((categories) => categories.name === selectedCategory)
            .statusList.map((status, idx) => (
              <option key={idx} value={status}>
                {status}
              </option>
            ))}
      </select>
      <button
        onClick={() => {
          props.onToDoAddClick(input,selectedCategory,selectedNewStatus);
        }}
      >
        Add
      </button>
      <div className="small-window">
        <select value={selectedFCategory} onChange={handleFilterCombo}>
          <option value="">Select a category</option>
          {props.categories &&
            props.categories.map((category, idx) => (
              <option key={idx} value={category.name}>
                {category.name}
              </option>
            ))}
        </select>
        <button onClick={handleFilterClick}>Filter</button>
        <ul>
          {filteredTodoList.map((item, idx) => (
            <li>
              <span>{item.name + ' '}</span>
              <button onClick={() => props.onTodoEditClick(idx)}>
                {item.categories}
              </button>
              <span>{item.status + ' '}</span>
            </li>
          ))}
        </ul>
      </div>
      <ul className="small-window">
      {props.todoList.map((item, idx) => (
        <li>
          <span>{item.name + ' '}</span>
          <button onClick={() => props.onTodoEditClick(idx)}>
            {item.categories}
          </button>
          <select
            defaultValue={selectedNewStatus}
            onChange={() => handleNewStatusCombo}
          > 
            <option value="">Select a status</option>
            {props.categories.find(category => category.name === props.todoList[idx].categories).statusList.map((status, statusIdx) => (
                <option 
                key={statusIdx} 
                value={status}>
                  {status}
                </option>
              ))}
          </select>
              <button className="del-button" onClick={() => props.onToDoDelClick(idx)}>
                Delete
              </button>
        </li>
        ))}
      </ul>
    
    </div>
  );
};

export default TodoList;

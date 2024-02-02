import { useState } from "react";
import "./App.css";
import TodoList from "./TodoList";
import Categories from "./Categories";
import StatusList from "./StatusList";

const ModalEnum = {
  TodoList: 1,
  Categories: 2,
  StatusList: 3,
};

function App() {
  const [currentModal, setCurrentModal] = useState(ModalEnum.TodoList);
  const [currentTodo, setCurrentTodo] = useState(0);
  const [currentCategory, setCurrentCategory] = useState(0);
  const [currentStatus, setCurrentStatus] = useState(0);
  

  const [appData, setAppData] = useState({
    todoList: [],
    categories: [
      { name: "Home", statusList: ["new", "todo", "in progress", "done"] },
      {
        name: "Garanti-tech",
        statusList: [
          "new",
          "todo",
          "in progress",
          "done",
        ],
      },
      {
        name: "Bootcamp",
        statusList: [
          "new",
          "todo",
          "in progress",
          "done",
        ],
      },
    ],
  });
  const handleModalChange = (index) => setCurrentModal(index);
  

  const handleTodoChange = (index) => {
    setCurrentTodo(index);
    setCurrentModal(ModalEnum.StatusList);
  };

  const handleAddNewToDo = (name,categories,status) => {
    const newTodo = {
      name: name,
      categories: categories,
      status: status,
    };
    
    setAppData({
      ...appData,
      todoList: [...appData.todoList, newTodo],
    });

  };
  
  const handleDeleteToDoByIndex = (idx) => {
    
    const isCancel = !confirm(
      `Are you sure about to delete To Do "${appData.todoList[idx].name}" ? `
    );
    if (isCancel) return;

    const isCategoryUsed = appData.todoList.some(
      (todo) => todo.categories === appData.categories[idx].name
    );
  

    setAppData({
      ...appData,
      todoList: appData.todoList.filter((item, _idx) => idx !== _idx),
    });
  };
  const handleCategoryChange = (index) => {
    setCurrentCategory(index);
    setCurrentModal(ModalEnum.StatusList);
  };
  const handleAddNewCategory = (name) => {
    setAppData({
      ...appData,
      categories: [
        ...appData.categories,
        {
          name: name,
          statusList: [],
        },
      ],
    });
  };
  const handleDeleteCategoryByIndex = (idx) => {
    
    const isCancel = !confirm(
      `Are you sure about to delete category "${appData.categories[idx].name}" ? `
    );
    if (isCancel) return;

    const isCategoryUsed = appData.todoList.some(
      (todo) => todo.categories === appData.categories[idx].name
    );
  
    if (isCategoryUsed) {
      alert(
        `Category "${appData.categories[idx].name}" is in use and cannot be deleted.`
      );
      return;
    }


    setAppData({
      ...appData,
      categories: appData.categories.filter((item, _idx) => idx !== _idx),
    });
  };

  const handleDeleteStatusByIndex = (idx) => {
    
    const isCancel = !confirm(
      `Are you sure about to delete status "${appData.categories[currentCategory].statusList[idx]}" ? `
    );
    if (isCancel) return;

    const categoryIndex = currentCategory;

    const isStatusUsed = appData.todoList.some(
      (todo) => todo.status === appData.categories[currentCategory].statusList[idx]
    );
  
    if (isStatusUsed) {
      alert(
        `Status "${appData.categories[currentCategory].statusList[idx]}" is in use and cannot be deleted.`
      );
      return;
    }
  
    setAppData({
      ...appData,
      categories: appData.categories.map((category, index) => {
        if (index === categoryIndex) {
          return {
            ...category,
            statusList: category.statusList.filter((item, _idx) => idx !== _idx),
          };
        }
        return category;
      })
    });
  };

  const handleAddNewStatus = (name) => {
      const updatedCategory = appData.categories[currentCategory];

      updatedCategory.statusList.push(name);      
      const updatedAppData = {
        ...appData,
        categories: [
          ...appData.categories.slice(0, currentCategory),
          updatedCategory,
          ...appData.categories.slice(currentCategory + 1),
        ],
        
  };
  setAppData(updatedAppData);
  console.log(props.todoList);
  };

  return (
    <div style={{ display: "flex", flexDirection: "column" }}>
      <div style={{ display: "flex", flexDirection: "row" }}>
        <button onClick={() => handleModalChange(ModalEnum.TodoList)}>
          TodoList
        </button>
        <button onClick={() => handleModalChange(ModalEnum.Categories)}>
          Categories
        </button>

      </div>
      <div>
        {currentModal === ModalEnum.TodoList && (
          
          <TodoList 
            todoList={appData.todoList}
            categories={appData.categories}
            onTodoEditClick={handleTodoChange}
            onToDoAddClick={handleAddNewToDo}
            onToDoDelClick={handleDeleteToDoByIndex}
        />)}
        
        {currentModal === ModalEnum.Categories && (
          <Categories
            categories={appData.categories}
            onCategoryEditClick={handleCategoryChange}
            onCategoryAddClick={handleAddNewCategory}
            onCategoryDelClick={handleDeleteCategoryByIndex}
          />
        )}
        {currentModal === ModalEnum.StatusList && (
          <StatusList
            statusList={appData.categories[currentCategory].statusList}
            categoryIndex={currentCategory}
            categoryName={appData.categories[currentCategory].name}
            onStatusDelClick={handleDeleteStatusByIndex}
          />
        )}
      </div>
    </div>
  );
}

export default App;

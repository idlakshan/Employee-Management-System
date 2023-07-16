
import { Route, Routes } from 'react-router-dom';
import './App.css';
import FooterComponent from './components/FooterComponent';
import HeaderComponent from './components/HeaderComponent';
import ListEmployeeComponent from './components/ListEmployeeComponent';
import AddEmployeeComponent from './components/AddEmployeeComponent';

function App() {
  return (
    <div>
         <HeaderComponent/>
        <Routes>
          <Route exact path='/' element={<ListEmployeeComponent/>}/>
          <Route path='/employees' element={<ListEmployeeComponent/>}/>
          <Route path='/add-employee' element={<AddEmployeeComponent/>}/>
          <Route path='/update-employee/:id' element={<AddEmployeeComponent/>}/>
        </Routes>
       <FooterComponent/>

    
      
    </div>
  );
}

export default App;

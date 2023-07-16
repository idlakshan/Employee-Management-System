import React, { useEffect, useState } from 'react'
import EmployeeService from '../services/EmployeeService';
import { Link, useNavigate, useParams } from 'react-router-dom';

const AddEmployeeComponent = () => {

    const [firstName,setFirstName]=useState("");
    const [lastName,setLastName]=useState("");
    const [email,setEmail]=useState("");
    const navigate= useNavigate();

    const{id}=useParams();


    const saveOrUpdateEmployee=(e)=>{
        e.preventDefault();

        const employee={firstName,lastName,email}

        if(id){
            EmployeeService.updateEmployee(id,employee).then((respose)=>{
                navigate("/employees")

            }).catch((error)=>{
                console.log(error)
            })
         
        }else{
            //console.log(employee)
        EmployeeService.createEmployee(employee).then((response)=>{

            console.log(response.data.data)
            navigate("/employees")

        }).catch((error)=>{
            console.log(error)
        })

        }
      
    }

    useEffect(()=>{
      EmployeeService.getEmployeeById(id).then((response)=>{
         setFirstName(response.data.data.firstName)
         setLastName(response.data.data.lastName)
         setEmail(response.data.data.email)

      }).catch((error)=>{
        console.log(error)
      })
    },[])

    const title=()=>{
        if(id){
            return <h2 className='text-center'>Update Employee</h2>
        }else{
            return <h2 className='text-center'>Add Employee</h2>
        }
    }

  return (
    <div>
        <br/>
        <br/>
        <div className='container'>
            <div className='row'>
                  <div className='card col-md-6 offset-md-3'>
                       {
                        title()
                       }
                        <div className='card-body'>
                            <form>
                                 <div className='form-group mb-2'>
                                    <label className='form-label'>First Name : </label>
                                    <input type='text'
                                    placeholder='Enter First Name'
                                    name='firstName'
                                    className='form-control'
                                    value={firstName}
                                    onChange={(e)=>{
                                        setFirstName(e.target.value)
                                    }}>
                                    </input>
                                 </div>

                                 <div className='form-group mb-2'>
                                    <label className='form-label'>Last Name : </label>
                                    <input type='text'
                                    placeholder='Enter Last Name'
                                    name='lastName'
                                    className='form-control'
                                    value={lastName}
                                    onChange={(e)=>{
                                        setLastName(e.target.value)
                                    }}>
                                    </input>
                                 </div>


                                 <div className='form-group mb-2'>
                                    <label className='form-label'>Email : </label>
                                    <input type='text'
                                    placeholder='Enter Email'
                                    name='email'
                                    className='form-control'
                                    value={email}
                                    onChange={(e)=>{
                                        setEmail(e.target.value)
                                    }}>
                                    </input>
                                 </div>

                                 <button className='btn btn-success' onClick={(e)=>{saveOrUpdateEmployee(e)}}>Save</button>
                                 <Link to="/employees">
                                  <button className='btn btn-danger ms-3'>Cancel</button>
                                 </Link>
                            </form>
                        </div>
                  </div>
            </div>
        </div>
    </div>
  )
}

export default AddEmployeeComponent
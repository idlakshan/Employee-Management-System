import React,{useState} from 'react'

const ListEmployeeComponent = () => {

    const [employees, setEmployees] = useState([])

  return (
    <div className='container'>
        <h2 className='text-center'>List Employee</h2>

        <table className='table table-bordered table-striped'>
            <thead>
                <th>Employee Id</th>
                <th>Employee First Name</th>
                <th>Employee Last Name</th>
                <th>Employee Email</th>
            </thead>
            <tbody>
                 {
                    employees.map(
                        employee=>
                        <tr key={employee.id}>
                             <td>{employee.id}</td>
                            <td>{employee.firstName}</td>
                            <td>{employee.lastName}</td>
                            <td>{employee.email}</td>
                        </tr>
                    )
                 }

            </tbody>



        </table>
      
    </div>
  )
}

export default ListEmployeeComponent
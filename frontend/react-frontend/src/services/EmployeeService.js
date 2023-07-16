import axios from "axios";

const employeeURL="http://localhost:8001/api/v1/employees";

class EmployeeService{
    getAllEmployees(){
        return axios.get(employeeURL)
    }
    createEmployee(employee){
       return axios.post(employeeURL,employee)
    }

    getEmployeeById(id){
        return axios.get(employeeURL+"/"+id)
    }

    updateEmployee(id,employee){
    return axios.put(employeeURL+"/"+id,employee)
    }

    deleteEmployee(id){
       return axios.delete(employeeURL+"/"+id) 
    }
}

export default new EmployeeService();
import axios from "axios";

const employeeURL="http://localhost:8001/api/v1/employees";

class EmployeeService{
    getAllEmployees(){
        return axios.get(employeeURL)
    }
}

export default new EmployeeService();
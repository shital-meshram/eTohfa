import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { User } from '../membership/user.model';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class RegServiceService {

  
  data:any;

  constructor(private http:HttpClient ) { }
//asynchronous data arrival set by observable
  getUsers():Observable<User>{
    let url:string="localhost:8080/customer/getcustomer";
    return this.http.get<User>(url);
  }

  public loginUserFromRAPI(email:string, password:string):Observable<any>{
    return this.http.get("http://localhost:8080/customer/login/"+email+"/"+password);
  }

  public loginEmployeeFromRAPI(email:string, password:string):Observable<any>{
    return this.http.get("http://localhost:8080/employees/login/"+email+"/"+password);
  }

  public RegisterUserFromRAPI(user:User):Observable<any>{

    this.data={
      "fname": user.fname,
      "lname": user.lname,
      "email": user.email,
      "password": user.password,
      "address": {
          "plotNo": user.flat,
          "city": user.city,
          "state": user.state,
          "country": user.country,
          "postalCode": user.pincode
      }
  }

    return this.http.post<any>("http://localhost:8080/customer/register", this.data);
  }

  registerEmployee(employee:Employee):Observable<any>
  {
    this.data=
      {
        "ename": employee.ename,
        "email": employee.email,
        "password": employee.password,
        "contactNo": employee.contactNo,
        "role": employee.role
    }
    

    return this.http.post<any>("http://localhost:8080/employees", this.data);
  }


  getEmployees():Observable<any>
  {
    return this.http.get<any>("http://localhost:8080/employees");
  }

  
}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../employee';
import { RegServiceService } from '../reg-service.service';

@Component({
  selector: 'app-employee-registration',
  templateUrl: './employee-registration.component.html',
  styleUrls: ['./employee-registration.component.css']
})
export class EmployeeRegistrationComponent implements OnInit {

  employee= new Employee();
  employeeList: Employee[];
  constructor(private service : RegServiceService, router:Router) { }

  ngOnInit(): void {
  }

  registerEmployee()
  {
    this.service.registerEmployee(this.employee).subscribe(
      data=>{
        console.log("Registraytion Successfull");
        alert("Registraytion Successfull");
      },error=>{
        console.log("Bad Credentials");
        alert("Bad Credentials");
      }
    )
  }

  getAllEmployees(){
    this.service.getEmployees().subscribe(
      data=>{
        this.employeeList= data as Employee[];
        console.log(this.employee);
      },error=>{
        console.log("error");
      }
    )
  }

}

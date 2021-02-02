import { Component, OnInit } from '@angular/core';
import { Category } from '../category';
import { ProductServiceService } from '../product-service.service';

@Component({
  selector: 'app-add-new-category',
  templateUrl: './add-new-category.component.html',
  styleUrls: ['./add-new-category.component.css']
})
export class AddNewCategoryComponent implements OnInit {

  category = new Category();
  constructor(private service:ProductServiceService) { }

  ngOnInit(): void {
  }

  addNewCategory()
  {
    this.service.addNewCategory(this.category).subscribe(
      data=>{
        console.log("category added successfully..!!!")
        alert("category added successfully..!!!")
      },error=>{
        console.log("error")
        alert("error")
      }
    )
  }

}

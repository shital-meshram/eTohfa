import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Category } from '../category';
import { ProductServiceService } from '../product-service.service';
import { Products } from '../products.model';

@Component({
  selector: 'app-get-all-category',
  templateUrl: './get-all-category.component.html',
  styleUrls: ['./get-all-category.component.css']
})
export class GetAllCategoryComponent implements OnInit {

  categoryList:Category[];
  categoryById:Category;
  catId:number;
  productList:Products[];
  constructor(private service:ProductServiceService, private router:Router) { }


  ngOnInit(): void {
    this.getAllCategory();

  }

  getAllCategory()
  {
    this.service.getCategoriesList().subscribe(
      data=>{
        this.categoryList= data as Category[];
        console.log("Date Received")
    },error=>{
      console.log("Date Received failed")
    })
  }

  getProductsByCategory(catId)
  {
    alert(catId);
    this.service.getCategoriesById(catId).subscribe(
      data=>{
        this.categoryById=data as Category;
        console.log(data)
      },error=>{
        console.log("error")
      }
    );

  }



  
}

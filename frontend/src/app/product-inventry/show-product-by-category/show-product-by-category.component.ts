import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Category } from '../category';
import { ProductServiceService } from '../product-service.service';
import { Products } from '../products.model';

@Component({
  selector: 'app-show-product-by-category',
  templateUrl: './show-product-by-category.component.html',
  styleUrls: ['./show-product-by-category.component.css']
})
export class ShowProductByCategoryComponent implements OnInit {

  category=new Category();
  productList:Products[];
  cat_id:number;
  constructor(private service:ProductServiceService, private route:Router, private activeRoute:ActivatedRoute) { }

  ngOnInit(): void {
    this.service.getCategoriesById(this.activeRoute.snapshot.params.id).subscribe(data=>{
      this.category= data as Category;
      console.log(this.category);
      console.log("data received")
    },error=>{
      console.log("data fetch cancel")
    });

    this. getProductByCategory(this.activeRoute.snapshot.params.id);
  }

  getProductByCategory(cat_id)
  {
    this.service.getProductByCategory(cat_id).subscribe(
      data=>{
        this.productList = data as Products[];
        console.log(this.productList)
        console.log("data received")
    },error=>{
      console.log("data fetch canceled")
    });
  }
}

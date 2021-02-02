import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../membership/customer';
import { Category } from './category';
import { Orders } from './orders';
import { Products } from './products.model';

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {


  newProduct: Products;
  data: any;
  category_id_for_update:any;
  existingProduct: Products;
  category_id_for_getproductbyid:any;
  baseUrl = "http://localhost:8080/product/";


  constructor(private http: HttpClient) { }

  //GET ALL PRODUCT LIST
  getProductList(): Observable<any> {
    return this.http.get<any>(this.baseUrl);
  }

  //ADD NEW PRODUCT
  addNewProduct(category_id: any, newProduct): Observable<any> {
    this.data = {
      "prodName": newProduct.prodName,
      "description": newProduct.description,
      "price": newProduct.price,
      "imgUrl": null,
      "quantity": newProduct.quantity
    }
    return this.http.post<any>(this.baseUrl + category_id, this.data);
  }

  //UPDATE PRODUCT DETAILS
  updateProductDetails(category_id_for_update, existingProduct): Observable<any> {
    this.data = {
      "prodName": existingProduct.prodName,
      "description": existingProduct.description,
      "price": existingProduct.price,
      "imgUrl": null,
      "quantity": existingProduct.quantity
    }

    return this.http.put(this.baseUrl + category_id_for_update, existingProduct);
  }

  //GET PRODUCT CATEGORY LIST
  getCategoriesList(): Observable<any> {
    return this.http.get<any>(this.baseUrl + "/categories");
  }

  getProductById(category_id_for_getproductbyid):Observable<any>{
    return this.http.get<any>(this.baseUrl+"/"+category_id_for_getproductbyid);
  }

  addNewCategory(category:Category):Observable<any>
  {
    this.data={
      "catName": category.catName,
      "brand": category.brand
    }

    return this.http.post<any>(this.baseUrl+"/categories", this.data);
  }

  // getProductByCategory(category: Category):Observable<any>{
  //   this.data={
  //     "catId": category.catId,
  //     "catName": category.catName,
  //     "brand": category.brand
  // }
  //   return this.http.post<any>("http://localhost:8080/product/getProductByCategory", this.data);
  // }

  getProductByCategory(cat_id:number):Observable<any>{
    return this.http.get<any>("http://localhost:8080/product/category/"+ cat_id);
  }

  getCategoriesById(category_id):Observable<any>
  {
    return this.http.get<any>(this.baseUrl+"category/"+category_id);
  }

  placeOrder(order:any):Observable<any>
  {

    return this.http.post<any>("http://localhost:8080/order", order);
  }

  getAllOrders()
  {
    return this.http.get<any>("http://localhost:8080/order");
  }

  getTotalAmount(order_id:number):Observable<any>
  {
    return this.http.get<any>("http://localhost:8080/order/totalamount/"+order_id);
  }

  deleteProduct(product_id:number):Observable<any>
  {
    return this.http.delete<any>("http://localhost:8080/product/delete/"+product_id);
  }
}

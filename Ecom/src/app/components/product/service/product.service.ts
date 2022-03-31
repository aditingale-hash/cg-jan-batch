import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Review } from "../../review/model/review.model";
import { Product } from "../model/product.model";

@Injectable({
  providedIn: "root"
})
export class ProductService{


  private getProductByCatIDApi : string;
  private getReviewByProductIDApi: string;

  constructor(private http: HttpClient){
    this.getProductByCatIDApi ='http://localhost:8888/product/';
    this.getReviewByProductIDApi='http://localhost:8888/review/product/';
  }

  public getProductByCatId(catId:number) : Observable<Product[]>{
    return this.http.get<Product[]>(this.getProductByCatIDApi + catId);
  }

  public getReviewsByProductId(pid: number):Observable<Review[]> {
     return this.http.get<Review[]>(this.getReviewByProductIDApi+ pid);
  }
}

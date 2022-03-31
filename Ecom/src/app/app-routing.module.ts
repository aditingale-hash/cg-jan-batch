import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/auth/home/home.component';
import { AuthGuard } from './components/auth/service/auth.guard.service';
import { CategoryHomeComponent } from './components/category/home/home.component';
import { ProductHomeComponent } from './components/product/home/home.component';
import { ReviewComponent } from './components/review/review.component';

const routes: Routes = [
  {path:'', component: CategoryHomeComponent},
  {path:'login', component: LoginComponent},
  {path:'product/:cid', component: ProductHomeComponent},
  {path: 'review/:pid', component: ReviewComponent, canActivate: [AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

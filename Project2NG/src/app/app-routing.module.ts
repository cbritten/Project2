import { NgModule } from '@angular/core';
import { Routes, RouterModule, Router } from '@angular/router';
import { NeighbourhoodComponent } from './Component/neighbourhood/neighbourhood.component';
import { CreateuserComponent } from './Component/createuser/createuser.component';
import { LoginComponent } from './Component/login/login.component';
import { SeereviewComponent } from './Component/seereview/seereview.component';
import { CreateReviewComponent } from './Component/createreview/create-review.component';
import { AdminpageComponent } from './Component/adminpage/adminpage.component';

const routes: Routes = [
  { path: 'neighbourhoods', component: NeighbourhoodComponent },
  { path: 'login', component: LoginComponent },
  { path: 'login/createuser', component: CreateuserComponent },
  { path: 'allreviews', component:SeereviewComponent},
  {path: 'addreview', component:CreateReviewComponent},
  {path: '', component: LoginComponent},
  { path:'adminPage', component: AdminpageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }



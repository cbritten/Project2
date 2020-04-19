import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { SlickCarouselModule } from 'ngx-slick-carousel'; 
import { NeighbourhoodComponent } from './Component/neighbourhood/neighbourhood.component';
import { NeighbService } from './Service/neighb.service';
import { CreateuserComponent } from './Component/createuser/createuser.component';
import { LoginComponent } from './Component/login/login.component';
import { SeereviewComponent } from './Component/seereview/seereview.component';
import { CreateReviewComponent } from './Component/createreview/create-review.component';
import { DatePipe } from '@angular/common';
import { AdminpageComponent } from './Component/adminpage/adminpage.component';
import { ShowpDirective } from './showp.directive';


@NgModule({
  declarations: [
    AppComponent,
    NeighbourhoodComponent,
    CreateuserComponent,
    LoginComponent,
    SeereviewComponent,
    CreateReviewComponent,
    AdminpageComponent,
    ShowpDirective
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SlickCarouselModule,
    HttpClientModule,
    FormsModule
    
  ],
  providers: [NeighbService, DatePipe], 
  bootstrap: [AppComponent]
})
export class AppModule { }

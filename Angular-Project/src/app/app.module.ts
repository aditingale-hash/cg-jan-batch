import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PostService } from './services/post.service';
import { PostGridComponent } from './components/post-grid/post-grid.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { PostStatComponent } from './components/post-stat/post-stat.component';
import { DemoComponent } from './components/demo/demo.component';
import { TracksComponent } from './learning-track/components/tracks/tracks.component';
import { CoursesComponent } from './courses/components/courses/courses.component';
import { DashboardComponent } from './dashboard/components/dashboard/dashboard.component';

@NgModule({
  declarations: [
    AppComponent,
    PostGridComponent,
    NavBarComponent,
    PostStatComponent,
    DemoComponent,
    TracksComponent,
    CoursesComponent,
    DashboardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [PostService],
  bootstrap: [AppComponent]
})
export class AppModule { }

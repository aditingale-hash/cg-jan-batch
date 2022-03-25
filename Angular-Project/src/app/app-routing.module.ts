import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TracksComponent } from './learning-track/components/tracks/tracks.component';
import { CoursesComponent } from './courses/components/courses/courses.component';
import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/components/dashboard/dashboard.component';


const routes: Routes = [
  { path: '', component: DashboardComponent },
  { path: 'learning-tracks', component: TracksComponent },
  { path: 'courses', component: CoursesComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

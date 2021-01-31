import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomepageComponent } from './components/homepage/homepage.component';
import { IzvestajiComponent } from './components/izvestaji/izvestaji.component';
import { LoginComponent } from './components/login/login.component';
import { ObavestenjaComponent } from './components/obavestenja/obavestenja.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { PodnosenjeZahtevaComponent } from './components/podnosenje-zahteva/podnosenje-zahteva.component';
import { ResenjaComponent } from './components/resenja/resenja.component';
import { ZahteviComponent } from './components/zahtevi/zahtevi.component';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' }, // Don't use prefix becasue empty path is a prefix to any path
  { path: 'login', component: LoginComponent },
  { path: 'homepage', component: HomepageComponent,
    children: [
      { path: 'zahtevi', component: ZahteviComponent },
      { path: 'obavestenja', component: ObavestenjaComponent },
      { path: 'resenja', component: ResenjaComponent },
      { path: 'izvestaji', component: IzvestajiComponent },
      { path: 'podnosenje-zahteva', component: PodnosenjeZahtevaComponent },
    ]  
  },
  
  { path: '404', component: PageNotFoundComponent },
  { path: '**', redirectTo: '/404' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

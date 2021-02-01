import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomepageComponent } from './components/homepage/homepage.component';
import { IzvestajiComponent } from './components/izvestaji/izvestaji.component';
import { KreiranjeResenjaComponent } from './components/kreiranje-resenja/kreiranje-resenja.component';
import { KreiranjeZalbeComponent } from './components/kreiranje-zalbe/kreiranje-zalbe.component';
import { LoginComponent } from './components/login/login.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { PrikazResenjaComponent } from './components/prikaz-resenja/prikaz-resenja.component';
import { PrikazZalbeComponent } from './components/prikaz-zalbe/prikaz-zalbe.component';
import { ResenjaComponent } from './components/resenja/resenja.component';
import { ZalbeComponent } from './components/zalbe/zalbe.component';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' }, // Don't use prefix becasue empty path is a prefix to any path
  { path: 'login', component: LoginComponent },
  {
    path: 'homepage', component: HomepageComponent,
    children: [
      { path: 'zalbe', component: ZalbeComponent },
      { path: 'resenja', component: ResenjaComponent },
      { path: 'izvestaji', component: IzvestajiComponent },
      { path: 'zalbe/:id', component: PrikazZalbeComponent },
      { path: 'resenja/:id', component: PrikazResenjaComponent },
      { path: 'podnosenje-zalbe', component: KreiranjeZalbeComponent },
      { path: 'zalbe/:id/podnosenje-resenja', component: KreiranjeResenjaComponent },
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

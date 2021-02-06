import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomepageComponent } from './components/homepage/homepage.component';
import { IzvestajiComponent } from './components/izvestaji/izvestaji.component';
import { LoginComponent } from './components/login/login.component';
import { ObavestenjaComponent } from './components/obavestenja/obavestenja.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { PodnosenjeObavestenjaComponent } from './components/podnosenje-obavestenja/podnosenje-obavestenja.component';
import { PodnosenjeZahtevaComponent } from './components/podnosenje-zahteva/podnosenje-zahteva.component';
import { PrikazZahtevaComponent } from './components/prikaz-zahteva/prikaz-zahteva.component';
import { PrikazZalbeComponent } from './components/prikaz-zalbe/prikaz-zalbe.component';
import { RegistracijaComponent } from './components/registracija/registracija.component';
import { ResenjaComponent } from './components/resenja/resenja.component';
import { ZahteviComponent } from './components/zahtevi/zahtevi.component';
import { ZalbeComponent } from './components/zalbe/zalbe.component';
import { RoleGuard } from './guards/role.guard';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' }, // Don't use prefix becasue empty path is a prefix to any path
  { path: 'login', component: LoginComponent },
  { path: 'registracija', component: RegistracijaComponent },
  {
    path: 'homepage', component: HomepageComponent,
    children: [
      { path: 'zalbe', component: ZalbeComponent, canActivate: [RoleGuard], data: { expectedRoles: "SLUZBENIK|GRADJANIN" } },
      { path: 'zalbe/:id', component: PrikazZalbeComponent, canActivate: [RoleGuard], data: { expectedRoles: "SLUZBENIK|GRADJANIN" } },
      { path: 'zahtevi', component: ZahteviComponent, canActivate: [RoleGuard], data: { expectedRoles: "SLUZBENIK|GRADJANIN" } },
      { path: 'zahtevi/:id', component: PrikazZahtevaComponent, canActivate: [RoleGuard], data: { expectedRoles: "SLUZBENIK|GRADJANIN" } },
      { path: 'obavestenja', component: ObavestenjaComponent, canActivate: [RoleGuard], data: { expectedRoles: "SLUZBENIK|GRADJANIN" } },
      // ovo nam ne treba uopste, gledamo ga u html i pdf formatu
      // { path: 'obavestenja/:id', component: PrikazObavestenjaComponent, canActivate: [RoleGuard], data: { expectedRoles: "SLUZBENIK|GRADJANIN" } },
      { path: 'resenja', component: ResenjaComponent, canActivate: [RoleGuard], data: { expectedRoles: "SLUZBENIK" } },
      // ovo nam ne treba uopste, gledamo ga u html i pdf formatu
      // { path: 'resenja/:id', component: PrikazResenjaComponent, canActivate: [RoleGuard], data: { expectedRoles: "SLUZBENIK" } },
      { path: 'izvestaji', component: IzvestajiComponent, canActivate: [RoleGuard], data: { expectedRoles: "SLUZBENIK|GRADJANIN" } },
      { path: 'podnosenje-zahteva', component: PodnosenjeZahtevaComponent, canActivate: [RoleGuard], data: { expectedRoles: "GRADJANIN" } },
      { path: 'zahtevi/:id/podnosenje-obavestenja', component: PodnosenjeObavestenjaComponent, canActivate: [RoleGuard], data: { expectedRoles: "SLUZBENIK" } }
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

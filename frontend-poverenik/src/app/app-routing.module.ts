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
import { ZahteviComponent } from './components/zahtevi/zahtevi.component';
import { ZalbaNaCutanjeComponent } from './components/zalba-na-cutanje/zalba-na-cutanje.component';
import { ZalbaNaOdbijanjeComponent } from './components/zalba-na-odbijanje/zalba-na-odbijanje.component';
import { ZalbeComponent } from './components/zalbe/zalbe.component';
import { RoleGuard } from './guards/role.guard';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' }, // Don't use prefix becasue empty path is a prefix to any path
  { path: 'login', component: LoginComponent },
  {
    path: 'homepage', component: HomepageComponent,
    children: [
      { path: 'zalbe', component: ZalbeComponent, canActivate: [RoleGuard], data: { expectedRoles: "POVERENIK|GRADJANIN" } },
      { path: 'zahtevi', component: ZahteviComponent, canActivate: [RoleGuard], data: { expectedRoles: "GRADJANIN" } },
      { path: 'resenja', component: ResenjaComponent, canActivate: [RoleGuard], data: { expectedRoles: "POVERENIK|GRADJANIN" } },
      { path: 'izvestaji', component: IzvestajiComponent, canActivate: [RoleGuard], data: { expectedRoles: "POVERENIK" } },
      // { path: 'zalbe/:id', component: PrikazZalbeComponent, canActivate: [RoleGuard], data: { expectedRoles: "POVERENIK|GRADJANIN" } },
      // { path: 'resenja/:id', component: PrikazResenjaComponent, canActivate: [RoleGuard], data: { expectedRoles: "POVERENIK|GRADJANIN" } },
      { path: 'zalba-odbijanje/:id', component: ZalbaNaOdbijanjeComponent, canActivate: [RoleGuard], data: { expectedRoles: "GRADJANIN" } },
      { path: 'zalba-cutanje/:id', component: ZalbaNaCutanjeComponent, canActivate: [RoleGuard], data: { expectedRoles: "GRADJANIN" } },
      { path: 'podnosenje-zalbe', component: KreiranjeZalbeComponent, canActivate: [RoleGuard], data: { expectedRoles: "GRADJANIN" } },
      { path: 'podnosenje-resenja-za-zalbu/:id', component: KreiranjeResenjaComponent, canActivate: [RoleGuard], data: { expectedRoles: "POVERENIK" } },
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

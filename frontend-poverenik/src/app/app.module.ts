import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './components/login/login.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { HomepageComponent } from './components/homepage/homepage.component';
import { MaterialModuleModule } from './material-module/material-module.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PrikazZalbeComponent } from './components/prikaz-zalbe/prikaz-zalbe.component';
import { PrikazResenjaComponent } from './components/prikaz-resenja/prikaz-resenja.component';
import { KreiranjeZalbeComponent } from './components/kreiranje-zalbe/kreiranje-zalbe.component';
import { KreiranjeResenjaComponent } from './components/kreiranje-resenja/kreiranje-resenja.component';
import { ZalbeComponent } from './components/zalbe/zalbe.component';
import { ResenjaComponent } from './components/resenja/resenja.component';
import { IzvestajiComponent } from './components/izvestaji/izvestaji.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    PageNotFoundComponent,
    HomepageComponent,
    PrikazZalbeComponent,
    PrikazResenjaComponent,
    KreiranjeZalbeComponent,
    KreiranjeResenjaComponent,
    ZalbeComponent,
    ResenjaComponent,
    IzvestajiComponent
  ],
  imports: [
    MaterialModuleModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

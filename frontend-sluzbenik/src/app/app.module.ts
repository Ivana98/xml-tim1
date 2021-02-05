import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './components/login/login.component';
import { HomepageComponent } from './components/homepage/homepage.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component'
import { MaterialModuleModule } from './material-module/material-module.module';
import { ZahteviComponent } from './components/zahtevi/zahtevi.component';
import { ObavestenjaComponent } from './components/obavestenja/obavestenja.component';
import { MatCell, MatHeaderCell, MatTableModule } from '@angular/material/table';
import { PodnosenjeZahtevaComponent } from './components/podnosenje-zahteva/podnosenje-zahteva.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ResenjaComponent } from './components/resenja/resenja.component';
import { IzvestajiComponent } from './components/izvestaji/izvestaji.component';
import { PrikazZahtevaComponent } from './components/prikaz-zahteva/prikaz-zahteva.component';
import { PrikazObavestenjaComponent } from './components/prikaz-obavestenja/prikaz-obavestenja.component';
import { PrikazResenjaComponent } from './components/prikaz-resenja/prikaz-resenja.component';
import { PodnosenjeObavestenjaComponent } from './components/podnosenje-obavestenja/podnosenje-obavestenja.component';
import { ZalbeComponent } from './components/zalbe/zalbe.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomepageComponent,
    PageNotFoundComponent,
    ZahteviComponent,
    ObavestenjaComponent,
    PodnosenjeZahtevaComponent,
    ResenjaComponent,
    IzvestajiComponent,
    PrikazZahtevaComponent,
    PrikazObavestenjaComponent,
    PrikazResenjaComponent,
    PodnosenjeObavestenjaComponent,
    ZalbeComponent
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

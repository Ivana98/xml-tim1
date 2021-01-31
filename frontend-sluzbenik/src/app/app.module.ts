import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './components/login/login.component';
import { HomepageComponent } from './components/homepage/homepage.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component'


import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import { MaterialModuleModule } from './material-module/material-module.module';
import { ZahteviComponent } from './components/zahtevi/zahtevi.component';
import { ObavestenjaComponent } from './components/obavestenja/obavestenja.component';
import { MatCell, MatHeaderCell, MatTableModule } from '@angular/material/table';
import { PodnosenjeZahtevaComponent } from './components/podnosenje-zahteva/podnosenje-zahteva.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomepageComponent,
    PageNotFoundComponent,
    ZahteviComponent,
    ObavestenjaComponent,
    PodnosenjeZahtevaComponent,
  ],
  imports: [
    MaterialModuleModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

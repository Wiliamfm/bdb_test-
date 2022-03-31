import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdoptPersonComponent } from './person/adopt-person/adopt-person.component';
import { CreatePersonComponent } from './person/create-person/create-person.component';
import { ListAllComponent } from './person/list-all/list-all.component';
import { PersonModelComponent } from './person/person-model/person-model.component';

const routes: Routes = [
  {path: '', component: PersonModelComponent},
  {path: 'persons', component: ListAllComponent},
  {path: 'persons/new', component: CreatePersonComponent},
  {path: 'persons/adopt', component: AdoptPersonComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
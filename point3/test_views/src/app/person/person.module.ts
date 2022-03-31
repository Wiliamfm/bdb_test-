import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CreatePersonComponent } from './create-person/create-person.component';
import { ListAllComponent } from './list-all/list-all.component';
import { PersonModelComponent } from './person-model/person-model.component';
import { AdoptPersonComponent } from './adopt-person/adopt-person.component';



@NgModule({
  declarations: [
    CreatePersonComponent,
    ListAllComponent,
    PersonModelComponent,
    AdoptPersonComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    CreatePersonComponent,
    ListAllComponent
  ]
})
export class PersonModule { }

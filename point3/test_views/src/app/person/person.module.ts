import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CreatePersonComponent } from './create-person/create-person.component';
import { ListAllComponent } from './list-all/list-all.component';



@NgModule({
  declarations: [
    CreatePersonComponent,
    ListAllComponent
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

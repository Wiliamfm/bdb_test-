import { Component, OnInit } from '@angular/core';
import { Person } from 'src/app/interfaces/person';
import { PersonService } from 'src/app/services/person.service';

@Component({
  selector: 'app-list-all',
  templateUrl: './list-all.component.html',
  styleUrls: ['./list-all.component.css']
})
export class ListAllComponent implements OnInit {

  persons: Person[] = [];
  
  constructor(private personService: PersonService) { }

  ngOnInit(): void {
    this.getPersons();
  }

  getPersons() {
    this.personService.getPerson().subscribe(persons => this.persons= persons);
  }

}

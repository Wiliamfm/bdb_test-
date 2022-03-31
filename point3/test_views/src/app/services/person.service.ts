import { Injectable } from '@angular/core';
import { Observable, of, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { Person } from '../interfaces/person';

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  url= 'http://localhost:8080/persons'

  constructor(private http: HttpClient) { }

  getPerson(): Observable<Person[]>{
    return this.http.get<Person[]>(this.url);
    /*
    return new Observable(observer => {
      fetch(this.url)
      .then(response => {
        return response.json();
      })
      .then(body => {
        observer.next(body);
        observer.complete();
      })
      .catch(err => {
        console.log('Error while trying to get persons: ', err);
        observer.error(err);
      })
    });
    */
  }
}

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-adopt-person',
  templateUrl: './adopt-person.component.html',
  styleUrls: ['./adopt-person.component.css']
})
export class AdoptPersonComponent implements OnInit {

  constructor() {
   }

  ngOnInit(): void {
    document.getElementById("form")?.addEventListener('submit', this.submitForm);
  }
  
  submitForm(event:SubmitEvent): void {
    let create_person_url = "http://localhost:8080/persons";
    event.preventDefault();
    let form= <HTMLFormElement> event.currentTarget;
    let data= {
      father_document: form['father_document'].value,
      mother_document: form['mother_document'].value,
      child_document: form['idChild'].value,
    };
    //alert(typeof(form['birth_date'].value));
    //alert(JSON.stringify(data));
    fetch(create_person_url+"/"+form['idChild'].value, {
      method: 'PUT',
      body: JSON.stringify(data),
      headers: {
        'Content-Type': 'application/json'
      }
    }).then(response => {
      switch (response.status) {
        case 200:
          alert(`Persona adoptada con éxito.`)
          break;
        case 202:
          alert('La persona con id: '+ form['idChild'].value+ ' ya cuenta con padres');
          break;
        case 500:
          alert('No es posible adoptar a la persona con id: '+ form['idChild'].value);
          break;
        default:
          console.log("Other status?"+ response.status);
          break;
      }
      response.json()
    })
    .then(data => {
      console.log(data);
      /*
      */
      form.reset();
    }).catch(err => {
      console.log('Can not adopt the person: ', err);
      alert('No es posible adoptar a la persona con id: '+ form['idChild'].value);
    })
  }

}

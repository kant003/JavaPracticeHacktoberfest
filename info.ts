import { Component, ElementRef, Input, OnInit, ViewChild } from '@angular/core';
import { AngularFirestore, AngularFirestoreCollection } from '@angular/fire/firestore';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Enrollment } from 'src/app/models/enrollments';
import { Subject } from 'src/app/models/subject';
import { User } from 'src/app/models/user';
import { Sing } from 'src/app/models/sing';

@Component({
  selector: 'app-user-sings',
  templateUrl: './user-sings.component.html',
  styleUrls: ['./user-sings.component.css']
})
export class UserSingsComponent implements OnInit {
  @Input() idAlumno: any;
  private enrollmentCollection: AngularFirestoreCollection<Enrollment>;
  enrollments$: Observable<Enrollment[]>;

  constructor(private afs: AngularFirestore, private route: ActivatedRoute) {
    if (!this.idAlumno) this.idAlumno = route.snapshot.paramMap.get('id')

  }

  ngOnInit(): void {
    this.enrollments$ = this.getEnrollmentsOfUser();

  }
}
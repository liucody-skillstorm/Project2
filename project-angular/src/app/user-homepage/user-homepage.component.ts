import { Component, OnInit } from '@angular/core';
import { PlanService } from '../services/plan.service';

@Component({
  selector: 'app-user-homepage',
  templateUrl: './user-homepage.component.html',
  styleUrls: ['./user-homepage.component.css']
})
export class UserHomepageComponent implements OnInit {

  constructor(private planService: PlanService) { }

  ngOnInit(): void {
  }

}
